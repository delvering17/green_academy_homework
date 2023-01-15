package Q;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;



class MusicPlayer {
	MusicInfo mi = new MusicInfo();
	Scanner sc = new Scanner(System.in);
	int input;
	int track;
	String title, singer;
	
	

	public MusicPlayer( int track, String title, String singer) {
		
		this.track = track;
		this.title = title;
		this.singer = singer;
	}
	public MusicPlayer() {
		mp3Work();
	}
	
	@Override
	public String toString() {
		return "no" + track +"."+  singer + " : " + title ;
	}
	void mp3Work() {
	
		MP3: while(true) {
			playOn();
			switch (input) {
			case 1:							// 노래 시작
				musicStart();
				break ;
			case 2:							// 노래 리스트 보기
				System.out.println("리스트");
				mi.listLook();
				
				break;
				
			case 0:							// 종료
				break MP3;
			}
				
		}
		
		System.out.println("MP3가 종료되었습니다.");

		
	}
	
	int playOn () {
		
		System.out.println("--메뉴--");
		System.out.println("1. 노래 시작");
		System.out.println("2. 노래 리스트 보기");
		System.out.println("0. 종료");
		System.out.print("입력: ");
		input = sc.nextInt();
		System.out.println("-------");
		return input;
	}
	
	void musicStart () {
		mi.listLook();
		Stack now ;
		Stack back;
		Stack next;
		System.out.println("노래를 선택하세요");
		input = sc.nextInt();
		
		
		mi.now.add(mi.norae.get(input-1));
		
		for (int i = input ; i < mi.norae.size()  ; i ++) {
			mi.next.add(mi.norae.get(i));
		}
		mi.playLook();
		
	}
}

class MusicInfo {
	static ArrayList norae = new ArrayList();
	static Stack now = new Stack() ;
	static Stack back = new Stack();
	static Stack next = new Stack();
	
	static void listLook () {
		norae.clear();
		now.clear();
		back.clear();
		next.clear();
		MusicPlayer [] musicL = {
				 new MusicPlayer(1, "애국가", "나"),
				 new MusicPlayer(2, "아기상어", "유튜브"),
				 new MusicPlayer(3, "곰세마리", "박효신"),
				 new MusicPlayer(4, "Next Level", "이수만")
		};
		for(Object i :  musicL) {
			norae.add(i);
		}
		for(Object i:norae) {
			System.out.println(i);
			
		}
	
		
	}
	
	void playLook () {
		System.out.println("현재 : " + now);
		System.out.println("이전 : " + back);
		System.out.println("다음 : " + next);
	}
	

}





public class Mp3Q {

	public static void main(String[] args) {
		System.out.println("Mp3가 시작되었습니다.");
		MusicPlayer mp = new MusicPlayer();
	
		
	}

}


/*
//mp3 노래듣기를 구현하세요
// 1. 노래 정보 :  트랙번호, 노래제목, 가수
// 2. 노래 리스트 -->next 에 넣기
// 3. 구현내용 다음곡, 이전곡, 트랙번호
--------------------------------------------------------------------------------------------------------
//검색기능을 구현하세요
//1. 제목으로 검색
//2. 현재 트랙 이후부터 검색
//3. 제목, 가수를 구분하여 검색
   ---  동일 검색내용이 있을 경우 
          1. 현재 트랙 바로 다음 나오는 곡으로 이동
          2. 검색된 노래 정보를 보여주고 트랙번호를 입력하여 선택하여 이동
*/