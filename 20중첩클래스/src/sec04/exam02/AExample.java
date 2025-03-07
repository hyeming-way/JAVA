package sec04.exam02;

/*
	로컬(지역)중첩클래스?
	- 바깥외부 클래스의 생성자 또는 메소드 중괄호{} 내부에 만들어지는 중첩클래스
*/

class A { //바깥외부클래스
	//생성자
	A(){
		//로컬 중첩클래스 선언 가능
		class B{}
		//로컬중첩클래스를 이용해 객체 생성
		B b = new B();
	}
	
//	B b = new B(); <- 로컬중첩클래스는 생성자, 메소드 외부에서 객체 생성 불가능
	
	//메소드
	void method() {
		//로컬 중첩클래스 선언 가능
		class B{}
		B b = new B();
	}
	

}
public class AExample {
	public static void main(String[] args) {

	}

}
