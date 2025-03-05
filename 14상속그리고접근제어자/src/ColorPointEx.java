
class Point{
	
	private int x, y; //한 점을 구성하는 x, y 좌표
	
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void showPoint() { //점의 좌표 출력
		System.out.println("(" + x + "," + y + ")");
	}
	
}

//Point를 상속받은 ColorPoint 선언
class ColorPoint extends Point {
	
	private String color; //점의 색 
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void showColorPoint() { //컬러 점의 좌표 출력
		System.out.print(color);
		showPoint(); //Point의 showPoint() 호출
	}
	
}


public class ColorPointEx {
	public static void main(String[] args) {
		
		Point p = new Point(); //Point 객체 생성
		p.set(1, 2); //Point 클래스의 set()호출
		p.showPoint();
		
		ColorPoint cp = new ColorPoint(); 
		cp.set(3, 4); //Point 클래스의 set()호출
		cp.setColor("red"); //ColorPoint의 setColor()호출
		cp.showColorPoint(); //컬러와 좌표출력
		
		
		//결론
		//- 자식 객체메모리를 생성하면 부모 객체메모리도 함께 포함되어 생성된다.
		//- 자식 객체메모리 내부에 부모객체메모리가 포함되므로, 같은 메모리 주소번지를 가진다.
		//- 즉, 하나의 객체가 부모와 자식의 모든 변수를 포함한 형태로 메모리에 저장된다
		

	}

}
