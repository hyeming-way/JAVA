package 생성자;
/*
	1. 생성자(Constructor)란?
		- 클래스가 객체로 생성될 때 자동으로 호출되는 특별한 메소드입니다.
		- 생성하는 객체메모리의 객체변수를 빠르게 저장(초기화) 담당을 한다.
		- 생성자 이름은 클래스이름과 동일해야 한다.
		- 생성자는 return 반환할 자료형을 기술하지않는다. (void 조차 작성하지않는다)
		- new 키워드를 사용하여 객체메모리를 생성할 때 생성자 호출구문을 작성해놓으면 자동으로 단 한번만 호출되서 실행됨
		
	2. 생성자 작성 문법
		
		class 클래스이름 {
		
			//생성자
			접근제어자 클래스명(매개변수(선택)){
			
				//객체 변수를 초기화하는 코드 작성
			
			}
		}
		
		📌 생성자의 구성 요소
		-------------------------------------------------------------------------
		[구성요소]									[설명]
		-------------------------------------------------------------------------
		접근제어자						public, private, protected, default 중 하나 사용
		-------------------------------------------------------------------------
		클래스이름						생성자의 이름은 반드시 클래스의 이름과 동일해야 함
		-------------------------------------------------------------------------
		매개변수						객체를 생성할 때 필요한 데이터를 전달받는 역할 (생략 가능)
		-------------------------------------------------------------------------
		객체 변수 초기화				생성자가 실행되면 객체 변수(필드)의 값을 저장하는 코드 작성
		-------------------------------------------------------------------------	
		
		
		📌 생성자의 특징
	  
		  1.클래스와 같은 이름을 사용해야 한다.
			- 클래스 이름이 Car라면, 생성자도 Car여야 함. 
					
		  2.반환 타입이 없다.
			- void, int, String 같은 반환 타입을 적으면 안 됨.
			- 따라서 return 문도 사용하지 않음.
		
		  3.객체를 만들 때(new 클래스이름()) 자동으로 실행된다.
		
		  4. 매개변수를 가질 수도 있고, 가질 필요가 없을 수도 있다.
			 - 매개변수를 가지지 않는 생성자는 기본 생성자라고 함. 
		 
		 
		 📌 생성자의 종류
			 1.기본생성자 - 매개변수를 작성하지 않고 객체변수의 값을 초기화시키는 코드가 작성된 생성자
			 
			     public 생성자명(){ 객체변수초기화코드;   }
			
			 2.매개변수가 있는 생성자 - 객체를 만들 때 객체변수들의 초깃값을 직접 저장할수 있도록 도와주는 생성자
			 
			 	 public 생성자명(매개변수,매개변수,....){   객체변수_초기화할_코드; }	   
		
*/

//자동차(Car)클래스를 만들고, 생성자를 정의해보자.
class Car{
	
	//1. 멤버변수(객체변수) 정의
	String brand;
	int speed;
	
	//2. 기본생성자 (매개변수 없는 생성자)
	public Car() {
		System.out.println("자동차 Car객체메모리가 생성되었습니다.");
		brand = "미정";
		speed = 0;
	}
	
	//3. 매개변수가 있는 생성자 (객체메모리 내부의 객체변수값 빠르게 초기화하는 역할)
	public Car(String brand_, int speed_) {
		
		brand = brand_; 
		speed = speed_;
		//객체변수명과 매개변수명 동일하게 할 수있음. 나중에 this 예약어 사용해서 사용 가능
		
		System.out.println("자동차 브랜드 : " + brand + ", 속도 : " + speed + "km/h");
		
	}
	
	
}


public class Ex2 {
	
	//생성자
	/*
	public Ex2(매개변수) {
		
	}
	*/
	
	//new Ex2(); <- 객체메모리 생성시 보이진 않지만 위 처럼 생성자가 만들어짐.
	//()안에 매개변수를 넣으면 객체메모리의 객체변수를 빠르게 초기화 할 수 있음.
	//반환타입이 없음. 반환타입으로 메소드인지 생성자인지 구분 가능~!
	//객체메모리 생성시 단 *한번만* 호출하여 실행됨.

	public static void main(String[] args) {
		
	//4. 생성자를 사용해 객체메모리 만들기
		
		//기본생성자 사용
		Car car1 = new Car(); //자동차 Car 객체메모리가 생성되고,
							  //brand = "미정", speed = 0; 으로 초기화
		
		//매개변수가 있는 생성자 사용
		Car car2 = new Car("BMW", 120); //brand = "BMW", speed = 120; 으로 초기화

	}

}
