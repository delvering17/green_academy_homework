package Q;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;



public class DivisorQ {

	public static void main(String[] args) {
		
		int [] nums = {22,4,56,7,8,90,12,3,45,6,22,31,45,63,86,57};
		
		int cnt = 1;		
		Map divisor = new HashMap();
		
		for (int j : nums) {
			for (int i = 2 ; i < j ; i++  ) {
				cnt = 1;
				if (j%i == 0) {		// 약수 검사
					if(divisor.containsKey(i)) {	 	// 자신을 빼는 것 검사
						cnt+=(int)divisor.get(i);		// 카운트 저장
					}
					divisor.put(i, cnt);				// 카운트 입력
				}				
			}
		}		

		for (Object obj : divisor.entrySet()) {
			System.out.println(obj);
		}
		

	}

}

