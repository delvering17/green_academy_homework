package Q;

import java.util.Scanner;
import java.util.regex.Pattern;

class AddressData {	
	String [] list = {

      "강남구","강동구", "강북구", "강서구", "관악구", "구로구", "금천구", 
      "노원구", "도봉구", "동대문구",  "동작구", "마포구",
      "서대문구", "서초구", "성동구", "성북구", "송파구",
      "양천구", "영등포구", "용산구", "은평구",
      "종로구", "중구", "중랑구"
	};
}



class SignUpCon  {
	Scanner sc = new Scanner(System.in);
	SignException se = new SignException();	
	
	String textIn;
	String textCon;
	String name;
	
	// 생성자
	SignUpCon () {
		DataCon c = new DataCon();
			System.out.println("회원가입이 완료되었습니다!!");
	}
	// 실행 메소드
	void Con (String name, String con) {
		while(true) {
			System.out.print(name + " : ");
			
			try {
				textIn = sc.nextLine();
				if (name == "비밀번호") {
					
					System.out.print("비밀번호 확인 : ");
					con = sc.nextLine();
					se.Gogo(textIn, con, name);
				} else if (name == "우편번호") {
					se.Gogo(textIn, con, name);
				} else {
					se.Gogo(textIn, con, name);
				} 
				break;
			} catch (Exception e) {
				
			}
		
		}
	}
	// 규칙과 선별 클래스
	class DataCon {
		DataCon () {
			Idcon ();
			Pwcon ();
			PhoneCon ();
			NameCon ();
			PicCon ();
			MailAddressCon ();
		}
		
		void Idcon () {	
			Con("아이디", "[A-Za-z0-9]*");
		}
		void Pwcon () {
			Con("비밀번호", "");
		}	
		void PhoneCon () {
			Con("전화번호('-'포함)", "[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}");
		}	
		void NameCon () {
			Con("이름", "[가-힣]*");
		}	
		void PicCon () {
			Con("사진 첨부파일(jpg/jpeg/bmp/png/gif)", "[A-Za-z0-9]*[.].*(jpg|jpeg|bmp|png|gif)");
		}	
		void MailAddressCon () {
			Con("우편번호","");
		}
	}	
}

// 예외 처리 클래스
class SignException extends AddressData {
	
	
	
	void Gogo (String textIn, String Con, String name) throws Exception { 
		try {
			String addC = "";
			
			if (name == "우편번호") {
				
				for (int i = 0; i < list.length ; i++) {
					if (textIn.equals(list[i])) {
						addC += list[i];
					}
				}
				if (addC == "") {
					throw new Exception("우편번호 오류입니다.");
				}
				
			} else if (!Pattern.matches(Con, textIn)) {
				throw new Exception(name+" 오류입니다.");
			}
			System.out.println(name+ " 입력되었습니다");
		} catch (Exception e) {
			
			System.out.println(e. getMessage());
			throw e;
		}
	}

}



public class SignUpQ {

	public static void main(String[] args) {

		SignUpCon suc = new SignUpCon();
		
		
	}

}