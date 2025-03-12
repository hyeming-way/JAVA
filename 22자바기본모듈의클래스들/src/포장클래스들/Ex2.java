package 포장클래스들;



public class Ex2 {
	public static void main(String[] args) {
		
		//int -> Integer 래퍼(포장) 클래스 학습
		
		//첫번째. Integer 클래스의 생성자 종류 2가지
		//	1. 정수값을 매개변수로 받아서 저장하는 생성자
		//	2. 문자열을 매개변수로 받아서 저장하는 생성자
		
		//기본자료형 정수값 하나를 래퍼(포장)역할을 하는 Integer 클래스의 객체메모리의 변수에 저장하기위해
		//Integer 클래스 자료형의 객체메모리 생성
		Integer num01 = new Integer(10); //박싱 : 기본자료형값 10을 래퍼클래스의 객체메모리에 저장 (수동박싱)		
		Integer num02 = new Integer("20"); //박싱 : 문자열 "20"을 래퍼클래스의 객체메모리에 저장 (수동박싱)
		//Integer num01 = 10; <-- 오토박싱

		//두번째. Integer 클래스의 메소드를 사용해서 Integer 객체에 박싱된 기본값을 얻어서 사용해보자
		//제공되는 메소드 -> int intValue()메소드 : Integer 객체 메모리의 인스턴스변수에 저장된 값을 정수로 변환해서 반환하는 메소드
		int n01 = num01.intValue(); //언박싱 : 포장클래스의 객체메모리에 저장된 기본자료형 값을 추출하는 작업 (수동언박싱)
		int n02 = num02.intValue(); //"20"을 정수 20으로 변환 후 반환 (수동언박싱)
		//int 01 = num01; <-- 오토언박싱
		
		int sum = n01 + n02;
		System.out.println("두 정수의 합은? " + sum);
		//출력결과 : "두 정수의 합은? 30"
		
		//sum변수에 저장된 값을 2진수로 변환, 8진수로 변환, 16진수 형태로 변환해서 반환하는 메소드들
		System.out.println("sum변수값 30을 2진수로 변환해서 반환 -> " + Integer.toBinaryString(sum) );
		//출력결과 : "sum변수값 30을 2진수로 변환해서 반환 -> 11110"
		
		System.out.println("sum변수값 30을 8진수로 변환해서 반환 -> " + Integer.toOctalString(sum) );
		//출력결과 : "sum변수값 30을 8진수로 변환해서 반환 -> 36"
		
		System.out.println("sum변수값 30을 16진수로 변환해서 반환 -> " + Integer.toHexString(sum) );
		//출력결과 : "sum변수값 30을 16진수로 변환해서 반환 -> 1e"
	
		
		
		//박싱 : 기본 자료형 값을 래퍼(포장)클래스의 객체메모리에 저장
		Integer num03 = new Integer(30);
		
		//Integer 클래스의 double doubleValue()메소드
		//-> Integer 객체메모리에 저장된 기본자료형값을 실수값으로 변환해서 반환하는 메소드
		double result = num03.doubleValue();
		System.out.println(result); 
		//출력결과 : 30.0
		
		//Integer 클래스의 static int parseInt(String s)메소드
		//-> 숫자형태의 문자열을 매개변수로 전달하면
		//   문자열을 정수로 변환해서 반환하는 정적메소드
		int num = Integer.parseInt("100"); //"100" -> 100으로 변환하여 반환
		System.out.println("문자열 '100'을 숫자100으로 변환 후 반환받자");
		System.out.println(num);
		//출력결과
		//"문자열 '100'을 숫자100으로 변환 후 반환받자"
		//100
		
		System.out.println(num + 200); //<-- num에 저장된 값이 진짜 숫자인지 확인하는 방법
		//출력결과 : 300
		
		//참고. parseXXX메소드들
		//	 -> 문자열형태의 데이터를 해당 포장(래퍼)클래스의 기본자료형값으로
		//      변경 후 반환하는 메소드들
		
		Double.parseDouble("100.0"); // -> 100.0
		Float.parseFloat("100.123"); // -> 100.123
		Boolean.parseBoolean("true"); // ->true
		Integer.parseInt("100"); // ->100
			
		
	}

}
