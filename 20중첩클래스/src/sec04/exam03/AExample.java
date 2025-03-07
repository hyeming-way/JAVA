package sec04.exam03;

/*
	로컬 중첩클래스 B {} 중괄호 내부에는
	일반클래스처럼 변수, 생성자, 메소드 선언이 올 수 있다.
	단! 정적변수와 정적메소드는 JAVA 17버전부터 선언할 수 있다.
*/

class A { //바깥클래스
	
	//A의 인스턴스메소드
	void useB() {
		
		//로컬 중첩클래스 B
		class B{
			
			//인스턴스변수선언
			int field1 = 1;
			//정적변수선언 (JAVA 17버전부터 선언가능)
			static int field2 = 2;
			//생성자
			B(){
				System.out.println("B 생성자 실행");
			}
			//인스턴스 메소드
			void method1() {
				System.out.println("B method1 실행");
			}
			//정적 메소드 (JAVA 17버전부터 선언가능)
			static void method2() {
				System.out.println("B method2 실행");
			}
		}//B
		
		//로컬중첩클래스 B에 대한 객체 생성
		B b = new B();
		
		//로컬중첩 B객체의 인스턴스변수와 인스턴스메소드 호출
		System.out.println(b.field1);
		b.method1();
		
		//로컬중첩 B클래스의 정적변수와 정적메소드 호출
		System.out.println(b.field2);
		b.method2();
			
	}//useB
		
}

public class AExample {
	public static void main(String[] args) {
		A a = new A();
		a.useB();
		/*
			B 생성자 실행
			1
			B method1 실행
			2
			B method2 실행
		*/
	}
	
}
