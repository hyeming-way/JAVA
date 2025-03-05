
//주제 : 부모클래스와 자식클래스가 같은 패키지에 만들어져 있을 경우
//		접근제어자들을 사용한 멤버(변수 또는 메소드)의 접근 범위

class AA { //부모클래스
	
	//default 접근제어자
	//- 부모클래스의 변수가 default 접근제어자로 작성한 변수이면
	//	자식클래스 내부든 다른 일반클래스 내부든 같은 패키지 내부에서는 모든 접근 가능
	int i;
	
	//protected 접근제어자
	//1. 같은 패키지에 만들어져있는 다른 클래스에서 protected로 만든 변수에 접근가능
	//2. 다른 패키지의 일반클래스에서는 접근 불가능합니다.
	//	 단! 다른패키지에 만들어 놓은 AA의 자식클래스 내부에서는 접근 가능
	protected int pro;
	
	//public 접근제어자
	//- 다른패키지 또는 같은 패키지에 만들어 놓은 모든 클래스에서 접근을 허용
	public int pub;
	
	//private 접근제어자
	//1. 같은 클래스 내부에 private으로 변수를 만들어 놓으면
	//	 같은 클래스 내부에서만 변수에 접근을 허용함
	//2. 인스턴스변수를 선언할때 대부분의 개발자들은 private 접근제어자를 많이 사용함
	//3. public 메소드 또는 생성자를 통해 private으로 선언한 변수값을 사용하거나 변경함
	private int pri;
	
	//pri변수에 저장된 값을 외부로 반환하는 getPri()메소드
	public int getPri() {
		return this.pri;
	}
	
	//pri변수에 저장된 값을 변경하는 setPri()메소드
	public void setPri(int pri) {
		this.pri = pri;
	}
	
}

class BB extends AA { //자식클래스
	
	//BB객체의 default 접근제어자를 이용하여 set 이름의 인스턴스 메소드
	void set() {
		//부모 객체메모리 주소번지를 기억하고 있는 예약어 -> super
		super.i = 1; //default 접근제어자로 만든 변수 i
					 //같은 패키지 내부의 다른 클래스에서 객체메모리의 인스턴스변수에 접근가능
		
		super.pro = 2; //protected 접근제어자로 만든 변수 pro 접근가능
		
	//	super.pri = 3; //에러발생. private은 같은 클래스 내부에서만 사용가능하므로 접근불가
		//public 접근제어자로 만들어 놓은 부모객체에 있는 setPri메소드를 호출해서
		//인스턴스변수의 값을 변경가능하다.
		super.setPri(3);
		
		super.pub = 4; //public 접근제어자로 접근가능
	}
	
	//BB객체의 get 인스턴스 메소드
	public String get() {
		return super.i + "," + super.pro + "," + super.pub + "," + super.getPri();
	}
	
}


public class Ex4 {

	public static void main(String[] args) {
		
		//BB 자식클래스의 객체메모리 생성
		BB bb = new BB();
		bb.set();
	
		System.out.println(bb.get()); //1,2,4,3
		
		/*
			  0x12  AA부모 객체
			--------------------------------
			int i; [ 1 ]
			protected int pro; [ 2 ]
			public int pub;  [4 ]
			private int pri; [3 ]
			//getter
			public int getPri(){}
			//setter
			public void setPri(int pri){}
			
			----------0x12 BB자식 객체---------
			  		 void set(){ }
				 public  String get(){ }			
			---------------------------------
		*/		
		
	}

}
