package sec02.exam02;
/*
중첩클래스 종류 중에서

  	인스턴스 멤버 중첩클래스 에 대한 예제
	
	예제 : 인스턴스 멤버 중첩클래스 B내부에는 일반클래스와 똑같이
	변수(필드), 생성자, 메소드 선언이 올 수 있다.
	그리고 정적변수와 정적메소드는 java 17버전이상 설치해야 선언이 가능하다.
*/


class A { //바깥 클래스(외부클래스역할)
	
	//인스턴스 멤버 중첩클래스 선언
	class B {
		//인스턴스 변수 선언 가능
		int filed1 = 1;
		
		//정적 변수 선언 가능 (JDK 17버전부터 허용)
		static int filed2 = 2;
		
		//생성자
		B (){
			System.out.println("B 생성자 실행");
		}
		
		//인스턴스 메소드 선언 가능
		void method1() {
			System.out.println("B method1 실행");
		}
		
		//정적메소드 선언 가능 (JDK 17버전부터 허용)
		static void method2() {
			System.out.println("B method2 실행");
		}
		
	} //B 인스턴스 멤버 중첩클래스 닫음
	
	//A의 인스턴스 메소드 선언
	void userB() {
		//B 인스턴스 멤버 중첩클래스를 이용해 객체 생성 및 메소드 호출해서 사용가능
		B b = new B();
		b.method1(); //인스턴스 메소드 호출 가능
	//	b.method2(); <-- 쓸 수 있지만, 아래의 방법이 더 좋음
	//	A.B.method2(); //정적 메소드 호출 가능, 인스턴스 메소드 안에서 정적메소드 호출하는 경우는 드물다!
		System.out.println(b.filed1); //인스턴스 변수 값 가져와 사용 가능
		
	}
}

public class AExample {
	public static void main(String[] args) {
		A a = new A();
		a.userB();
		/*
			B 생성자 실행
			B method1 실행
			1
		*/

	}

}
