

//주제 : SingleThreadEx1.java 파일에서 메인스레드에서 한 작업 2개 분리하기


//보조작업스레드 객체를 생성하기 위한 사용자정의 스레드 클래스 만들기
class MultiThreadDemo1 extends Thread { //<--- 10번 반복 # 출력

	@Override
	public void run() {
		//10번 반복하여 1초 간격으로 #을 하나씩 출력하는 작업
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("#");
		}
		//메인스레드 작업2를 하는데 소요된 시간 구하기 : 
		//(#을 10번 출력한 후 의 현재시간 - * 10번 출력하기전 작업1시간)/1000
		System.out.println("보조스레드 작업2의 소요된 시간 : " + (System.currentTimeMillis() - MultiThreadEx1.startTime)/1000 + "초");
		
	}

}

public class MultiThreadEx1 {

	static long startTime = 0;
	
	//주(메인)스레드 -> 10번 반복해서 1초간격으로 * 출력
	public static void main(String[] args) {
		//보조작업스레드 객체 생성 후 일 시키기
		new MultiThreadDemo1().start();
		
		//주(메인)스레드가 작업을 할 때 걸린 시간을 측정하기위해 일단 시작한 시간 저장
		startTime = System.currentTimeMillis();
		
		//주(메인)스레드 작업1
		//10번 반복해서 1초 간격으로 *을 하나씩 출력
		for(int i=0; i<10; i++) {
			try {
				//1초 휴식
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//* 출력
			System.out.print("*");
		}
				
		//메인스레드 작업1을 하는데 소요된 시간 구하기 : 
		//(*을 10번 출력한 후 의 현재시간 - * 10번 출력하기전 작업1시간)/1000
		System.out.println("주(메인)스레드 작업1의 소요된 시간 : " + (System.currentTimeMillis() - startTime)/1000 + "초");

	}

}
