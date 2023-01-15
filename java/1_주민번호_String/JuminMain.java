public class JuminMain {

	public static void main(String[] args) {
		// 성별, 국적, 생년월일, 한국나이, 만나이, 올해생일, 다가올 생일, 생일파티 DDay를 출력하세요.
		// "aBcd Efg HIJk lMn opQR" -> Abcd Efg Hijk Lmn Opqr  로 변경해 주세요
		//"lMn aBcd HIJk opQR  Efg" -> GFe rqPO Kjih DCbA Nmi  로 변경해 주세요

		String jumin = "940320-1234567";
		JuminNum juminNum = new JuminNum("940320-1234567");
		juminNum.Juminday(7,2,2022);

		juminNum.juminGender();
		juminNum.juminNationality();
		juminNum.juminBirth();
		juminNum.juminKorAge();
		juminNum.juminAge();
	}

	// 올해생일,다가올 생일, 생일파티 dday 추가 필요...

}