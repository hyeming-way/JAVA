
/*
	메소드 오버로딩?
	- 같은 클래스 내부에서 동일한 이름의 메소드를 여러개 정의하는것을 말함
	
	메소드 오버로딩 조건
	
	1. 매개변수의 갯수를 달리해서 동일한 이름의 메소드 여러개 작성 가능
	
		void display(){}
		void display(int a){}
		void display(int a, int b){}
		
	2. 매개변수의 타입(자료형) 종류를 달리해서 동일한 이름의 메소드 여러개 작성가능
	
		void display(int a){}
		void display(double a){}
		void display(String a){}
		
	3. 매개변수의 갯수와 타입이 동일하지만 매개변수 작성 순서만 다른 경우에도 메소드 오버로딩 가능
	
		void display(int a, String b){}
		void display(String a, int b){}
		
	주의 : 매개변수의 갯수와 타입이 동일하지만 순서만 다른 경우에만 오버로딩이 가능함
		  매개변수가 모두 동일한 경우(개수, 타입, 순서 모두 동일)는 오버로딩 불가능합니다.
	
	참고. 반환타입(자료형)만 다르고 매개변수가 동일한 메소드들은 오버로딩이 불가능함
	
		public int getValue(int a){
			return a;
		}
		
		public double getValue(int a){
			return (double)a;
		}
*/

//메소드 오버로딩 예

//add라는 동일한 이름의 메소드를 4개 정의한 클래스
class Calculator{
	
	//메소드오버로딩? 동일한 이름의 메소드를 여러개 작성
	
	//두 정수의 합을 구해 반환하는 메소드
	public int add(int a, int b) {
		return a + b;
	}
	
	//세 정수의 합을 구해 반환하는 메소드
	public int add(int a, int b, int c) {
		return a + b + c;	
	}
	
	//두 실수의 합을 구해 반환하는 메소드
	public double add(double a, double b) { //매개변수의 자료형을 달리해서 메소드 오버로딩 가능
		return a + b;
	}
	
	//정수와 실수의 합을 구해 반환하는 메소드
	public double add(int a, double b) { //매개변수의 자료형을 달리해서 메소드 오버로딩 가능
		return a + b;
	}
	
}


public class Main {
	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		
		//두 정수의 합 (5+10)
		int sum1 = calculator.add(5, 10);
		System.out.println("두 정수의 합 : " + sum1); //두 정수의 합 : 15
		
		//세 정수의 합 (5+10+15)
		int sum2 = calculator.add(5, 10, 15);
		System.out.println("세 정수의 합 : " + sum2); //세 정수의 합 : 30
		
		//두 실수의 합 (5.5+10.5)
		double sum3 = calculator.add(5.5, 10.5);
		System.out.println("두 실수의 합 : " + sum3); //두 실수의 합 : 16.0
		
		//정수와 실수의 합 (5+10.5)
		double sum4 = calculator.add(5, 10.5);
		System.out.println("정수와 실수의 합 : " + sum4); //정수와 실수의 합 : 15.5
		
	}

}
