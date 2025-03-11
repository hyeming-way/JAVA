package exam03;

/*
	주제 : 최고 부모클래스 Object의 toString()메소드를 오버라이딩시킨
		  새로운 자식 Point 클래스 만들어 사용
*/

//한 점을 표시하기위한 좌표값 x, y축의 경로를 저장할 용도의 클래스(설계도)
class Point {
	
	int x, y;
	
	public Point(){} //기본생성자
	
	//new Point(10, 20); 객체를 생성하는 동시에 x, y 인스턴스변수값 초기화할 생성자
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/*
		아래 toString()메소드가 상속됨
	      public String toString(){
       		return this.getClass().getName() + "@" + Integer.toHexString(hashCode());
       				생성된 객체의 클래스명		 + "@" + 	    16진수 해시코드;   
       }  
	*/
	
	//point 클래스의 객체를 생성하면 인스턴스변수 x와 y에 저장된 데이터를
	//하나의 문자열로 만들어서 반환할 수 있도록 toString메소드 오버라이딩
	@Override
	public String toString() {
		//기능 재정의
		return "(" + x + "," + y + ")"; //"(x,y)"형태로 반환
	}
	
} //class Point

public class ObjectTest {
	public static void main(String[] args) {
		
		Point point = new Point();
		
		System.out.println(point.toString()); 
		//Object 클래스의 메소드를 상속받은 경우
		//출력결과
		//exam03.Point@2ff4acd0
		
		//메소드 재정의 후 출력결과
		//(0,0)
		
		Point point2 = new Point(10, 20);
		System.out.println(point2.toString());
		//출력결과 : (10,20)
		
		//toString() 호출구문은 생략 가능하다.
		System.out.println(point2);
		//출력결과 : (10,20)
		
	}

}
