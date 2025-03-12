package 포장클래스들;

/*
	수동박싱 방법에는 다음과 같은 2가지 방법이 존재한다.
	
	방법1. 키워드 new 연산자를 이용한 일반적인 객체 생성 방법
		예) new Integer(10);
	
	방법2. 래퍼클래스가 제공해주는 static 메소드를 이용한 객체 생성 방법
		예) Integer.value.Of(10);
		
	
	예제 : 위 두가지방법으로 수동박싱 방법들의 차이점 살펴보기
*/

public class Test3 {
	public static void main(String[] args) {
			
		//수동박싱 방법1. new를 이용한 일반적인 객체생성방법 (메모리가 두 번 만들어짐)
		 	Integer iValue3 = new Integer(10);
		 	Integer iValue4 = new Integer(10);
		
		//두 iValue3, iValue4 참조변수가 사용하고 있는 Integer 객체메모리의 주소가 같은지 비교	
			if(iValue3 == iValue4) {
				System.out.println("iValue3과 iValue4는 동일한 하나의 객체메모리 참조");
			}else {
				System.out.println("iValue3과 iValue4는 각각의 다른 객체메모리 참조");
			}
			//출력결과 : "iValue3과 iValue4는 각각의 다른 객체메모리 참조" 	
		
			
			
		//수동박싱 방법2. static 메소드를 이용한 객체생성방법 (값이 같으면 메모리 한 번만 만들어짐)
			Integer iValue1 = Integer.valueOf(10);			
			Integer iValue2 = Integer.valueOf(10);
			
		//두 iValue1, iValue2 참조변수가 사용하고 있는 Integer 객체메모리의 주소가 같은지 비교
			if(iValue1 == iValue2) {
				System.out.println("iValue1과 iValue2는 동일한 하나의 객체메모리 참조");
			}else {
				System.out.println("iValue1과 iValue2는 각각의 다른 객체메모리 참조");
			}
			//출력결과 : "iValue1과 iValue2는 동일한 하나의 객체메모리 참조"	

			
			//-----------------------------------------------------
			
			//1번. 키워드 new를 이용한 일반적인 객체생성방법(박싱방법)
			// 과....
			//2번. static 메소드를 이용한 객체 생성방법 (박싱방법)
			//의 실행 결과를 보면.. 박싱방법의 차이점이 있는데..
			//두가지 박싱 방법중 어느것이 더 효율적인가요??
			//: ->   
			/*
				valueOf메소드는 객체생성요청으로 전달되는 값에 해당하는 객체가 이미 한번이라도 만들어진 상태라면
				새로운 객체를 생성하지 않고 기존에 생성된 객체의 주소값을 반환받아 사용합니다.
			*/
			
				
			//만약 두개중 하나의 방법이 효율적이라면 그이유를 쓰시오.
			//: ->
			/*
				new 연산자를 사용하는 래퍼객체 생성 방법은  각각의 객체메모리가 만들어지고 
				static메소드를 호출해서 래퍼객체 생성방법은 저장되는 기본값이 같으면 
				처음 만들어진 래퍼객체메모리를 
				재활용 하기 떄문에 static메소드를 호출해서 
				래퍼객체를 생성하는 방법이 더 효율적이다.
			*/
			
			
			
	}

}
