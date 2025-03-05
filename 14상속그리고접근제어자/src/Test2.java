

//주제 : 부모클래스와 자식클래스가 같은 패키지에 만들어져 있는 경우
//		다양한 종류의 접근제어자 작성 연습

//Super라는 이름의 Class만들기
class Super {
	
	//public 접근제어자 이용, 4바이트 크기의 정수를 저장시킬 num1변수 선언 후 10저장
	public int num1 = 10;
	
	//protected 접근제어자 이용, 4바이트 크키의 정수를 저장시킬 num2변수 선언 후 20저장
	protected int num2 = 20;
	
	//default 접근제어자 이용, 4바이트 크키의 정수를 저장시킬 num3변수 선언 후 30저장
	int num3 = 30;
	
	//private 접근제어자 이용, 4바이트 크키의 정수를 저장시킬 num4변수 선언 후 40저장
	private int num4 = 40;
	
	//num4변수는 private 접근제어자로 은닉(보호)되고 있으므로
	//외부클래스에서는 변수명이 보이지않기때문에
	//public getter 역할의 메소드를 만들어 num4 인스턴스변수값을 외부클래스로 반환(공유)하게 메소드 선언
	public int getNum4() {
		return num4;
	}

}

//--------------------------------------------------------------------------------------

//Super클래스를 부모로 정하여 상속받아 새롭게 만드는 Sub 자식클래스 만들기
	class Sub extends Super {
		
		//private 접근제어자 이용, 4바이트 크기의 정수 하나를 저장시킬 num5변수 선언
		private int num5;
		
		//public 접근제어자 이용
		//Sub 클래스의 객체메모리 생성하면 부모와 자식객체메모리가 다 만들어진다는 가정하 작성
		//부모 Super 객체메모리에 만들어져있는 num1, num2, num3, num4 인스턴스변수의 값을 얻어 출력,
		//또한 자식 Sub 객체메모리의 num5 인스턴스변수의 값을 얻어 한 줄 단위로 출력하는 print 인스턴스메소드 선언
		public void print() {
			System.out.println(super.num1);
			System.out.println(super.num2);
			System.out.println(super.num3);
			System.out.println(super.getNum4());
			System.out.println(this.num5);
		
	}
	
}

public class Test2 {

	public static void main(String[] args) {
		
		Sub sub = new Sub();
		sub.print();
		
		/*
			출력형식
			10
			20
			30
			40
			0
		*/

	}

}
