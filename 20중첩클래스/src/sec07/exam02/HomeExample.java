package sec07.exam02;

/*
	익명구현객체 - 부모인터페이스를 구현받아(추상메소드 강제로 오버라이딩)
				이름이 없는 자식익명클래스를 만드는 동시에 이름이 없는 자식익명구현객체 생성한다는 의미
				
	익명구현객체 생성 문법
				
				new 부모인터페이스명(){
				
					부모인터페이스에 만들어 놓은 추상메소드를 강제로 오버라이딩해서 작성;
				
				};
				
				해석 : 부모인터페이스 내부에 만들어 놓은 추상메소드들을 강제로 메소드 오버라이딩해 놓은
				      이름이 없는 자식익명구현클래스이자 자식익명구현객체를 생성합니다.
*/

interface RemoteControl { //부모인터페이스
	
	//추상메소드
	void trunOn();
	void trunOff();

} //interface RemoteControl


class Home { //일반클래스
	
	//인스턴스변수 rc를 만들어 RemoteControl 부모인터페이스를 구현한
	//이름이 없는 자식익명구현클래스를 만드는 동시에 이름이 없는 자식익명구현객체메모리 생성해서 주소 저장
	private RemoteControl rc = new RemoteControl() {
		@Override
		public void trunOn() {
			System.out.println("Tv를 켭니다.");
		}
		@Override
		public void trunOff() {
			System.out.println("Tv를 끕니다.");
		}
	}; 
	
	//Home 클래스의 인스턴스 메소드
	public void use1() {
		this.rc.trunOn();
		this.rc.trunOff();
	}
	
	//Home 클래스의 인스턴스 메소드2
	public void use2() {
		
		//로컬(지역)변수 형태로 rc 인스턴스변수를 만들고
		//RemoteControl 부모인터페이스의 추상메소드를 강제로 오버라이딩 시킨
		//이름이 없는 로컬익명자식구현클래스를 만드는 동시에 로컬익명자식구현객체를 생성해서
		//rc 인스턴스변수에 대입해서 주소 저장
		RemoteControl rc = new RemoteControl() {
			@Override
			public void trunOn() {
				System.out.println("에어컨을 켭니다.");
			}
			@Override
			public void trunOff() {
				System.out.println("에어컨을 끕니다.");
			}
		};
		
		//위 자식익명구현객체 내부에 만들어놓은 오버라이딩한 메소드들 호출
		rc.trunOn();
		rc.trunOff();
	
	} //use2
	
	public void use3(RemoteControl rc) {		
		rc.trunOn();
		rc.trunOff();	
	} //use3
	
	
	
} //class Home


public class HomeExample {
	public static void main(String[] args) {
		
		//Home 외부클래스 객체메모리 생성
		Home home = new Home();
		
		home.use1();
		//출력결과
		//Tv를 켭니다.
		//Tv를 끕니다.
		
		home.use2();
		//출력결과
		//에어컨을 켭니다.
		//에어컨을 끕니다.
		
		//Home 객체메모리 내부의 use3 메소드 호출할 때
		//매개변수로 RemoteControl 부모인터페이스를 구현한
		//중첩 자식익명구현객체메모리를 생성해서 주소번지 전달해서 사용
		home.use3( new RemoteControl() {
			@Override
			public void trunOn() {
				System.out.println("난방을 켭니다.");
			}
			@Override
			public void trunOff() {
				System.out.println("난방을 끕니다.");
			}
		} ); //use3
		//출력결과
		//난방을 켭니다.
		//난방을 끕니다.


	}//main

} //HomeExample
