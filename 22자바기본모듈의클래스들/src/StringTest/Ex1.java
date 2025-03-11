package StringTest;

/*
	String 클래스
	  - java.lang패키지에 만들어져 있는 클래스
	  - 특정 문자열을 저장할 용도로 사용되는 클래스
	  - 특정 문자열을 한번 저장해 놓으면 문자열이 변경되지 않음을 보장하는 클래스
	  
	  
	String 클래스를 이용해 객체메모리 생성방법 3가지
	
		방법1. 문자열 리터럴상수를 직접 변수에 대입해서 String 객체메모리를 생성하는 방법
			  예) String 변수선언 = "리터럴상수문자열";
			  
		방법2. new 연산자와 함께 생성자를 호출해서 String 객체메모리를 생성하는 방법
			  예) String 변수선언 = new String("특정문자열");
			  
		방법3. new 연산자와 함께 문자들이 저장된 문자배열메모리를
			  생성자를 호출시 매개변수로 전달받아 하나로 합친 문자열을 저장해서 String 객체메모리 생성하는 방법
			  예) String 변수선언 = new String({'1', '2', '3'}); <-- "123" 하나의 문자열로 저장함
*/

public class Ex1 {
	public static void main(String[] args) {
		//String 클래스를 이용해 객체 생성 방법 1
		String s1 = "JAVA";
		
		//String 클래스를 이용해 객체 생성 방법 2
		String s2 = new String("programming");
		
		//String 클래스를 이용해 객체 생성 방법 3
		//순서1. 문자들이 저장된 문자배열메모리 생성
		char[] charArr = {'S', 't', 'r', 'i', 'n', 'g'};
		//순서2. String 클래스의 생성자를 호출할때 위 charArr 배열전달하면
		//		각각의 문자들을 모두 추출해서 하나의 문자열로 합쳐 저장하게 됩니다.
		String s3 = new String(charArr); // "String"
		
		//String 객체메모리 내부에 저장된 각각의 문자열을 얻어서 출력할때
		//String 클래스에서 제공해주는 toString()메소드 사용
		System.out.println("s1 = " + s1.toString()); //출력결과 : s1 = JAVA
		System.out.println("s2 = " + s2.toString()); //출력결과 : s2 = programming
		System.out.println("s3 = " + s3.toString()); //출력결과 : s3 = String
		
		//-----------------------------------------------------------------------
		
		//String 클래스를 이용해 객체 생성 방법1과 방법2 차이점
		//결론 -> String 객체메모리 생성의 차이점
		
		//방법1
		String str3 = "JSP";
		String str4 = "JSP";
		//같은 문자열 리터럴 상수를 각 참조변수에 저장하여 String 객체메모리를 만들면
		//"JSP"문자열을 저장할 String 객체메모리는 단 한번만 만들어지고
		//두 참조변수 str3과 str4는 한번 생성된 String 객체메모리 하나를 참조하여 사용
		/*
			그림
				 str3     String 객체메모리 주소번지 0x1
				[ 0x1 ] = [ "JSP" ]
				
				 str4
				[ 0x1 ]
		*/
		
		//위 str3참조변수, str4참조변수에 저장된 String 객체메모리 주소번지가 같은지 비교 (== 비교연산자 사용)
		if(str3 == str4) {
			System.out.println("서로 같은 문자열 'JSP'가 저장된 단 하나의 String객체메모리이다.");
		}else {
			System.out.println("서로 다른 String객체메모리에 각각 'JSP'문자열이 저장되어있다.");
		}
		//출력결과
		//서로 같은 문자열 'JSP'가 저장된 단 하나의 String 객체메모리이다.
		
		System.out.println("----------------------------------------------------------");
		
		//방법2
		String str1 = new String("Java");
		String str2 = new String("Java");
		/*
			 str1   = String 객체메모리 주소번지 0x2
			[ 0x2 ] = [ "Java" ]
			
			 str2   = String 객체메모리 주소번지 0x3
			[ 0x3 ] = [ "Java" ]
			
			각각의 메모리공간을 가짐
		*/
		
		if(str1 == str2) {
			System.out.println("서로 같은 String 객체메모리이다.");
		} else {
			System.out.println("서로 같은 Java라는 문자열이 저장된 String 객체메모리이지만");
			System.out.println("각각 String 객체메모리가 생성되어 각각 java라는 문자열이 저장되어있다.");
		}
		//출력결과
		//서로 같은 Java라는 문자열이 저장된 String 객체메모리이지만
		//각각 String 객체메모리가 생성되어 각각 java라는 문자열이 저장되어있다.
		
		
		//같은 문자열을 저장할 용도라면 방법1이 효율적임. (메모리 1번만 만들어지니까!)
		
		System.out.println("----------------------------------------------------------");
		
		//String 클래스에 만들어져 있는 메소드들
		//(String 객체메모리 내부에 만들어진 문자열을 조작할 수 있는 인스턴스메소드들)
		String str5 = "JAVA_Study";
		//각 문자는 배열이 아니더라도 인덱스 번호를 가짐 
		
		//String 클래스의 length()메소드
		//-> String 객체메모리 내부에 저장된 전체문자열의 문자 총 갯수를 세어서 반환
		System.out.println(str5.length()); //출력결과 : 10
		
		//String 클래스의 charAt(index)메소드
		//-> String 객체메모리 내부에 저장된 전체 문자열의 특정 문자의 index 위치번호를 이용해
		//	 그 문자를 얻어올 수 있게(반환하는) 메소드
		System.out.println(str5.charAt(9)); //출력결과 : y
		
		
		
	
	}

}
