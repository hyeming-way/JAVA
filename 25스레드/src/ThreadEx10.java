
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//보조작업스레드 객체를 생성하기위한 클래스
//하는 일 : 현재 실행중인 스레드 5초 휴식주는 일
class ThreadDemo4 extends Thread {
	
	//보조작업스레드 객체의 이름을 생성자의 매개변수로 받아 초기화할 생성자
	public ThreadDemo4(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		try {
			this.sleep(5*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

//현재 실행되고 있는 모든 스레드에 대한 정보를 화면에 출력하는 일을 하는
//보조작업스레드객체를 생성하기위한 클래스
class ThreadDemo5 extends Thread {
	
	//보조작업스레드객체의 이름을 저장할 생성자
	public ThreadDemo5(String name) {
		super(name);
	}
	
	//현재 실행되고있는 Stack 메모리영역에 올라가 있는 모든 스레드에 대한 정보를 화면에 출력하는 일
	@Override
	public void run() {
	
		/*		
		Thread클래스의 static메소드인 getAllStackTraces()메소드 ??
		- 프로세스 내부에서 실행하는 모든 스레드에 대한 정보를 얻을수 있습니다.
		- 이메소드는 Map부모인터페이스타입의 자식객체를 반환하는데...
		  key자리에는 스레드객체이고, value는  스레드의 상태 기록들을 갖고 있는 StackTraceElement[] 배열입니다.
		 */		
		//스택 메모리안의 현재 실행중인 모든 Thread객체(key)들과
		//그 모든 Thread객체(key)와 같이 저장된 Thread객체의 상태기록들이 저장된
		//자식 HashMap<Thread, StackTraceElement[]> 객체를 반환합니다.
		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
		
		//위 HashMap배열에 저장된 Thread객체(key)들만
		//HashSet배열에 담아 HashSet배열메모리 주소 자체를 반환
		Set<Thread> set = map.keySet();
		
		//HashSet배열에 저장된 Thread 객체(key)들 모두 꺼내어
		//Iterator 배열에 담아서 Iterator 배열메모리 주소 자체를 반환
		Iterator<Thread> iterator = set.iterator();
		
		//JVM의 Stack메모리 영역 안에 존재하는 모든 Thread 객체들에 순번을 설정하기 위한 변수
		int x = 0;
		
		//Iterator 배열에 현재 실행중인 Thread객체(key)들이 저장되어 있으면 반복해서 작업
		while(iterator.hasNext()) {
			
			//현재 실행중인 Thread객체(key)를 하나씩 얻기
			Thread thread = iterator.next();
			
			//현재 실행중인 스레드객체(key)를 이용해 스레드객체(key)와 같이 저장되었던
			//상태기록정보들이 저장된 StackTraceElement[]배열을 하나씩 얻기
			//위 HashMap에서 얻기
			StackTraceElement[] ste =  map.get(thread);
			
			System.out.println(
					
					//(++x) : 스택안에 있는 현재 실행되고 있는 스레드객체의 출력순서
					//thread.getName() : 스택안에 있는 현재 실행되고 있는 스레드객체의 이름 반환
					//thread.getThreadGroup().getName()
					//:현재 실행되고 있는 스레드객체가 속한 스레드그룹객체의 이름 반환
					//thread.isDaemon() : 현재 실행중인 스레드객체가 데몬스레드면 true 반환
					//					  일반 스레드이면 fasle를 반환
					"[" + (++x) + "] name : " + thread.getName() +
					", group : " + thread.getThreadGroup().getName() + 
					", demon : " + thread.isDaemon()
							  );
			
			//현재 실행되고있는 Thread 객체의 상태기록 정보를
			//StackTraceElement[] 배열에서 반복해서 꺼내와 출력
			for(int i=0; i<ste.length; i++) {
				System.out.println(ste[i]);
				
			}
			
			System.out.println();
			
		}//while	
		
	}
	
}

public class ThreadEx10 {
	public static void main(String[] args) {
		
		new ThreadDemo4("첫번째 보조작업스레드").start();
		new ThreadDemo5("두번째 보조작업스레드").start();

	}
	/*

		객체를 참조하기 위한 핸들러 역할을 하는 데몬스레드 
		[1] name : Reference Handler, group : system, demon : true
	
		자바 GUI(SWING)프로그램에서 이벤트 동작을 실행하기 위한 데몬스레드 
		[2] name : Attach Listener, group : system, demon : true
	
		[3] name : Notification Thread, group : system, demon : true
	
		보조작업스레드 ThreadDemo5 현재 실행중인 스레드 객체의 정보 출력
		[4] name : 두번째 보조작업스레드, group : main, demon : false
	
		현재 사용되고 있지 않은 객체메모리를 JVM의 heap영역에서 자동제거하는 데몬스레드 
		[5] name : Finalizer, group : system, demon : true
	
		[6] name : Signal Dispatcher, group : system, demon : true
	
		보조작업스레드 ThreadDemo4 현재 실행중인 스레드 객체의 정보 출력
		[7] name : 첫번째 보조작업스레드, group : main, demon : false
	
	
		[8] name : Common-Cleaner, group : InnocuousThreadGroup, demon : true

	*/

}
