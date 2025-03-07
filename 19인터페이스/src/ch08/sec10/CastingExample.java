package ch08.sec10;

//부모인터페이스
interface Vehicle {
	//추상메소드
	void run();
}

//부모인터페이스를 구현한 자식클래스
class Bus implements Vehicle {
	
	//부모 Vehicle 인터페이스의 추상메소드 run을 강제로 오버라이딩
	@Override
	public void run() {
		System.out.println("Bus가 달립니다.");
	}

	//Bus클래스의 메소드
	public void checkFare() {
		System.out.println("승차요금을 체크합니다.");
	}
}


public class CastingExample {
	public static void main(String[] args) {
		
		//업캐스팅
		// - 장점 : 부모인터페이스의 참조변수 하나로 여러 자식객체를 관리(저장)할 수 있다.
		// - 단점 : 부모인터페이스자료형으로 자동형변환되어 부모인터페이스 내부에 작성된 추상메소드 run만 
		//		   생성된 자식객체메모리 Bus의 run에만 접근해서 사용할 수 있습니다.
		Vehicle vehicle = new Bus();
				vehicle.run(); //"Bus가 달립니다."
			//	Vehicle.checkFare();	호출불가능
			// 부모인터페이스 Vehicle에 만들어져있지않은 메소드는 호출이 불가능하다.
				
				
				
		//업캐스팅의 단점을 해결하기위해 다운캐스팅이 나옴
				
		//다운캐스팅(강제형변환)
		//자식클래스자료형 참조변수 = (자식클래스자료형)자식객체주소가저장된_부모인터페이트자료형의 참조변수명;
		Bus bus = (Bus)vehicle;
		    bus.run(); //"Bus가 달립니다."
		    bus.checkFare(); //"승차요금을 체크합니다."
		//강제형변환 후 bus 참조변수로 모든 메소드를 호출할 수 있다.

	}

}
