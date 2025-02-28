
/* 
	
[예제1] 09클래스와객체 프로젝트 내부의 Ex1.java 를 복사해서 10생성자 프로젝트에 넣어 과일장수 이야기 업그레이드 시키자 (version2)

------------------------------------------------

두명의 과일장수와 한명의 구매자가 있다고 가정 하자!

과일장수1 : 보유하고 있는 사과의 수는 30개이고, 개당가격은 1,500원
과일장수2 : 보유하고 있는 사과의 수는 20개이고, 개당가격은 1,000원


과일 구매자


[시물레이션 상황] 
"나는 과일장수1에게 4,500원어치 사과를 구매했고, 
 과일장수2에게 2,000원어치 사과를 구매했다."

문제점 : 두명의 과일장수 객체를 생성해야 하는데.. 
       과일장수들의 사과보유수와 , 사과 개당가격이 다르기 때문에  
       인스턴스변수의 초기값도 달라저야한다. 
       그러므로 전의 Ex1.java파일 코드처럼 클래스를 정의하면서 
       변수값 final int APPLE_PRICE = 1000;를 초기화할 수 없다.
       생성되는 과일장수 객체마다 변수 값을 달리해야 하기 때문이다.

문제해결 할수 있는 최선의 방법 :
- 과일 장수들 객체를 생성하고 나서, int apple_price 객체변수를 초기화합니다.
- int apple_price 객체 변수를 초기화 하기위한 메소드를 생성 하여 클래스 내부에 추가. 

--------------------------------------------------------
	
*/
//(2단계) 클래스(설계도) 정의  :  변수 + 메소드
//과일장수 FruitSeller라는 이름의 틀(클래스,설계도)정의

class FruitSeller{
		
	//변수 
	//1.사과 한 개당 가격을 저장할 변수(상수메모리 final예약어로 전환)
//	final  int APPLE_PRICE = 1000;	
	//상수메모리를 변수메모리로 바꿔서 만들어주자
	int apple_price;
	
	//2.보유하고 있는 사과의 수를 저장할 변수
	int numofApple;
	//3.판매수익을 저장할 변수
	int myMoney;
		
	//메소드
	//1.과일장수의 과일판매 동작(기능,행동)을 할 메소드
	int saleApple(int money) { //사과 구매 금액을 과일구매자객체(FruitBuyer객체)로 부터 
							   //매개변수로 받는다.		
		//판매한 사과 갯수 구하기
		//-> 과일구매자객체(FruitBuyer객체)가 지불한 금액에  한개당 가격을 나누면
		//   판매한 사과 갯수 구할수 있음
		int num = money / apple_price;
		
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
	
	//3. 나중에 FruitSeller클래스의 객체메모리를 생성 후
	// 각 객체변수 3개의 값을 저장할 기능의 메소드 추가
	public void initMembers(int apple_price_, int numOfApple_, int myMoney_) {
		
		apple_price = apple_price_;
		numofApple = numOfApple_;
		myMoney = myMoney_;
		
	}
	
}//FruitSeller과일장수 class 설계도 끝

//(2단계) 클래스(설계도) 정의  : 변수 + 메소드 
//나(과일구매자) FruitBuyer라는 이름의 클래스 정의
class FruitBuyer{
//---과일구매자의 속성(데이터,상태) 정보를 저장할 변수---    
//    1.현재 소유하고 있는 현금을 저장할 변수
	  int myMoney = 5000;
//    2.현재 소유하고 있는 사과수를 저장할 변수
	  int numOfApple = 0;
	
//---과일구매자의 동작(기능,행동)을 메소드로 만들기---
//	1.과일구매자의 과일구매 동작(기능,행동)을 할 메소드
 		//매개변수-> 과일구매를 위한 과일장수(판매자)객체, 구매시 지불한 금액
	 public void buyApple(FruitSeller seller, int money) {
		 
		 	//과일장수(판매자)객체에게 과일을 구매하기위해
		 	//FruitSeller seller매개변수로 전달받은 과일판매자객체(new FruitSeller())객체의
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
}//과일구매자(FruitBuyer) class정의 끝


//프로그램 실행의 시작점이 되는 메인이 되는 클래스(설계도)
public class Ex1 {
	public static void main(String[] args) {
	//(3단계) 객체 생성과 사용	
	
	//해결방법 사용 : 
	//과일장수1, 2 객체를 생성하고 나서,
	//객체변수 3개를 추가한 메소드로 3개의 변수값 초기화합니다.
		
	//과일장수1(FruitSeller클래스의 객체 생성)
	FruitSeller seller1 = new FruitSeller();
	
	//생성된 과일장수1 객체의 객체변수들의 값을 처음 저장(초기화)하기 위해
	//추가한 initMember메소드 사용
	seller1.initMembers(1500, 30, 0);
	//-> 사과 개당 가격 : 1500원, 현재 보유한 사과갯수 : 30, 판매수익이자 잔고 : 0
	
	//과일장수1(FruitSeller클래스의 객체 생성)
	FruitSeller seller2 = new FruitSeller();
	
	//생성된 과일장수2 객체의 객체변수들의 값을 처음 저장(초기화)하기 위해
	seller2.initMembers(1000, 20, 0);
	//-> 사과 개당 가격 : 1000원, 현재 보유한 사과갯수 : 20, 판매수익이자 잔고 : 0
	
	//1명의 과일 구매자 객체(FruitBuyer클래스의 객체 생성)
	FruitBuyer buyer1 = new FruitBuyer();
	
	//과일 구매자 객체는 과일장수1 객체에게 4500원을 지불하고 사과 구매
	buyer1.buyApple(seller1, 4500);
	
	//과일구매자 객체의 현재 객체변수들에 저장된 값들의 상황 출력
	System.out.println("---------과일 구매자의 현재 상황------------");
	buyer1.showBuyResult();
	
	//과일장수1 객체의 현재 객체변수들에 저장된 값들의 상황 출력
	System.out.println("----------과일장수1의 현재 상황------------");
	seller1.showSaleResult();
	
	//1명의 과일구매자 객체가 과일장수2 객체에게 2000원어치 사과 구매하기
	buyer1.buyApple(seller2, 2000);
	
	//과일구매자 객체의 현재 객체변수들에 저장된 값들의 상황 출력
	System.out.println("---------과일 구매자의 현재 상황------------");
	buyer1.showBuyResult();
	
	//과일장수2 객체의 현재 객체변수들에 저장된 값들의 상황 출력
	System.out.println("----------과일장수2의 현재 상황------------");
	seller2.showSaleResult();
		
/*
	이 프로그램은 과일장수1 , 과일장수2객체들의 사과 1개당 가격은
	객체 메모리를 생성한 후 각각 1500원,  1000원 으로 다르게 설정하는 것은 가능했다
	
		그러나 이프로그램 문제점 2가지 가 있다
		
			1. 과일장수1,2객체는 생성하고 난 다음에 객체변수들의 값을 초기화해야한다
			   즉! 두줄에 걸쳐서 코드문장을 작성해야 하나의 객체메모리를 생성해서 완성할수 있다
			   코드의 가독성이 저하 됨
			
			2. FruitSeller(과일장수)클래스로 객체를 생성하면
			   객체 메모리 내부의  APPLE_PRICE상수의 final선언이 사라진점이 문제가됨
			   
			    final선언이 사리진점이 왜 문제가 될까?
			     : 클래스 설계시 과일장수가 판매하는 사과 한개당 가격은 변경되지 않음을 가정해 두고
			       객체변수 int apple_price로 변경했습니다
			       initMember메소드 내부에서 구현코드로 apple_price변수값을
			       초기화 하려다보니 어쩔수없이 final선언을 강제로 삭제 시켰습니다
			       여기서 하나의 문제점이 있는데............	       
			       initMember메소드라는 것은 만들어 놓고 여러번 호출할수 있으므로
			       initMember메소드를 여러번 호출한다면
			       개발자가 객체메모리의 변수값 초기화 하는작업의 실수를 범할수도 있기때문에
			       객체메모리 생성하는 동시에 단 한번만 호출되는 생성자를 이용해
			       객체메모리를 생성후 빠르게 객체변수들을 초기화 해야 합니다.
			       
			
	      이프로그램의 문제점들 해결방법은  클래스설계시 내부에 생성자를 만들어 놓고 사용하자
	      
*/			
	
	}

}


