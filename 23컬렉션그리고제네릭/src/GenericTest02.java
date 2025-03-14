
//주제 : 모든 자료형(데이터)만 처리하는 클래스

class TestClass1 {
	
	private Object member;
	
	public void setMember(Object member) {
		this.member = member;
	}

	public Object getMember() {
		return member;
	}

}

public class GenericTest02 {
	public static void main(String[] args) {
		
		TestClass1 obj01 = new TestClass1();
		
		obj01.setMember(3); //<--- 오토박싱되어 new Integer(3); 객체를 매개변수로 전달
		
		System.out.println("member인스턴스변수의 값을 반환받아 출력 : " + obj01.getMember());
		//member인스턴스변수의 값을 반환받아 출력 : 3
		
		obj01.setMember(3.4); //<--- 오토박싱되어 new Double(3.4); 객체를 매개변수로 전달
		System.out.println("member인스턴스변수의 값을 반환받아 출력 : " + obj01.getMember());
		//member인스턴스변수의 값을 반환받아 출력 : 3.4
		
		obj01.setMember("메롱"); //<--- 오토박싱되어 new String("메롱"); 객체를 매개변수로 전달
		System.out.println("member인스턴스변수의 값을 반환받아 출력 : " + obj01.getMember());
		//member인스턴스변수의 값을 반환받아 출력 : 메롱

		

	}

}
