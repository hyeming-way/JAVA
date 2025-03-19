
//Semaphore는 동시 접근을 제어하기 위한 클래스로,
//여러 스레드가 동시에 공유 자원에 접근할 수 있는 최대 개수를 제한하는데 사용됩니다.
import java.util.concurrent.Semaphore;

//공유 자원 클래스
class SharedResource4 {
	
	private final Semaphore semaphore = new Semaphore(2);
	//Semaphore 객체를 생성하면서 최대 2개의 스레드만 자원에 접근할 수 있도록 설정합니다.
	//즉, 동시에 자원에 접근할 수 있는 스레드는 2개로 제한됩니다.
	//자원이 더 필요하면 다른 스레드는 대기합니다.
	
	//자원에 접근하는 메서드
	public void accessResource() {		
		try {
			
		    //acquire(): 카운터를 1 감소시키고, 카운터가 0이면 자원을 사용할 수 있을 때까지 대기합니다.
		    //           스레드가 자원을 사용하고자 할 때 호출합니다.
			semaphore.acquire();
			//스레드는 acquire() 메서드를 호출하여 세마포어에서 자원에 대한 접근 허가를 요청합니다.
			//만약 이미 2개의 스레드가 자원을 사용중이라면,
			//이 호출은 대기 상태가 되어 다른 스레드가 자원을 반환할때까지 기다립니다.
			
			//자원에 접근한 현재 스레드의 이름을 출력합니다.
			System.out.println(Thread.currentThread().getName() + " 자원 사용 중.........");
			
			Thread.sleep(1000);			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			//자원 사용이 끝났으므로 release() 호출하여
			//세미포어 객체에서 자원에 대한 접근 권한을 반환합니다.
			//이 메소드를 호출하면 대기 중인 다른 스레드가 자원을 사용할 수 있게 됩니다.
			semaphore.release();
			//release(): 카운터를 1 증가시킵니다. 
			//			 자원 사용이 끝나면 호출하여, 
			//	         다른 대기 중인 스레드가 자원을 사용할 수 있게 합니다.
		}	
	}
}


public class SemaphoreExample {
	public static void main(String[] args) {
		
		SharedResource4 resource4 = new SharedResource4();
		
		//5개의 보조작업스레드를 생성하여 공유자원에 접근
		for(int i=0; i<5; i++) {
			//내부 익명 구현 객체
			new Thread(new Runnable() {
				@Override
				public void run() {
					//각 보조작업 스레드는 SharedResource4 공유자원 객체의 accessResource()메소드를 실행
					//accessResource()메소드에서 세미포어 객체메모리를 통해 자원에 접근하고 사용
					resource4.accessResource();
				}
			}).start();
		}
	}
}
