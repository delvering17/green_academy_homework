package Q;

public class Game369 {

	public static void main(String[] args) {
		int num = 100;
		for (int i = 1 ; i <= num ; i++) {
			int one = i%10;
			int ten = i-one;
			int three = one%3;
			int tenThree = ten%3;
			
			// 십의 자리  
			try {
				
				int a = 123 / (i/10) ; // 십의 자리와 일의 자리 숫자 구분
				
				try {
					a = 123 / one;		//	일의 자리 0 숫자 구분
					
					try {						
						a = 123 / three;		// 일의 자리 3배수 구분
						try {				
							a = 123 / tenThree;		//십의 자리 3배수 구분
							System.out.println(i);  
						} catch (Exception e3) {
							System.out.println("짝"); 
						}
						
					} catch (Exception e2) {	//일의 자리 3배수 인것들모두
						try {
							a = 123 / tenThree; 		// 십의 자리 3배수 
							System.out.println("짝");
						} catch (Exception e3) {
							System.out.println("짝짝");
						}
					
					}
				} catch (Exception e) {	// 일의 자리가 0인 것  
					// 십의 자리 3배수
					try {
						a = 123 / tenThree;
						System.out.println(i);
					} catch (Exception e1) {
						System.out.println("짝");
					}
				}
			// 일의 자리
			} catch (Exception e) {
				try {
					int a = 123 / three;
					System.out.println(i);
				} catch (Exception e1) {
					System.out.println("짝");
				}
				
			}
		
		}
	}
}
/*
1. 십의 자리

	1-1. 일의 자리 0 아닌 것
		1-1-1. 일의 자리 3배수 아닌 것
			1-1-1-1. 십의 자리 3배수 31
			1-1-1-2. 십의 자리 3배수 아닌 것 51
		1-1-2. 일의 자리 3배수 
			1-1-2-1. 십의 자리 3배수 아닌 것 53
			1-1-2-2. 십의 자리 3배수 33
			
	1-2. 일의 자리 0
		1-2-1. 십의 자리 3배수 아닌 것 50
		1-2-1. 십의 자리 3배수 30

2. 일의 자리
	2-1. 3배수 아닌 것 1
	2-2. 3배우 인 것 3
*/

