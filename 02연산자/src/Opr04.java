/*
 두가지 논리 값을 비교 판단하도록 하는 논리연산자
 - 논리 연산자는 주어진 논리식을 판단하여, 참(true)과 거짓(false)를 결정하는 연산자입니다
 
 논리 연산자 종류
 		논리 연산자 종류				설명
 		&&(논리 AND 연산)			논리식이 모두 참이면 참(true)를 반환함
 		||(논리 OR 연산)			논리식 중에서 하나라도 참(true)이면 참(true)을 반환함
 		!(논리 NOT 연산)			논리식의 결과가 참(true)이면 거짓(false)을,
 								거짓(false)이면 참(true)를 반환하는 연산자로
 								!연산자는 피연산자가 단 하나뿐인 단항 연산자라고도 부르며
 								피연산자의 연산순서는 오른쪽에서 왼쪽으로 연산해야함
 								!false -> true
 		
 논리 연산자의 모든 동작의 결과를 보여주는 진리표
 
 	A변수값		B변수값		A && B		A || B		!A
 	true		true		  true		 true		false
 	true		false		  false		 true		false
 	false		true		  false		 true		true
 	false		false		  false		 false		true


	예) A   && B  논리 AND연산식을 해석하면
	   true && true일때 AND연산 &&을 하면
	   두 피연산자의 값이 모두 true일때만 하나의 true의 값을 되돌려 받는다
	   만약 두 피연산자의 값 중 하나라도 false가 존재하면 false의 값을 되돌려 받게 될것이다
	
	예) A  || B 논리 OR연산식을 해석하면
	   true|| false 일때  OR 연산 || 하면
	   두 피연산자의 값중 하나라도 true가 존재하면 하나의 true의 값을 되돌려 받는다
	   만약 두 피연산자의 값이 모두 true가 존재할때도  true의 값을 되돌려 받게 될것이다
	   
	예) !A  논리 NOT연산식을 해석하면
	    만약 A변수에 저장된 true이면 true의 반대의 값 false의 값을 되돌려 받게 될것이다

*/
//예제. 특정 범위에 속하는 값인지를 물어보기(변수에 저장된 나이가 10대인지 아닌지 알아보기)
//	   논리 연산자 중에서  &&  연산자 사용 예

public class Opr04 {

	public static void main(String[] args) {
		
		int a = 29; //나이저장
		
		//a변수에 저장된 나이가 10대인지 10대가 아닌지 관한 문자열을 저장할 변수
		String result = "";
		
		//참고. 자바에서 특정 범위에 속하는 값인지를 물어보기 위해서는
		// 논리 연산자 중에서 논리 AND 연산자와 &&를 사용합니다.
		
		//a변수에 저장된 나이가 10대인지 아닌지 판단해야합니다.
		//10대에 속하려면 a변수에 저장된 나이가 10살 이상이고 19살이하여야합니다.
		
		result = (a >= 10 && a <= 19) ? "10대" : "10대가 아님";
		
		System.out.println("a변수에 저장된 나이 : " + a + "는 " + result); //"a변수에 저장된 나이 : 29는 10대가 아님"

	}

}
