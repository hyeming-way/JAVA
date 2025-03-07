package ch08.sec08;

//전원을 켜고, 끄고, 검색을 구현하기위한 자식클래스 생성
public class SmartTelevision implements RemoteControl, Searchable {

	//두 부모인터페이스 내부에 작성된 모든 추상메소드를 강제로 메소드 오버라이딩(재구현)
	//단축키	:	alt + shift + s v
	
	@Override
	public void search(String url) { //Searchable 부모 인터페이스의 추상메소드 강제 오버라이딩
		System.out.println(url + "을 검색합니다.");
	}

	@Override
	public void turnOn() { //RemoteControl 부모 인터페이스의 추상메소드 강제 오버라이딩
		System.out.println("SmartTelevision의 전원을 켭니다.");
	}

	@Override
	public void turnOff() { //RemoteControl 부모 인터페이스의 추상메소드 강제 오버라이딩
		System.out.println("SmartTelevision의 전원을 끕니다.");
	}

}
