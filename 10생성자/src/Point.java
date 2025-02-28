
public class Point { //x좌표, y좌표 점 설계도
	
	//x, y 좌표값을 각각 저장시킬 int 객체변수 2개 선언
	int x, y;
	
	//기본생성자 (매개변수 없는 생성자) 선언
	public Point() {
		//x 객체변수값 2로 초기화
		x = 2;
		//y 객체변수값 2로 초기화
		y = 2;
		//생성자가 호출됨을 알리기위한 출력
		System.out.println("[기본 생성자] Point 기본생성자 호출됨");
	}
	
	//x 객체 변수값만 초기화하는 생성자 선언 (매개변수 하나인 생성자)
	public Point(int x_) {
		//x 객체 변수값 매개변수로 전달 받는 값으로 초기화
		x = x_;
		//y 객체 변수값 0으로 초기화
		y = 0;	
	}
	
	//x 객체 변수, y 객체 변수 값 모두 초기화 하는 생성자 선언
	public Point(int x_, int y_) {
		//x 객체 변수값 매개변수로 전달 받는 값으로 초기화
		x = x_;
		//y 객체 변수값 매개변수로 전달 받는 값으로 초기화
		y = y_;	
	}
	
	//--------------------------------------------------------
	
	//위 y 객체 변수값 변경하는 setY 메소드 생성
	public void setY(int y_) { //setter 메소드
		y = y_;	
	}
	//위 y 객체 변수값 반환하는 getY 메소드 생성
	public int getY() { //getter 메소드
		return y;
	}
	//위 x 객체 변수값 변경하는 setX 메소드 생성
	public void setX(int x_) { //setter 메소드
		x = x_;	
	}
	//위 x 객체 변수값 반환하는 getX 메소드 생성
	public int getX() { //getter 메소드
		return x;
	}
	//현재 x 객체 변수값 그리고 y 객체 변수값 모두 하나의 문자열로 만들어 출력하는 기능의 printCoordinates메소드 만들기
	//"출력 x, y : 100, 200"
	public void printCoordinates() {
		System.out.println("출력 x, y : " + x + ", " + y);
	}	

	public static void main(String[] args) {
		
		//1. 기본생성자를 이용하여 Point 클래스의 객체 생성, 참조변수 point1
		Point point1 = new Point();
		
		//1.2
		//point1 참조변수에 저장된 객체의 x 좌표값 출력
		//"객체변수 x = 2"
		System.out.println("객체변수 x = " + point1.getX());
		
		//point1 참조변수에 저장된 객체의 y 좌표값 출력
		//"객체변수 y = 2"
		System.out.println("객체변수 y = " + point1.getY());
		
		//point1 참조변수에 저장된 객체의 전체 좌표정보 출력
		//"출력 x, y : 2, 2"
		point1.printCoordinates();
		
		System.out.println("=====================");
		
		//1.3 
		//point1 참조변수에 저장된 객체의 x 좌표값을 setX메소드 사용 -> 10으로 변경
		point1.setX(10);
		
		//point1 참조변수에 저장된 객체의 y 좌표값을 setY메소드 사용 -> 20으로 변경
		point1.setY(20);
		
		//point1 참조변수에 저장된 객체의 전체 좌표정보 출력
		//"출력 x, y : 10, 20"
		point1.printCoordinates();
		
		System.out.println("=====================");
		
		//1.4
		//point1 참조변수에 저장된 객체의 x 좌표값을 getX메소드 사용 -> 10을 반환해서 이 자리에 출력
		System.out.println(point1.getX());
		//point1 참조변수에 저장된 객체의 y 좌표값을 getY메소드 사용 -> 20을 반환해서 이 자리에 출력
		System.out.println(point1.getY());
		
		System.out.println("=====================");
		
		//2. x 좌표값만 초기화하는 생성자를 사용하여 Point 클래스의 객체 생성, 참조변수 point2
		Point point2 = new Point(300);
		
		//2.1 point2 참조변수에 저장된 객체의 전체 좌표정보 출력
		//"출력: x = 300, y = 0"
		System.out.println("출력: x = " + point2.getX() + ", y = " + point2.getY() );
		
		System.out.println("=====================");
		
		//3. x, y 좌표값을 모두 초기화하는 생성자를 사용하여 Point 클래스의 객체 생성, 참조변수 point3
		Point point3 = new Point(300, 400);
		
		//3.1 point3 참조변수에 저장된 객체의 전체 좌표정보 출력
		//"출력: x = 300, y = 400"
		System.out.println("출력: x = " + point3.getX() + ", y = " + point3.getY() );
	
	}

}
