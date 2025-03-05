
//주제 : 두 클래스의 상속관계에서 private 접근제어자를 지정한 변수 또는 메소드 사용 실습

class A /*extends Object*/{ //부모역할을 하는 클래스
	//참고. 자바 모든 클래스는 java.lang.Object클래스를 자동으로 상속받음
	//Object 안에는 toString()메소드가 포함되어있다.
	
	public int p; //어디서든 접근 가능(public)
	
	private int n; 
	//자식클래스에서 직접 접근할 수 없으며,
	//상속되지않는 것이 아니라 "보이지 않을 뿐"입니다. (상속은 가능)
	//super.getN()을 통해서만 값을 가져올 수 있습니다.
	//클래스 A 내부에서만 접근 가능(private)
	
	//public 메소드를 통해서 private 변수 n을 설정 및 반환 (캡슐화)
	public void setN(int n) {
		this.n = n;
	}
	
	public int getN() {
		return this.n;
	}
	
}

class B extends A { //자식클래스
	
	private int m; //B클래스 내부에서만 접근 가능(public)

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}
	//부모클래스의 private변수 n은 직접 접근할 수 없으므로 getN()메소드를 통해 접근
	public String toString(){
		return "n=" + /*super.*/getN() + " m=" + this.getM(); //super. 부모객체의 멤버를 기억하고 있는 예약어
	}
	
}



public class Ex3 {

	public static void main(String[] args) {
		
		//자식클래스 B의 객체 생성
		B b = new B();
		b.p = 5; //public 변수 p는 접근 가능
	//	b.n = 10; -> 오류발생. private 변수 n은 타 클래스에서 접근 불가
		b.setN(10); //setN()을 통해서 n값 설정
	//	b.m = 20;- > 오류발생. private 변수 m은 타 클래스에서 접근 불가
		b.setM(20); //setM()을 통해서 m값 설정
		
		//toString()메소드를 호출하여 출력
		System.out.println(b.toString()); //n=10 m=20
		
/*
        생성된 B 객체의 메모리 구조
        
        [B 객체 메모리 (0x10)]
        ┌───────────────────────────┐
        │ A의 멤버 (상속된 부모 부분) 	│
        │   public int p = 5        │
        │   private int n = 10 (직접 접근 불가, getN()으로 접근)
        │   public void setN()      │
        │   public int getN()       │
        ├───────────────────────────┤
        │ B의 멤버 (자식 부분)       	│
        │   private int m = 20 (직접 접근 불가, getM()으로 접근)
        │   public void setM()      │
        │   public int getM()       │
        │   public String toString()│
        └───────────────────────────┘
*/			
		
		//부모클래스 A의 객체메모리 생성
		A a = new A();
		a.p = 5;
	//	a.n = 0; -> 오류발생. private 변수 n은 타 클래스에서 접근 불가
	//	a.setN(5); //setN()을 통해서 n값 설정
		
        /*
        생성된 A 객체의 메모리 구조

        [A 객체 메모리 (0x11)]
        ┌───────────────────────────┐
        │ public int p = 5          │
        │ private int n = 0 (직접 접근 불가) 
        │ public void setN()        │
        │ public int getN()         │
        └───────────────────────────┘
        */
		
	}

}
