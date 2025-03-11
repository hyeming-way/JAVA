package ex1;

/*
	예제에서 printLength()메소드는 문자열의 문자개수를 구해서 출력하는 메소드이다.
	이때 문자열이 존재하지 않는데(문자열을 매개변수로 받지 않는데)..
	문자열의 문자총갯수를 알아내기위해 .length() 메소드를 호출하려할때
	NullPointerException이라는 이름의 예외가 발생 했습니다.
	즉! 값이 없는데 값을 사용하려고 할떄 발생하는 예외입니다. 


	참고. NullPointerException 예외는
	     참조변수가 null인(값이 저장되어 있지 않는) 상태에서
	     메소드에서 참조변수값을 불러와 사용할경우 발생하는 
	     예외 종류중 하나 
	     
	요약 : 변수를 선언하고 변수에 값을 저장하지 않은 상태에서
	     	   변수값을 사용하면 NullPointerException예외가 발생함 	     
*/


public class ExceptionHandlingExample1 {
	
	//기능 : 매개변수 data로 전체문자열 하나를 전달받아
	//		전체문자열의 문자갯수를 구해서 int result 변수에 저장하고
	//		result 변수에 저장된 문자갯수를 출력하는 기능의 메소드
	public static void printLength(String data) {
		
		int result = data.length();
		System.out.println("전체 문자열의 문자갯수 : " + result);
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("[프로그램 시작]\n");
		
		printLength("ThisIsJava");
		printLength(null); //<--- 매개변수로 전달은 되지만,
						   //	  data.length();를 만나서 예외가 발생함
		//예외내용
		//Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "data" is null
		
		System.out.println("[프로그램 종료]\n");

	}

}
