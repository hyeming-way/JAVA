
import java.util.Date;

/*
	Thread클래스의 join()메소드
	- 특정스레드가 종료되는것을 막아서 지연시켜주는 역할을 하는 메소드
	- 하나의 스레드가 다른 스레드의 작업이 완료 될때까지 기다릴수 있도록
	  도와 주는 기능의 메소드
	  즉, 한스레드가 join()메소드를 호출한 다른 스레드의 작업이 완료될떄까지 대기하기 됩니다.
	
	join메소드의 동작순서
	 1. join()메소드 호출시, 현재 실행중인 스레드는 지정된 스레드가 종료될때까지 대기합니다.
	 2. 지정된 스레드가 종료되면 join()메소드를 호출한 스레드는 종료된 스레드의 후속작업을 실행합니다.
	 3. 만약 지정된 시간내에 스레드가 종료되지 않으면, join()메소드는 타임아웃이 발생하여
	    대기를 종료하고 호출 스레드는 정상적으로 실행됩니다.
    
 주제 : 메인스레드의 종료되는 시점을 지연시켜 마지막으로 메인스레드 종료되게 하는 프로그램    
 
*/

//보조작업스레드 객체 생성하기위한 Runnable 인터페이스의 
//run 추상메소드를 오버라이딩 해놓은 일반클래스 만들기
public class ThreadEx13 implements Runnable {
	
	@Override
	public void run() {
		//반복문을 돌면서 현재 실행중인 스레드 이름, 1~9까지 반복해서 출력,
		//스레드가 실행하는 현재 날짜정보 출력
		for(int i=1; i<10; i++) {
			System.out.println(Thread.currentThread().getName() + ", " + i + ", " + new Date());
							 //Thread.currentThread() 현재 실행(작업)중인 스레드의 객체의 주소를 반환해줌
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		ThreadEx13 threadEx13 = new ThreadEx13();
		
		Thread first = new Thread(threadEx13); //Thread-0
		Thread second = new Thread(threadEx13); //Thread-1
		
		first.start(); second.start();
		
		//first 보조작업스레드가 일이 끝날때까지(run메소드가 모두 실행될때까지) 기다렸다가
		//first 보조작업스레드가 일이 끝난 후 main 메인스레드 종료되게 하기 위해 호출!
		first.join();
		
		//second 보조작업스레드가 일이 끝날때까지(run메소드가 모두 실행될때까지) 기다렸다가
		//second 보조작업스레드가 일이 끝난 후 main 메인스레드 종료되게 하기 위해 호출!
		second.join();
		
		System.out.println("main스레드 종료됨");

	}

}
