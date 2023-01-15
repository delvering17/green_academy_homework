package oops_p;

class Car {
	String name ;
	double point = 0;
	String seong ;
	void point (String seong) {
		System.out.println("성능 점수 기본: " + point );
	}
}

class SportsCar extends Car {
	int speed, mileage, design;
	public SportsCar (int speed, int mileage, int design) {
		this.speed = speed;
		this.mileage = mileage;
		this.design = design;
		point = speed*0.5 + mileage*0.2 + design*0.3;
		name = "스포츠카";
	}
	
	void point(String seong) {
		System.out.println(name + "의 성능 점수: " + "속도 " + speed + ", 연비 " + mileage + ", 디자인 " + design );
		System.out.println("점수 	계산:" + point);
	}

	
}

class truck extends Car {
	int mileage, loadage;
	public truck (int mileage, int loadage) {
		this.mileage = mileage;
		this.loadage = loadage;
		point = mileage*0.6 + loadage*0.4;
		name = "트럭";
	}
	
	void point(String seong) {
		System.out.println(name + "의 성능 점수: " + "연비 " + mileage + ", 적재량 " + loadage );
		System.out.println("점수 계산:" + point);
	}
}

class van extends Car {
	int speed, mileage, people;
	public van (int speed, int mileage, int people) {
		this.speed = speed;
		this.mileage = mileage;
		this.people = people;
		point = speed*0.15 + mileage*0.35 + people*0.5;
		name = "승합차";
	}
	
	void point(String seong) {
		System.out.println(name + "의 성능 점수: " + "속도 " + speed + ", 연비 " + mileage + ", 탑승인원 " + people );
		System.out.println("점수 계산:" + point);
	}
}

public class CarWork {

	public static void main(String[] args) {
		Car[] c = {
			new SportsCar(50, 20, 30),
			new SportsCar(100, 100, 100),
			new SportsCar(11, 22, 33),
			new truck(60,40),
			new truck(47,59),
			new van(100,2,36),
			new van(50,98,100),
		};
		
		for (Car a : c) {
			a.point("성능점수");
		}

	}

}

/*
자동차 성능 테스트 하세요

자동차 클래스로 성능확인 가능할 것

차종 에 따른 연산 식 다르게 할 것
차종
 스포츠카  : 속도 50 , 연비 20, 디자인 30
트럭 : 연비 60, 적재량 40
승합차 : 속도 15, 연비 35, 탑승인원 50

으로 각 성능점수를 계산토록 할 것


*/