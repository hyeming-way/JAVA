
//예제 . 문자열 데이터에 + 연산하기

/*
   산술연산자 + 에대해
     + 산술연산자는 합을 구할수도 있지만 
     문자열 끼리 하나로 합쳐서 계산할수 있다.
     + 산술연산자는  문자결합연산자라고도 부른다.
 */

public class Opr01_02 {

	public static void main(String[] args) {
		
		String a;
		a = "Apple";
		
		String b = "Banana";
		
		String c = a + b; //문자열 + 문자열 -> 결합된 하나의 문자열
		//문자열 끼리 + 연산을 할 경우 두 문자열은 하나의 문자열로 합쳐져서 반환됩니다.
		
		System.out.println(c); //"AppleBanana"
		
		String str = "결과값 : ";
		int n = 10;
		
		System.out.println(str + n); //"결과값 : 10"
		//"결과값 : " + "10" <- 정수 10은 문자열 "10"으로 자동형변환하게 됨
		
		System.out.println(n + str); //"10결과값 : "

	}

}
