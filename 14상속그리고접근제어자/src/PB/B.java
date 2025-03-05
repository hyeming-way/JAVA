package PB;

//다른 PA외부 패키지에 만들어져있는 A class를 현재 PB패키지의 B class 내부에서 사용하기 위해
//import구문을 작성해서 자바컴파일러에게 알려줘야합니다.

//import 외부패키지명.사용할외부클래스명;
import PA.A;

//PA다른패키지에 만들어져있는 부모역할을 하는 A외부부모클래스를 상속받아
//새롭게 만드는 자식 B 클래스 만들기
public class B extends A {
	
	//default 접근제어자로 B클래스의 메소드 선언
	void set() {
		//다른 패키지의 부모 A객체메모리에 만들어 놓은
		//i 인스턴스변수는 default 접근제어자를 이용해 만들어 놓았기 때문에
		//자식객체메모리 내부에서 접근 불가능
	//	super.i = 1; (default)다른 패키지여서 접근 불가능
		
		//다른 PA패키지의 부모 A객체메모리에
		//protected pro 변수에 접근 가능
		super.pro = 2; //(protected)다른 패키지여도 자식클래스면 접근 가능
		
		//다른 PA패키지의 부모A객체 메모리에
		//private pri 변수에 접근 불가능
	//	super.pri = 3; (private) 같은 클래스에서만 접근 가능함
		
		//다른 PA패키지의 부모A객체 메모리에
		//public pub 변수에 접근 가능
		super.pub = 4; //(public) 모든 접근 가능
		
	}

	public static void main(String[] args) {
		
		//자식 B클래스에 대한 객체메모리 생성
		B b = new B();
		//B자식 객체 메모리 생성 구문 new B()를 작성하면
		//자식 B클래스의 생성자 B가 먼저 호출되고 
		//B의 부모인 A클래스의 생성자가 바인딩되어 호출됩니다.
		//그런후 부모A클래스의 생성자가 실행되어 부모 A객체메모리가 먼저 생성되고
		//나중에 자식B클래스의 생성자B()가 실행되어 자식 B객체 메모리가 생성됩니다.
		
		b.set();
		b.print();
		//i=0, pro=2, pri=0, pub=4입니다.
		
		/*
		   ---------------------------------------------------------	   

							A부모객체 메모리 내부 모습
			
						int i; //default
			protected 	int pro;
			private		int pri;
			public 		int pub;
			
			public A(){}  <---기본생성자 
			
			
			public void print() {
				System.out.print("i=" + this.i + "," );
				System.out.print("pro=" + this.pro + ",");
				System.out.print("pri=" + this.pri + ",");
				System.out.println("pub=" + this.pub + "입니다.");
			}
		   ---------------------------------------------------------	   
		        			B자식객체 메모리 내부 모습
		   
		   		public B(){}   <---기본생성자 
		   
		        void set(){
		        	super.pro = 2;
		        	super.pub = 4;
		        }
		
		   ----------------------------------------------------------	
	*/
		
	}

}
