
//주제 : 정해진 자료형(데이터)만 처리하는 클래스

class TestClass {
	
	private int member;
	
	public void setMember(int member) {
		this.member = member;
	}

	public int getMember() {
		return member;
	}

}

public class GenericTest01 {
	public static void main(String[] args) {
		
		TestClass obj01 = new TestClass();
		
		obj01.setMember(3); //int member = 3
		
		System.out.println("member인스턴스변수의 값을 반환받아 출력 : " + obj01.getMember());
		//member인스턴스변수의 값을 반환받아 출력 : 3
		
	//	obj01.setMember(3.4); //실제 메소드 호출시 전달되는 값이 실수자료형이면 에러 발생
		
	//	obj01.setMember("메롱"); //실제 메소드 호출시 전달되는 값이 문자열형이면 에러 발생
		

	}

}
