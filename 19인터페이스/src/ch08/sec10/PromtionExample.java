package ch08.sec10;

//최고 부모인터페이스 역할
interface A {} //상수, 추상메소드를 안 넣어도 인터페이스는 만들 수 있다!

//A인터페이스의 자식클래스B
class B implements A {}

//A인터페이스의 자식클래스C
class C implements A {}

//D클래스의 부모클래스 -> B클래스
//D클래스의 부모인터페이스 -> A인터페이스
class D extends B {} 

//E클래스의 부모클래스 -> C클래스
//E클래스의 부모인터페이스 -> A인터페이스
class E extends C {}


public class PromtionExample {
	public static void main(String[] args) {
		
		//업캐스팅(자동형변환)
		//-> 부모인터페이스자료형 참조변수 = 자식객체메모리생성;
		
		//자식객체생성
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		
		//부모인터페이스자료형 참조변수선언
		A a;
		
		//부모인터페이스자료형 참조변수에 자식객체 메모리 생성 후 주소값 저장
		a = b; //a = (A)b; <-- 원래는 (A)를 적어주어야하지만, 안 적어도 자동형변환이 일어남!! : 자동 타입 변환(업캐스팅)
		a = c;
		a = d;
		a = e;
		
	}

}
