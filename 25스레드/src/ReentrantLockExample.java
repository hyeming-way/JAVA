
import java.util.concurrent.locks.ReentrantLock;

/*
참고.

ReentrantLock은 java.util.concurrent.locks 패키지에 속하는 클래스로, 
동기화를 제어하는 데 사용됩니다. 
기본적인 synchronized와 비슷하지만, ReentrantLock은 더 유연하고 강력한 기능을 제공합니다.

1. ReentrantLock이란?
	- ReentrantLock은 **재진입 가능 잠금(Reentrant Lock)**을 제공하는 락 객체입니다. 
	  "재진입"이란, 이미 락을 획득한 스레드가 동일한 락을 다시 획득할 수 있는 기능을 의미해요. 
	  예를 들어, 같은 스레드가 이미 락을 획득한 상태에서 다시 lock()을 호출할 수 있다는 뜻입니다.

      이와 같은 특징은 synchronized와 다르게, 같은 스레드가 락을 여러 번 획득할 수 있는 점에서 차이를 보입니다.

2. 기본 사용법
   - 락 (잠금)획득: lock.lock() 메서드를 사용해 락을 획득합니다. 락을 획득하면 다른 스레드는 이 락을 획득할 수 없게 됩니다.
   - 락 (잠금)해제: lock.unlock() 메서드를 사용해 락을 해제합니다. 락을 해제하면 다른 스레드가 락을 획득할 수 있게 됩니다.
   - try-finally 구조: 락을 획득하고 나서, 예외가 발생하더라도 락을 해제하도록 finally 블록을 사용하는 것이 중요합니다. 
                      이를 통해 락이 항상 해제되어 데드락(Deadlock) 상황을 예방할 수 있습니다.
  
*/


//공유 클래스
class SharedResource3 {
	private int count = 0;
	
	//ReentrantLock 객체를 생성하여 동기화 제어
	//여러 스레드가 동일한 자원에 접근할 때 충돌을 방지하기 위해 사용.
	private final ReentrantLock lock = new ReentrantLock();
	
	//count 값을 증가시키는 메소드
	public void increment() {
		lock.lock(); //락을 획득(문을 잠금) 다른 스레드가 이 메소드를 실행하지 못하도록 막음
					 //이 지점에서 락을 획득한 스레드만 count 값을 수정할 수 있게 됨
					 //다른 스레드는 lock.unlock()호출되어 락이 해제될 때까지 대기 하게됨
		try {
			count++; //동기화된 상태에서만 안전하게 접근가능
					 //여러 스레드가 동시에 count 값을 수정하는 것을 방지함
			
			//현재 락을 걸고 작업중인 스레드 이름과 count 값을 출력하여 어떤 보조작업스레드가 작업했는지 추적
			System.out.println(Thread.currentThread().getName() + " - count : " + count);
		} finally {
			lock.unlock();
			//락을 해제. 반드시 해제해야 다른 스레드가 이 메서드를 실행할 수 있음.
			//'finally'블록에서 락을 해제함으로써 예외가 발생하더라도 락이 반드시 해제되도록 보장
			//락을 해제하지않으면, 다른 스레드가 이 메서드에 접근하지 못하고 데드락이 발생할 수 있음.
		}
	}
}


//Runnable 인터페이스를 구현한 클래스를 정의하여 스레드 작업을 처리한다
class CounterRunnable3 implements Runnable {
	private SharedResource3 resource;
	
	public CounterRunnable3(SharedResource3 resource) {
		this.resource = resource;
	}
	
	@Override
	public void run() {
		//5번 반복해서 공유ShareResource 객체메모리 내부의 increment()메소드 호출
		for(int i=0; i<5; i++) {
			resource.increment(); //increment 메소드를 호출하여 count 변수값 계속 1증가
		}
	}
}


public class ReentrantLockExample {
	public static void main(String[] args) {
		
		//공유 자원 객체를 생성 (모든 스레드가 이 객체를 공유)
		SharedResource3 resource = new SharedResource3();
		
		Thread t1 = new Thread(new CounterRunnable3(resource));
		Thread t2 = new Thread(new CounterRunnable3(resource));
		
		t1.start(); t2.start();
		
		/*
			출력결과
			Thread-0 - count : 1
			Thread-0 - count : 2
			Thread-0 - count : 3
			Thread-0 - count : 4
			Thread-0 - count : 5
			Thread-1 - count : 6
			Thread-1 - count : 7
			Thread-1 - count : 8
			Thread-1 - count : 9
			Thread-1 - count : 10
		*/
			
	}

}
