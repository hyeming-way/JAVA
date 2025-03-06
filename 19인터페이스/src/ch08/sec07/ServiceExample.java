package ch08.sec07;

interface Secvice{
	
	//default 메소드 선언가능
	default void defaultMethod1() {
		System.out.println("defaultMethod1 종속코드");
		//아래쪽에 만들어 놓은 private 메소드 호출가능
		defaultCommon();
	}
	default void defaultMethod2() {
		System.out.println("defaultMethod2 종속코드");
		//아래쪽에 만들어 놓은 private 메소드 호출가능
		defaultCommon();
	}
	
	//private 메소드 선언가능
	private void defaultCommon() {
		System.out.println("defaultMethod 중복코드 A");
		System.out.println("defaultMethod 중복코드 B");
	}
	
	//정적(static) public 메소드 선언가능
	static void staticMethod1() {
		System.out.println("staticMethod1 종속코드");
	//	defaultCommon(); <-- private 메소드 호출 불가능	
		
		//아래쪽에 만들어놓은 private static 정적메소드 호출가능!
		Secvice.staticCommon();
	}
	
	static void staticMethod2() {
		System.out.println("staticMethod2 종속코드");
	//	defaultCommon(); <-- private 메소드 호출 불가능		
		
		//아래쪽에 만들어놓은 private static 정적메소드 호출가능!
		Secvice.staticCommon();
	}
	
	//private 정적메소드
	private static void staticCommon() {
		System.out.println("staticMethod 중복코드 C");
		System.out.println("staticMethod 중복코드 D");
		
	}
	
}


public class ServiceExample {
	public static void main(String[] args) {
		
		

	}

}
