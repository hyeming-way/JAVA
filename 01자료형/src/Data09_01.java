
public class Data09_01 {

	public static void main(String[] args) {
		
		/*
		 
			문제. 다음 중 변수를 잘못 선언하고 초기화(처음저장)한 것은? (모두 고르시오) 1, 2, 3, 4
			
			1. byte b = 256;
			2. char c = '';
			3. char answer = 'no';
			4. float f = 3.14;
			5. double d = 1.4e3f;
			
			
			
			풀이
			
			1. byte b = 256;
			- -128부터 127까지의 값을 가질 수 있기 때문에 256은 범위를 초과합니다.
			
			2. char c = '';
			- char는 하나의 문자를 저장해야하며, 빈 문자열 ''은 허용되지 않습니다.
			
			3. char answer = 'no';
			- char는 하나의 문자만 저장할 수 있으므로 'no'는 저장할 수 없습니다.
			
			4. float f = 3.14;
			- 3.14는 double로 인식하여 컴파일 에러가 발생한다. float으로 저장하려면 3.14f;로 저장해야한다.
			
			5. double d = 1.4e3f;
			- 1.4e3f는 float타입이지만, 자동 형변환이 일어나 double 타입 변수에 할당할 수 있습니다.
		
		 */

	}

}
