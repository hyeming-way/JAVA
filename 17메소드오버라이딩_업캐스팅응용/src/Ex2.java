
//예제 : 메소드 오버라이딩 예

//도형 설계도(클래스) - 부모클래스
class DObject {
	
	//부모클래스자료형 참조변수 선언?
	public DObject dObject;
	
	//생성자 - 위 DObject클래스자료형의 참조변수 dObject 초기화
	public DObject() {
		this.dObject = null;
	}
	
	//그림을 단순히 그리는 기능을 표현하는 메소드
	public void draw() {
		System.out.println("도형을 그린다.");
	}
	
} //DObject class

//-------------------------------------------------------------------------

//선을 그리기위한 자식클래스 선언
class Line extends DObject {
	
	//부모클래스의 draw메소드 재구현(오버라이딩)
	@Override //<-- 생략가능하지만 개발자가 쉽게 확인하기 위해서 적어줌
	public void draw() {
		System.out.println("선을 그린다.");
	}
	//참고. 메소드오버라이딩된 draw는 
	//     Line클래스로 객체를 생성해서 호출하면
	//     Dobject부모클래스의 메소드가 은닉(보호)되어 상속받지 못하게
	//     되기때문에 메소드 오버라이딩된 draw메소드가 호출되어 실행됨
	
}//Line class

//-------------------------------------------------------------------------

//원을 그리기위한 자식클래스 선언
class Circle extends DObject {
	
	@Override 
	public void draw() {
		System.out.println("원을 그린다.");
	}
	//참고. 메소드오버라이딩된 draw는 
	//     Circle클래스로 객체를 생성해서 호출하면
	//     Dobject부모클래스의 메소드가 은닉(보호)되어 상속받지 못하게
	//     되기때문에 메소드 오버라이딩된 draw메소드가 호출되어 실행됨	
	
} //Circle class


public class Ex2 {
	public static void main(String[] args) {
		
		//부모클래스 -> DObject
		//자식클래스 -> Line, Circle
		
		//1. Line 자식클래스의 객체메모리 생성
		Line line = new Line();
		line.draw(); //"선을 그린다." 오버라이딩된 메소드가 최종 실행
		
		//2. 업캐스팅을 해서 자식 Circle객체를 생성해서 사용하자
		//업캐스팅? 부모클래스자료형 참조변수에 자식객체메모리를 생성해서 주소번지를 저장
		DObject dObject = new Circle();
		dObject.draw(); //"원을 그린다."
		
 		//설명
 		//부모클래스(DObject)자료형 참조변수 dObject로
 		//draw()메소드 호출시
 		//참조변수 dObject는 DObject부모클래스자료형의 변수이므로 
 		//동작순서1. 먼저 은닉된 부모의 draw()메소드를 호출해서 찾고
 		//동작순서2. 부모의 draw()와 같은 이름의 메소드가
 		//        자식클래스에 있는지 검사후 찾아서
 		//        동적으로 바인딩되어 
 		//        오버라이딩된 자식의 draw()메소드가 자동으로 호출되어
 		//		   최종 실행됩니다.

	}

}
