package 포장클래스들;

//주제 : 문자열 String 객체를 해당 기본자료형 데이터로 변환
//		그리고 문자열로 변환 연습

public class Test4 {
	public static void main(String[] args) {
		
		//"123" 문자열을 기본자료형값 123으로 변환하여 반환받아 int i 변수에 저장 ------------------------------------------- **중요**
		int i =  Integer.parseInt("123"); //123
		
		//"true" 문자열을 기본자료형값 true로 변환하여 반환받아 boolean b 변수에 저장
		boolean b = Boolean.parseBoolean("true"); //true
		
		//"3.141592" 문자열을 기본자료형값 3.141592로 변환하여 반환받아 float f 변수에 저장
		float f = Float.parseFloat("3.141592"); //3.141592f
		
		//정수 123을 문자열 "123"으로 변환 후 저장된 문자열 객체메모리의 주소를 반환받아 String s1 변수에 저장 ------------------- **중요**
		String s1 = Integer.toString(123); //"123"
		
		//정수 123을 16진수형태의 문자열 "7b"로 변환 후 저장된 문자열 객체메모리의 주소를 반환받아 String s2 변수에 저장 ----------- **중요**
		String s2 = Integer.toHexString(123); //"7b"
		
		//문자 'a'를 문자열 "a"로 변환 후 저장된 문자열 객체메모리의 주소를 반환받아 String s3 변수에 저장
		String s3 = Character.toString('a'); //"a"
		
		//boolean 자료형의 값 true를 문자열 "true"로 변환 후 저장된 문자열 객체메모리의 주소를 반환받아 String s4 변수에 저장
		String s4 = Boolean.toString(true); //"true"
		
	}

}
