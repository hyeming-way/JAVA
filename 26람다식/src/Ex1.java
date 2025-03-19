

import java.util.function.Function; //함수형 인터페이스 apply 추상메소드
import java.util.function.Predicate; //함수형 인터페이스 test 추상메소드
import java.util.function.Consumer; //함수형 인터페이스 accept 추상메소드

public class Ex1 {
	public static void main(String[] args) {
		
	/*	
		1. Function<T, R> : 하나의 인자를 받아서 결과를 반환하는 함수형 인터페이스입니다.
		   T는 입력타입, R은 반환타입을 의미합니다.	
		   여기서는 입력 타입이 Integer이고, 반환타입이 String입니다.
		   intToString 람다식은 정수 값 하나를 매개변수로 받아서
		   "숫자:"라는 문자열과 i 매개변수값을 결합하여 하나의 문자열로 반환하는 익명메소드입니다.
	*/	
	
	//5를 매개변수로 전달하면 "숫자:5"라는 문자열을 반환하는 람다식 작성
	Function<Integer, String> intToString = (i) -> { return "숫자:" + i; };
										   //i  -> "숫자:" + i;
	
	//이름이 없는 익명객체 주소번지는 intToString 참조변수에 자식객체로 저장되어있다.
	//익명 객체 내부에는 Function 부모인터페이스 내부에 apply 추상메소드를 강제로 오버라이딩한 
	//이름이 없는 익명함수(메소드)형태로 람다식을 사용하여 정의 해 놓았습니다.
	System.out.println(intToString.apply(5)); //숫자:5
	
	
//--------------------------------------------------------------------------------------------	
	
	
	/*
		2. Predicate<T> : 인자를 받아서 boolean 값을 반환하는 
		   test 추상메소드 하나를 가진 함수형 인터페이스
		
		   T는 입력타입을 의미하며, boolean 값을 반환합니다.
		   isEmpty 참조변수에 저장된 람다식은 매개변수 s로 받은 값이 빈 문자열인지 여부를 확인하는 역할을 함
		   매개변수 s로 문자열을 받지못하면 true, 받으면 false 반환합니다.
	
	*/
	
	//문자열이 없는(비어있는) 경우에는 true 반환, 그렇지않으면 false 반환하는 람다식
	Predicate<String> isEmpty = (s) -> { return s.isEmpty(); };
							  // s  -> s.isEmpty();
	
	//test 메소드 사용하여 빈 문자열("")을 테스트하여 true 반환 받자
	System.out.println(isEmpty.test("")); //true
	
	
//--------------------------------------------------------------------------------------------		
	
	/*
		3. Consumer<T> : 인자를 받아서 처리하지만, 값을 반환하지않는 accept 추상메소드를 가진
		   함수형 인터페이스 입니다.
		   
		   T는 입력타입을 의미하며, Consumer는 입력값을 받아서 처리만 하고,
		   반환값은 없습니다.
	*/
		
	//print 참조변수에 저장된 람다식은 매개변수로 입력된 문자열을 그대로 출력하는 역할
	Consumer<String> print = s -> System.out.println(s); //Hello
						  //(s)-> { System.out.println(s); };
	
	//accept 메소드를 사용하여 Consumer 인터페이스를 구현한
	//익명객체의 익명메소드를 호출할 때 "Hello"를 s 매개변수로 전달해서 출력
	print.accept("Hello");

	
	}
	
/*
	참고
	
	세부 설명
	1. Function<T, R>:
	   - `T`: 입력 값의 타입 (여기서는 `Integer`).
	   - `R`: 반환 값의 타입 (여기서는 `String`).
	   - `apply()` 메서드를 통해 입력 값을 받아 변환 작업을 수행하고 결과를 반환합니다. 
	     이 코드에서는 숫자를 문자열로 변환하여 "숫자: X" 형식으로 반환합니다.
	
	2. Predicate<T>:
	   - `T`: 입력 값의 타입 (여기서는 `String`).
	   - 입력 값을 받아 특정 조건을 확인하고, 그 결과로 `boolean` 값을 반환하는 함수형 인터페이스입니다. 
	     이 코드에서는 문자열이 비어 있는지를 확인합니다. `isEmpty()`는 문자열이 비어 있으면 `true`를 반환합니다.
	
	3. Consumer<T>:
	   - `T`: 입력 값의 타입 (여기서는 `String`).
	   - 입력 값을 받아서 처리하지만, 반환 값이 없습니다. 
	     주로 부작용을 일으키는 작업에 사용됩니다. 
	     이 코드에서는 문자열을 받아서 콘솔에 출력하는 역할을 합니다.

*/

}
