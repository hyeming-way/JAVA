
//주제 : 업캐스팅을 하는 이유 응용2


//부모클래스 
class 해장국{
	public void 간맞추기() {
		System.out.println("소금치기");
	}
}
//자식클래스1
class 뼈다귀해장국 extends 해장국{
	
	//뼈다귀해장국 클래스의 행동에 맞게
	//부모 해장국 클래스의 간맞추기 메소드를 오버라이딩 
	@Override
	public void 간맞추기() {
		System.out.println("뼈다귀해장국에는 들깨가루 넣기");
	}
	
	public void 뼈추가하기() {
		System.out.println("뼈추가!");
	}
}
//자식클래스2 
class 콩나물해장국 extends 해장국{
	//메소드 오버라이딩
	@Override
	public void 간맞추기() {
		System.out.println("콩나물해장국에 고추가루 넣기!");
	}
	
	public void 콩나물넣기() {
		System.out.println("콩나물!");
	}
}

//해장국 객체들 중에 하나를 선택해서 간을 맞추는 취객 클래스
class 취객{

//업캐스팅후 부모클래스자료형의 참조변수(매개변수)로
//여러 자식해장국객체들 주소를 전달받을수 있도록 매개변수는 하나만 작성해서 만들자
	public void 해장국간맞추기(해장국  무슨해장국) {
								  //new 뼈다귀해장국()
								  //new 콩나물해장국()
		무슨해장국.간맞추기();
	}
	
/*	
	//취객이 해장국집에 들어가서
	//뼈다귀해장국 그리고 콩나물해장국을 모두 시켜 간을 맞추는 행동을 위해 메소드 2개 추가
	
	public void 뼈다귀해장국간맞추기(뼈다귀해장국   뼈다귀해장국) {
									      //new 뼈다귀해장국()
		      뼈다귀해장국.간맞추기();
//		new 뼈다귀해장국().간맞추기();
	}
	
	public void 콩나물해장국간맞추기(콩나물해장국  콩나물해장국) {
										  //new 콩나물해장국()
		
		   콩나물해장국.간맞추기();
//    new 콩나물해장국().간맞추기();
		
	}
*/	
}

public class Test2 {

	public static void main(String[] args) {
		//취객 객체 생성
		취객 취객1 = new 취객();
		
		//업캐스팅
//   부모클래스 참조변수    =  자식객체 생성;		
		해장국 해장국한그릇 = new 뼈다귀해장국();
			  
		취객1.해장국간맞추기(해장국한그릇);
		//뼈다귀해장국에는 들깨가루 넣기
		
	//	해장국한그릇.뼈추가하기(); //부모클래스 참조변수로 접근 불가능(업캐스팅 단점)
		
		//다운캐스팅
	//자식클래스 참조변수  = (자식클래스)부모클래스의참조변수명;
	  뼈다귀해장국 뼈 = (뼈다귀해장국)해장국한그릇;	
				뼈.뼈추가하기(); //서비스 받음
				//뼈추가!
	  //-----------------------
	  //업캐스팅
			해장국한그릇  = new 콩나물해장국();
			
		취객1.해장국간맞추기(해장국한그릇);	
		
	  //다운캐스팅
	 //자식클래스  참조변수 = (자식클래스)부모클래스의 참조변수명;
	   콩나물해장국   콩   = (콩나물해장국)해장국한그릇;
	   			   콩.콩나물넣기(); //서비스 받음
				 //콩나물!
	 //-------------------------------------			
		
/*		
		//뼈다귀 해장국 객체 생성
		뼈다귀해장국  뼈 = new 뼈다귀해장국();
		
		취객1.뼈다귀해장국간맞추기(  뼈 );

		뼈.뼈추가하기();//서비스 받음
		
		//---------------------------------
		//콩나물해장국 객체 생성
		콩나물해장국 콩 = new 콩나물해장국();
		
		취객1.콩나물해장국간맞추기(콩);
		
		콩.콩나물넣기();//서비스 받음
*/		
		
		
	}

}










