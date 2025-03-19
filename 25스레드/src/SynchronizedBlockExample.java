
//공유 자원 클래스 정의
class ShareResource2 {
	private int count = 0; //공유데이터 (모든 스레드가 접근 가능)
	
	private final Object lock = new Object(); //동기화를 위한 락 객체
	
	public void increment() {
		
		synchronized (lock) { //특정 코드 블록만 동기화
			count++;
			System.out.println(Thread.currentThread().getName() + "- count: " + count);
			//System.out.println(lock.toString());
		}

	}
}


//Runnable 인터페이스를 구현한 클래스를 정의하여 스레드 작업을 처리한다
class CounterRunnable2 implements Runnable {
	private ShareResource2 resource;
	
	public CounterRunnable2(ShareResource2 resource) {
		this.resource = resource;
	}
	
	@Override
	public void run() {
		//5번 반복해서 공유ShareResource 객체메모리 내부의 increment()메소드 호출
		for(int i=0; i<5; i++) {
			resource.increment();
		}
	}
}


//실행클래스 (메인스레드 포함하고 있는 클래스)
public class SynchronizedBlockExample {
	public static void main(String[] args) {
		
		//공유 자원 객체를 생성 (모든 스레드가 이 객체를 공유)
		ShareResource2 resource = new ShareResource2();
		
		Thread t1 = new Thread(new CounterRunnable2(resource));
		Thread t2 = new Thread(new CounterRunnable2(resource));
		
		t1.start(); t2.start();
			
	}

}
