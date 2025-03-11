package ex2;

/*
	이 예제는 은행계좌(Account)클래스의 출금(withdraw)메소드에서
	잔고(balance)변수와 출금액(매개변수로전달하는값)을 비교해
	잔고가 부족하면 InsufficientException을 발생시키고 throws한다.
	그리고 AccountExample은 withdraw()메소드를 호출할 때 예외처리를 한다.
*/

class Account { //은행계좌 클래스(설계도)
	
	private long balance; //잔고가 저장될 변수
	
	public Account(){} //기본생성자
	
	public long getBalance() { //잔고 반환(리턴) 메소드
		return this.balance;
	}
	
	//예금을 하여 잔고금액 변경하기 위한 메소드
	public void deposit(int money) {
		this.balance += money;
	}
	
	//출금을 위한 메소드
								//throws 키워드를 이용해 사용자정의 발생예외가 메소드 내부에서
								//발생하면 withdraw 메소드를 호출한 코드 줄로 가서 예외처리하라~!
	public void withdraw(int money) throws InsufficientException {
		
		if(balance < money) {
			
			//개발자가 강제로 예외를 발생시키는 코드를 작성할 수 있다.
			//문법
			//		throw new 강제로발생시킬_사용자정의_예외클래스의_객체생성();
			throw new InsufficientException("잔고부족 : " + (money - this.balance) + "모자람");
			
		}
		
		//잔고에서 차감
		this.balance -= money;
		
	}

} //class Account

//사용자정의 예외 클래스 만들기
class InsufficientException extends Exception {
	
	//기본생성자
	public InsufficientException() {} 
	
	//예외메세지 하나를 매개변수로 전달받는 생성자
	public InsufficientException(String message) {
		
		super(message); //부모생성자 호출
		
	}
	
} //class InsufficientException


public class AccountExample {
	public static void main(String[] args) {
		
		//Account 클래스(은행 계좌 클래스)의 객체 생성
		Account account = new Account();
		
		//10000 예금하기
		account.deposit(10000);
		
		//10000 예금 후 잔고 확인하기
		System.out.println("예금액 : " + account.getBalance()); //예금액 : 10000
		
		//30000원 출금하기
		//참고. 예금한 금액은 10000원인데 30000원을 출금하려고해서
		//	   개발자가 직접 만든 사용자정의예외처리종류클래스의 객체를 새엇ㅇ해
		//	   강제로 예외발생시킴
		try {
			account.withdraw(30000); //<--- 메소드를 호출한 곳!
			
		} catch (InsufficientException e) {
			//발생한 예외의 이유 출력
			System.out.println(e.getMessage());
			
		}
	
		System.out.println("main메소드 내부의 자바 프로그램 종료 코드");

	} //main

}
