
/*
	클래스(class)내부에 작성된 멤버변수(클래스변수, 인스턴스변수) 초기화 방법
	
		방법1. 개발자가 강제(명시) 초기화
			  예) int a = 1;
		
		방법2. 객체메모리 생성시 생성자 호출해서 생성자 내부에서 초기화
			  예) new X(10);		-> class X{ 	X(int v){ int a = v; } 		}
			  
		방법3. 초기화 블럭 이용한 변수값 초기화
			  1) 클래스 초기화 블럭
			  		static {	클래스변수값초기화코드작성;	}
			  2) 인스턴스 초기화 블럭
			  		{	인스턴스변수값초기화코드작성;	}
*/


public class Ex3 {
	
	//1. 개발자가 강제(명시)초기화
	int door = 4;
	
	//2. 생성자를 이용한 초기화
	public Ex3() {
		System.out.println("생성자가 호출되어 door변수값 초기화시킴");
		door = 10;
	}
	
	//3. 초기화 블럭을 이용한 초기화
	//	1)클래스 초기화 블럭 이용 (클래스변수만 초기화 가능)
	static {
		System.out.println("호출순서 알아보기");
		System.out.println("static { 클래스 초기화 블럭 사용함 }");
	}
	
	//	2)인스턴스 초기화 블럭 이용
	{
		System.out.println("{인스턴스 초기화 블럭 사용함}");
	}
	

	public static void main(String[] args) {
		
		System.out.println("main메소드로 진입하여 Ex3 ex3 = new Ex3(); 객체 생성");
		Ex3 ex3 = new Ex3();
		
		/*
			출력결과
			호출순서 알아보기
			static { 클래스 초기화 블럭 사용함 }
			main메소드로 진입하여 Ex3 ex3 = new Ex3(); 객체 생성
			{인스턴스 초기화 블럭 사용함}
			생성자가 호출되어 door변수값 초기화시킴
		*/
		
		System.out.println("main메소드로 진입하여 Ex3 ex4 = new Ex3(); 객체 생성");
		Ex3 ex4 = new Ex3();
		/*
			출력결과
			main메소드로 진입하여 Ex3 ex4 = new Ex3(); 객체 생성
			{인스턴스 초기화 블럭 사용함}
			생성자가 호출되어 door변수값 초기화시킴
		*/
		
		/*
		   Ex3클래스가 실행되면서 JVM메모리에 로딩될때의 호출순서
		   
		   	순서1. static{} 클래스 초기화 블럭 실행됨
		   	순서2. static이 작성된 main메소드가 호출되어 JVM의 스택영역에 쌓임
		   	순서3. new 연산자를 이용해 객체 생성시~ {} 인스턴스 초기화 블럭 실행됨
		   	순서4. 생성자가 수행됨
		   	
		   	실행결과(출력결과)로 알수 있는것!!
		   	-> 클래스 초기화 블럭은 처음 JVM메모리에 로딩될때 한번한 수행되지만,
		   	   인스턴스 초기화 블럭은 객체가 생성될 때 마다 수행되었다.
		   	   
		   	   
			호출순서 알아보기
				static{클래스초기화블럭 사용함}
				main메소드로 진입하여! Ex3 ex3 = new Ex3();객체생성
				{인스턴스 초기화 블럭 사용함}
				생성자가 호출되어 변수값 초기화함
		
				main메소드로 진입하여! Ex3 ex4 = new Ex3();객체생성
				{인스턴스 초기화 블럭 사용함}
				생성자가 호출되어 변수값 초기화함
		*/
		
		
		
	}

}
