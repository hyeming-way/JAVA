
//주제 : 업캐스팅을 하는 이유 응용1

//부모클래스 (알파벳 설계도)
class Alphabet {

	//개선된 코드 예
	
	//부모클래스의 모든 자식객체의 주소를 하나의 매개변수로 모두 전달받아
	//처리하는 메소드 하나만 선언
	public static void printAlphabet(Alphabet alphabet) { //<--- new A1();, new B1();, new C1(); (업캐스팅)
		
		alphabet.display(); //다형성으로 자식클래스의 오버라이딩된 메소드가 최종 실행됨
		
	}
	
	//부모 Alphabet클래스에서 만든 메소드
			public void display() {
				System.out.println("I am the parent class:Alphabet");
	
			}		
/*	
 	안 좋은 방법의 코드 예
 	
	//A1객체 메모리 주소 하나를 매개변수a로 받아서 처리하는 메소드
	public static void printA(A1 a) { //<--- new A1();
		a.display();
	}
	
	//B1객체 메모리 주소 하나를 매개변수b로 받아서 처리하는 메소드
	public static void printB(B1 b) { //<--- new B1();
		b.display();
	}
	
	//C1객체 메모리 주소 하나를 매개변수c로 받아서 처리하는 메소드
	public static void printC(C1 c) { //<--- new C1();
		c.display();
	}
*/	
	
}

//자식클래스1 (A1 알파벳 설계도)
class A1 extends Alphabet {
	
	@Override
	public void display() {
		System.out.println("I am class A1");
	}
	
}

//자식클래스2 (B1 알파벳 설계도)
class B1 extends Alphabet {
	
	@Override
	public void display() {
		System.out.println("I am class B1");
	}
	
}

//자식클래스3 (C1 알파벳 설계도)
class C1 extends Alphabet {
	
	@Override
	public void display() {
		System.out.println("I am class C1");
	}
	
}

public class Test {
	public static void main(String[] args) {
		
	
			// 개선된 코드 예
			Alphabet.printAlphabet(new A1());
			Alphabet.printAlphabet(new B1());
			Alphabet.printAlphabet(new C1());
		
		
		/*
			좋지 않은 코드 예
			
			Alphabet.printA(new A1());
			Alphabet.printB(new B1());
			Alphabet.printC(new C1());
		*/

	}

}
