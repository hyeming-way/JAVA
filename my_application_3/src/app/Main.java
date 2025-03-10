package app;

//my_module_a 모듈프로젝트의 pack1, pack2 패키지 내부에 만든 A, B class 불러와 사용
import pack1.A;
import pack2.B;

//my_module_b 모듈프로젝트의 pack3 패키지 내부에 만든 C class 불러와 사용
import pack3.C;


public class Main {
	public static void main(String[] args) {
		
		//my_module_a 모듈프로젝트의 pack1패키지에 포함된 A클래스 이용
		A a = new A();
		a.method();
		//출력결과 : A-method 실행
		
		//my_module_a 모듈프로젝트의 pack2패키지에 포함된 B클래스 이용
		B b = new B();
		b.method();
		//출력결과 : B-method 실행
		
		//my_module_b 모듈프로젝트의 pack3패키지에 포함된 C클래스 이용
		C c = new C();
		c.method();
		//출력결과 : C-method 실행
		

	}

}
