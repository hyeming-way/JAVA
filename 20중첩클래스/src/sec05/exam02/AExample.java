package sec05.exam02;

/*
	중첩클래스 내부에서 바깥 외부 클래스에 대한 객체메모리에 접근방법
	
		바깥클래스명.this
		
	중첩클래스 내부에서 중첩클래스에 대한 객체메모리에 접근방법
		
		this
		
*/
//예제 : 중첩클래스와 바깥클래스가 동일한 이름의 인스턴스변수와 메소드를 가지고 있을 경우
//		바깥 객체 소속의 변수와 메소드를 사용하는 방법

class A { //바깥클래스
	
	//인스턴스 멤버 선언
	String field = "A-Field";
	void method() {
		System.out.println("A-method");
	}
	
	//인스턴스멤버 중첩클래스 B 선언
	class B {
		//바깥클래스의 인스턴스멤버와 동일한 이름의 중첩클래스의 인스턴스멤버 선언
		String field = "B-Field";
		void method() {
			System.out.println("B-method");
		}
		
		//B만의 인스턴스메소드 추가
		void print() {
			//B 객체의 인스턴스 변수와 인스턴스 메소드 사용을 위해 this 이용
			System.out.println(this.field);
			this.method();
			
			//외부 A객체의 변수와 메소드 사용
			System.out.println(A.this.field);
			A.this.method();
		}//print
		
	} //class B
	
	//A만의 인스턴스 메소드
	void useB() {
		B b = new B();
		b.print();
	}//useB
	
} //class A


public class AExample {
	public static void main(String[] args) {
		A a = new A();
		a.useB();
		/*
			B-Field
			B-method
			A-Field
			A-method
		*/

	}

}
