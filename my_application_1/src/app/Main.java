package app;

//my_lip.jar 라이브러리 파일에 포함된
//pack1패키지 안에 만들어져 있는 A클래스를 
//현재 Main.java의 Main 클래스 내부에서 사용하기 위해 불러옴
import pack1.A;
import pack2.B;


public class Main {
	public static void main(String[] args) {
		//my_lib.jar 라이브러리에서 불러온 A클래스를 이용해 객체 생성가능
		A a = new A();
		a.method();
		//출력결과
		//A-method 실행
		
		//my_lib.jar 라이브러리에서 불러온 B클래스를 이용해 객체 생성가능
		B b = new B();
		b.method();
		//출력결과
		//B-method 실행

	}

}
