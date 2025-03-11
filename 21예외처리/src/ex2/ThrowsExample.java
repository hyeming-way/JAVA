package ex2;

public class ThrowsExample {
	public static void main(String[] args) {
		
		//findClass 메소드를 호출한 장소 여기서 try 블럭으로 감싸서 예외처리 대신 함
		try {
			findClass(); //아래의 메소드를 호출한 장소
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료 코드");

	}
	
	//정적메소드
	//							   해석 : findClass메소드를 호출한 장소 줄로 가서 ClassNotFoundException 예외처리해라~!
	//							   throws 발생한처리할종류의예외클래스명
	public static void findClass() throws ClassNotFoundException {
		
		//ClassNotFoundException 예외가 발생할 예상 코드 작성
		Class.forName("java.lang.String2");

	}
		
	/*
		출력결과
	 
		java.lang.ClassNotFoundException: java.lang.String2
			at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)
			at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
			at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:526)
			at java.base/java.lang.Class.forName0(Native Method)
			at java.base/java.lang.Class.forName(Class.java:421)
			at java.base/java.lang.Class.forName(Class.java:412)
			at ex2.ThrowsExample.findClass(ThrowsExample.java:23)
			at ex2.ThrowsExample.main(ThrowsExample.java:8)
		프로그램 종료 코드
	*/

}
