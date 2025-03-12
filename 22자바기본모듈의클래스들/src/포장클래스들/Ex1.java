
/*
  자바의 자료형의 종류 2가지 
  	1. 기본자료형 : byte, char, short, int, long, float, double, boolean
  	2. 참조자료형 : 참조변수를 만들기 위한 클래스자료형
  	
  포장클래스란(래퍼클래스란)?	
    - 기본자료형의 데이터를 객체메모리의 변수에 저장시킬떄 사용되는 클래스들
    - 기본자료형  8 개에 대응되는 래퍼클래스들을 제공 해줍니다.
    
      기본자료형					래퍼클래스
      byte						Byte
      char						Character
      short						Short
      int						Integer
      long						Long
      float						Float
      double					Double
      boolean					Boolean


    기본자료형의 데이터를 객체메모리의 변수에 저장시키는 이유?

	예)  showData(Object   obj) 메소드를 반드시 사용해야 할 상황인 경우
	
	 
	 	public static void showData(Object    obj){
	 	
	 		System.out.println(obj.toString());
	 	}
	 	
	  위 showData메소드를 통해서 출력해야하는 데이터가 정수3과 정수7이다.
	  이러한 상황에서 정수3과 정수7이 Object클래스를 상속하는 자식객체형태가 되어야만..
	  showData(Object obj) 메소드 호출시 전달인자로 전달될수 있습니다.
	  객체의 주소값을 전달받는 변수자리에 기본자료형 데이터를 전달해야할 셩우
	  기본자료형의 데이터를 래퍼클래스의 객체 메모리를 생성해서 변수에 저장한 후 
	  래퍼객체 자체의 주소를 매개변수 obj로 전달 해야합니다.
*/

//주제 :  기본자료형의 정수int 데이터를 저장시키기 위한  
//       래퍼클래스 Integer클래스 흉내내어 만들어보기 
package 포장클래스들;

//자바문법에서 제공해주는 Integer라는 이름의 래퍼(포장)클래스를 직접 흉내내어 만들어보자
class IntWrapper extends Object {
	
	private int num; //기본자료형의 정수데이터를 저장시킬 변수
					 //3 또는 7을 저장할 수 있습니다.
	
	//래퍼(포장)역할을 하는 IntWrapper 객체 생성시 호출되는 생성자
	public IntWrapper(int num) {
		this.num = num;
	}
	
	//Object 부모클래스의 toString()메소드 오버라이딩
	@Override
	public String toString() {
		//재구현 : num 인스턴스변수에 저장된 기본자료형의 값 3을 가져와 빈공백""과 합쳐서
		//		  하나의 문자열로 만들어서 반환
		return "" + this.num;
	}
	
}//class IntWrapper


public class Ex1 {
	
	//정수 3 또는 7을 매개변수로 전달받아 문자열형태로 출력해주는 기능의 static 메소드 만들기
	public static void showData(Object obj) {
		System.out.println(obj.toString());
	}
	
	public static void main(String[] args) {
		
		//래퍼(포장)Integar 클래스 역할을 하는
		//개발자가 직접 만든 위 IntWrapper 클래스의 객체 생성시
		//생성자를 호출해서 기본자료형 int 값 7을 저장
		IntWrapper intWrapper = new IntWrapper(7);
		
		//바로 위에 만든 showData 메소드 호출시
		//기본 자료형 값 7을 저장하고 있는 new IntWrapper 자식객체의 주소번지를
		//매개변수 Object obj로 전달하여 사용
		showData(intWrapper);
		//출력결과 : "7"
		
		//정수 3을 박스(IntWrapper 객체메모리)에 포장(저장)해서
		//박스(IntWrapper 객체메모리) 자체를 매개변수 Object obj로 전달하여 사용
		showData(new IntWrapper(3));
		//출력결과 : "3"

	}

}
