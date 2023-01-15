package Q;

import java.util.ArrayList;

import javax.swing.JOptionPane;

class QuizTimer extends Thread {
	
	boolean timeStop = false;
	
	public void run() {
		
		for (int i = 30 ; i > 0 ; i--) {
			
			if (timeStop) {					// 답 제출 시 멈춤
				break;
			}
			
			try {
				
				System.out.println(i + ","  + timeStop);
				sleep(1000);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			
		}
		
		timeStop = true;
		System.out.println("-----시간 끝----");	
	}	
}

class Quiz extends Thread {
	
	
	
	QuizTimer timer ;
	ArrayList<QuizData> arr;
	
	public Quiz(QuizTimer timer, QuizData...arr) {
		this.timer = timer;
		this.arr = new ArrayList<QuizData>();
		
		for (QuizData d :arr) {
			this.arr.add(d);
		}
	}
	
	public void run() {
		
		for (QuizData data : arr) {
			while (true) {
				String input = JOptionPane.showInputDialog(data.question);
				
				
				if (timer.timeStop) {
					
					input = "시간이 경과되었습니다.";
					break;
				}
				System.out.println(input);
				if (input.equals(data.answer)) {	// 정답 아니면 while문 계속돌아감
					System.out.println("정답입니다!");
					break;
				}
				if (input.equals("pass")) {			// 패스 구현
					System.out.println("패스하셨습니다");
					break;
				}
				System.out.println("틀렸습니다");
			}
		}
		
		timer.timeStop = true;
		
	}


	
}

class QuizData {
	
	String question;
	String answer;
	
	public QuizData (String question, String answer) {
		this.question = question;
		this.answer = answer;
	}	
}



public class ThreadQuizPassQQ {

	public static void main(String[] args) {
		QuizTimer timer = new QuizTimer();
		Quiz qq = new Quiz(
				timer,
				
				new QuizData("1+1은 ?", "2"),
				new QuizData("1+2은 ?", "3"),
				new QuizData("1+3은 ?", "4"),
				new QuizData("1+4는 ?", "5"),
				new QuizData("1+5는 ?", "6")
				
				);

		timer.start();
		qq.start();

	}

}





//풀이한 Quiz 를 기반으로  
//
//1. 패스를 구현해 주세요 
//
//2. 정답이 아닐 경우 맞출때까지 문제를 풀게 해 주세요
//
//3. 패스 한 경우 오답을 패스 이전 대답으로 할게 해주세요