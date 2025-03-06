package ch08.sec02;

//인터페이스(추상클래스보다 더 추상화된 미완성 설계도)
interface RemoteControl {
	
	//상수
	final int MAX_VOLUME = 10;
	
	int MIN_VOLUME = 0;
	//interface 내부에 상수를 선언할 때 final을 생략하면 변수는 상수메모리로 인식함
	//interface 내부에는 상수만 올 수 있음!!!
	
	//추상메소드
	public abstract void turnOn();
					void turnOff();
					void setVolume(int volume);
	//추상메소드 작성할 때 public abstract 생략 가능!!!
	/*
	인터페이스는 구현 클래스(자식 클래스)가 재정의하는 public 추상메소드를
	멤버로 가질수 있다. 
	추상메소드는 리터타입, 메소드명, 매개변수만 기술되고 중괄호{}를 붙이지 않는
	메소드를 말한다.  public abstract를 생략을 하더라도
	컴파일 과정에서 자동으로 붙게 된다. 
    */				
					
	
	//JDK 8이상의 버전부터 인터페이스 내부에 추가로 작성할 수 있는 멤버
		//1. default 메소드 선언 가능
		// - 인터페이스에는 완전한 실행코드를 가진 default메소드를 선언할 수 있습니다.
		//   추상메소드는 실행부(중괄호 {})가 없지만 defaul메소드는 실행부가 있습니다.
		// - 선언방법
		//		public default 반환자료형타입 메소드명(매개변수,...){ 실행부코드; }			
		public default void setMute(boolean mute) {	
			if(mute) {
				System.out.println("무음 처리합니다.");
				setVolume(MIN_VOLUME);
			}else {
				System.out.println("무음을 해제합니다.");
			}
		}
		
		//2. 정적, 클래스(static을 붙여 만든)메소드
		// - 인터페이스 내부에는 정적(클래스)메소드 선언 가능
		// - 추상메소드와 default메소드는 구현 자식객체가 필요하지만,
		//   정적(클래스)메소드는 인터페이스명.정적메소드명();으로 호출할 수 있다.
		//   단, public을 생략하더라도 자동으로 컴파일 과정에서 붙는 것이
		//   일반 클래스 내부에 작성되는 정적(클래스)메소드와의 차이점이다.
		// - 문법
		//		public 또는 private static 반환타입 정적메소드명(매개변수,...){ 실행코드; }
		static void changeBattery() {
			System.out.println("리모콘 건전지를 교환합니다.");
			
			//정적메소드 내부에서는 주의할 점이 있는데
			//상수를 제외한 추상메소드, 디폴트메소드, private 메소드등을
			//호출할 수 없다는 점 입니다.
		}
		
//----------------------------------------------------------------------------------------
/*
	특정 인터페이스 내부에 만들어 놓은 추상메소드를 강제로 오버라이딩해서
	새로운 자식클래스를 설계하는 문법
	
		class 자식클래스명 implements 부모인터페이스명 {
			
			인터페이스에 만들어 놓은 추상메소드를 강제로 메소드오버라이딩 코드 작성;
			
			자식클래스의 일반메소드 선언
		
		}
		
		implements : 인터페이스안에 만들어 놓은 추상메소드를 강제로 재구현(오버라이딩)함
*/
	
}

//자식클래스를 만들 때 인터페이스 안에 만들어 놓은 추상메소드들을
//강제로 오버라이딩해서 만들겠다.
class Television implements RemoteControl {
	
	//변수
	private int volume;
	
	//참고. 재정의할때 주의할 점은 인터페이스의 추상메소드는
	//	   기본적으로 public 접근제어자를 가지기때문에 public 보다 낮은 접근제어자로 
	//	   재정의할 수 없다. 그래서 재정의되는 메소드는 모두 public이 추가됨
	
	//오버라이딩 단축키 : Alt + Shift + r v
	@Override
	public void turnOn() {
		System.out.println("텔레비전 전원을 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("텔레비전 전원을 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		//인터페이스 상수를 이용해서 volume 변수의 값을 제한할 수 있다.	
		if(volume > RemoteControl.MAX_VOLUME){			
			
			this.volume = RemoteControl.MAX_VOLUME;		
			
		}else if(volume < RemoteControl.MIN_VOLUME) {
			
			this.volume = RemoteControl.MIN_VOLUME;
			
		}else {
			
			this.volume = volume;
		}
		System.out.println("현재 텔레비전 객체의 볼륨 : " + this.volume);
	}
	
}//Television class 설계 끝

//해석 : 새로운 자식클래스인 Audio클래스를 만들 때
//		RemoteControl인터페이스 내부의 추상메소드를 강제로 오버라이딩(재구현)해서 만들겠다
class Audio implements RemoteControl {

	private int volume;
	private int mamoryVolume;
	
	@Override
	public void turnOn() {
		System.out.println("오디오 전원을 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("오디오 전원을 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		//인터페이스 상수를 이용해서 volume 변수의 값을 제한할 수 있다.	
		if(volume > RemoteControl.MAX_VOLUME){			
			
			this.volume = RemoteControl.MAX_VOLUME;		
			
		}else if(volume < RemoteControl.MIN_VOLUME) {
			
			this.volume = RemoteControl.MIN_VOLUME;
			
		}else {
			
			this.volume = volume;
		}
		System.out.println("현재 오디오 객체의 볼륨 : " + this.volume);

	}
	
	@Override
	public void setMute(boolean mute) {
		if(mute) {
			this.mamoryVolume = this.volume;
			System.out.println("무음 처리 합니다.");
		}else {
			System.out.println("무음 해제 합니다.");
			//매개변수 boolean mute로 전달받은 값이 false일 때
			setVolume(this.mamoryVolume);
		}
	}
	
}


public class RemoteControlExample {
	public static void main(String[] args) {
		//레퍼런스(참조자료형) 종류
		// - 클래스자료형, 인터페이스자료형 ....
		
		//인터페이스자료형으로 참조변수 선언 가능하고, 업캐스팅도 가능하다.
		
		//업캐스팅
		//부모인터페이스자료형 참조변수선언 후 자식개체생성하여 주소 저장
		RemoteControl rc = new Television();
					  rc.turnOn(); //텔레비전 객체 메모리 내부의 오버라이딩한 메소드 호출
					  			   //"텔레비전 전원을 켭니다."
					  rc.setVolume(5); //"현재 텔레비전 객체의 볼륨 : 5"
					  rc.turnOff(); //"텔레비전 전원을 끕니다."
					  rc.setMute(true); 
					  //무음 처리합니다.
					  //현재 텔레비전 객체의 볼륨 : 0
					  rc.setMute(false); //"무음을 해제합니다."
					  
					System.out.println("---------------------------");
					
					//업캐스팅
					rc = new Audio();
					rc.setVolume(5); //"현재 오디오 객체의 볼륨 : 5"
					rc.turnOff(); //"오디오 전원을 끕니다."
					rc.setMute(true); //"무음 처리 합니다."
					rc.setMute(false); 
					//무음 해제 합니다.
					//현재 오디오 객체의 볼륨 : 5
					
		//상수는 자식 구현객체와 관련없는 인터페아스 소속멤버이므로
		//인터페이스명으로 바로 접근해서 상수에 저장된 값을 읽어 올 수 있다.
		//문법
		//인터페이스명.상수명			
		System.out.println("리모콘 최대볼륭:" + RemoteControl.MAX_VOLUME); //리모콘 최대볼륭:10
		System.out.println("리모콘 최소볼륭:" + RemoteControl.MIN_VOLUME); //리모콘 최소볼륭:0
		
		//static 정적메소드 호출 (인터페이스 내부에 만들어 놓은)
		//인터페이스명.정적메소드명();
		RemoteControl.changeBattery(); //리모콘 건전지를 교환합니다.
	}

}
