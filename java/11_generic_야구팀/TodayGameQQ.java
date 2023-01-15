package Q;

import java.util.Comparator;
import java.util.TreeMap;




public class TodayGameQQ {

	public static void main(String[] args) {
		
		
		// 헛발질 
		/*
		TreeMap t = new TreeMap();
		
		TreePlayer [] tp ;
		for (String a :arr11) {
			tp.add(new TreePlayer(a.substring(0,1),Integer.parseInt(a.substring(1,a.length()))));
		}
		
		for (Object obj : tp) {
			System.out.println(obj);
		}
		*/
		
/*	약수 구하기와 비슷?	
		h	TreeMap			a  TreeMap
		num cnt			num cnt
*/		
		String [] arr11 = {"h22","h23","h11","a3","a7","a22","h23","a11","h5","a3","h8","a11","h22","h23"};
		
		
		TreeMap hTeam = new TreeMap();
		TreeMap aTeam = new TreeMap();
		
		String team = "";
		int num = 0, cnt = 1;
		
		for (String a: arr11) {
			team = a.substring(0,1);
			num = Integer.parseInt(a.substring(1,a.length()));
	
			if (team.equals("h")) {
				
			
				cnt=1;
				if(hTeam.containsKey(num)) {
					cnt += (int)hTeam.get(num);
				}								
				hTeam.put(num,cnt);					
			} 
			if (team.equals("a")) {
				
				cnt=1;
				if(aTeam.containsKey(num)) {
					cnt += (int)aTeam.get(num);
				}			
				aTeam.put(num,cnt);								
			}
			
			
			
		}
	
		System.out.println("---H팀---");
		for (Object obj : hTeam.entrySet()) {
			System.out.println(obj);
		
		}
		

		System.out.println("---A팀---");
		for (Object obj : aTeam.entrySet()) {
			System.out.println(obj);
		}
		
		
		

		
		
		
		
	}

}

/*
////// 오늘 경기 기록을 출력하세요
  입력: "h22","h23","h11","a3","a7","a22","h23","a11","h5","a3","h8","a11","h22","h23"..........


 출력내용

  h : 홈팀,  a:상대팀

  각 팀별로 선수가 안타를 친 갯수를 출력하세요

 단 선수번호는 오름차순으로 정렬

ex)

홈팀

22 : 2

23 : 3

...

상대팀

3 : 2

7 : 1

....



*/