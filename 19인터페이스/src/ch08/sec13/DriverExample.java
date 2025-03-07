package ch08.sec13;

interface Vehicle {
	//추상메소드
	void run(); //달리는 기능
}

//Vehicle 부모인터페이스 안의 추상메소드를 재정의한 Bus 클래스 생성
class Bus implements Vehicle {
	@Override
	public void run() {
		//재정의
		System.out.println("버스가 달립니다.");
	}	
}

//Vehicle 부모인터페이스 안의 추상메소드를 재정의한 Taxi 클래스 생성
class Taxi implements Vehicle {
	@Override
	public void run() {
		System.out.println("택시가 달립니다.");
	}
}

//운전자 설계도(클래스)
class Driver {
	
	//Vehicle 부모인터페이스를 구현한 다양한 자식객체주소를 전달받기위해 매개변수를 선언 (업캐스팅)
	void drive(Vehicle vehicle) { //<--new Bus();, new Taxi(); 두개 중 하나를 전달받음
		vehicle.run(); //부모인터페이스의 추상메소드를 강제로 오버라이딩한 자식 객체의 메소드 호출
	}
}


public class DriverExample {
	public static void main(String[] args) {
		
		//운전자클래스의 객체 생성
		Driver driver = new Driver();
		//new Driver(); <-- 이렇게만 적어도 됨. 참조변수가 없는 **인스턴스**. 한번만 쓰고 버릴 경우 사용
		//Driver driver = new Driver(); <-- **객체**. 재활용 가능함
		
		//Vehicle 부모인터페이스를 구현한 자식객체들 생성
		Bus bus = new Bus();
		Taxi taxi = new Taxi();

		//Driver객체의 drive메소드 호출시 매개변수로 어떤 자식객체를 전달하는지에 따라
		//drive메소드 내부에서 호출되는 run()메소는 전달한 자식객체 내부의 오버라이딩해 놓은 메소드 호출되어
		//실행된다.
		driver.drive(bus); //"버스가 달립니다."
		driver.drive(taxi); //"택시가 달립니다."
		

	}

}
