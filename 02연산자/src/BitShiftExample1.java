
//예제 : 비트 이동연산자 이용

public class BitShiftExample1 {

	public static void main(String[] args) {
		
		//1. 좌측 이동 연산자 << 를 사용하여 정수 1을 3비트만큼 왼쪽으로 이동시키자
		int num1 = 1;
		int result1 = num1 << 3; // 1 << 3
		
		System.out.println(result1); //8
		
		//1.1 좌측 이동 연산자 << 는 아래와 같이 Math클래스의 pow메소드를 호출해서 사용하면
		//2의 3승의 결과값을 구할 수 있다.
		int result2 = num1 * (int)Math.pow(2, 3); // 1 << 3 = 1 X 2의 3승 = 8
		System.out.println(result2); //8
		
		
		
		//2. 우측 이동 연산자 >> 를 사용하여 정수 -8을 3비트만큼 오른쪽으로 이동시키자
		//참고. 쉬프트 연산자는 Math.pow()메소드 호출하는 것보다 처리 속도가 빠름
		int num2 = -8;
		int result3 = num2 >> 3; //-8 >> 3
		System.out.println(result3); //-1
		
		//2.1 우측 이동 연산자 >> 는 다음과 같이 2의 거듭제곱을 나눈 결과와 동일하다
		int result4 = num2 / (int)Math.pow(2, 3); //-8 >> 3 = -8 / 2의 3승 = -1
		System.out.println(result4); //-1
		
		
		
		//3. 우측 이동 연산자 >>> 를 사용하여 정수 -8을 3비트만큼 오른쪽으로 이동시켜보자
		int result5 = -8 >>> 3;
		System.out.println(result5); //536870911

	}

}
