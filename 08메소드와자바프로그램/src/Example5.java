
//예제 : 가변길이 매개변수를 이용하여 사용자정의메소드 만들고 사용해보자

public class Example5 {
	
	//가변길이 매개변수?
	//- 메소드에서 인자(매개변수로 전달받는 데이터)의 갯수를 유동적으로 받을 수 있도록 해주는 매개변수
	
	//문법
	//public static 반환타입 메소드명 (자료형... 가변길이매개변수명){}
	
	//메소드명 : sum
	//기능 : 여러개의 정수를 가변길이 매개변수로 전달받아 그 합을 계산해서 반환해주는 기능
	public static int sum(int... numbers) {
							//만약 1,2,3 -> {1,2,3}배열로 받는다
		
		//합계를 저장시킬 변수
		int total = 0;
		
		//가변길이 매개변수 인자 배열인 numbers를 이용해서
		//sum메소드 호출시 전달받은 인자를 배열neumbers에서 반복해서 추출할 수 있다.
		for( int number : numbers) {
			
			total += number;
			
		}
		
		return total; //최종 합계를 반환

	}
	

	public static void main(String[] args) {
		
		//sum메소드 호출할떄 다양한 개수의 인자를 전달할 수 있다.
		
		//1. 3개의 인자 전달
		//sum(1,2,3);
		int result1 = sum(1,2,3);
		System.out.println("Sum of 1,2,3 : " + result1);
		
		//2. 5개의 인자 전달
		int result2 = sum(10,20,30,40,50);
		System.out.println("Sum of 10,20,30,40,50 : " + result2);
		
		//3. 인자가 없는 경우 호출 가능
		int result3 = sum();
		System.out.println("Sum with no arguments : " + result3);

	}

}
