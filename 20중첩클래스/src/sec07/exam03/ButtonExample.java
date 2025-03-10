package sec07.exam03;

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
						
	
	//외부 Button 클래스의 인스턴스메소드 setter 만들기
	//기능 : 바로 위 만들어놓은 clickListener인스턴스변수값 변경
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	
	//Button이 클릭되었을때(click 이벤트가 발생했을때) 이벤트처리 기능을 가진 click()인스턴스메소드 만들기
	public void click() {
		this.clickListener.onClick();
	}
	
} //------------------------------------------class Button



public class ButtonExample {
	public static void main(String[] args) {
	
		//Button 설계도(클래스) 객체 생성
		Button btnOk = new Button();
		
		btnOk.setClickListener(new Button.ClickListener() {
			@Override
			public void onClick() {
				System.out.println("btnOk버튼을 클릭했으니 선물을 줄게요!");
			}
		});
		
		btnOk.click(); 
		
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		

		//Cancel 역할을 하는 버튼 객체 생성
		Button btnCancel = new Button();
	
		btnCancel.setClickListener(new Button.ClickListener() {
			@Override
			public void onClick() {
				System.out.println("btnCancel버튼을 클릭했으니 집으로 가겠다");
			}
		});
		
		//Cancel역할을 하는 Button객체 클릭 이벤트 발생시키기
		btnCancel.click(); //"btnCancel버튼을 클릭했으니 집으로 가겠다"	  		
		
		
	}//main

}//class ButtonExample
