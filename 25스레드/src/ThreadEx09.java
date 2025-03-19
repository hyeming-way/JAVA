
/*
	스레드는 크게 2가지 종류로 나뉜다.
	1. 일반스레드(독립스레드 : main스레드 및 다른 보조작업스레드들) : 
	   직접 개발자에 의해서 제어가 되는 스레드
	
	2. 데몬 스레드 (일반스레드에 의해서 실행되는 종속스레드)
	  : 일반스레드의 작업을 돕는 보조적인 역할을 하는 스레드 
	  
	  데몬스레드?
	  - 다른 일반스레드의 작업을 돕는 보조적인 일을 수행하는 스레드
	  - 일반스레드가 모두 종료되면 데몬스레드는 강제로 따라 종료 됩니다.
	  - 일반스레드를 생성한다음 실행전 setDemon(true); 를 호출하면 일반스레드를 데몬스레드화 해서 만들수 있다
	  
	  
시나리오
	  어떤 두개의 스레드가 있다고 할떄.....
	  하나의 스레드(메인스레드)가 종료될떄...
	  나머지 일반스레드를 데몬스레드로 만들어 자동종료되게 하기
*/

//데몬 스레드를 만들 일반클래스
//(Runnable 인터페이스의 run 메소드를 오버라이딩해서 작성해놓은 클래스)만들기
class T implements Runnable {
	
	//작업파일을 자동 저장할지 말지 여부값 (true 또는 false)를 저장할 플래그 변수
	static boolean autoSave = false;
	
	//작업파일을 자동저장하는 기능을 표시하는 일	
	@Override
	public void run() {
		//3초 휴식 후 작업파일 저장되었다고 메세지 반복해서 출력
		while(true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//autoSave 변수에 저장되어있는 값이 true일때만 
			if(autoSave) {
				autoSave(); //메소드를 호출하여 작업파일이 자동으로 저장되었다는 메세지 출력
			}
			
		} //while
		
	} //run()
	
	public void autoSave() {
		System.out.println("작업파일이 자동으로 저장되었습니다.");
	}
	
} //class T


public class ThreadEx09 {
	public static void main(String[] args) throws InterruptedException {
		
		//보조작업스레드 객체 생성
		Thread thread = new Thread(new T());
		
		//보조작업스레드(일반스레드)를 데몬스레드로 변경
		thread.setDaemon(true);
		
		//데몬스레드 시작
		thread.start();
		
		//주스레드에서 숫자를 반복해서 출력하는 작업
		for(int i=0; i<=20; i++) {
			//현재 실행되고 있는 주스레드 1초 휴식 후 i 변수값 출력
			Thread.sleep(1000);
			System.out.println(i);
			
			//i 변수값이 5가 되는 순간 static autoSave변수의 값을 true로 변경해서 저장
			if(i == 5) {T.autoSave = true;}
		}
		
		System.out.println("프로그램 종료합니다.");

	}

}
