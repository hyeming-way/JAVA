
//예제 : if else문을 사용하여, 해당 문자가 영문 소문자인지 아닌지 확인하는 예제

public class If02 {

	public static void main(String[] args) {
		
		char ch = 'J';
		//대문자 J -> 74
		//소문자 a -> 97
		//소문자 z -> 122
		
		//ch변수에 저장된 문자가 소문자이냐?
		if (ch >= 'a' && ch <= 'z') {
			
			System.out.println("해당 문자는 영문 소문자입니다.");
			
		} else { //ch변수에 저장된 문자가 소문자가 아니냐?
			
			System.out.println("해당 문자는 영문 소문자가 아닙니다.");

		}		
		
		// 출력결과 : "해당 문자는 영문 소문자가 아닙니다."

	}

}
