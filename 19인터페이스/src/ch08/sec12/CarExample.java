package ch08.sec12;

//부모인터페이스
interface Tire {
	//추상메소드
	void roll(); //굴러간다는 기능
}

//Tire 부모인터페이스의 roll 추상메소드를 구현한(메소드오버라이딩한)
//자식 HabkookTire 클래스 생성
class HankookTire implements Tire {
	@Override
	public void roll() {
		//한국타이어의 기능에 맞게 추상메소드 강제로 오버라이딩(재정의, 재작성)
		System.out.println("한국타이어가 굴러갑니다.");
	}	
}

//Tire 부모인터페이스의 roll 추상메소드를 구현한(메소드오버라이딩한)
//자식 KumhoTire 클래스 생성
class KumhoTire implements Tire {
	@Override
	public void roll() {
		//한국타이어의 기능에 맞게 추상메소드 강제로 오버라이딩(재정의, 재작성)
		System.out.println("금호타이어가 굴러갑니다.");
	}	
}

//Car클래스 만들기
class Car {
	//변수(필드)
	// -> 금호타이어 또는 한국타이어 클래스의 객체메모리를 생성해서 주소번지를 저장할 변수
	// -> 문법	부모인터페이스자료형 참조변수 = new 자식클래스의생성자호출();
	private Tire tire1 = new HankookTire(); //<- new KumhoTire(); 나중에 대신 변경해서 저장할 것이다.
	private Tire tire2 = new HankookTire(); //<- new KumhoTire(); 나중에 대신 변경해서 저장할 것이다.
	
	//메소드
	//setter 메소드 추가 (타이어 교체 기능)
	public void setTire1 (Tire tire) {
		this.tire1 = tire;
	}
	
	public void setTire2 (Tire tire) {
		this.tire2 = tire;
	}
	
	
	void run() {
		this.tire1.roll();
		this.tire2.roll();
	}
}


public class CarExample {
	public static void main(String[] args) {
	
		//Car클래스의 객체 생성(자동차 객체 생성)
		Car myCar = new Car();
		myCar.run();
	    /*
		    한국타이어가 굴러갑니다.
		    한국타이어가 굴러갑니다.
		*/
		
		//setter메소드를 이용한 금호타이어 교체
		myCar.setTire1(new KumhoTire());
		myCar.setTire2(new KumhoTire());
		myCar.run();
		/*
			금호타이어가 굴러갑니다.
			금호타이어가 굴러갑니다.
		*/
		
	}

}
