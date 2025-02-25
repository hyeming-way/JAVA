/*
 
 삼항 조건 연산자 문법
 	
 	조건식  ?  수식-1  : 수식-2;
 	
 	해석1. 수식-1 : 조건식의 결과가 참(true)일때 수행되는식
 	해석2. 수식-2 : 조건식의 결과가 거짓(false)일때 수행되는식

참고. 조건식이란? 연산결과값이 참(true)아니면 거짓(false) 둘 중에 하나의 값으로
               나타나는 수식을 의미하므로 
               조건식에 관계(비교)연산자를 사용할수 있습니다.
*/
//예제. 삼항조건연산자를 이용해서 최대값 구하기

public class Opr03 {

	public static void main(String[] args) {
		
		int a = 5, b = 10;
		
		//최대값을 저장할 변수 선언
		int max;
		
		max = a > b ? a : b; // max = 5 > 10 ? 5 : 10
		
		System.out.println("max = " + max); // "max = 10"
			

	}

}
