

//보조작업 스레드 객체를 생성하기위한 사용자정의 스레드 클래스 만들기
//방법2. Runnable 인터페이스를 구현받아 run 추상메소드를 가진 일반클래스로 만들자

//보조작업스레드 객체가 할일을 구현해놓은 run 메소드를 가지고 있는 일반 클래스 만들기
class ThreadDemo1_1 implements Runnable {
	
	//실제 작업할 보조작업스레드 객체를 생성해서 저장할 참조변수 선언
	Thread thread;
	
	//보조작업 스레드 객체의 이름을 초기화할 생성자
	public ThreadDemo1_1(String name) {
		//실제 보조작업스레드 객체를 생성하는 동시에 run()메소드 실행을 위해 start()메소드 호출
		thread = new Thread(this, name);
		thread.start();
	}
	
	//보조작업스레드 객체가 할 작업을 run 메소드에 구현해놓자
	@Override
	public void run() {
		int sum = 0;
		
		for(int i=0; i<5; i++) {
			try {
				//현재 실행중(작업중)인 보조작업스레드 객체 1초간 휴식
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			sum += i;
			
			//보조작업스레드 작업하고 있는 정보 출력
			System.out.println(thread.getName() + ":" + sum);
			//참고. thread.getName() 대신 아래 코드 적용 가능
			//  - 현재 작업중인 보조작업스레드 객체의 정보 얻기 : Thread.currentThread();
			//  - 현재 작업중인 보조작업스레드 객체의 이름 얻기 : Thread.currentThread().getName();
		}
		
	}

}

public class ThreadEx03_1 {
	
	//주(메인) 스레드 <-- 무조건 하나만 존재
	public static void main(String[] args) {
		//보조작업 스레드 객체를 생성하기위해
		//Runnable 부모인터페이스의 run 추상메소드를 강제로 오버라이딩 시켜놓은
		//ThreadDemo1_1 일반클래스의 객체메모리 생성시 생성자로 보조작업스레드 객체의 이름 전달
		new ThreadDemo1_1("첫번째 보조작업 스레드이름");
		new ThreadDemo1_1("두번째 보조작업 스레드이름");

	}

}
