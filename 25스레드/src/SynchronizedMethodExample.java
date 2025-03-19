
//공유 자원 클래스 정의
class ShareResource {
	private int count = 0; //공유데이터 (모든 스레드가 접근 가능)
	public synchronized void increment() {
	//synchronized 키워드를 사용하여
	//한 번에 하나의 스레드만 increment() 메서드를 실행할 수 있도록 제한한다.
		count++;
		System.out.println(Thread.currentThread().getName() + "- count: " + count);
	}
}


//Runnable 인터페이스를 구현한 클래스를 정의하여 스레드 작업을 처리한다
class CounterRunnable implements Runnable {
	private ShareResource resource;
	
	public CounterRunnable(ShareResource resource) {
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
public class SynchronizedMethodExample {
	public static void main(String[] args) {
		
		//공유 자원 객체를 생성 (모든 스레드가 이 객체를 공유)
		ShareResource resource = new ShareResource();
		
		Thread t1 = new Thread(new CounterRunnable(resource));
		Thread t2 = new Thread(new CounterRunnable(resource));
		
		t1.start(); t2.start();
		
		/*		
			Thread-0- count: 1
			Thread-0- count: 2
			Thread-0- count: 3
			Thread-0- count: 4
			Thread-0- count: 5
			Thread-1- count: 6
			Thread-1- count: 7
			Thread-1- count: 8
			Thread-1- count: 9
			Thread-1- count: 10
		*/
	
	}

}
