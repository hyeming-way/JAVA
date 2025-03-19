
import java.util.Stack;

/*
스레드 동기화 처리 두번째 예제 (자판기)

시나리오
	음료수를 제공하는 공급자 스레드가 자판기(공용메모리)에 음료수를 공급하면
	자판기에서 음료를 구입하여 뽑아먹는 소비자 스레드가 있다.
	
	공급자스레드는 음료수를 자판기에 공급해야~
	소비스레드가 자판기에서 음료수를 구입하여 뽑아먹을수 있다.

    이때 자판기(공유데이터가 저장되는 객체 메모리) 이해 하자.
*/
/*
동기화(synchronized) : 자판기를 동시에 여러보조작업스레드가 사용하려고 할때
                    데이터 일관성을 유지하기 위해 사용합니다.
                   synchronized키워드는 특정 메소드나 블록이 여러 스레드에 의해
                   동시에 접근되는것을 방지 합니다.

wait() : 현재 스레드를 일시 중단시키고, 다른 스레드가 자원(자판기)에 접근할수 있도록합니다

notify() : wait()메소드로 일시 중단시킨 스레드를 꺠워서 다시 실행할수 있게하는 메소드 

*/

//자판기 역할을 하는 클래스 <- 공유 클래스
class AutoMachine {
	//자판기 공간을 스택메모리를 생성해서 사용
	Stack store = new Stack();
	
	//소비자 스레드 객체가 자판기에서 음료를 뽑아먹는 행동을 표현한 메소드
	public synchronized String getDrink() {
		
		try {
			this.wait(); //공급자 스레드 객체가 음료를 공급할 때까지 대기하게 하는 메소드
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		//어떤 음료수를 뽑아먹는지 음료수 번호를 문자열로 반환
		return store.pop().toString();
	}
	//공급자 스레드 객체가 자판기에 음료를 공급하는 행동을 표현한 메소드
	public synchronized void putDrink(String drink) {
		
		this.notify(); //wait()메소드를 호출하여 대기중인 소비자 스레드 객체 깨움
		//자판기 공간(Stack 객체메모리)에 음료수 집어 넣기(공급)
		store.push(drink);
	}
}

//음료를 공급할 공급자 스레드 객체를 생성하기 위한 일반클래스
class Producer implements Runnable {
	
	//자판기 역할을 하는 AutoMachine 클래스의 객체 주소번지를 저장할 참조변수 선언
	private AutoMachine machine;
	
	//생성자를 이용해 machine 인스턴스변수값 초기화
	public Producer(AutoMachine machine) {
		this.machine = machine;
	}
	
	//자판기에 9개의 음료수 공급하는 기능의 오버라이딩
	@Override
	public void run() {
		//9번 반복해서 AutoMachine 객체 내부의 Stack 메모리에 음료 공급
		for(int i=1; i<10; i++) {
			System.out.println(Thread.currentThread().getName() + " : 음료수No." + i + "를 공급 함");
			
			//실제로 AutoMachine객체 내부에 만들어져 있는
			//Stack 자판기 메모리에 문자열형태의 "음료수No.1"등 공급
			machine.putDrink("음료수No." + i);
			
			//공급자 스레드 객체 0.1초 휴식
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//for
	}//run
}//class Producer


//음료를 구입해서 자판기에서 음료를 뽑아먹는 소비자 스레드 객체를 생성하기 위한 일반클래스
class Consumer implements Runnable {
	
	//자판기 역할을 하는 AutoMachine 클래스의 객체 주소번지를 저장할 참조변수(인스턴스변수) 선언
	private AutoMachine machine;
	
	public Consumer(AutoMachine machine) {
		this.machine = machine;
	}
	
	//자판기(Stack메모리)에 공급된 9개의 음료수를 구입하여 뽑아먹는 행동
	@Override
	public void run() {
		for(int i=1; i<10; i++) {
			//음료수를 뽑아 먹고 있다는 것을 보여주기 위해 출력
			System.out.println(Thread.currentThread().getName() + " : " + machine.getDrink() + "를 구입해서 뽑아먹음");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//for
	}//run
}//class Consumer


public class SyncThreadEx2 {
	public static void main(String[] args) {
		
		AutoMachine autoMachine = new AutoMachine();
		
		new Thread(new Producer(autoMachine), "정우 공급자").start();
		new Thread(new Consumer(autoMachine), "길동 소비자").start();
		
		
	}

}
