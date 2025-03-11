package exam01;

/*
	Object 클래스의 boolean equals(Object obj) 메소드는
	두 객체 메모리의 주소번지가 같냐? 라고 물어보는 메소드로
	같으면 true, 틀리면 false 반환하는 메소드입니다.
	
	그림
	
		class A extends Object {
		
			public boolean equals(Object obj){ //Object 클래스로부터 상속받은 equals 메소드
			
				return (this == obj);
			
			}
		
		}
		
	 예시코드 
			 0x01             0x02
			new A().equals( new A() ); <-- false
			-> 두 A객체 메모리의 주소번지가 같으냐? 라고 물어보는 메소드
			
			A a = new A();		a.equals( a2 );
			A a2 = new A();	
*/

/*
	주제 : Member 객체의 동등비교(Member 객체 내부의 변수값이 같은지 비교)를 위해서
		  Object 부모클래스의 equals 메소드를 재정의(메소드 오버라이딩)한다.
		  
		  각 Member 객체들의 id 인스턴스변수값이 같은지 비교하여
		  같은 경우 true, 틀릴 경우 false 반환
*/

class Member /*extends Object*/ {
	
	public String id;
	
	//회원의 아이디를 매개변수로 전달받아 id 인스턴스변수값 초기화할 생성자
	public Member(String id) {
		this.id = id;
	}

	//Object 부모클래스에 만들어져있는 equals 메소드를 상속받지않고 메소드오버라이딩
	//메소드 오버라이딩 단축키 : alt + shift + s  v
	
	//재구현 내용 : 각 Member 객체들 내부의 인스턴스 변수 id 값 비교
	@Override
	public boolean equals(Object obj) { //new Member("blue");
		
		/*
			instanceof 예약어?
			- A객체 instanceof A클래스자료형 또는
			  A객체 instancsof Object 자료형식이 적혀있다고 했을 때
			  instanceof 예약어는 A객체가 A클래스를 이용해서 생성된 객체이거나,
			  Object 부모클래스를 상속받아 만든 자식객체라면 true 반환, 그렇지않으면 false 반환
			  
			예) obj instanceof Class  
				-> obj가 Class에 속하거나 Class를 상속받는 클래스에 속하면 true 반환됩니다.
		*/
		
		//재구현
		//Member 클래스로 다운캐스팅한 후 target 변수에 저장하게 된다.
		if(obj instanceof Member target) {
			
			//두 Mamber 객체 내부에 만들어져 있는 id 인스턴스변수값이 같으냐? 
			if(this.id.equals(target.id)){
				
				return true;
				
			} 
	
		}
		
		return false;
		
	} //equals
	
} //class Member

public class EqualsExample {
	public static void main(String[] args) {
		
		//Member 클래스 설계도 객체메모리 생성
		Member obj1 = new Member("blue"); //<----- 생성된 객체메모리 주소번지 0x1 라고 가정
		
		//Member 클래스 설계도 객체메모리 생성
		Member obj2 = new Member("blue"); //<----- 생성된 객체메모리 주소번지 0x2 라고 가정
		
		//Member 클래스 설계도 객체메모리 생성
		Member obj3 = new Member("red"); //<----- 생성된 객체메모리 주소번지 0x3 라고 가정
		
		if( obj1.equals(obj2) ) {
			System.out.println("두 Mamber객체의 id인스턴스변수에 저장된 문자열은 같습니다.");		
		}else {
			System.out.println("두 Mamber객체의 id인스턴스변수에 저장된 문자열은 다릅니다.");	
		}
		
		//출력결과
		//두 Mamber객체의 id인스턴스변수에 저장된 문자열은 같습니다.
		
		//-----------------------------------------------------------------------------------
		
		if( obj2.equals(obj3) ) {
			System.out.println("두 Mamber객체의 id인스턴스변수에 저장된 문자열은 같습니다.");		
		}else {
			System.out.println("두 Mamber객체의 id인스턴스변수에 저장된 문자열은 다릅니다.");	
		}	
		
		//출력결과
		//두 Mamber객체의 id인스턴스변수에 저장된 문자열은 다릅니다.

	}

}
