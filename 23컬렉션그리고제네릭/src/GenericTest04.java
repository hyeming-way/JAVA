import java.util.ArrayList;
import java.util.Vector;

/*
	제네릭 타입이란?
	  - 클래스를 설계할 때 변수등이 아직 결정되지 않는 타입을 말한다.
	  - 객체를 생성할때 제네릭타입이 결정된다.
	  
	제네릭 타입을 이용한 클래스 또는 인터페이스?
	  - 변수의 타입(자료형)이 결정되어 있지 않는 클래스와 인터페이스를 말합니다.
*/


//제네릭 기법이 작성된 클래스 설계
class GenericClass<T> { //<>안에 아직 결정되지않은 자료형타입 (아무거나 써도 상관X E, T, K, M .....)
	
	private T member; //현재 member 변수는 
					  //아직 결정되지않는 T 제네릭타입을 지정해서 만든 변수
	
	public void setValue(T value) { //매개변수 또한 아직 결정되지 않은 T 제네릭타입을 지정해서
									//매개변수 value를 만들어 놓을 수 있다.
		this.member = value;
	}
	public T getValue() { //메소드의 반환 타입도 아직 결정되지 않은 T 제네릭 타입을 지정해
						  //메소드를 만들어 놓을 수 있다.
		return this.member;
	}
	
} //class GenericClass



class Product<K, M> { //다양한 종류의 모델제품을 저장하기위해 제네릭타입 지정
	
	private K kind; //Tv Kind; 또는 Car kind;
	private M model; //String model; 또는 char model;
	
	public K getKind() {
		return this.kind;
	}
	public void setKind(K kind) {
		this.kind = kind;
	}
	
	public M getModel() {
		return this.model;
	}
	public void setModel(M model) {
		this.model = model;
	}
	
} //class Product



class Tv {}
class Car {}



//Rentable 인터페이스를 제네릭타입으로 선언
//다양한 대상을 렌트하기위해 rent() 추상메소드의 반환타입(리턴타입)을 제네릭타입으로 선언
interface Rentable<P> {
	//추상메소드
	P rent();	
}

//렌트 대상인 Home클래스와 Car2 클래스 
class Home {
	public void turnOnLight() {
		System.out.println("전등을 켭니다.");
	}
}



class Car2 {
	public void run() {
		System.out.println("자동차가 달립니다.");
	}
}



//HomeAgency와 CarAgency는 집과 자동차를 렌트해주는 대리점 클래스로
//Rentable 타입 피라미터를 Home과 Car로 대체해서 구현하는 방법을 보여줍니다.
class HomeAgency implements Rentable<Home> { //<-- 타입을 Home으로 설정
	//추상메소드 오버라이딩
	@Override
	public Home rent() { //<-- 클래스의 제네릭 타입을 Home으로 설정해주었기 때문에 반환타입도 Home!
		return new Home();
	}
}



class CarAgency implements Rentable<Car2> {
	//추상메소드 오버라이딩
	@Override
	public Car2 rent() { //<-- 클래스의 제네릭 타입을 Car2으로 설정해주었기 때문에 반환타입도 Car2!
		return new Car2();
	}
}



public class GenericTest04 {
	public static void main(String[] args) {
		
		HomeAgency homeAgency = new HomeAgency();
		Home home = homeAgency.rent();
		home.turnOnLight();
		//전등을 켭니다.
		
		System.out.println("------------------------------");

		CarAgency carAgency = new CarAgency();
		Car2 car2 = carAgency.rent();
		car2.run();
		//자동차가 달립니다.
		
		System.out.println("------------------------------");
		
		//K 는 Tv, M은 String으로 대체
		Product<Tv, String> product1 = new Product<Tv, String>(); //<--- new Product<>();로 적어도 됨
		
		//settet 메소드들을 호출할때 매개변수로 반드시 Tv 객체주소와 String 문자열 객체 주소 전달하여 저장할 수 있다.
		product1.setKind(new Tv());
		product1.setModel("스마트Tv");
		
		//getter 메소드들을 호출하여 각 변수에 저장된 값들을 반환받아 여기에 저장할 수 있다.
		Tv tv = product1.getKind(); //new Tv() 객체 반환 받음
		String tvModel = product1.getModel(); //"스마트Tv" 객체 반환 받음
		
		//----------------------------------------------------------------------
		
		//K는 Car로 대체, M은 String으로 대체
		Product<Car, String> product2 = new Product<Car, String>();
		
		product2.setKind(new Car());
		product2.setModel("SUV자동차");
		
		boolean result = product2.getKind().equals(product2.getKind());
		System.out.println(result); //true
		
		if(product2.getModel().equals("SV자동차")) {
			System.out.println("두 문자열객체 내부에 저장된 문자열은 같다.");
		}else {
			System.out.println("두 문자열 객체 내부에 저장된 문자열은 다르다.");
		}
		//두 문자열 객체 내부에 저장된 문자열은 다르다.
		
		//----------------------------------------------------------------------
		
		//클래스의 객체를 생성할때 <>오브 기호 안에 제네릭타입을 작성해놓으면
		//제네릭 클래스에 모든 변수나 반환타입이 <>오브 기호 안에 적었던 제네릭타입으로 변경된다.
		GenericClass<Double> obj01 = new GenericClass<Double>();
		
		obj01.setValue(3.5); //오토박싱되어 new Double(3.5); 객체의 주소가 전달됨
		System.out.println(obj01.getValue()); //3.5
		
		
		GenericClass<Integer> obj02 = new GenericClass<>();
		
		obj02.setValue(10); 
		System.out.println(obj02.getValue()); //10
		
		
		GenericClass<String> obj03 = new GenericClass<String>(); 
		obj03.setValue("이해할 수 있다!");
		System.out.println(obj03.getValue()); //이해할 수 있다!
				
	}

}
