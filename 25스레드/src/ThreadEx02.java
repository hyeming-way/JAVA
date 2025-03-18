
/*
 Thread클래스의 public static void sleep(long milis)메소드
 - 현재 작업중인 스레드객체를? 매개변수 milis로 전달한 시간 동안
   일시적으로 정지시키는 기능의 메소드 
   이메소드를 호출하면 스레드를 일시적으로 정지시켜
   다른 보조스레드객체에게 실행기회를 양보 하거나,
   일정한 시간간격을 가지고 작업을 수행시킬수 있습니다. 
 - 매개변수 long mlils에는 스레드를 일시 정지할 시간을
   1000분의 1초 단위값(밀리초 단위)로 지정합니다.
 - 예외 : InterruptedException
         sleep()메소드가 실행중에 다른 보조스레드에 의해 
         인터럽트되었을때 위 예외가 발생합니다.	  
*/

//보조작업 스레드 객체를 생성하기 위한 사용자정의 스레드 클래스 만들기
//방법1. Thread 클래스를 상속받아 ThreadDemo라는 이름으로 사용자정의 스레드 클래스 만들기

class ThreadDemo extends Thread {
	
	//숫자를 카운팅해서 저장할 변수 선언
	int count;
	
	//보조작업스레드의 객체생성시 
	//스레드 이름을 매개변수로 받아 초기화할 생성자 선언
	//단! 생성자 내부에서 run 메소드가 실행되게 start()메소드 호출
	public ThreadDemo(String name) {
		super(name);
		this.start();
	}
 
	//보조작업스레드클래스의 객체가 할일을 구현
	@Override
	public void run() {
		//현재 작업중인 보조작업스레드 객체의 이름을 얻고 "시작" 문자열과 연결해서 출력
		System.out.println(this.getName() + "시작");// getName() <--- Thread 클래스 내부의 이름을 반환
		
		//0 ~ 9까지 1씩 증가시키면서 1초 간격으로 숫자를 반복해서 출력하는 작업
		do {			
			try {
				//현재 작업중인 보조작업스레드 객체에게 1초간 휴식
				//-> 현재 작업중인 보조작업 스레드객체 1초간 휴식줘서 다른 보조작업스레드 객체에게 작업기회 양보
				Thread.sleep(1000); //1초간 휴식
				
				//현재 보조작업스레드객체가 run 메소드를 실행하고 있으며, 보조작업스레드 객체 이름도 같이 출력
				System.out.println(this.getName() + ", 카운터 = " + this.count);
				
				count++; //1증가 카운팅				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 		
		} while (count < 10);
		
		//현재 작업중인 보조작업스레드 객체의 이름을 얻고 "작업 끝" 문자열과 연결해서 출력
		System.out.println(this.getName() + "작업 끝");
		
	} //run()
	
} //class ThreadDemo

public class ThreadEx02 {
	
	//주스레드
	//하는일 : 보조작업스레드 객체 생성하는일,
	//		  0.5초 간격으로 . 을 10번 반복해서 출력하는 일
	public static void main(String[] args) throws InterruptedException{
		System.out.println("주 스레드 일 시작");
		
		//보조작업스레드 객체 생성
		new ThreadDemo("보조작업스래드객체1");
		
		//0.5초 간격으로 .을 10번 반복해서 출력하는 일
		int count = 0;
		
		do {
			//주스레드 0.5초 휴식
			Thread.sleep(500);
			System.out.print(".");
			count++;
		} while (count<10);

		System.out.println("주 스레드 일 끝");

	}
	
	/*
	결론 :  주스레드와 보조작업스레드가 각각 실행중일때  0.5초 또는 1초 휴식 하면서 
			서로 번갈아가면서 스레드(하나의작업)을 합니다.
			주스레드는 0.5초 휴식이니 더빨리 일이 마무리되고, 
			보조작업스레드는 1초 휴식이니 더늦게 일처리를 합니다.
	*/

}
