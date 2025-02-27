
//예제 : 반환값이 없는 메소드 정의 및 사용
//재활용하기위해 사용자정의메소드 만듬

public class Example2 {

	//사용자정의메소드 printMessage 만들기
	//기능 : 매개변수 message로 전달받은 문자열을 화면에 출력 후 한줄 줄바꿈하는 기능
	public static void printMessage(String message) {
				//void 메소드를 호출한 줄로 반환할 값이 없다라는 의미의 자료형.
				//void를 작성하면 메소드 구현부 내부에는 return 구문을 작성하면 안 된다.
		
		//출력 후 줄바꿈 기능
		System.out.println(message);

	}
	
	
	
	//기능 : 프로그램을 실행시키고 종료시키는 기능
	public static void main(String[] args) {
		
		//위 만들어져 있는 printMessage라는 이름의 메소드를 호출해서
		//"안녕하세요"를 출력하자
		printMessage("안녕하세요");
		printMessage("집에 가고 싶다...");

	}

}
