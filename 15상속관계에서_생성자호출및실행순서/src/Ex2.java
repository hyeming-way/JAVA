
/*
	주제 : 상속관계에서 자식클래스의 객체메모리가 생성될때
		  생성자가 호출되는데 자동으로 어떤 부모생성자가 호출되고 실행되는가?
		  
	조합1. 자식클래스의 객체메모리가 생성될때
		  자식클래스의 기본생성자를 호출하면
		  부모클래스의 기본생성자가 있으면 자동(super())으로 호출된다.
*/

class AA /*extends Object*/ { //부모클래스
	
	//기본생성자
	public AA () {
		//super(); <-- 부모 Object 클래스의 Object() 기본생성자 호출구문이 생략된 것
		System.out.println("AA의 기본생성자");
	}
	
	//매개변수가 1개인 생성자
	public AA(int x) {
		System.out.println("AA의 매개변수가 1개인 생성자");
	}
}

//---------------------------------------------------------------------------------

class BB extends AA {
	
	//기본생성자
	public BB() {
		//super(); <-- 부모 AA 클래스의 기본생성자 AA() 호출 구문 생략
		System.out.println("BB자식의 기본생성자");
	}
	
	//매개변수가 1개인 생성자
	public BB(int x) {
		System.out.println("BB의 매개변수가 1개인 생성자");
	}
	
}

public class Ex2 {

	public static void main(String[] args) {
		
		new BB(); //자식 BB클래스의 객체생성하는 동시에 기본생성자 호출!
		

	}

}
