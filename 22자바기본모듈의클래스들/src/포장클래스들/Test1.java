package 포장클래스들;

//boolean 기본자료형 데이터 true 또는 false 저장시키기 위한
//Boolean 포장(래퍼)클래스 흉내내어 직접 만들어보기
//만들 포장(래퍼)클래스명 -> BooleanWrapper

class BooleanWrapper {
	
	private boolean power;
	
	public BooleanWrapper(boolean power) {
		this.power = power;
	}
	
	@Override
	public String toString() {
		return "" + power;
	}
	
}

public class Test1 {
	
	//boolean 기본자료형 데이터 true 또는 false 매개변수 Object obj로 받아서
	//문자열("true" 또는 "false")로 출력할 기능의 showData메소드를 static으로 만들기
	public static void showData(Object obj) {
		
		System.out.println(obj);
		
	}
	
	public static void main(String[] args) {
		
		//showData메소드 호출
		//포장(래퍼)역할을 하는 BooleanWrapper 객체메모리 생성 후
		//인스턴스변수 power에 true 저장한 상태로
		//BooleanWrapper 자식객체의 주소를 showData 메소드의
		//매개변수 Object obj로 전달!
		BooleanWrapper booleanWrapper = new BooleanWrapper(true);
		showData(booleanWrapper);
		//출력결과
		//"ture"
		
	}

}
