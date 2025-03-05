
//예제 : super, super() 사용 예

//부모클래스
class Person { //사람설계도
	
	int age = 20;
	String name; //null
	
	//사람 이름(name) 변수값만 초기화할 생성자
	public Person(String name) {
		this.name = name;
	}

}

//자식클래스
class Man extends Person {
	
	int age = 40; 
	//부모클래스 내부의 age 변수명과 동일함
	//동일한 변수명이 있다면 부모클래스의 age 변수는 상속이 안 됨.

	//매개변수가 1개인 생성자
	public Man(String name) {
		//Man객체 생성하면
		//name인스턴스변수는 부모 Person객체메모리 내부에 만들어져 있으므로
		//부모 Person객체의 name인스턴스변수 위치에 저장해야하므로
		//부모 person클래스의 매개변수가 1개인 생성자를 호출할떄 이름을 전달해서
		//저장해야 합니다.  그러므로 아래의 코드작성이 필요하다.			
		super(name);
	}
	
	//메소드 : age 인스턴스변수값을 얻어 출력
	public void getInfo() {
		System.out.println("자식 Man객체메모리에 만들어진 age 인스턴스 변수값 얻어 출력 : " + age); //this. <-가 생략된 것
		//Person부모클래스의 변수 age와 
		//Man자식클래스 변수 age의 이름이 같을때
		//이때 부모 Person객체의 age변수값을 얻어 사용하고 싶으면		
		
		System.out.println("부모 Person객체메모리에 만들어진 age 인스턴스 변수값 얻어 출력 : " + super.age);
	}
	
	//메소드 : name 인스턴스 변수에 초기화된 값을 얻어와 출력
	public void getInfo2() {
		System.out.println("부모 Person 객체메모리 내부에 만들어져 있는 인스턴스변수 name값 : ");
		System.out.println(super.name); //"홍길동"
		//부모 클래스(부모 객체)와 자식클래스(자식객체)내부에
		//인스턴스변수명이 같지 않을때는 
		//생성된 자식객체 메모리 내부에서 부모객체의 인스턴스변수 name값을
		//불러와서 사용시 super.은 생략 가능 하다.		
		System.out.println(name); //"홍길동" <-- super 안 붙여도 상속을 받았기때문에 눈에 보이진않지만 변수 사용가능
	}
	
}

public class Ex6 {
	public static void main(String[] args) {
		
		//자식 Man 클래스의 객체를 생성하는 동시에 매개변수 1개가 존재하는 생성자 호출해서 인스턴스변수값 초기화
		Man man = new Man("홍길동");
		
		man.getInfo();
		man.getInfo2();
	
	}

}
