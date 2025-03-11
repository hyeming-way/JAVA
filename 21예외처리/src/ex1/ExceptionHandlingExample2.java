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


public class ExceptionHandlingExample2 {
	
	//기능 : 매개변수 data로 전체문자열 하나를 전달받아
	//		전체문자열의 문자갯수를 구해서 int result 변수에 저장하고
	//		result 변수에 저장된 문자갯수를 출력하는 기능의 메소드
	public static void printLength(String data) {
		
		//1. 실행 예외가 발생할 것이 예상되는 코드줄의 영역을
		//	 자바문법에서 제공해주는 예외처리하는 문법 중에서
		//   try{} 블럭으로 묶어 감싸주자.
		
		//2. 그리고 묶어준 코드줄 중에서 만약 예외가 발생하는 코드줄이 생기면
		//	 개발자가 직접 발생하는 예외 종류에 따라 예외처리할 코드를 작성하는
		//	 catch(예상해서_발생할_종류의_예외를_처리할_클래스명  매개변수명){} 블럭을 이어서 작성해주자.
		
		//	 catch의 매개변수로는 발생한!!! 예외의 종류에 따라 어떤 예외 종류가 발생했는지에 대한
		//   예외정보를 메세지로 제공해주고 발생한 예외를 처리할 클래스의 객체가 자동으로 생성되어 넘어온다.
		//   또한 catch의 {}블럭 내부에는 예외처리할 코드를 작성한다.
		
		//3. 마지막으로 finally{} 블럭을 작성하여
		//	 발생한 예외랑 상관없이 무조건 한 번은 실행해야할 코드를 넣어준다.
		
		try { //<--- 단독으로 사용X
			
			int result = data.length();
			System.out.println("전체 문자열의 문자갯수 : " + result);

		}catch(NullPointerException e) { //new NullPointerException(); 객체가 생성되면서 매개변수로 받음
				//1번 발생한 예외 메세지 출력 가능
					//출력방법1. 예외가 발생하면 발생한 이유만 문자열로 반환
				//	System.out.println(e.getMessage());
					//-> Cannot invoke "String.length()" because "data" is null
					
					//출력방법2. 발생한 예외종류명:발생한 이유를 하나의 문자열로 합쳐서 반환
				//	System.out.println(e.toString());
					//-> java.lang.NullPointerException: Cannot invoke "String.length()" because "data" is null
					
					//출력방법3. 발생한 예외종류명 + 발생한 이유 + 예외발생코드 위치 줄번호까지 하나의 문자열로 합쳐서 출력
				//	e.printStackTrace();
					//java.lang.NullPointerException: Cannot invoke "String.length()" because "data" is null
					//at ex1.ExceptionHandlingExample2.printLength(ExceptionHandlingExample2.java:45)
					//at ex1.ExceptionHandlingExample2.main(ExceptionHandlingExample2.java:79)
				
				//2번 예외처리할 코드를 개발자가 이 자리에 작성
					System.out.println("printLength메소드를 호출할 때 문자열을 전달해야함");
			
		}finally {
			//예외 발생여부와 상관없이 무조건 실행될 코드를 이자리에 작성
			System.out.println("[마무리 실행]\n");
			
		}
	
	} //printLength(){}
	
	public static void main(String[] args) {
		
		System.out.println("[프로그램 시작]\n");
		
		printLength("ThisIsJava");
		printLength(null); //<--- 매개변수로 전달은 되지만,
						   //	  data.length();를 만나서 예외가 발생함
		//예외내용
		//Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "data" is null
		
		System.out.println("[프로그램 종료]\n");
		
		//결론 : 예외처리를 하면 프로그램을 끝까지 실행 후 종료한다!!!

	}

}
