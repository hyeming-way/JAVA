

//보조작업스레드 클래스
class ThreadDemo3 extends Thread {
	//보조작업스레드 일 시키기
	@Override
	public void run() {
		//다른 일반 메소드 호출
		throwException();
	}
	
	//일반 메소드 : 예외 강제로 발생
	public void throwException() {
		try {
			throw new Exception(); //예외 강제로 발생시키기
		} catch (Exception e) {
			e.printStackTrace(); //현재 스택에 있는 예외정보를 꺼내서 출력
		}
	}
}

public class ThreadEx04 {
	public static void main(String[] args) {
		//보조작업스레드 객체 생성
		ThreadDemo3 td = new ThreadDemo3();
		td.start(); //새로운 보조작업스레드 객체 생성 후 일 시키고
					//다시 주스레드로 되돌아와서 주스레드의 코드를 실행시킨다. CPU점유O
		/*
			java.lang.Exception
				at ThreadDemo3.throwException(ThreadEx04.java:15)
				at ThreadDemo3.run(ThreadEx04.java:9)
		*/
		
		td.run(); //새로운 보조작업스레드 객체 내부의 start()메소드를 통해 run 메소드가 실행되는 것이 아니라
				  //주스레드 내부에서 run() 일반메소드를 호출해서 실행되는 것임. CPU점유X
		/*
			java.lang.Exception
				at ThreadDemo3.throwException(ThreadEx04.java:15)
				at ThreadDemo3.run(ThreadEx04.java:9)
				at ThreadEx04.main(ThreadEx04.java:29)
		*/
		
		System.out.println("안녕?");
		
		//결론
		//1. start()메소드 호출시 보조작업스레드 객체가 생성되고, run()메소드를 Stack 공간에 올려놓아 호출하게 됨
		//2. run()메소드를 직접 호출하면 보조작업스레드가 생성되는 것이 아니라
		//	 주스레드에서 run 메소드만 호출하는 것이다.	

	}

}
