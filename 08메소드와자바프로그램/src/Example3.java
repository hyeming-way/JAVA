

//예제 : 반환값이 없고 매개변수도 없는 메소드 정의 및 호출해서 사용
public class Example3 {

	//기능 : "안녕하세요" 인사 메세지 출력
	public static void greet() {
		
		System.out.println("안녕하세요");

	}	
	
	
	
	//기능 : 프로그램을 실행시키고 종료시키는 기능
	public static void main(String[] args) {
		
		
		//class 내부에 static 키워드로 정의한 메소드 호출하는 문법
		//클래스명.메소드명(); 또는 메소드명();
		greet();
		Example3.greet();
		
	}

}
