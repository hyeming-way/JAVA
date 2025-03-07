package sec05.exam01;

/*
	정적 멤버 중첩클래스는 바깥 객체가 없어도 사용가능 해야하므로
	바깥 클래스의 인스턴스변수와 인스턴스메소드는 사용하지 못한다.
*/


public class A { //바깥클래스
	
	//A클래스의 멤버(인스턴스변수 + 인스턴스메소드)선언
	int field1;
	void method1() {}
	
	//A클래스의 정적멤버(정적(클래스)변수 + 정적(클래스)메소드) 선언
	static int field2;
	static void method2() {}
	
	//A클래스의 멤버(정적 멤버 중첩클래스) 선언
	static class C { //중첩클래스 C
		void method() {
			//A의 인스턴스변수와 인스턴스메소드 사용가능?
			//field1 = 10; <--- 불가능. 정적중첩클래스는 정적멤버만 사용가능
			//method1(); <--- 불가능. 정적중첩클래스는 정적멤버만 사용가능
			
			//A의 정적변수와 정적메소드 사용가능?
			field2 = 10; //정적변수여서 가능
			method2(); //정적메소드여서 가능
		}
	
	} //class C
	
	class B { //A클래스의 인스턴트멤버 중첩클래스
		
		void method() {
			//A의 인스턴스변수와 인스턴스메소드 사용가능?
			field1 = 10;
			method1();
			//A의 정적변수와 정적메소드 사용가능?
			field2 = 20;
			method2();
			
			// 다 사용 가능~~!!!
	
		}
		
	} //class B

	public static void main(String[] args) {
		

	}

}
