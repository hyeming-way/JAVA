// 1단계: 현실의 객체 모델링
// - 현실에서 '은행 계좌'를 생각해보자.
// - 계좌에는 여러 가지 정보(데이터)와 기능(행동)이 있다.
// - 데이터: 계좌번호(accountNumber), 예금주(owner), 잔액(balance)
// - 기능: 돈을 입금(deposit), 출금(withdraw), 잔액 확인(checkBalance)


 // 2단계: 자바 코드로 class 설계 (데이터 + 기능)
class BankAccount { // '은행 계좌'를 코드로 표현한 클래스
 
    // 계좌의 정보(데이터)를 저장할 클래스 변수들 선언
		// 계좌번호 (예: "123-456-789")
        // 예금주 (예: "이영희")
        // 잔액 (예: 100000원)
		String accountNumber;
		String owner;
		double balance;

    // 메서드명: deposit  
    // 기능: 특정 금액(amount)을 입금하면, 잔액(balance)이 증가한다.
	
						// 사용자가 입금할 금액(amount)을 매개변수로 받는다.
					    // 예: 사용자가 50,000원을 입금하면 amount = 50000		
    void deposit(double amount) {
        

    	// 현재 잔액(balance)에 amount(입금 금액)를 더한다.
        // 예: 기존 잔액이 100,000원이었고 50,000원을 입금하면, balance = 150,000
    	balance += amount;
     
        // 예: "이영희님의 계좌에 50000원이 입금되었습니다."  <---- 이자리에서 출력
    	System.out.println(owner + "님의 계좌에 " + (int)amount + "원이 입금되었습니다.");

        // 예: "현재 잔액: 150000원" <----이자리에서 출력
    	System.out.println("현재 잔액: " + (int)balance + "원");
    }

    // 메서드명: withdraw  
    // 기능: 특정 금액(amount)을 출금하면, 잔액(balance)이 감소한다. 
    // 단, 잔액이 부족하면 출금이 실패한다.
							    // 사용자가 출금할 금액(amount)을 매개변수로 받는다.
							    // 예: 사용자가 30,000원을 출금하면 amount = 30000
    void withdraw(double amount) {
       
        if (balance >= amount) { // 현재 잔액이 출금할 금액보다 많거나 같다면 출금 가능
           
        	// 현재 잔액(balance)에서 출금할 금액(amount)을 뺀다.
            // 예: 기존 잔액이 150,000원이었고 30,000원을 출금하면, balance = 120,000
        	balance -= amount;

            // 예: "이영희님의 계좌에서 30000원이 출금되었습니다." <---이자리에 출력
        	System.out.println(owner + "님의 계좌에서 " + (int)amount + "원이 출금되었습니다.");

            // 예: "현재 잔액: 120000원" <---이자리에 출력
        	System.out.println("현재 잔액: " + (int)balance + "원");

        } else { // 현재 잔액이 출금할 금액보다 적다면 출금 불가
           
        	System.out.println("잔액 부족! 출금 실패.");
           
        }
    }

    // 메서드명: checkBalance  
    // 기능: 현재 계좌의 잔액(balance)을 출력한다.
    void checkBalance() {
        System.out.println(owner + "님의 현재 잔액: " + (int)balance + "원");
        // 예: "이영희님의 현재 잔액: 120000원"
    }
}

// 실행을 위한 메인 클래스
public class BankAccountTest {
    public static void main(String[] args) {
        // 3단계: 객체 생성 후 데이터 저장 및 사용

        // (1) '은행 계좌' 객체를 생성한다.
        BankAccount account = new BankAccount();  

        // (2) 계좌 정보를 설정한다.
        account.accountNumber = "123-456-789";   // 계좌번호 설정
        account.owner = "이영희";                // 예금주 설정
        account.balance = 100000;                // 초기 잔액 설정 (100,000원)

        // (3) 계좌 기능을 사용해보기
        // 50,000원 입금  기능 실행
        // 30,000원 출금  기능 실행
        // 현재 잔액 확인   기능 실행
        account.deposit(50000);
        account.withdraw(30000);
        account.checkBalance();
        
    }
}
