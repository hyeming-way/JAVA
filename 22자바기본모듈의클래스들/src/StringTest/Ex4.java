package StringTest;

/*
	주제 : "Hello, World!" 전체 문자열에서
		  "l" 문자열을 모두 제거시킨 "Heo, Word!"로 만들자
*/

public class Ex4 {
	public static void main(String[] args) {
		
		//전체 문자열 <- 검사할 대상
		String originalString = "Hello, World!";
							   //0123456789  12
		
		//삭제할 대상 문자열
		String deleteString = "l";
		
		//전체문자열 중에서 "l" 특정문자열을 제거하기위해
		//substring 메소드를 이용해 잘라낸 "Heo, Word!"를 저장시킬 변수 선언
		String modifiedString = "";
		
		for(int i=0; i<originalString.length(); i++) {
			
			//검사할 대상 문자열이 삭제 대상문자열("l")이 아니라면?
			if(!originalString.substring(i, i+1).equals("l")) {
				
				modifiedString += originalString.substring(i, i+1);
				
			}
			
		}
		
		System.out.println("modifiedString변수값 : " + modifiedString);
		//출력결과
		//modifiedString변수값 : Heo, Word!

	}

}
