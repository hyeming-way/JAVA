package Math;

public class Ex1 {
	public static void main(String[] args) {
		
		/*
			Math 클래스의 메소드들
			
			public static int abs(int num)메소드
			  - 매개변수로 정수 하나를 전달받아 절대값을 구해 정수로 반환하는 메소드
			  - abs 메소드는 실제로 실수값을 전달받게 오버로딩되어 만들어져있다.		
		*/
		
		
		//-5의 절대값을 구하기 위해 Math 클래스의 abs 메소드 호출시 매개값으로 -5를 전달하면
		//절대값 5를 반환받아 v1 변수에 저장
		int v1 = Math.abs(-5);
		System.out.println("v1의 절대값: " + v1);
		//출력결과 : "v1의 절대값: 5"
		
		
		//-3.14의 절대값 구하기
		double v2 = Math.abs(-3.14);
		System.out.println("v2의 절대값 : " + v2);
		//출력결과 : "v2의 절대값 : 3.14"
		
		
		/*
		 	public static int max(int n, int m ,....) 메소드
		 	- 매개변수로 전달하는 정수중에서 가장 큰 최대값 하나를 반환
		 	
		 	 public static double max(double n, double m ,....) 메소드
		 	- 매개변수로 전달하는 실수중에서 가장 큰 최대값 하나를 반환
		 	
		 	public static int min(int n, int m ,....) 메소드
		 	- 매개변수로 전달하는 정수중에서 가장 작은 최소값 하나를 반환
		 	
		 	public static double min(double n, double m ,....) 메소드
		 	- 매개변수로 전달하는 실수중에서 가장 작은 최소값 하나를 반환
	 	
		*/	
		
		
		//Math클래스의 max 메소드 호출시 5, 9 매개변수로 전달하면
		//두 수 중에서 큰 최대값 9를 반환
		int v7 = Math.max(5, 9);
		System.out.println("v7의 최대값 : " + v7);
		//출력결과 : "v7의 최대값 : 9"
		
		
		//Math클래스의 max 메소드 호출시 5.3, 2.5 매개변수로 전달하면
		//두 수 중에서 큰 최대값 5.3를 반환
		double v8 = Math.max(5.3, 2.5);
		System.out.println("v8의 최대값 : " + v8);
		//출력결과 : "v8의 최대값 : 5.3"
		
		
		//Math클래스의 min 메소드 호출시 5, 9 매개변수로 전달하면
		//두 수 중에서 작은 최소값 5를 반환
		int v9 = Math.min(5, 9);
		System.out.println("v9의 최소값 : " + v9);
		//출력결과 : "v9의 최소값 : 5"
		
		
		//Math클래스의 min 메소드 호출시 5.3, 2.5 매개변수로 전달하면
		//두 수 중에서 작은 최소값 2.5를 반환
		double v10 = Math.min(5.3, 2.5);
		System.out.println("v10의 최소값 : " + v10);
		//출력결과 : "v10의 최소값 : 2.5"

		
		
		/*
			public static double floor(double d)메소드
			  - 매개변수로 전달받는 양수인 실수값을 소수점 첫번째 자리를 절사해서 버리고 만든 실수값을 반환
			  - 매개변수로 전달받는 음수인 실수값을 소수점 첫번째 자리에서 올림해서 만든 음의 실수값을 반환
		*/
		
		//Math 클래스의 floor 메소드 호출시 매개변수로 5.3을 전달하면
		//소수점 첫번째 자리 3을 내림한 5.0을 만들어서 반환
		double v11 = Math.floor(5.3);
		System.out.println("v11의 소수점 자리 내림한 값: " + v11);
		//출력결과 : "v11의 소수점 자리 내림한 값: 5.0"
		
		v11 = Math.floor(5.923);
		System.out.println("v11의 소수점 자리 내림한 값: " + v11);
		//출력결과 : "v11의 소수점 자리 내림한 값: 5.0"
		
		double v12 = Math.floor(-5.3);
		System.out.println("v12의 소수점 자리 내림한 값: " + v12);
		//출력결과 : "v12의 소수점 자리 내림한 값: -6.0"



		/*
			public static double ceil(double d) 메소드
			  - 매개변수로 전달받은 실수값을 소수점이하를 무조건 올림처리하여 더 큰 정수로 변환하는 메소드입니다.
			  	양수와 음수 모두 적용되며, 주어진값보다 크거나 같은 가장 작은 정수값을 반환합니다.

		*/
		
		//Math 클래스의 ceil 메소드 호출시 매개변수로 5.3을 전달하면
		//소수점 첫번째 자리 3을 무조건 올림 처리한 6.0을 만들어 반환합니다.
		double v3 = Math.ceil(5.3);
		System.out.println("v3의 소수점 자리 올림한 값: " + v3);
		//출력결과 : "v13의 소수점 자리 올림한 값: 6.0"
		
		v3 = Math.ceil(5.923);
		System.out.println("v3의 소수점 자리 올림한 값: " + v3);
		//출력결과 : "v3의 소수점 자리 올림한 값: 6.0"
		
		//음수를 전달하면 소수점 첫번째 자리를 없앤
		double v4 = Math.ceil(-5.3);
		System.out.println("v4의 소수점 자리 올림한 값: " + v4);
		//출력결과 : "v4의 소수점 자리 올림한 값: -5.0"
			
		v4 = Math.ceil(-3.7);
		System.out.println("v4의 소수점 자리 올림한 값: " + v4);
		//출력결과 : "v4의 소수점 자리 올림한 값: -3.0"
		
		/*	
			public static double random()메소드
			
			- random메소드를 호출하면 0.0 <= 랜덤값 < 1.0 이 범위의 랜덤값 하나를 반환
			
			- Math.random() * 숫자
			  : 입력한 숫자보다 작지만 무한히 가까운 수를 랜덤으로 반환
			  
			  예) Math.random() * 12
			  	: 12보다는 작지만 무한히 가까운 수를 랜덤으로 반환
			  	
			- 특정 범위 사이의 랜덤값을 정수로 발생시키는 공식
			 
			   (int) Math.random() * (최대값-최소값+1) + 최소값
			   
			   예)  특정범위가 최소값 1 ~ 최대값 12 사이의 랜덤값을 정수로 얻자
			   
			   	  (int) (Math.random() * (12-1+1)) + 1
			   	  (int) (Math.random() *  12     ) + 1		
		*/		
		
		//1 ~ 12 랜덤 값을 정수로 10개를 만들어서 반복해서 출력
		for(int i=0; i<10; i++) {
			
			System.out.print( (int) (Math.random() * 12 ) + 1 + " ");
			//출력결과 : "6 7 7 2 12 9 9 5 7 7"
			
		}
		
		System.out.println();
	
		/*
 		
 		public static int round(double d)  메소드
 		
 		- 매개변수로 전달받은 실수값의 소수점 첫번째 자리에서 반올림한 정수값을 반환하는 메소드
 		
 		  참고. 반올림 규칙에 따라 소수점 첫번쨰 자리에서 0.5이상이면 올림, 그렇지 않으면 내림 처리됨	
		*/

		System.out.println( Math.round(10.0) ); //10
		System.out.println( Math.round(10.4) ); //10
		System.out.println( Math.round(10.5) ); //11
		System.out.println( Math.round(-3.4) ); //-3
		System.out.println( Math.round(-3.6) ); //-4
			
		/*		
			public static double pow(double d, double d2)메소드 
				
			- 매개변수 d와 d2로 실수 2개를 전달하면
			  d의 d2승 값을 반환합니다.
			- 매개변수로 전달된 두개의 double형 값을 가지고 제곱 연산을 수행합니다.
			  
			  예를 들어  Math.pow(5,2); -> 5의 2승 계산한 25.0를 반환 	
		*/	
		
		System.out.println( Math.pow(5, 2) ); //25.0
		
		
		/*
			Math클래스의 PI상수 메모리
			- 원의 원주를 지름으로 나눈 비율(원주율)값으로 약3.14159를 제공해줍니다.
			- public static final PI = 3.141592;
		*/		
		
		System.out.println( Math.PI ); //3.141592653589793
		
	}

}
