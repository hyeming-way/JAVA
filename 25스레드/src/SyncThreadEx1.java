
/*
	스레드 동기화가 발생하는 문제 
	- 다수의 스레드가 하나의 공유데이터에 동시에 접근해서 사용할 경우
	  그 공유 데이터 사용에 관한 동기화문제 발생!
	  
	동기화처리 
	- 스레드들 사이의 작업시기를 맞추어서 똑같은 데이터를 유지 할수 있게 하는것.
	
	스레드 동기화 처리 방법
	- synchronized키워드를 이용 

주제 : 스레드 동기화 처리를 위한 화장실 예제

*/

//화장실 설계도(클래스) <----- 스레드 아님. 공용영역
class Toilet {
	
	/*	
		synchronized 키워드
		- 자바에서 스레드 동기화를 위한 키워드
		- synchronized키워드와 함께 작성된 메소드는 
		  특정 보조작업스레드가 메소드를 호출하여 일처리를 시작하기 전에
		  락(lock)을 걸고 소유하며, 락(lock)을 소유하지 못한 다른 보조작업스레드들은 
		  synchronized블록앞에 락(lock)을 소유할떄까지 대기함.
	*/
	//화장실 문으로 들어가 대변을 보는 행동을 표현한 메소드
	public synchronized void openDoor(String name) { //화장실 문으로 들어오는 가족단위 스레드 객체 이름	
		//가족구성원 가족스레드들 중에서 화장실 문으로 입장하는 것을 보여주기 위해 출력
		System.out.println(name + " 스레드가 화장실 문으로 입장 함");
		
		//대변을 보는 시간을 억번 반복해서 출력
		//만약 10000번이 되는 순간 대변보는 효과를 출력
		for(int i=0; i<10000000; i++) {
			if(i == 10000) {
				System.out.println(name + " : 끄으응~~");
			}
		}
		//대변을 다 본 효과 출력
		System.out.println(name + " : 아~ 시원해~~");
	}//openDoor
	
}


//가족 설계도(보조작업 객체를 생성하기위한 클래스) <----- 각각 가족단위로 보조작업스레드 객체 생성
class Family extends Thread {
	
	//공용으로 사용할 화장실(Toilet 클래스의 객체)주소를 저장할 참조변수 선언
	Toilet toilet;
	//가족의 구성원 중에서 한 사람(보조작업스레드 Family 객체)의 이름을 저장할 변수 선언
	String who;
	
	public Family(Toilet toilet, String who) {
		this.toilet = toilet;
		this.who = who;
	}
	
	//화장실 문으로 특정 Family 가족객체가 들어가서 대변을 보는 행동을 표현하는 일
	@Override
	public void run() {
		toilet.openDoor(who);
	}
	
}


public class SyncThreadEx1 {
	public static void main(String[] args) {
		
		//화장실 객체(각 Family 보조작업 스레드 객체가 공용으로 사용할 메모리)생성
		Toilet toilet = new Toilet();
		
		//각각의 가족구성원 역할을 하는 보조작업스레드 Family 객체들(아빠, 엄마, 누나, 형, 나)생성
		Family father = new Family(toilet, "아빠");
		Family mother = new Family(toilet, "엄마");
		Family sister = new Family(toilet, "누나");
		Family brother = new Family(toilet, "형");
		Family me = new Family(toilet, "나");
		
		father.start();
		mother.start();
		sister.start();
		brother.start();
		me.start();	
	
	}

}
