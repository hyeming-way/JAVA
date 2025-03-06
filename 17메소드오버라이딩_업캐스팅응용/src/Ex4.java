
/*
	예제 : 부모클래스의 변수를 상속받아 사용하는 예
	
	
*/
class Point2D { //부모클래스
	protected int x = 10;
	protected int y = 20;
}


class Point3D extends Point2D { //자식클래스
	protected int x = 40;
	protected int y = 50;
	
	protected int z = 30;
	
	//메소드
	//기능 : x, y, z 변수의 값을 불러와 출력
	public void print() {
		System.out.println( this.x + ", " + this.y + ", " + z ); //x, y만 적어도 됨!
		System.out.println( super.x + ", " + super.y + ", " + z ); //부모클래스의 변수값 그대로 불러오려면 super 키워드 사용
	}
}




public class Ex4 {
	public static void main(String[] args) {
		
		new Point3D().print(); //<-- 인스턴스. 한번 쓰고 버림
							   //40, 50, 30
							   //10, 20, 30
		/*
		  	결론
			 	   메소드 오버라이딩시~~~
			 	   상속되지 않고 은닉된 부모클래스의 메소드와 같이
			 	   부모클래스에 정의된 변수와 같은이름을 가진 변수를 자식클래스에서 선언하는데
			 	   이러한 경우에도 부모클래스의 변수는 자식클래스에서 상속받을 수 없게 된다.
		 */		
	 

	}

}
