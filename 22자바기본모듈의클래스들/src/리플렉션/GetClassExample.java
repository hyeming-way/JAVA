package 리플렉션;

import java.net.MulticastSocket;

/*
	메타정보란? 
	
		클래스가 만들어져있는 패키지정보, 타입정보, 멤버(생성자, 변수, 메소드)정보 등을 말한ㄷ.

	리플렉션?
	  - 자바는 클래스와 인터페이스의 메타정보를 Class 객체로 관리합니다.
	  - 메타정보를 프로그램에서 읽고 수정하는 행위를 리플렉션이라고 합니다.
	  
	  
	자바프로그램에서 Class라는 이름의 클래스의 객체메모리를 얻는 방법 3가지
		
		//클래스이름만 가지고 Class 객체를 얻는 방법
		방법1. Class claszz = 클래스이름.class;
			예) Class claszz = String.class;
		
		방법2. Class claszz = Class.forName("패키지.클래스이름");
			예) class claszz = Class.forName("java.lang.String");
		
		//객체로부터 얻는 방법
		방법3. Class claszz = 객체참조변수.getClass();
			예) String str = "김자바";
			    Class claszz = str.getClass();
	
			    
			    
기능 : 패키지와 타입정보얻기
설명 : 패키지와 타입(클래스, 인터페이스)이름 정보는 다음과 같은 메소드를 통해 얻을 수 있습니다.

		메소드						용도
		Package getPackage()		패키지 정보 읽기
		String getSimpleName()		패키지를 제외한 타입 이름(클래스명 또는 인터페이스명)
		**String getName()			패키지를 포함한 전체 타입 이름(클래스명 또는 인터페이스명)
			    		    
*/

//예제 : Car클래스의 Class객체를 얻고, 패키지와 클래스의 이름을 얻어 출력.

class Car {
	
	//기본생성자만 만들어진 상태
	
}

public class GetClassExample {
	public static void main(String[] args) throws Exception {
		
		//위 만들어져있는 Car클래스의 메타정보를 저장한 Class의 객체 얻기
		//방법1. Class claszz = 클래스이름.class;
		//	Class claszz = Car.class;
		
		//방법2. Class claszz = Class.forName("패키지.클래스이름");
		//	Class claszz = Class.forName("리플렉션.Car"); //<---- 나중에 DB연동할 때 사용
		
		//방법3. Class claszz = 객체참조변수.getClass();
			Car car = new Car();
			Class claszz = car.getClass();
		

			
			System.out.println("패키지 경로 : " + claszz.getPackage());
			//출력결과 : "패키지 경로 : package 리플렉션"
			
			System.out.println("클래스 명 : " + claszz.getSimpleName());
			//출력결과 : "클래스 명 : Car"
			
			System.out.println("클래스 전체 경로 : " + claszz.getName());
			//출력결과 : "클래스 전체 경로 : 리플렉션.Car"


	}

}
