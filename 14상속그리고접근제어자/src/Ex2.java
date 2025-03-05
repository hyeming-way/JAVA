
//주제 : 상속을 사용하지않고 Point2D, Point3D클래스 설계시
//		각 클래스 내부의 코드가 중복되는 예

//2차원 평면의 좌푯값을 저장하는 Point2D클래스 설계
//Point2D클래스는 변수로 x, y를 갖고,
//이 좌표값은 2차원 좌표계에서의 점을 나타냅니다.
class Point2D{
	private int x; //private?	클래스 내부에서만 쓸 수 있게 접근을 막음
	private int y;
	
	//setter, getter메소드들 자동으로 만드는 단축키
	// alt + shift + s r
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}

//3차원 공간상의 좌푯값 한점을 나타내는 x,y,z를 저장하는 Point3D클래스 설계
class Point3D{
	private int x; //Point2D클래스의 x변수 선언 코드와 중복됨
	private int y; //Point2D클래스의 y변수 선언 코드와 중복됨
	private int z;
	
	public int getX() { //Point2D클래스의 코드와 중복
		return x;
	}
	public void setX(int x) { //Point2D클래스의 코드와 중복
		this.x = x;
	}
	public int getY() { //Point2D클래스의 코드와 중복
		return y;
	}
	public void setY(int y) { //Point2D클래스의 코드와 중복
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
}

public class Ex2 {

	public static void main(String[] args) {
		

	}

}
