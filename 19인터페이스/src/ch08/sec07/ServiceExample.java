package ch08.sec07;

/*
인터페이스 내부에 작성할수 있는 private 메소드
- 인터페이스의 상수, 추상메소드, default메소드, static정적메소드는
  모두 public 접근제어자를 갖습니다
  이 멤버들을 선언할때에는 public을 생략하더라도
  컴파일 과정에서 public 접근제어자가 붙어 항상 외부 클래스에서 접근이 가능합니다
  또한 인터페이스 {}중괄호 외부에서 접근할수 없도록 private메소드 선언도 가능하다
  
  구분 		       		설명
  private메소드          구현객체가 필요로하는 메소드
  private 정적메소드	    구현객체가 필요없는 메소드 
  
  추가설명
  	private메소드는 default메소드안에서만 호출이 가능한 반면,
  	private 정적메소드는 default메소드 뿐만아니라
  	정적메소드 안에서도 호출이 가능하다.
  	private메소드의 용도는 default와 정적메소드들의 중복코드를 줄이기 위함이다.

예제. Service인터페이스에서 2개의 default메소드와 2개의 정적메소드 중
     중복코드 부분을 각각 private메소드와  private정적메소드로 선언하고 호출하는 방법
*/

interface Service{
	
/*
	참고. 인터페이스의 메서드 접근 제어자 정리
	     
	[인터페이스 내부의 메서드들은 접근 제한자가 다르게 적용됩니다.]

	메서드 유형				접근 제한								자식 클래스에서 상속 여부
	default 메서드			public (기본적으로 공개)				⭕ 상속됨
	static 메서드				public (인터페이스명으로 호출)			❌ 상속되지 않음 (클래스에서 호출 불가)
    private 메서드			private (인터페이스 내부에서만 사용)	❌ 상속되지 않음
	private static 메서드		private (인터페이스 내부에서만 사용)	❌ 상속되지 않음
*/		
	
	//default 메소드 선언가능
	default void defaultMethod1() {
		System.out.println("defaultMethod1 종속코드");
		//아래쪽에 만들어 놓은 private 메소드 호출가능
		defaultCommon();
	}
	default void defaultMethod2() {
		System.out.println("defaultMethod2 종속코드");
		//아래쪽에 만들어 놓은 private 메소드 호출가능
		defaultCommon();
	}
	
	//private 메소드 선언가능
	private void defaultCommon() {
		System.out.println("defaultMethod 중복코드 A");
		System.out.println("defaultMethod 중복코드 B");
	}
	
	//정적(static) public 메소드 선언가능
	static void staticMethod1() {
		System.out.println("staticMethod1 종속코드");
	//	defaultCommon(); <-- private 메소드 호출 불가능	
		
		//아래쪽에 만들어놓은 private static 정적메소드 호출가능!
		Service.staticCommon();
	}
	
	static void staticMethod2() {
		System.out.println("staticMethod2 종속코드");
	//	defaultCommon(); <-- private 메소드 호출 불가능		
		
		//아래쪽에 만들어놓은 private static 정적메소드 호출가능!
		Service.staticCommon();
	}
	
	//private 정적메소드
	private static void staticCommon() {
		System.out.println("staticMethod 중복코드 C");
		System.out.println("staticMethod 중복코드 D");
		
	}
	
} //interface Service

//Service 인터페이스를 구현받아 새로운 자식 ServiceImpl클래스 만들기 --보통 클래스 이름	~Impl라고 지음. 
//implements <- Service 인터페이스 내부에 작성되어 있는 default메소드를 상속받고
//				나머지 멤버들 중에서 추상메소드들을 강제로 재구현(메소드 오버라이딩)시켜
//				ServiceImpl라는 이름으로 새로운 자식클래스를 완성시키자
class ServiceImpl implements Service {
	//default 메서드들은 자동으로 상속됨(오버라이딩 가능)
	//요약 : ServiceIpml은 default 메서드만 상속받고,
	//		private 및 static 메서드는 상속되지않습니다.
	
	
	
}


public class ServiceExample {
	public static void main(String[] args) {
		//업캐스팅
		//-> 부모인터페이스자료형의 참조변수 선언후 자식객체 생성해서 자식객체메모리 주소번지 저장
		Service service = new ServiceImpl();
		
		//이 때 ServiceImpl객체는 다음 default메소드들을 호출해서 사용할 수 있습니다.
		//이유 상속받았기때문에
		service.defaultMethod1();
		/*
			defaultMethod1 종속코드
			defaultMethod 중복코드 A
			defaultMethod 중복코드 B
		*/
		service.defaultMethod2();
		/*
			defaultMethod2 종속코드
			defaultMethod 중복코드 A
			defaultMethod 중복코드 B
		*/
		System.out.println("----------------------------------------");
		
	//	service.defaultCommon();	호출 불가능
	//	service.staticCommon();		호출 불가능
		//private 메소드와 private static 메소드는 
		//자식클래스에 상속되지않기때문에 호출해서 사용할 수 없다.
		//이 메소드들은 오직 Service 인터페이스 내부에서만 사용되기 때문입니다.
		
		//정적(static)메소드들은 어떻게 될까요?
		// - 정적메소드는 인스턴스(객체)가 아니라 "인터페이스명"으로 직접 호출하는 방식이라
		//	 자식클래스에서 상속되지않습니다.
		
		//인터페이스명.정적메소드명();
		Service.staticMethod1();
		/*
			staticMethod1 종속코드
			staticMethod 중복코드 C
			staticMethod 중복코드 D
		*/
		
		Service.staticMethod2();
		/*
			staticMethod2 종속코드
			staticMethod 중복코드 C
			staticMethod 중복코드 D
		*/
		

	}

}
