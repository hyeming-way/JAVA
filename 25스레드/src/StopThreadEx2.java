
/*
	Thread.currentThread()메소드
	  - 현재 실행(작업)중인 스레드 객체주소를 반환
	  
	Thread.isInterrupted() 메소드
	  - 현재 보조작업스레드 일을 중지해라! 라는 명령을 했는지에 대한 검사하는 메소드
	  - 참고! 현재 보조작업스레드객체의 일을 중지해라! 라는 명령어는?
	  	interrupt() 메소드를 호출한 것과 같다.	

*/

//주제 : Thread 클래스에서 제공하는 interrupt()메소드를 이용하여
//		현재 작업중인(run()메소드가 실행되는 중인) 보조작업 스레드 강제로 대기시키기

//보조작업스레드 객체를 생성하기위해 run 추상메소드(Runnable 인터페이스)를 강제로 메소드 오버라이딩시킨 일반클래스 설계
class StopThreadDemo2 implements Runnable {
	
	@Override
	public void run() {
		
		try {
			//현재 보조작업스레드객체를 중지(대기)해라~ 명령(interrupt();)
			//내리지 않았으면 계속 반복해서 출력 작업
			while(!Thread.currentThread().isInterrupted()) {
				System.out.println("현재 보조작업스레드객체는 작업중이다.....");
				//현재 실행상태인? 보조작업스레드 객체 0.5초 (시간의 대기)
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("interrupt()메소드를 호출하여 보조작업스레드객체 강제 중지(대기)시킴");
		} finally {
			//while 반복문의 실행이 끝나면 무조건 한번 출력되는 구문
			System.out.println("보조작업스레드 객체 현재 중지(대기)시킴..........");
		}
		
	}
	
}

public class StopThreadEx2 {
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("--interrupt()메소드를 이용한 보조작업스레드객체 강제로 중지(대기) 시작");
		
		Thread thread = new Thread(new StopThreadDemo2());
		//보조작업스레드객체 일시키기위해 대기방에 준비시키기
		thread.start();
		
		//주스레드 1초 휴식(대기)
		Thread.sleep(1000);
		
		//현재 작업하고 있는(run메소드를 실행하고 일시정지중인)보조작업스레드객체 강제로 중지(대기)
		thread.interrupt();
		
		/*

		스레드의 상태 !!!!!!!!!!!!!!!!!!!!!!!!!!
	                                                         
	------------------         ------------------         ----------------         -----------------
	스레드 객체 생성      start()      실행대기             run()
	 new Thread();     ------>  RUNNABLE상태          ---->     실행상태       ----->    스레드 종료상태
	------------------         ------------------         -----------------        ---------------
	
														interrupt()메소드 호출
									     		   ------------------- 
				
				                                       일시 정지 상태 
								                   ------------------- 
		
 */

	}

}
