package projectteam;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class StudentInput {
	String type, name, gender;
	int ban, kor,eng,math, art;
	int total, sum;
	public StudentInput (String type, String name, int ban, String gender, int ...score) {

		
		this.type = type ;
		this.name = name;
		this.ban = ban;
		this.gender = gender;
		this.kor = score[0] ;
		this.eng = score[1] ;
		this.math = score[2] ; 
		this.sum = (kor + eng + math + art);
		total = (kor + eng + math)/3;
		if(score.length==4) {
			art = score[3];
			total = (kor + eng + math + art)/4;
		}
		
	}

	
	@Override
	public String toString() {
		return   name + " " + ban + "반 " + gender +  " / 총합: " + sum + " 평균: " + total + "\t" ;
	}	

}

class type1Com implements Comparator {
	
	public int compare (Object o1, Object o2) {
		StudentInput me = (StudentInput)o1;
		StudentInput you = (StudentInput)o2;
		int res = me.type.compareTo(you.type);
		if (res == 0) {
			res = you.total -me.total ;
		}
		if (res == 0) {
			res = me.ban - you.ban;
		}
		
		return res;
		
	}
} 

class type2Com implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
	
		StudentInput in = (StudentInput)o1;
		StudentInput std = (StudentInput)o2;
		
		int res = in.type.compareTo(std.type);
		
		if(res==0) {
			res = in.ban-std.ban;
		}
		if(res==0) {
			res = std.total-in.total;
		}
		
		return res;
		
	}

}

class type3Com implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		StudentInput me = (StudentInput)o1;
		StudentInput you = (StudentInput)o2;
		int res = me.ban-you.ban;
		if(res==0) {
			res = me.gender.compareTo(you.gender);
		}
		if(res==0) {
			res =  you.total-me.total;
		}
		
		return res;
		
	}
	
}

class type4Com
implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		
		StudentInput me = (StudentInput)o1;
		StudentInput you = (StudentInput)o2;
		
		int res = me.ban-you.ban;
		if(res==0)	{
			res = me.name.compareTo(you.name);
		}
		
		if(res==0) {
			res = you.total-me.total;
		}
		
		return res;

	}

}


public class ClassProject {

	public static void main(String[] args) {
		
		System.out.println();
		System.out.println("type 1---------------");
		System.out.println();
	
		Set type1 = new TreeSet(new type1Com());
		
		type1.add(new StudentInput ("일반","송찬욱",1,"남",90,20,30));
		type1.add(new StudentInput ("일반","김경준",1,"여",80,30,40));
		type1.add(new StudentInput ("일반","나현우",2,"남",100,100,100));
		type1.add(new StudentInput ("일반","함한솔",2,"여",50,60,50));	
		type1.add(new StudentInput ("특기생","이찬순",1,"남",100,20,30,40));
		type1.add(new StudentInput ("특기생","박현순",1,"여",50,50,50,100));
		type1.add(new StudentInput ("특기생","최경순",2,"남",90,20,30,60));
		type1.add(new StudentInput ("특기생","김한순",2,"여",100,100,10,70));
		
	
	
		int a=0;
		int b=0;
		for (Object obj : type1) {		
			if(((StudentInput)obj).type=="일반") {
				if(a==0){
					System.out.println("일반");
				}
				a++;
				System.out.println(a + "등\t" + obj);
			}else {
				if(b==0){
					System.out.println("특기");
					
				}
				b++;
				System.out.println(b+"등\t"+obj);
			}		
		
		}
		
		System.out.println();
		System.out.println("type 2---------------");
		System.out.println();
		
		Set type2 = new TreeSet(new type2Com());
		
		type2.add(new StudentInput ("일반","송찬욱",1,"남",90,20,30));
		type2.add(new StudentInput ("일반","김경준",1,"여",80,30,40));
		type2.add(new StudentInput ("일반","나현우",2,"남",100,100,100));
		type2.add(new StudentInput ("일반","함한솔",2,"여",50,60,50));	
		type2.add(new StudentInput ("특기생","이찬순",1,"남",100,20,30,40));
		type2.add(new StudentInput ("특기생","박현순",1,"여",50,50,50,100));
		type2.add(new StudentInput ("특기생","최경순",2,"남",90,20,30,60));
		type2.add(new StudentInput ("특기생","김한순",2,"여",100,100,10,70));
		
		int i=0; 
		for (Object obj : type2) {
			i++;
			if(i==1) {
				System.out.println("일반");
				System.out.println("  1반");

			}
			if(i==3) {
				System.out.println("  2반");

			}
			if(i==5) {
				System.out.println("특기");
				System.out.println("  1반");
			}
			if(i==7) {
				System.out.println("  2반");

			}
			System.out.println("\t"+obj);
		}
		
		System.out.println();
		System.out.println("type 3---------------");
		System.out.println();
		
		Set type3 = new TreeSet(new type3Com());
		
		type3.add(new StudentInput ("일반","송찬욱",1,"남",90,20,30));
		type3.add(new StudentInput ("일반","김경준",1,"여",80,30,40));
		type3.add(new StudentInput ("일반","나현우",2,"남",100,100,100));
		type3.add(new StudentInput ("일반","함한솔",2,"여",50,60,50));	
		type3.add(new StudentInput ("특기생","이찬순",1,"남",100,20,30,40));
		type3.add(new StudentInput ("특기생","박현순",1,"여",50,50,50,100));
		type3.add(new StudentInput ("특기생","최경순",2,"남",90,20,30,60));
		type3.add(new StudentInput ("특기생","김한순",2,"여",100,100,10,70));
	
		i=0; 
		for (Object obj : type3) {
			i++;
			if(i==1) {
				System.out.println("1반");
				System.out.println("  남자");
			}
			if(i==3) {
				System.out.println("  여자");

			}
			if(i==5) {
				System.out.println("2반");
				System.out.println("  남자");

			}
			if(i==7) {
				System.out.println("  여자");

			}
			System.out.println("\t" + obj );
		}
		
		System.out.println();
		System.out.println("type 4---------------");
		System.out.println();
		
	
		Set type4 = new TreeSet(new type4Com());
		
		type4.add(new StudentInput("일반","송찬욱",1,"남",90,20,30));
		type4.add(new StudentInput("일반","김경준",1,"여",80,30,40));
		type4.add(new StudentInput("일반","나현우",2,"남",100,100,100));
		type4.add(new StudentInput("일반","함한솔",2,"여",50,60,50));
		type4.add(new StudentInput("특기생","이찬순",1,"남",100,20,30,40));
		type4.add(new StudentInput("특기생","박현순",1,"여",50,50,50,100));
		type4.add(new StudentInput("특기생","최경순",2,"남",90,20,30,60));
		type4.add(new StudentInput("특기생","김한순",2,"여",100,100,10,70));
		
		i=0 ;
		for (Object obj : type4) {
			i++;
			
			
			if(i==1) {
				System.out.println("1반");
			}
			if(i==5) {
				System.out.println("2반");
			}

			
			System.out.println("\t" + obj);
		
		}
		
	}

}

