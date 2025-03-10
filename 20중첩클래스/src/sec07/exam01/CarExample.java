package sec07.exam01;

/*
	익명클래스
	  - 이름이 없는 클래스
	  
	익명객체
	  - 이름이 없는 클래스를 이용해서 생성한 이름이 없는 객체
	  
	익명객체 종류
	  1. 익명자식객체 - 클래스를 상속해서 만든 이름없는 자식객체
	  2. 익명구현객체 - 인터페이스를 구현받아 만든 이름없는 자식객체
	  
	  
	익명자식객체
	  - 부모클래스를 상속받아 다음과 같은 문법으로 생성할 수 있다.
	  
	  		new 상속받은_부모클래스의_생성자_호출(){
	  		
	  			//이름이 없는 익명 클래스이자 익명객체의 구현코드를 작성하는 곳;
	  			
	  		};
	  		
	  의미1. 상속받은 부모클래스의 생성자를 호출해 이름이 없는 익명자식클래스를 만드는 동시에
	  의미2. 이름이 없는 익명자식객체메모리를 생성한다는 의미	   
*/


class Tire { //부모클래스
	
	//public Tire() {}	<--- 자바 컴파일러가 기본생성자를 자동으로 만들어준다.
	
	//부모클래스의 인스턴스 메소드 작성
	public void roll() {
		System.out.println("일반 타이어가 굴러갑니다.");
	}

} //class Tire


class Car { //자동차클래스
	
	//Tire 클래스의 참조변수를 만들고, new Tire()객체를 생성해서 주소번지를 저장
	private Tire tire1 = new Tire();
	
	
	//Tire클래스(부모) roll메소드를 오버라이딩 시킨 
	//이름이 없는 익명클래스 만드는 동시에 이름이 없는 익명자식객체 생성하여
	//private Tire tire2 인스턴스 변수에 주소번지 저장
	private Tire tire2 = new Tire() {

		//이름이 없는 익명자식클래스 그리고 익명자식객체의 구현코드가 들어갈 곳;
		//메소드 오버라이딩 roll
		//단축키 : alt + shift + s v
		@Override
		public void roll() {
			System.out.println("익명자식객체1이 굴러갑니다.");
		}
		
	};
	
	//Car 클래스의 인스턴스 메소드 run1만들기
	public void run1() {
		//부모 new Tire()객체메모리의 메소드 호출
		this.tire1.roll();
		//부모 Tire 클래스의 이름이 없는 익명자식객체메모리의 메소드 호출
		this.tire2.roll();
	}
	
	//Car클래스의 인스턴스메소드 run2만들기
	public void run2() {
		
		//로컬(지역)변수를 참조변수 형태로 만들어서
		//Tire 부모클래스의 roll메소드를 오버라이딩시킨
		//익명자식클래스(익명로컬자식클래스)이자 익명자식객체(익명로컬자식객체)를 생성해서
		//주소번지를 tire 참조변수에 저장
		Tire tire = new Tire() {
			//Tire 부모클래스의 roll메소드를 개발자가 메소드 오버라이딩
			@Override
			public void roll() {
				System.out.println("익명자식객체2가 굴러갑니다.");
			}
		};
		
		tire.roll();
		
	} //run2
	
	//Car클래스의 인스턴스 메소드 - 매개변수 이용
	public void run3(Tire tire) {
					//매개변수로 생성된 자식익명객체메모리의 주소를 받아 사용할 수 있음
		
		//매개변수 tire로 받은 익명자식객체 내부에 작성된
		//메소드 오버라이딩 해 놓은 roll 메소드가 호출!
		tire.roll();
		
	} //run3
	
} //class Car


public class CarExample {
	public static void main(String[] args) {
		
		//Car 클래스의 객체메모리 생성
		Car car = new Car();
		
		//익명자식객체가 대입된 참조변수 이용
		car.run1();
		//출력결과
		//일반 타이어가 굴러갑니다.
		//익명자식객체1이 굴러갑니다.
		
		//익명자식객체가 대입된 로컬변수 이용
		car.run2();
		//출력결과
		//익명자식객체2가 굴러갑니다.
		
		car.run3( new Tire() {
			@Override
			public void roll() {
				System.out.println("익명자식객체3이 굴러갑니다.");
			}
		} );
		//출력결과
		//익명자식객체3이 굴러갑니다.
		
		
	}//main

}//CarExample
