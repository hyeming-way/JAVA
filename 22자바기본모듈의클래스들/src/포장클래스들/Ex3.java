package 포장클래스들;



public class Ex3 {
	public static void main(String[] args) {
		
/*
	박싱?
	  -> 기본자료형의 데이터를 래퍼(포장)클래스의 객체메모리 내부에 저장시키는 것.
	
	박싱방법 2가지
	  1. 해당 기본자료형 데이터에 대응되는 래퍼(포장)클래스의 생성자를 호출해서 박싱하는 방법
	  		예) new Integer(10);
	  		
	  2. 해당 기본자료형 데이터에 대응되는 래퍼(포장)클래스에 만들어져있는 메소드를 사용해서 박싱하는 방법
	  		예) Integer.valueOf(10); 
*/		
		
		int n = 10; //기본자료형의 데이터
		
		//수동박싱
		//해석 : 10을 Integer 객체메모리에 저장하기 위해
		//	    Integer 클래스의 valueOf 메소드 호출시 매개변수로 10을 전달하면
		//	    10이 저장된 새로운 Integer 객체메모리의 주소를 반환해줍니다.
		Integer num = Integer.valueOf(n);
					 //new Integer(10);
		

		
/*		
	언박싱?
	  -> 래퍼(포장) 객체메모리 내부에 저장된 기본자료형의 값을 꺼내어 얻는 작업
	  
	언박싱방법
	  - 해당 래퍼(포장)객체 내부에서 제공해주는 인스턴스메소드를 호출해서 기본자료형의 값을 얻는다.
	  		예) new Integer(10).intValue(); 메소드를 호출해서 기본자료형의 값 10을 얻는다.
*/		
		
		//수동언박싱
		int value = num.intValue();
		
	
	}

}
