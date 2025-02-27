

//1단계 : 현실의 소나타 객체를 모델링
// - 데이터 : 브랜드, 색상, 속도
// - 기능 : 가속, 감속

//2단계 : 자바코드로 class 설계 (데이터 + 기능)
public class Car {
	
	//클래스변수 선언
	String brand;
	String color;
	int speed;
	
	//클래스메소드 선언
		//accelerate : 자동차 속도를 10 증가시킴
		//"Hyundai 가속! 현재속도 : 0 km/h" <-출력
		public void accelerate() {
			speed += 10;
			System.out.println(brand + " 가속! 현재속도 : " + speed + " km/h");	
		}	
	
		//break : 자동차 속도를 10감소시킴 (최소 0까지)
		//"Hyundai 감속! 현재속도 : 90 km/h" <-출력
		public void break1() {
			if(speed>0) {
				speed -= 10;
			}		
			System.out.println(brand + " 감속! 현재속도 : " + speed + " km/h");	
		}

	public static void main(String[] args) {
		
		//3단계 : 객체 생성 후 데이터 저장 및 사용
				
		//1. Car 클래스 이용해 객체메모리 생성
		Car mycar = new Car();
		
		//2. 브랜드명을 Hyundai로 저장
		//	 색상을 Red로 저장
		//   속도를 0로 저장
		mycar.brand = "Hyundai";
		mycar.color = "Red";
		mycar.speed = 0;
		
		//3. 가속 기능 실행
		//   가속 기능 실행
		//   감속 기능 실행
		mycar.accelerate();
		mycar.accelerate();
		mycar.break1();
		
		/*
			출력결과
			Hyundai 가속! 현재속도 : 10 km/h
			Hyundai 가속! 현재속도 : 20 km/h
			Hyundai 감속! 현재속도 : 10 km/h
		*/

	}

}
