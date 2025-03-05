
package test;

//주제 : 중복되는 코드를 재활용하는 상속의 장점

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
//상속문법
//class 새롭게설계하는자식클래스명 extends 상속받을부모클래스명 {}

class Point3D extends Point2D{
	
	private int z;
	
	
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
}

public class Ex2_1 {

	public static void main(String[] args) {
		
		//Point3D (새롭게 설계한 자식클래스)의 객체메모리 생성
		Point3D point3d = new Point3D();
		
		point3d.setX(10); //상속받은 부모 Point2D객체의 인스턴스변수에 저장
		point3d.setY(20); //상속받은 부모 Point2D객체의 인스턴스변수에 저장
		point3d.setZ(30); //Point3D 객체메모리 내부의 인스턴스변수에 저장
		
		System.out.println(point3d.getX() + ", " + point3d.getY() + ", " + point3d.getZ());
		
	
	}

}
