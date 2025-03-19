
//함수형 인터페이스?
//  - 추상메소드를 **단 하나만** 가진 인터페이스
//	- 람다식을 작성할 때 사용되는 인터페이스

//@FunctionalInterface 어노테이션 기호
//  -> 이 인터페이스가 함수형 인터페이스임을 자바컴파일러에게 알려주는 기호

@FunctionalInterface
interface MathOperation {
	//operation 이라는 이름의 추상메소드를 정의함
	//기능 : 두 개의 정수를 매개변수로 각각 받아 int 타입의 값을 반환하는 메소드
	int operation(int a, int b);
}

public class Main {
	public static void main(String[] args) {
				
		/*
			람다식은 본질적으로 함수형 부모인터페이스의 자식 익명객체의 메소드를 구현하는 방식이며
			이 과정은 자바컴파일러에 의해 자동으로 처리됩니다.
			
			1. 익명클래스의 예시 : 익명클래스는 새로운 클래스에 이름을 정의하지않고,
							   바로 부모인터페이스나 부모클래스를 구현하는 객체를 생성하는 설계도입니다.				
		
		
		MathOperation add = new MathOperation() {
		@Override
		public int operation(int a, int b) {
			return a + b;
			}						
		};	
		
		System.out.println(add.operation(5, 3)); //8

		
		
			여기서 익명클래스는 MathOperation 부모인터페이스의 추상메소드 operation을
			강제로 구현(메소드오버라이딩)하는 익명객체를 생성하며,
			익명객체 내부에 operation 추상메소드를 강제로 오버라이딩해놓은것입니다.
			   
		*/
		
		/*
			2. 람다식의 예시 : 
			익명클래스 대신 람다식을 사용하면 코드가 훨씬 간결해집니다.
			람다식은 함수형 인터페이스의 추상메소드를 바로 구현하는 이름이 없는 익명메소드형태의 식입니다.

		*/
		//두개의 정수를 매개변수로 각각 전달받아서 더한 결괏값을 정수로 반환하는
		//MathOperation함수형 부모인터페이스 내부의 operation추상메소드를 강제로 오버라이딩한
		//이름이 없는 익명객체 내부에 ~~~ 이름이 없는 익명메소드를 작성해서  add참조변수에 익명객체주소저장
		
		MathOperation add = (int a, int b) -> {return a + b; };
							     // (a, b) -> a + b;
		System.out.println(add.operation(5, 3)); //8
		
		MathOperation subtract = (a, b) -> a - b;
		System.out.println(subtract.operation(5, 3)); //2

	}

}
