
//주제 : 부모클래스 A와 자식클래스 B가 다른 패키지에 각각 만들어져 있는 경우
//		접근제어자의 접근 허용 범위가 어떻게 되는지 알아보자.

//부모클래스 A는 PA패키지 내부에 존재합니다.
package PA;

public class A { //A클래스는 PA패키지에 속한 부모클래스입니다.
	
	//1. 접근제어자별 변수 선언
	int i; //(default) 같은 패키지에서는 접근 가능, 다른 패키지에서는 접근 불가능
	
	protected int pro; //([protected) 다른 패키지라도 자식클래스라면 접근 가능
	
	private int pri; //(private) 같은 클래스 내부에서만 접근 가능
	
	public int pub; //(public) 어디서든지 접근 가능
	
	//2. A클래스 내부에서 멤버변수(인스턴스변수) 값 얻어 출력하는 public 메소드 선언
	public void print() {
		System.out.print("i=" + this.i + ", "); //default 접근가능 (같은 클래스 내부)
		System.out.print("pro=" + this.pro + ", "); //protected 접근가능 (같은 클래스 내부)
		System.out.print("pri=" + this.pri + ", "); //private 접근가능 (같은 클래스 내부)
		System.out.println("pub=" + this.pub + "입니다."); //public 접근가능 (같은 클래스 내부)
	}
	
	public static void main(String[] args) {
		
	}

}
