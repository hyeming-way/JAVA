
//참고.  스레드란? 하나의 작업

//예제. 자바문법에서 제공해 주는 Thread클래스를 상속받아
//     개발자가 직접 ThreadEx01 스레드 역할의 클래스 만들기 

//Thread클래스를 상속받아 스레드역할을 하는 클래스를 만드는 이유
//-> 자바에서 run메소드의 역할은 하나의 작업을 처리하는 코드를 여기에 작성해 놓기 때문에
//   Thread클래스에 run메소드가 만들어져 있으므로 상속받아서 메소드 오버라이딩 해야합니다

//보조스레드 <----- 개발자가 직접 클래스로 설계
//  - 0 ~ 4까지 5번 반복하면서 sum 변수에 차례로 누적해서 sum 변수에 저장된 값 출력하는 하나의 작업

//Thread 클래스를 상속받아 ThreadEx01 클래스 만들기. <---- 스레드 역할을 하는 클래스 설계 방법1
public class ThreadEx01 extends Thread {
	
	String name;//스레드 이름 저장
	
	//스레드 이름을 초기화할 생성자
	public ThreadEx01(String name) {
		this.name = name;
	}
	
	//보조작업스레드(ThreadEx01객체)가 할 작업을 구현해야하는 콜백 메소드 run 오버라이딩
	//오버라이딩 단축키 : alt + shift + s   v
	//콜백메소드? 개발자가 호출해주는 것이 아니라 거꾸로 시스템이 자동으로 호출해주는 메소드
	@Override
	public void run() {
		int sum = 0;
		for(int i=0; i<5; i++) {
			//숫자 0 ~ 4까지 sum 변수에 누적해서 출력
			sum += i;
			System.out.println(this.name + ":" + sum);
		}	
	}

	//주(메인)스레드 : 주요 작업을 처리하는 주스레드 역할을 하는 main 메소드
	public static void main(String[] args) {
		
		//보조작업 스레드(ThreadEx01)의 객체를 생성해서
		//보조작업 스레드 객체를 만들어줍니다.
		ThreadEx01 t1 = new ThreadEx01("첫번째 스레드"); //보조작업스레드객체1
		
		ThreadEx01 t2 = new ThreadEx01("두번째 스레드"); //보조작업스레드객체2
		
		//참고. 총 스레드 3개입니다. -> main(주스레드), 첫번째스레드, 두번째스레드
		/*
		  Thread클래스는 start()메소드를 제공해 줍니다.
		  start()메소드는 직접 run()메소드를 호출하게 하는 메소드는 아니며
		  자바 JVM가상머신에게 보조스레드객체가 각각 준비가 되었으니
		  자바 JVM가상머신에게 run()메소드를 호출하라고 부탁하는 메소드입니다.
		  요약 : run()메소드를 호출해서 스레드 작업을 할수 있게 보조스레드객체를 준비 시킨다 
		 */
		t1.start();
		t2.start();
		//작업순서는 랜덤임
		
		System.out.println("main스레드 일 끝남");
		
	}

}
