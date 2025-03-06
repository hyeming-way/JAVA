
/*
	추상?
	- 사전적의미 : 실체(객체)간의 공통되는 특성을 추출한 것을 말한다.
	  예를 들어 새, 곤충, 물고기 등의 공통점은 동물입니다.
	  여기서 동물은 실체(객체)들의 공통되는 특성을 가지고 있는 추상적인 것이라 볼 수 있다.
	  
	추상클래스?
	- 일반클래스(완성된 설계도) : 객체를 생성할 수 있는 일반 클래스
	  						 메소드가 완전히 구현부까지 완성되어 있는 클래스
	- 추상클래스(미완성 설계도)
		-> 일반클래스들의 공통적인 변수나 메소드들을 추출해서 선언한 미완성 설계도
	- 추상클래스는 일반(완성된)클래스의 부모클래스 역할을 합니다.
	  따라서 일반클래스는 추상클래스를 상속받아 공통적인 변수나 메소드를 물려받을 수 있다.
	  
	  
	  그림
	  		
	  				    Animal.class <-------- 추상클래스(부모추상클래스)
	  				    
	  				       상속
	  				 
	  				 
	  		Bird.class     Insect.class    Fish.class  <---실체 클래스
	  		
     -  추상 클래스는 실체 클래스의 공통되는 변수나 메소드를 추출해서 만들었기때문에
     	new 연산자를 사용해 객체를 직접 생성할수 없다.
     	예)  Aniaml animal = new Aniaml();   X  객체 생성 
     	
     -  추상 클래스는 새로운 자식(실체)클래스를 만들기 위한 부모 클래스의 역할로만 사용된다
        즉, 추상클래스는 extend 뒤에만 올수 있다.
        
        	예)
        			class Fish extends Animal{
        			
        			
        			}
        			
	 - 추상클래스 선언 문법
	 
	 	public abstract class 추상클래스명 {
	 		//상수
	 		//변수
	 		//생성자
	 		//일반메소드
	 		//추상메소드  	
	 	}

	설명 : 추상클래스도 상수, 변수, 메소드를 선언할수 있다.
          그리고 자식객체가 생성될때 super()로 추상클래스의 생성자가 호출되기때문에
          생성자도 반드시 1개 이상은 있어야 한다.
          또한 추상메소드가 추가로 작성됩니다.
          
*/

//전화기 종류 : 스마트폰, 아이폰, 일반전화, 공중전화
// 추상화 : 전화를 걸 수 있다. (공통점)

//모든 전화기의 공통변수와 메소드만 뽑아내서 추상클래스 Phone 선언
abstract class Phone { //추상클래스이자 부모역할을 하는 클래스
	//변수
	String owner;
	
	//생성자
	public Phone(String owner) {
		this.owner = owner;
	}
	
	//일반메소드
	void turnOn() {
		System.out.println("폰 전원을 켭니다.");
	}
	void turnOff() {
		System.out.println("폰 전원을 끕니다.");
	}
	
	//추상메소드
	//abstract void call();
}

//추상클래스를 상속받은 자식클래스
class SmartPhone extends Phone {
	
	//생성자
	public SmartPhone(String owner) {
		super(owner); //부모 Phone 생성자를 호출해서 owner 매개변수로 받은 데이터 초기화
	}
	
	//메소드
	void internetSearch() {
		System.out.println("인터넷 검색합니다.");
	}
	
}


public class PhoneExample {
	public static void main(String[] args) {
		
		//1. 추상클래스 Phone을 이용하여 객체 생성 X
	//	Phone phone = new Phone("철수");
		
		//2. 추상클래스 Phone의 자식클래스(실체클래스) SmartPhone에 대한 객체 생성은 허용 O
		SmartPhone smartPhone = new SmartPhone("홍길동");
		smartPhone.turnOn(); //"폰 전원을 켭니다." - Phone 추상클래스의 메소드
		smartPhone.internetSearch(); //"인터넷 검색합니다." - SmartPhone의 메소드
		smartPhone.turnOff(); //"폰 전원을 끕니다." - Phone 추상클래스의 메소드
		
	    /*
			결론 :  Phone객체는 new 연산자로 직접 생성할수 없었지만
				   자식객체인 SmartPhone은 new연산자로 객체 생성이 가능하고,
				   Phone으로 부터 상속(물려)받은 turnOn()메소드와
				   turnOff()메소드를 호출할수 있다.
		*/
		
	}

}
