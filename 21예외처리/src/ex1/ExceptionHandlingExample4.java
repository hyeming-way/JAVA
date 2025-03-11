package ex1;

/*
예제. 배열의 index위치의 범위를 벗어나 접근했을 경우
     발생하는 ArrayIndexOutOfBoundsException예외 종류와
     
     숫자형태의 문자열이 아닌데 숫자로 변경하려고할때 발생하는 
     NumberFormatException예외 종류를 
     
     각각 다르게 예외처리하는 코드의 예
*/

//참고. 숫자형태 "100"문자열을 숫자로 변환해서 반환하는 메소드
//    Integer클래스의  int parseInt(String value)메소드
//    예)   Integer.parseInt("100");  ->  100 반환	

public class ExceptionHandlingExample4 {
	public static void main(String[] args) {
		//문자열을 저장한 배열메모리 생성
		String[] array = {"100","1oo"};
		
		//array배열에 저장된 문자열 2개를 얻어 숫자로 변환
		for(int i=0; i<=array.length; i++) {
			
			try {
				
				int value = Integer.parseInt(array[i]);
				//"100" -> 100숫자로 변환
				//"1oo" -> 숫자로 변환 안 됨 - NumberFormatException 예외발생
				
				System.out.println("array[" + i + "] : " + value);

			}catch(ArrayIndexOutOfBoundsException e) {
				//예외가 발생하면 발생한 예외 정보 출력
				e.printStackTrace();
				//예외처리할 코드 작성
				System.out.println("array배열에 없는 원소(칸)에 접근해서 사용을 시도했다.");
				
			}catch(NumberFormatException e) {
				//예외가 발생하면 발생한 예외 정보 출력
				e.printStackTrace();
				//예외처리할 코드 작성
				System.out.println("array[1]위치에 저장된 '1oo'은 숫자로 변환할 수 없다.");
				
			}
			
			
		} //for
		
		System.out.println("프로그램 종료 코드 실행된다!");
		
		/*
		 	출력결과
		 	array[0] : 100
			java.lang.NumberFormatException: For input string: "1oo"
				at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
				at java.base/java.lang.Integer.parseInt(Integer.java:662)
				at java.base/java.lang.Integer.parseInt(Integer.java:778)
				at ex1.ExceptionHandlingExample4.main(ExceptionHandlingExample4.java:27)
			array[1]위치에 저장된 '1oo'은 숫자로 변환할 수 없다.
			java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
				at ex1.ExceptionHandlingExample4.main(ExceptionHandlingExample4.java:27)
			array배열에 없는 원소(칸)에 접근해서 사용을 시도했다.
			프로그램 종료 코드 실행된다!
		*/

	}

}
