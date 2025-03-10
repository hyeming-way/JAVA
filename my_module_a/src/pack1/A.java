package pack1;

import pack2.B;
import pack3.C; //my_module_b 모듈 프로젝트 내부에 만들어져있는 pack3 패캐지의 c클래스 사용


public class A {
	//메소드 선언
	public void method() {
		System.out.println("A-method 실행");
		
		//B클래스 사용
		B b = new B();
		b.method();
	}
	
	
	//메소드 선언
	public C getC() {
		return new C();
	}
		
}
