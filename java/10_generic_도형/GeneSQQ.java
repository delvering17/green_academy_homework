package Q;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;



class GenShape implements Comparable {
	String name;
	double area, border;
	
	
	@Override
	public String toString() {
		return name + " : " + area + "," + border;
	}


	@Override
	public int compareTo(Object o) {
		GenShape you = (GenShape)o;
		int res = (int)(area - you.area );
		
		if (res == 0) {
			res = (int) (border - you.border);	
		}
		return res ;
	}
	
	
	
}

class GenRectangle extends GenShape{
	public GenRectangle(int w, int h) {
		name = "직사각형";
		area = w * h ;
		border = (w+h)*2;
		
	}
}

class GenCircle extends GenShape{
	public GenCircle(int r) {
		name = "원";
		area = r * r * Math.PI; ;
		border = Math.PI*r*2;
		
	}
}

 


public class GeneSQQ {

	public static void main(String[] args) {
		
		ArrayList<GenShape> arr = new ArrayList<GenShape>();
		arr.add(new GenRectangle(5,6));
		arr.add(new GenCircle(5));
		arr.add(new GenRectangle(10,6));
		arr.add(new GenCircle(8));
		arr.add(new GenCircle(10));
		arr.add(new GenRectangle(8,7));
		
		Iterator<GenShape>it = arr.iterator();
		TreeMap tm = new TreeMap();
		
		while(it.hasNext()) {
			GenShape gs = it.next();
			
			
			if (!tm.containsKey("원")) {
				tm.put(gs.name,new TreeSet());
			} 
			if (!tm.containsKey("직사각형")) {
				tm.put(gs.name,new TreeSet());
			} 
			
			((TreeSet)tm.get(gs.name)).add(gs);
		}
		Set ss = tm.entrySet();
		for (Object obj : ss) {
			Map.Entry go = (Map.Entry)obj;
				
			System.out.println(""+go.getKey()+ go.getValue());
		}
		
		/*
		for (GenShape gs :arr) {
			System.out.println(gs.name+"=>" +gs.area);
		}
		*/
		
		
	}

}
/*
 		
		
*/
/*

도형별로 나누어 정렬하여 출력하세요

​

구분 : 도형이름

정렬순서 : 넓이 > 둘레 내림차순 기준

​

​

*/