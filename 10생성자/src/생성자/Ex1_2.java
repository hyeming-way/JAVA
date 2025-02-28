/* 

두명의 과일장수와 한명의 구매자가 있다고 가정 하자!

과일장수1 : 보유하고 있는 사과의 수는 30개이고, 개당가격은 1,500원
과일장수2 : 보유하고 있는 사과의 수는 20개이고, 개당가격은 1,000원

과일 구매자

[시물레이션 상황] 
"나는 과일장수1에게 4,500원어치 사과를 구매했고, 
 과일장수2에게 2,000원어치 사과를 구매했다."
	
//------------------- 생성자를 이용하는 방법으로 업그레이드 시키자

//FruitSeller(과일장수) 클래스 내부 수정
//순서1. 사과 한개당 가격 변수에 final을 붙여 상수로 만들어주자.
// 단! 사과 한개당 가격은 객체 메모리 생성시 호출되는 생성자 내부에서 초기화하자

//순서2. 과일장수객체의 사과 한개당 가격, 사과보유수, 판매수익을 각각
//      객체변수들에 초기화 시킬 생성자 추가 

//순서3. 추가한 initMembers메소드 지우기(삭제)

//--------------------------------------------

//FruitBuyer(과일구매자) 클래스 내부 수정

//순서1. 현재 소유하고 있는 현금 0원, 개수 0개로 초기화

//순서2. 구매자의 현재 소유하고 있는 현금을 매개변수로 받아 초기화,
//      구매자의 현재 사과 보유 개수를 매개변수로 받아 초기화할 생성자 추가 	
*/
//(2단계) 클래스(설계도) 정의  :  변수 + 메소드
//과일장수 FruitSeller라는 이름의 틀(클래스,설계도)정의
package 생성자;


class FruitSeller{
		
	//변수 
	//1.사과 한 개당 가격을 저장할 변수(상수메모리 final 예약어로 전환)
	final  int APPLE_PRICE;	
	
	//2.보유하고 있는 사과의 수를 저장할 변수
	int numofApple;
	//3.판매수익을 저장할 변수
	int myMoney;
		
	//생성자 추가
	public FruitSeller(int apple_price, int numofApple_, int myMoney_) {
		APPLE_PRICE = apple_price;
		numofApple = numofApple_;
		myMoney = myMoney_;	
	}

	//메소드
	//1.과일장수의 과일판매 동작(기능,행동)을 할 메소드
	int saleApple(int money) { //사과 구매 금액을 과일구매자객체(FruitBuyer객체)로 부터 
							   //매개변수로 받는다.		
		//판매한 사과 갯수 구하기
		//-> 과일구매자객체(FruitBuyer객체)가 지불한 금액에  한개당 가격을 나누면
		//   판매한 사과 갯수 구할수 있음
		int num = money / APPLE_PRICE;
		
		//사과 판매한 후 과일장수객체가 보유한 사과 갯수 차감 
		numofApple -= num;
		
		//과일장수객체가 판매한 판매수익금액을 누적
		myMoney += money;
				
		return num;//실제 과일장수객체가 판매한 사과 갯수 반환		
	}
	
	//2.사과판매후 남은 사과수,판매수익 출력 하는 기능의 메소드
	public void showSaleResult() {
		System.out.println("과일장수객체의 남은 사과 갯수 : " +  numofApple);
		System.out.println("과일장수객체의 현재 잔고 : " + myMoney);
	}
	
	
}//FruitSeller과일장수 class 설계도 끝

//(2단계) 클래스(설계도) 정의  : 변수 + 메소드 
//나(과일구매자) FruitBuyer라는 이름의 클래스 정의
class FruitBuyer{
	//---과일구매자의 속성(데이터,상태) 정보를 저장할 변수---    
	//1.현재 소유하고 있는 현금을 저장할 변수
	int myMoney;
	//2.현재 소유하고 있는 사과수를 저장할 변수
	int numOfApple;
	 
	//생성자 추가 : 과일구매자객체의 현재 소유하고 있는 현금, 현재 소유 사과수 초기화할 생성자
	public FruitBuyer(int myMoney_, int numOfApple_) {
	myMoney = myMoney_;
	numOfApple = numOfApple_;
	}

//---과일구매자의 동작(기능,행동)을 메소드로 만들기---
//	1.과일구매자의 과일구매 동작(기능,행동)을 할 메소드
 		//매개변수-> 과일구매를 위한 과일장수(판매자)객체, 구매시 지불한 금액
	 public void buyApple(FruitSeller seller, int money) {
		 
		 	//과일장수(판매자)객체에게 과일을 구매하기위해
		 	//FruitSeller seller 매개변수로 전달받은 과일판매자객체(new FruitSeller())객체의
		 	//salApple객체메소드 호출! 호출시 매개변수로 구매시 지불할 금액 전달하면
		    //과일구매자객체는 구매한 과일(사과)갯수를 반환받는다.
		    //과일구매자객체(FruitBuyer객체)의 객체변수  numOfApple에 누적!
		    numOfApple += seller.saleApple(money);
		 
		    //과일판매자객체(FruitSeller객체)에게 과일 구매후 현재 과일구매자객체(FruitBuyer)의 현금 차감
		    myMoney -= money;
	 }
	  
//	2.과일구매후 현재 남은 현금과 사과의수 출력 기능의 메소드 
	 public void showBuyResult() {
		 System.out.println("현재 잔액 : " + myMoney); //현재 남은 돈 출력
		 System.out.println("보유 사과 수 : " + numOfApple);//현재 보유한 사과 수 출력
	 }
}//과일구매자(FruitBuyer) class 정의 끝


//프로그램 실행의 시작점이 되는 메인이 되는 클래스(설계도)
public class Ex1_2 {
	public static void main(String[] args) {
		//(3단계) 객체 생성과 사용	
		
		//과일장수(FruitSeller)객체 메모리 생성하는 동시에 생성자 호출해 객체 변수값 빠르게 초기화	
		//1. 과일장수1 -> 사과 단가 1500, 사과보유수 30, 판매수익 0
		FruitSeller seller1 = new FruitSeller(1500, 30, 0);
		
		//2. 과일장수2 -> 사과 단가 1000, 사과보유수 20, 판매수익 0
		FruitSeller seller2 = new FruitSeller(1000, 20, 0);
		
		//과일구매자(FruitBuyer)객체 메모리 생성하는 동시에 생성자를 호출해 객체변수값들 빠르게 초기화
		//1. 과일구매자1 -> 현재 소유 현금 10000, 현재 구매한 사과 수 0
		FruitBuyer buyer1 = new FruitBuyer(10000, 0);
		
		//과일구매자1은 과일장수1에게 4500원 지불 후 사과 구매 동작
		buyer1.buyApple(seller1, 4500);
		
		//과일구매자1은 과일장수2에게 2000원 지불 후 사과 구매 동작
		buyer1.buyApple(seller2, 2000);
		
		//과일장수1, 과일장수2, 과일구매자1의 현재 상태 출력
		System.out.println("--------------과일장수1--------------");
		seller1.showSaleResult();
		
		System.out.println("--------------과일장수2--------------");
		seller2.showSaleResult();
		
		System.out.println("--------------과일구매자1--------------");
		buyer1.showBuyResult();

	}

}


