
//예제 : 사용자 정보를 입력받는 메소드를 오버로딩하여 다양한 정보를
//		처리할 수 있도록 한 예

//요구사항
//1. 사용자 이름과 이메일을 입력받아 사용자 정보를 등록하는 메소드
//2. 사용자 이름, 이메일, 나이를 입력받아 사용자 정보를 등록하는 메소드
//3. 사용자 이름, 이메일, 나이, 전화번호를 입력받아 사용자 정보를 등록하는 메소드
//4. 각 메소드는 등록된 사용자 정보를 출력하는 기능을 포함합니다.


public class UserRegistration { //사용자 한 사람의 정보를 제공하는 설계도(클래스)
	
	//사용자 정보를 저장할 변수들 선언
	//변수들은 외부 다른 클래스에서 볼 수 없도록 private 접근 제어자로 은닉화해서 만듬
	private String name;
	private String email;
	private int age;
	private String phone;
	
	
	
	//기본생성자가 컴파일러에 의해 자동으로 만들어져 있다. 그런데 우리 눈에는 보이지않는다.
	//public UserRegistration() {}
	
	
	
	//사용자 등록 메소드 - 이름, 이메일을 매개변수로 받아서 사용자 정보 출력
	public void registerUser(String name, String email) {
		this.name = name;
		this.email = email;
		this.age = 0;
		this.phone = null;
		//사용자 정보 메소드 호출해서 각 객체변수의 정보 출력가능하게 하기
		printInfo();
	}
	
	//사용자 등록 메소드 - 이름, 이메일, 나이를 매개변수로 받아서 객체변수에 저장 후 사용자 정보 출력
	public void registerUser(String name, String email, int age) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.phone = null;
		//사용자 정보 메소드 호출해서 각 객체변수의 정보 출력가능하게 하기
		printInfo();
	}
	
	//사용자 등록 메소드 - 이름, 이메일, 나이, 전화번호를 매개변수로 받아서 객체변수에 저장 후 사용자 정보 출력
	public void registerUser(String name, String email, int age, String phone) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.phone = phone;
		//사용자 정보 메소드 호출해서 각 객체변수의 정보 출력가능하게 하기
		printInfo();
	}
	
	
	//사용자 정보 출력하는 메소드
	public void printInfo() {
		System.out.println("사용자 정보 : ");
		System.out.println("이름 : " + this.name); //this 생략가능
		System.out.println("이메일 : " + this.email); 
		
		//사용자가 나이를 입력했다면
		if(this.age != 0) {
			System.out.println("나이 : " + this.age);
		}
		
		//사용자가 전화번호를 입력했다면
		if(this.phone != null) {
			System.out.println("전화번호 : " + this.phone);
		}
		System.out.println(); //한줄 줄바꿈 출력
	}

	public static void main(String[] args) {
		
		UserRegistration userRegistration = new UserRegistration();
		
		//사용자 등록을 위한 메소드 호출
		
		//1. 이름과 이메일 등록
		userRegistration.registerUser("홍길동", "hong@example.com");
		
		//2. 이름, 이메일, 나이 등록
		userRegistration.registerUser("김철수", "kim@example.com", 25);
		
		//3. 이름, 이메일, 나이, 전화번호 등록
		userRegistration.registerUser("이영희", "lee@example.com", 30, "010-1234-5678");
	
	}

}
