
/*
	Stack 클래스
	
	  - 스택메모리는 한 개 이상의 데이터를 저장할 수 있는 기억공간입니다.
	  
	  - 스택메모리는 Last In First Out(LIFO, 후입선출) 구조를 가집니다.
	  
	  - 메소드 종류
	  		
	  		pop() : 스택메모리의 맨위에 객체를 제거하고 그 객체를 반환하는 메소드
	  		
	  		push(E item) : 스택메모리의 맨위에 객체를 추가한다.
				 E - 반환타입이 결정되지않음
				 
			peek() : 스택메모리의 맨위에 있는 객체를 반환하지만, 이 객체를 스택메모리에서 제거하지 않는 메소드
			
			Boolean empty() : 현재 스택메모리 내부에 객체가 비어있느냐? 물어보는 메소드로
							  비어있으면 true, 비어있지않으면 false 반환 메소드
							  isEmpty()메소드와 같은 기능을 한다.						

*/

//Stack의 isEmply()메소드
//Stack메모리에 객체가 저장되어 있지 않느냐?라고 물어보는메소드로
//저장되어 있지 않으면 true반환, 저장되어 있으면 false반환  

import java.util.Stack;

public class StackTest01 {
	public static void main(String[] args) {
		
		Stack stack = new Stack();
		
		stack.push("1-자바");
		stack.push("2-자바스크립트");
		stack.push("3-API");
		stack.push("4-데이터베이스");

		//Stack 메모리 내부에 객체가 저장되어 있느냐? (내부에 객체가 비어있지않느냐?)
		while( !stack.isEmpty() ) {
			
			//Stack 메모리에 저장된 객체들을 역순으로 꺼내옵니다.
			System.out.println(stack.pop());
			/*
				출력결과
				4-데이터베이스
				3-API
				2-자바스크립트
				1-자바
			*/
			
		}
		
		//스택메모리 내부에 위 while 반복문 내부에서 pop 메소드를 이용해 모든 객체를 꺼내오고 삭제했으므로
		//스택메모리 내부에 객체가 저장되어있는지 확인
		System.out.println("메모리 내부가 비어있느냐? " + stack.isEmpty());
		//메모리 내부가 비어있느냐? true
		
		
		
		
		
	}

}
