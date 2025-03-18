

//주제 : 플래그변수(조건을 판단하는 변수)를 이용하여 
//		현재 run메소드가 실행중인 보조작업스레드 객체 강제로 중지시키기


//보조작업스레드 객체를 생성하기 위한 Runnable 인터페이스를 구현한 일반클래스
class StopThreadDemo1 implements Runnable {
	//플래그변수 : 보조작업스레드 객체가 현재 작업을 하고있는지 하고있지않은지 판단할 값
	//			 true 또는 false 저장할 변수
	private boolean stoped = false;
	
	//보조작업스레드객체가 작업할 일
	@Override
	public void run() {
		//플래그변수에 저장되어있는 값이 false일때만 계속 반복해서 일을 함
		while (!stoped) {
			//메세지 출력하는 일
			System.out.println("보조작업스레드객체는 현재 동작하고 있다.");
			//보조작업스레드 객체를 0.5초 대기상태로 만들기(휴식)
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("보조작업스레드객체는 현재 Dead........");
	}
	
	//현재 작업하고 있는 보조작업스레드객체가 중지되었다고 판단할 값을 저장할 기능의 일반 메소드
	public void stop() {
		this.stoped = true;
	}
	
}

public class StopThreadEx01 {
	
	public static void main(String[] args) {
		System.out.println("## 플래그 변수를 이용한 보조작업스레드객체 강제 중지 기능 시작");
		
		new StopThreadEx01().process();

	} //main
	
	//주스레드가 작업을 정의해 놓은 메소드
	//기능 : 보조작업스레드 객체 생성 및 일시키기
	public void process() {
		
		StopThreadDemo1 std1 = new StopThreadDemo1();
		
		Thread thread = new Thread(std1);
		
		thread.start();
		
		//주스레드 1초 휴식
		try {
			thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//StopThreadDemo1일반클래스의 객체 내부에 만들어져 있는
		//stop인스턴스메소드를 호출하여 플래그 변수 값을 false에서 true로 변견
		//즉! 강제로 보조작업스레드 객체 작업 중지 시키기!
		std1.stop();
	
	}
	
} //public class StopThreadEx01
