

//예제 : if else if else문을 사용하여
//해당 문자가 영문 소문자나 영문대문자인지, 아니면 영문자가 아닌지 확인하는 예제
public class If03 {

	public static void main(String[] args) {
		
		char ch = 'J';
		// J -> 74
		// a -> 97
		// z -> 122
		// A -> 65
		// Z -> 90
		
		if(ch >= 'a' && ch <= 'z') { //ch변수에 저장된 값이 영문 소문자이냐?
			
			System.out.println("해당 문자는 영문 소문자입니다.");			
			
		}else if(ch >= 'A' && ch <= 'Z') { //ch변수에 저장된 값이 영문 대문자냐?
			
			System.out.println("해당 문자는 영문 대문자입니다.");			
			
		}else { //ch변수에 저장된 값이 영문자가 아니냐?
			
			System.out.println("해당 문자는 영문자가 아닙니다.");		
			
		}
		
		// 출력결과 : "해당 문자는 영문 대문자입니다."

	}

}
