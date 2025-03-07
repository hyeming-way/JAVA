package sec02.exam01;
/*
	1) 중첩클래스란?
		- 클래스 내부에 선언한 클래스
	
	2) 중첩클래스 주요 사용 목적
		- 특정 클래스와 강하게 연관된 클래스를 논리적으로 묶기 위헤
		- 캡슐화 강화하여 외부 접근을 제한하기 위해
		- 코드의 가독성과 유지보수성을 높이기 위해
	
	3) 중첩클래스 종류 2가지
		1. 멤버중첩클래스 : 클래스내부에 선언한 클래스
		2. 로컬중첩클래스 : 클래스의 메소드 내부에 선언한 클래스
		
		1. 멤버중첩클래스 2가지
		
			[1] 인스턴스 멤버중첩클래스
			
				class A {
				
					class B{ 		<--- 인스턴스 멤버중첩클래스 B
					
					}
					
				}
			
			[2] 정적(static)멤버중첩클래스
			
				class A {
				
					static class C { 	<--- 정적멤버중첩클래스 C
					
					}
				
				}
				
		2. 로컬중첩클래스
		
			class A {
			
				void method(){
				
					class B{ 		<---로컬중첩클래스
					
					}
					
				}
			}
*/

/*
예제. 인스턴스 멤버 중첩클래스 B는 주호 A외부클래스 내부에서 사용되므로
     private 접근 제어자를 갖는것이 일반적입니다.
     B객체는 A외부클래스 내부 어디에서나 생성할수는 없고,
     참조변수 field, 생성자, 인스턴스메소드 내부에서 생성할수 있다.
	 이유는  A객체가 생성되어 있어야  안쪽 B중첩클래스의 객체도 생성할수 있기때문입니다
*/

class A { //바깥쪽(외부) 클래스
	
	class B { //인스턴스 멤버 중첩클래스 B		
		
	}
	
	B filed = new B();
	//인스턴스(참조)변수 값으로 B객체를 생성해서 주소번지 저장 가능
	
	//바깥쪽(외부) A클래스의 생성자
	A(){
		B b = new B();
	}
	
	//바깥쪽(외부) A클래스의 인스턴스 메소드
	void method() {
		B b = new B();
	}
		
}

public class AExample {
	public static void main(String[] args) {
		
		//B 인스턴스 멤버 중첩클래스에 대한 객체를 A클래스 외부 AExample내부에서
		//생성하려면 default 또는 public 접근 제한을 가져와야하고
		//순서는 A외부객체를 먼저 생성한 다음에 안쪽 B객체를 생성해야 합니다.
		
		//순서1. A외부클래스의 객체를 먼저 생성
		A a = new A();
		
		//순서2. B 인스턴스 멤버 중첩클래스의 객체 생성 문법
		// -> 외부클래스명.내부중첩클래스자료형명 참고변수 = 생성된_외부객체의_참조변수명.new 내부중첩의생성자();
		A.B b = a.new B();
		
		//중요한 점!
		//A.B b = new A.B(); 이렇게는 B객체를 만들 수 없음 (A 객체가 필요하기 때문)
		//무조건 A a = new A();를 먼저 실행한 후 a.new B(); 방식으로 B 객체를 생성해야 함.

	}

}
