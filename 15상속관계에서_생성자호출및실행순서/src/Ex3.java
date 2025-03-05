
//예제 : 상속관계에서 자식클래스의 객체메모리 생성시
//		기본생성자를 호출했을 때, 부모클래스 내부에 개발자가 기본생성자를
//		만들어 놓지 않은 경우 컴파일 오류가 발생하는 예

//부모클래스
class D {
	private int d;
	
	//개발자가 직접 기본생성자 만들지않음!
	//참고.개발자가 클래스 내부에 생성자를 1개이상 만들어 놓으면
	//	  자바 컴파일러는 기본생성자를 만들어놓지않는다.
	//	  그러므로, 개발자가 기본생성자를 직접 만들어줘야 사용할 수 있다.
	
	//매개변수가 1개인 생성자
	public D(int d) {
		this.d = d;
	}
	
}

//자식클래스
class E extends D {
	
	public E() { //<----- 부모클래스에서 기본생성자를 만들지 않아서 오류발생
		//super(); <-부모 D클래스의 기본생성자 호출구문 생략
		System.out.println("E자식 클래스의 기본생성자");
	}
	
}

public class Ex3 {
	public static void main(String[] args) {
		
		//E자식클래스의 객체메모리 생성시 ~ 기본생성자 호출!
		E e = new E();
		
		/*	   
		Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
		Implicit super constructor D() is undefined. 
		Must explicitly invoke another constructor

		at E.<init>(Ex3.java:23)
		at Ex3.main(Ex3.java:32)

			결론:자식클래스E의 기본생성자에서 super();부모D클래스의 기본생성자 호출구문을 이용해
			    호출 했지만 개발자가 직접 기본생성자를 만들어 놓지 않았기때문에
			    컴파일러에 의해 예외(오류)가 발생 했습니다
		    
		    참고. 클래스 내부에 생성자를 1개이상을 만들어 놓지 않으면
		     	 컴파일러가 기본생성자를 자동으로 만들어 클래스 내부에 삽입해 준다.
		*/		

	}

}
