
/*
	Thread스레드객체들 간의 데이터 교환 예제
	
	  1. 특정 파이값(3.141592)을 계산하는 보조작업 스레드 
	  
	  2. 계산한 파이값을 가져다가 사용하는 보조작업 스레드
	  
	  3. 각 보조작업 스레드들간의 파이값을 공유할 코드가 적혀있는 일반 클래스 

	  4. 메인스레드 
*/

//3. 각 보조작업 스레드들간의 파이값을 공유할 코드가 적혀있는 일반 클래스 
class SharedArea { //<-----공유영역
	//두 개의 보조작업스레드 객체가 데이터 교환을 위해 공동으로 사용할 공용 인스턴스 변수
	double result;
	//현재 공유시킬 산출된 파이값이 공유영역(SharedArea의 result변수)에 저장되어 있는지 여부값을 저장하는 
	//플래그 변수 -> 저장되어있으면? true 저장, 저장되어있지않으면? false 저장
	boolean isReady; //기본값 false
}

//1. 특정 파이값(3.141592)을 계산하는 보조작업 스레드객체 생성시 사용할 스레드클래스
class PiCalc extends Thread {
	
	//공유영역 SharedArea객체의 result변수에 저장된 데이터를 가져다가 사용하기위해
	//new SharedArea()객체의 주소를 저장할 참조변수 선언
	SharedArea sa; //인스턴스변수이자 참조변수
		
	//파이값 산출 작업
	@Override
	public void run() {
		//파이값을 계산하여 산출한 값 저장
		double pi = 3.141592;
		
		//산출한 파이값을 공유객체 메모리인 new SharedArea()객체 내부의 result 인스턴스변수에 저장
		sa.result = pi;
		
		//산출한 파이값을 공유객체 메모리인 new SharedArea()객체 내부의 
		//result 인스턴스변수에 저장했으므로
		//isReady인스턴스변수값을 true로 변경하여 저장
		sa.isReady = true;
	}
}

//2. 계산해서 공유한 파이값을 가져다가 사용하는 보조작업 스레드객체를 생성하기 위한 스레드 클래스 설계
class PiPrint extends Thread {
	//공유영역 SharedArea객체의 result 변수에 저장된 데이터를 가져다가 사용하기위해
	//new SharedArea()객체의 주소를 저장할 참조변수 선언
	SharedArea sa;
	
	//공유영역 SharedArea객체메모리 내부에 만들어져있는 result 변수의 값을 가져다가 사용하는 작업
	@Override
	public void run() {
		//공유영역에 파이값이 저장되어있지않으면? 파이값 가져다 사용하는 작업 중지시키기
		while(sa.isReady != true) {
			continue; //다시 while 조건식으로 가시 조건검사
		}
		//공유영역(SharedArea객체의 인스턴스변수 result)에 파이값이 저장되어 있으면
		//공유받아서 출력
		System.out.println("PiPrint보조스레드가 파이값 공유받아 사용한 값 : " + sa.result);
	}
	
}

public class ThreadEx14 {
	public static void main(String[] args) {

		PiCalc piCalc = new PiCalc(); //파이값 산출하고 공유하는 보조작업스레드 객체
		PiPrint piPrint = new PiPrint(); //파이값 공유받아 사용하는 보조작업스레드 객체
		
		SharedArea sharedArea = new SharedArea(); //공유영역 객체메모리 생성
		
		//파이값 산출 보조작업스레드 객체 내부의 인스턴스변수 sa에 공유영역객체의 주소 저장
		piCalc.sa = sharedArea;
		
		//산출된 파이값을 공유받아 사용(출력)할 보조작업스레드 객체 내부의 인스턴스변수 sa에
		//공유영역객체의 주소를 저장
		piPrint.sa = sharedArea;
		
		piCalc.start(); piPrint.start();
		
		
		//PiPrint보조스레드가 파이값 공유받아 사용한 값 : 3.141592

	}

}
