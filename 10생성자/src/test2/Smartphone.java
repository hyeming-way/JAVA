package test2;

//스마트폰을 표현하는 클래스(설계도)
public class Smartphone {
	
	//객체변수 생성
	//스마트폰 브랜드명 저장할 brand 객체변수 선언
	String brand;
	
	//스마트폰 모델명 저장할 model 객체변수 선언
	String model;
	
	//배터리 용량을 정수로 저장할 batteryCaoacity 객체변수 선언
	int batteryCaoacity;
	
	//생성자 생성 (단, 생성자 오버로딩하기)
		//1. 모델명만 초기화하는 생성자 만들기
		//this()를 사용하여 세번째 생성자 호출
		//브랜드->"Samsung", 매개변수로 전달받은 모델명 전달, 배터리용량->4000 
	public Smartphone(String model) {
		this("Samsung", model, 4000);
	}
	//2. 브랜드와 모델명을 초기화하는 생성자 만들기
		//this()를 사용하여 세번째 생성자 호출
		//매개변수로 전달받은 브랜드명과 모델명 전달, 배터리 용량 4000 전달
	public Smartphone(String brand, String model) {
		this(brand, model, 4000);	
	}
	
	//3. 브랜드와 모델명, 배터리 용량까지 모두 초기화하는 생성자 만들기
		//this키워드를 사용하여 현재 객체메모리의 모든객체 변수값을 초기화
	public Smartphone(String brand, String model, int batteryCaoacity) {
		this.brand = brand;
		this.model = model;
		this.batteryCaoacity = batteryCaoacity;
	}

	public static void main(String[] args) {
		
		//Smartphone클래스의 객체 생성하는 동시에 첫번째 생성자 호출시 매개변수로 모델명 "Galaxy S24"만 전달하여 초기화
		Smartphone phone1 = new Smartphone("Galaxy S24");
		
		//Smartphone클래스의 객체 생성하는 동시에 두번째 생성자 호출시 매개변수로 모델명 "Apple", 브랜드 "iPhone 15" 전달하여 초기화
		Smartphone phone2 = new Smartphone("Apple", "iPhone 15");
		
		//Smartphone클래스의 객체 생성하는 동시에 세번째 생성자 호출시 매개변수로 모델명 "Google", 브랜드 "Pixel 8", 배터리용량 4000 전달하여 초기화
		Smartphone phone3 = new Smartphone("Google", "Pixel 8", 4000);
		
		//생성된 위 3개의 객체메모리 내부의 모든 객체 변수값들 차례로 출력
		System.out.println(phone1.brand + ", " + phone1.model + ", " + phone1.batteryCaoacity + "mAh"); //Samsung, Galaxy S24, 4000mAh
		System.out.println(phone2.brand + ", " + phone2.model + ", " + phone2.batteryCaoacity + "mAh"); //Apple, iPhone 15, 4000mAh
		System.out.println(phone3.brand + ", " + phone3.model + ", " + phone3.batteryCaoacity + "mAh"); //Google, Pixel 8, 4000mAh
	
	}

}
