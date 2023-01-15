package Q;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BufferedQQQ {
	Scanner sc = new Scanner(System.in);
	ArrayList<String> arr = new ArrayList<String>();
	
	
	public BufferedQQQ() throws Exception {
		
		
		System.out.println("입장");
		
		while(true) {
			System.out.println("1. 로그인, 2. 회원가입, 3. 종료");
			int ch = sc.nextInt();
			
			if (ch == 1 ) {
				Login();
			} else if (ch == 2) {
				SignIn();			
			} else if (ch == 3) {
				break;
			}
		
		}
		System.out.println("프로그램 종료");
	}
	
	void SignIn () throws IOException {
		String id;
		String name;
		String password;
		
		FileWriter fw = new FileWriter("fff/memberInfo.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);		
		FileReader fr = new FileReader("fff/memberInfo.txt");
		BufferedReader br = new BufferedReader(fr);
		
		

		
		BIG : while(true) {
			
			
			System.out.println("--회원가입--");
			
			System.out.print("아이디 : ");
			id = sc.next();
			
			System.out.print("이름 : ");
			name = sc.next();

			System.out.print("비밀번호 : ");
			password = sc.next();
			
			System.out.println("입력된 정보가 맞습니까?---\n 1. 예 2. 아니오");
			System.out.print("아이디 : "+ id + "\t");			
			System.out.print("이름 : "+ name + "\t");
			System.out.print("비밀번호 : "+ password + "\t\n");
			System.out.print("입력: ");
			int ch = sc.nextInt();
			
			if(ch == 2) {

				System.out.println("다시 입력해주세요");
				continue;
			} else {
				
				String con;
				while((con = br.readLine()) != null) {
					arr.add(con);
				}
				
				for (String a : arr) {
					
					String [] concon = a.split(",");
					
					if (id.equals(concon[0]) || password.equals(concon[2])) {	
						System.out.println("중복된 정보입니다. 다시 입력해주세요");
					
						continue BIG;
					}
					
					
				}
				System.out.println("---회원가입 성공---");
				break;
			}
		}
		
		
		bw.write("\n" + id + "," + name  + "," + password);
		
		fr.close();
		br.close();
		
		bw.close();
		fw.close();
	}
	
	
	
	void Login () throws Exception {

		FileReader fr = new FileReader("fff/memberInfo.txt");
		BufferedReader br = new BufferedReader(fr);
		
		BIG : while (true) {
	
			
			String con ;
			System.out.println("---로그인---");
			
			System.out.print("아이디: ");
			String id = sc.next();
			System.out.print("비밀번호: ");
			String password = sc.next();
			System.out.println();
			
			
			while((con = br.readLine()) != null) {
				arr.add(con);

			}
			
			for (String a : arr) {
				
				String [] concon = a.split(",");
				
				if (id.equals(concon[0]) && password.equals(concon[2])) {	
					System.out.println("--로그인 성공--");
					System.out.println(concon[1]+"님 반갑습니다");
					 break BIG ;
				}
				
				
			}
			System.out.println("정보를 잘못입력했습니다.");
		}
		fr.close();
		br.close();
	
		
	}
	
	public static void main(String[] args) throws Exception {
		
		new BufferedQQQ();
		
		
	}

}
