package ex1;

public class ExceptionHandlingExample3 {
	
	//참고.
	//Class.forName("특정클래스의 전체경로를 문자열로 전달");
	//이코드는 클래스가저장된 위치(ClassPath)에 만들어진 클래스를 찾는코드이다
	//만약 찾지 못하면 ClassNotFoundException종류의 예외가 발생한다
	//             (그경로에 클래스가 만들어져 있지 않아 찾을수 없다)
	//따라서 소스가 컴파일되려면 일반 예외처리코드를 반드시 작성해야 한다	
	
	public static void main(String[] args) {
		
		//1. 예외가 예상되는 코드줄을 마우스로 드래그한다.
		//2. alt + shift + z  y를 눌러 try catch블럭을 자동으로 작성
		
		
		try {
			//매개변수로 전달한 경로에 String 클래스가 만들어져있는지 확인을 위해
			//Class라는 이름의 클래스의 forName메소드를 호출할 때 패키지를 포함한 String 클래스의 경로 전달
			Class.forName("java.lang.String");
			System.out.println("java.lang패키지에는 String.class파일이 만들어져 있습니다.");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		System.out.println();
		
		try {
			Class.forName("java.lang.String2");
		} catch (ClassNotFoundException e) {
			//어떤 예외가 발생했는지 정보출력
			e.printStackTrace();
			//예외처리 코드 개발자가 직접 작성
			System.out.println("java.lang패키지에 String2.class파일이 만들어져 있지 않다.");
		}
		
		System.out.println("프로그램 코드 끝까지 수행되었음");
		
	}

}
