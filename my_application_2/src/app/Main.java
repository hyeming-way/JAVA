package app;

//my_module_a 모듈 프로젝트에서 가져옴
import pack1.A;
//import pack2.B;  //<-- my_module_a의 모듈기술자 파일에 exports 하지않았기때문에 (은닉화)
					 //불러올 경우 에러가 발생한다.

//my_module_b 모듈 프로젝트에서 가져옴
import pack3.C;
import pack4.D;


public class Main {
	public static void main(String[] args) {
		//my_module_a 모듈프로젝트 내부의 패키지에 포함된 A, B클래스 이용해 객체 생성
		A a = new A();
		a.method(); //"A-method 실행"

		
	//	B b = new B();  //<-- import 되지않기때문에 에러가 발생함
		
		
		//my_module_b 모듈프로젝트 내부의 패키지에 포함된 C, D클래스 이용해 객체 생성
		C c = new C();
		c.method(); //"C-method 실행"
		
		D d = new D();	
		d.method(); //"D-method 실행"
		
		System.out.println("---------------------------------");
		
		//-------------------------------------------------------------------------------
		
		C result = a.getC(); // -> new C(); 객체메모리를 C클래스 자료형 타입으로 반환
		result.method(); //"C-method 실행"
		
	}

}
