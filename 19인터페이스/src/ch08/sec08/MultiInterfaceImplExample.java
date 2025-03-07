package ch08.sec08;

//자바프로그램을 실행시키는 시작점인 main메소드 기능을 가지고 있는 클래스
public class MultiInterfaceImplExample {
	public static void main(String[] args) { //main 메소드 = 주스레드
		
		//업캐스팅을 통해 SmartTelevision 자식 객체메모리 생성
		RemoteControl rc = new SmartTelevision();
		//업캐스팅 후 부모인터페이스자료형의 참조변수 rc로
		//뒤에 생성된 SmartTelevision객체의 멤버는
		//RemoteControl인터페이스에 만들어 놓은 추상메소드만
		//호출해서 사용할 수 있다.
		
		rc.turnOn();  //"SmartTelevision의 전원을 켭니다."
		rc.turnOff(); //SmartTelevision의 전원을 끕니다.
		
	//	rc.search("httpL//www.naver.com");
		//Searchable 부모인터페이스에 정의한 메소드이므로
		//RemoteControl부모인터페이스 참조변수로 호출이 불가능함
		
		//업캐슽팅을 통해 SmartTelevision 자식 객체메모리 생성
		Searchable searchable = new SmartTelevision();
		searchable.search("http://www.naver.com");
		//"http://www.naver.com을 검색합니다."
		
		
	}

}
