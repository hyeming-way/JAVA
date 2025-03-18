
//주제 : start(), run() 메소드 사용 예제
/*
	예제스토리
	
	어떤 값을 입력하여 엔터키를 누르면...
	결과가 오랜시간 뒤에 출력되어 나온다고 가정할 때...
	결과가 나오기 전에 약간의 효과를 줘서(잠시만 기다려주세요...)라는 메세지를 스레드를 이용하여 처리하자
	
	예)
		숫자 입력 :
		잠시만 기다려주세요... <-- 스레드를 이용하여 처리
		결과 : 
		
*/

import java.util.Scanner;

//보조작업스레드 객체를 생성하기 위한 Runnable 인터페이스를 구현한 일반 클래스 정의
class TestThread implements Runnable { //<---- 일반클래스
@Override
	public void run() {
		System.out.println("\n\n잠시만 기다려주세요...\n\n");		
	}
}

public class ThreadEx05 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("숫자입력 : ");
		
		//키보드로부터 입력받은 숫자를 바이트 단위의 크기로 읽어들이기 위한 입력스트림 통로 준비
		//Scanner 클래스 : System.in을 통해 읽어들인 바이트 데이터들을 쉽게 
		//				  기본자료형으로 형변환하는 nextXX메소드를 제공하는 클래스
		Scanner scanner = new Scanner(System.in); //<--- 형변환 해주는 기능을 제공
		
		//키보드로부터 입력받은 숫자는 System.in(BufferedInputStream)입력스트림 통로로 부터
		//바이트 단위로 읽어들이기 때문에 읽어들인 바이트 데이터들을
		//long 데이터로 변환해서 얻어오기 위해 Scanner 객체의 nextLong()메소드 호출하면 반환받습니다.
		long num = scanner.nextLong(); //입력한 숫자가 저장되어 있음
		
		//보조작업 스레드 객체 생성
		//순서1. run 메소드를 강제로 오버라이딩 해 놓은 TestThread 일반 클래스의 객체 생성
		//순서2. 생성된 TestThread 객체의 주소번지를 Thread 클래스의 생성자로 전달해 저장시킨
		//		실제 보조작업스레드 객체 생성
		Thread thread = new Thread(new TestThread());
		
		//실제 보조작업스레드 객체에 일 시키기위해 대기 상태로 만들기
		thread.start(); //run 콜백메소드가 JVM에 의해서 자동으로 호출
		
		//----------------------------------------------------------------------
		
		//주스레드 작업
		//-> 0부터 입력받은 숫자까지의 합을 누적해서 출력
		long total = 0;
		
		thread.sleep(1000);
		
		for(int i=0; i<=num; i++) {
			total += i; //0부터 1씩 증가하면서 total에 입력받은 숫자까지 반복해서 누적
		}
		
		System.out.println("총 합의 결과 : " + total);
	
	}

}
