


//보조작업스레드 객체를 생성하기 위한 설계도(클래스)1
class A4 extends Thread {
	@Override
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.println("A4보조작업스레드 객체 i변수값 출력 : " + i);
		}
	}
}

//보조작업스레드 객체를 생성하기 위한 설계도(클래스)2
class B4 extends Thread {
	@Override
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.println("B4보조작업스레드 객체 i변수값 출력 : " + i);
		}
	}
}


public class PriorityMain {
	public static void main(String[] args) {
		//보조작업 스레드 객체1, 객체2 생성
		A4 a4 = new A4(); 
		B4 b4 = new B4(); 
		
		a4.setPriority(3); //작업 우선순위 3
	//	a4.setPriority(Thread.NORM_PRIORITY); //작업 우선순위 5
	//	a4.setPriority(Thread.MAX_PRIORITY); //작업 우선순위 10 <--- 가장 빨리 일처리 
		
		b4.setPriority(8); //작업 우선순위 8 <--- 더빨리 작업함
		
		System.out.println("A4보조작업스레드 객체의 작업우선순위 : " + a4.getPriority());
		System.out.println("B4보조작업스레드 객체의 작업우선순위 : " + b4.getPriority());
		
		//두 보조작업스레드 객체들 일 시키기
		a4.start(); b4.start();

	}

}
