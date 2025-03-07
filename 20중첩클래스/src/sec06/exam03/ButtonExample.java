package sec06.exam03;

//버튼 설계도(클래스) 만들기
class Button { //외부클래스
	
	//정적 중첩 인터페이스 만들기
	// - 외부클래스에서 접근이 불가능하도록
	//   public 이면서 Button 객체 생성없이 사용할 수 있는 static 중첩 인터페이스로 만듬
	public static interface ClickListener {
		//클릭하는 동작의 기능의 추상메소드 등록
		void onClick();
	} //------------------------------------interface ClickListener
	
	
	//외부 Button 클래스의 인스턴스변수 만들기
	private ClickListener clickListener;
						//new OkListener(); 
						//new CancelListener();
						
	
	//외부 Button 클래스의 인스턴스메소드 setter 만들기
	//기능 : 바로 위 만들어놓은 clickListener인스턴스변수값 변경
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	
	//Button이 클릭되었을때(click 이벤트가 발생했을때) 이벤트처리 기능을 가진 click()인스턴스메소드 만들기
	//실행내용
	// - 위 private ClickListener 인터페이스자료형 clickListener인스턴스변수에
	//   저장된 
	public void click() {
		this.clickListener.onClick();
	}
	
	

	
} //------------------------------------------class Button



public class ButtonExample {
	
	public static void main(String[] args) {
	
		//Button 설계도(클래스) 객체 생성
		Button btnOk = new Button();
		
		//클릭이벤트가 발생했을때 클릭이벤트를 처리할 OkListener클래스를 내부중첩클래스로 만들기
		//만드는 방법
			//Button 클래스 내부에 중첩 ClickListener 인터페이스 내부의 추상메소드를 강제로 오버라이딩해서
			//로컬 중첩 클래스형태로 만듭니다.
		class OkListener implements Button.ClickListener {
			
			//버튼을 클릭했을때 호출되는 메소드로
			//클릭이벤트가 발생했을때 이벤트처리코드를 작성하는 곳
			@Override
			public void onClick() {
				//재구현
				System.out.println("btnOk버튼을 클릭했으니 선물을 줄게요!");
			}
								
		}//--------------------------------------------class OkListener
		
		//btnOk 객체를 클릭할때마다 이벤트 처리메소드 onClick메소드를 
		//오버라이딩해놓은 OkListener중첩로컬클래스의 객체 생성
		btnOk.setClickListener(new OkListener());
		
		//Ok버튼을 클릭하는 행위(이벤트)하기
		btnOk.click(); //"btnOk버튼을 클릭했으니 선물을 줄게요!"

		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		

		//Cancel 역할을 하는 버튼 객체 생성
		Button btnCancel = new Button();
		
		//Cancel 버튼 클릭했을때 이벤트처리 코드가 작성된 오버라이딩된 Onclick메소드를 가지고 있는
		//CancelListener클래스 만들기
		//단! Button클래스 내부에 중첩인터페이스 ClickListenr의 추상메소드 Onclick을 강제로 오버라이딩 해야함
		class CancelListener  implements Button.ClickListener{

			@Override
			public void onClick() {
				//이벤트 처리 코드 작성
				System.out.println("btnCancel버튼을 클릭했으니 집으로 가겠다");
			}
			
		}//CancelListener 로컬 중첩 클래스 닫기 
	
		//Cancel역할을 하는 Button btnCancel = new Button()객체의 setClickListener메소드 호출시 
		//매개변수로 new CancelListener()객체를 전달해서
		//Button클래스 내부에 만들어놓은  private ClickListener clickListener; 변수에 저장 해야함
		btnCancel.setClickListener(new CancelListener());
		
		//Cancel역할을 하는 Button객체 클릭 이벤트 발생시키기
		btnCancel.click(); //"btnCancel버튼을 클릭했으니 집으로 가겠다"	  		
		
		
	}//main

}//class ButtonExample
