
/*
	예제
	조합3. 상속관계에서 자식객체생성시 매개변수가 있는 자식의 생성자 호출하면
		  부모클래스의 기본생성자 super()에 의해 자동으로 호출됨
		  
		  자식클래스의 매개변수_생성자(5); -> 부모클래스의 기본생성자(); 호출됨
*/


//부모클래스
class F {
	public F() {
		System.out.println("기본생성자 F");
	}
	
	//매개변수가 1개인 생성자
	public F(int d) {
		System.out.println("F부모의 매개변수가 하나인 생성자 F");
	}
	
}

//자식클래스
class G extends F {
	
	public G() {
		System.out.println("기본생성자 G");
	}
	
	//매개변수가 1개인 생성자
	public G(int x) {
		//super(); 부모클래스의 ***기본생성자***를 호출하는 구문이 생략됨
		System.out.println("G자식의 매개변수가 하나인 생성자 G");
	}
	
}

public class Ex4 {
	public static void main(String[] args) {
		
		new G(5);

	}

}
