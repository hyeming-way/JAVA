
/*
	연습. 클래스 내부에 멤버변수(인스턴스변수, 클래스변수 만들기)
	
	Student 클래스 만들기
	
		정수 하나를 저장할 인스턴스변수 num 만들기
		정수 하나를 저장할 클래스변수 staticNum 만들기
		
		기본 생성자 만들기 (아무런 일도 하지않음)
		
		하나의 정수값을 매개변수로 전달받아 인스턴스변수, 클래스변수에 각각 누적시키는
		인스턴스 메소드 add 만들기
*/

class Student{
	
	int num;
	static int staticNum;
	
	public Student() {}
	
	public void add(int num) {
		this.num += num;
		Student.staticNum += num;
	}
	
}


public class Test1 {

	public static void main(String[] args) {
		
		//Student 클래스의 객체 생성 후 참조변수 a_student에 저장
		Student a_student = new Student();
	
		a_student.add(5);
		
		/*
			--참조변수 a_student객체--
			인스턴스변수 num = 5
			클래스변수 staticNum = 5
		*/
		System.out.println("--참조변수 a_student객체--");
		System.out.println("인스턴스변수 num = " + a_student.num);
		System.out.println("클래스변수 staticNum = " + Student.staticNum);
		System.out.println();
		
		//Student 클래스의 객체 생성 후 참조변수 b_student에 저장
		Student b_student = new Student();
	
		b_student.add(5);
		
		/*
			--참조변수 b_student객체--
			인스턴스변수 num = 5
			클래스변수 staticNum = 10
		*/
		System.out.println("--참조변수 b_student객체--");
		System.out.println("인스턴스변수 num = " + b_student.num);
		System.out.println("클래스변수 staticNum = " + Student.staticNum);

		//인스턴스변수와 클래스변수의 차이점 적어보기
		// -> 인스턴스변수는 객체메모리를 생성할때마다 객체메모리내부에 개별적으로 올라가는 메모리 공간
		// -> 클래스변수는 생성된 각 객체메모리들이 공용으로 사용하는 공용변수메모리이기때문에
		//	  자바프로그램이 시작되면 가장 처음에 class가 JVM의 Method영역에 올라갈 때
		//	  class메모리에 포함되어 같이 올라가는 변수메모리입니다.
	}

}
