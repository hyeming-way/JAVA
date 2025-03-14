
//주제 : Object자료형으로 변수나 메소드의 반환타입을 사용하면
//		단점(업캐스팅, 다운캐스팅)이 있다.

class TestClass2 {
	
	private Object member;
	
	public void setMember(Object member) {
		this.member = member;
	}

	public Object getMember() {
		return member;
	}

}

public class GenericTest03 {
	public static void main(String[] args) {
		
		TestClass2 obj01 = new TestClass2();
		
		obj01.setMember("apple");
		
					//"apple" 문자열 자식객체의 주소를 
					//부모 Object클래스의 참조변수에 저장할 객체로 반환받는다.
		Object obj = obj01.getMember(); //업캐스팅이 일어나 "apple" 자식 문자열 객체가 저장됨
	
	//	obj.toUpperCase(); <--String 클래스에 만들어 놓은 메소드 호출 불가
	//						  Object 클래스에는 toUpperCase()메소드가 만들어져 있지 않음
		
		//다운캐스팅하여 toUpperCase 메소드 호출 가능
		String temp = (String)obj;
		
		System.out.println(temp.toUpperCase());
		//APPLE

	}

}
