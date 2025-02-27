
//예제 : 반환값이 없고 여러 매개변수를 가진 메소드 정의 및 호출 후 사용

public class Example4 {

	//메소드명 : printStudentInfo
	//매개변수 : 문자열 1개(학생이름) 전달받고, 정수 1개(학생나이) 전달받을 매개변수
	//기능 : "이름: 홍길동, 나이: 20" <- 출력 후 줄바꿈
	public static void printStudentInfo(String name, int age) {
		
		System.out.println("이름:" + name + " , " + "나이:" + age);
		

	}	
	
	
	
	//메소드명 : add
	//매개변수 : 정수2개를 전달받을 매개변수
	//기능 : 매개변수 2개로 전달받은 정수 2개의 합을 반환하는 기능
	
	public static int add(int x, int y) {
		
		return x+y;
		
	}	
	
	
	
	//메소드명 : add2
	//매개변수 : 실수2개를 전달받을 매개변수
	//기능 : 매개변수 2개로 전달받은 실수 2개의 합을 반환하는 기능
	
	public static double add2(double x, double y) {
		
		return x+y;
		
	}	
	
	
	public static void main(String[] args) {
		
		printStudentInfo("홍길동", 30);
		System.out.println(add(10,5));
		System.out.println(add2(5.5,10.5));
		
		
		/*
			출력결과
			이름:홍길동 , 나이:30
			15
			16.0
		*/
		
		
		

	}

}
