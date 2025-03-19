
/*
	Thread클래스의 isAlive()메소드
	- 해당 스레드가 현재 실행중인지 여부를 확인하는데 사용되는 메소드
	- 이메소를 호출하면 스레드의 실행상태를 확인할수 있으며 실행중이면 true반환
	  종료된 상태면 false반환
	  
	isAlive()메소드의 동작
		1. 실행중인 스레드  : 스레드가 start()메소드를 호출하여 시작한 후 run()메소드가 종료되기 전까지
		  				  스레드는 실행중인 상태입니다.
		2. 종료된 스레드 : 스레드의 run()메소드가 종료되면 스레드는 더이상 실행할수 없다.
		  				 이때  isAlive()메소드를 호출하면 false를 반환합니다.

		주의할점은 isAlive()메소드를 호출한 순간과 
		실제 스레드의 실행상태가 일치하지 않을수 있다는 점입니다
		스레드의 실행상태는 실제 스레드 스케줄러(JVM내부에 존재하는 우선순위를 설정하는 프로그램)에 의해 결정되며
		호출시점에 따라서 isAlive()메소드의 반환값이 바뀔수 있다.
*/

//보조작업 스레드 객체를 생성할 사용자 정의 스레드 클래스
class ThreadDemo6 extends Thread {
	
	int count;
	
	public ThreadDemo6(String name) {
		super(name);
		this.start(); //보조작업스레드 객체 일 시작
	}
	
	@Override
	public void run() {
		System.out.println(this.getName() + " 시작.........");
		
		//0.5초 간격으로 휴식하면서 현재 실행중인 보조작업스레드객체의 이름과 1씩 증가된 count 변수에 저장된 값 반복해 출력
		try {
			do {
				Thread.sleep(500);
				System.out.println(this.getName() + ", count is " + this.count);
				count++;
			} while (count<10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(this.getName() + " 종료.........");
	}
	
}

public class ThreadEx12 {
	public static void main(String[] args) {
		
		System.out.println("메인 스레드 일 시작");
		
		ThreadDemo6 t1 = new ThreadDemo6("보조작업스레드1");
		ThreadDemo6 t2 = new ThreadDemo6("보조작업스레드2");
		ThreadDemo6 t3 = new ThreadDemo6("보조작업스레드3");
		
		//메인스레드에게 . 을 반복해서 출력 작업
		try {
			do {
				System.out.print(".");
				Thread.sleep(100); //0.1초 휴식
			//보조작업스레드 객체들의 종료 시점을 메인스레드로 유도해서 .을 출력되게 하기
			//조건 -> 모든 보조작업스레드 객체들이 현재 실행 중인 상태일 동안만
			//		 메인스레드에서 . 반복해서 출력할 수 있도록 아래의 조건식 작성
			} while (t1.isAlive() || t2.isAlive() || t3.isAlive());
			//while (t1.count<10  || t2.count<10  || t3.count<10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		System.out.println("메인 스레드 일 끝");

		//결론 : isAlive()메소드는 현재 실행하고 있는 스레드의 생존여부를 통해서
		//		특정 메인스레드의 종료시점을 결정할 수 있다.
	}

}
