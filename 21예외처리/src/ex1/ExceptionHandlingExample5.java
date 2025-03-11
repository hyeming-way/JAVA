package ex1;

/*
예제. 두 개 이상 종류의 예외를  
     하나의 catch블록으로 동일한 예외처리 코드를 작성하고싶을때
     catch블록의 매개변수자리에  예외처리클래스자료형1  |  예외처리클래스자료형2
     와 같이  기호 | (또는의 의미) 를 작성하여 연결하면 된다.
     
     catch( NumberFormatException  |  NullPointerException ){
     
     	   처리할 예외처리 코드 작성;
     }
*/

public class ExceptionHandlingExample5 {
	public static void main(String[] args) {
		
		String[] array = {"100", "1oo", null, "200"};
		
		for(int i=0; i<=array.length; i++) {
			
			try {
				
				int value = Integer.parseInt(array[i]);
				System.out.println("array[" + i + "] = " + value);
				
			} catch (ArrayIndexOutOfBoundsException e) { //배열에 없는 칸에 접근해서 배열의 값을 사용하려고 할 때의 예외				
				//예외 발생 메세지 간략히 출력
				System.out.println("배열에 없는 index 위치 칸에 접근 : " + e.getMessage());
			
			//2가지 종류의 예외가 발생했을때 동일한 예외처리 하는 곳	
			} catch (NumberFormatException | NullPointerException e) {
				//예외 발생 메세지 간략히 출력
				System.out.println("데이터에 문제가 있음 : " + e.getMessage());
			}
			
		} //for
		System.out.println("프로그램 종료 코드");
		
		/*
			출력코드
			array[0] = 100
			데이터에 문제가 있음 : For input string: "1oo"
			데이터에 문제가 있음 : Cannot parse null string
			array[3] = 200
			배열에 없는 index 위치 칸에 접근 : Index 4 out of bounds for length 4
			프로그램 종료 코드
		*/

	}

}
