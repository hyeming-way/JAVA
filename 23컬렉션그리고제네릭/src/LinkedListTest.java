
//주제 : Queue 인터페이스를 구현한 자식 LinkedList 클래스에 대해 알아보고
//		List 인터페이스를 구현한 자식 LinkedList 클래스와 ArrayList 클래스의 차이점도 알아보자.

import java.util.Queue; //Queue 인터페이스
import java.util.LinkedList; //LinkedList 클래스
import java.util.List; //List 인터페이스
import java.util.ArrayList; //ArrayList 클래스


public class LinkedListTest {
	public static void main(String[] args) {
		
		//업캐스팅을 이용한 LinkedList 객체 생성
		Queue myQue = new LinkedList(); //터널과 같은 메모리 공간

		//boolean offer(E o) 위 LinkedList(터널) 공간에 객체를 넣는다.
		myQue.offer("1-자바");
		myQue.offer("2-C++");
		myQue.offer("3-API");
		myQue.offer("4-JSP");
		
		/*
			---------------------------------------------------
			입구 ->  "4-JSP", "3-API", "2-C++", "1-자바"   출구 ->
			---------------------------------------------------		
		*/
		
		//LinkedList(터널) 공간의 출구 방향의 문자열객체가 존재하면?
		while( myQue.peek() != null ) {
			
			//LinkedList(터널) 공간에서 "1-자바"문자열객체부터 꺼내옵니다. (터널에서 제거됨)
			System.out.println(myQue.poll());
			/*
				출력결과
				1-자바
				2-C++
				3-API
				4-JSP
			*/
			
			/*
				E poll() 메소드
				  - 큐에서 데이터를 꺼내옵니다. 만일 큐가 비어있다면 null을 반환함
				  	큐에서 꺼내온 데이터는 제거됩니다.
				  	
				E peek() 메소드
				  - 큐의 맨 나가는 곳에 위치한 객체를 반환합니다.
				    반환하는 객체는 큐공간에서 제거하지않습니다.
				    그리고 만약 큐가 비어있다면 null을 반환합니다.  	
			*/
		}	
		
		System.out.println("------------------------------------");	
		
		//List 인터페이스를 구현한 LinkedList 클래스와 ArrayList 클래스의 차이점을 알아보자.
		//  -> 정수값을 저장하는 ArrayList에 객체를 추가하고 제거하는 작업을 하자
		List<Integer> arrayList = new ArrayList<Integer>(2);
		
		//ArrayList배열에 Integer 객체(요소)들 추가
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(30);
		
		//ArrayList 배열에 추가된 Integer 객체들을 얻어 출력
		System.out.println("ArrayList");
			
		//확장(향상된) for 반복문 활용
		for( int i :arrayList ) {
			System.out.print(i + "  ");
		}
		/*
			출력결과
			ArrayList
			10  20  30
		*/
		
		System.out.println();
		
		//위 ArrayList배열에 저장된 Integer 객체 중에서 20 삭제 후 반환 받을 수 있음.
		arrayList.remove(1);
		
		System.out.println("ArrayList");
		for( int i :arrayList ) {
			System.out.print(i + "  ");
		}
		/*
			삭제 후 출력결과
			ArrayList
			10  30  
		*/	
		
		System.out.println();
		System.out.println("------------------------------------");
		
		//List 부모인터페이스를 구현한 자식 LinkedList 클래스의 객체 생성
		List<Integer> linkedList = new LinkedList<Integer>();
		/*
			[  헤더  ] ---> [  헤더  ] ---> [  헤더  ]
			[       ]      [       ]      [       ]
				0			   1			  2
		*/
		
		//LinkedList 가변길이 배열에 add 메소드를 사용해 40, 50, 60 추가
		linkedList.add(40);
		linkedList.add(50);
		linkedList.add(60);
		
		/*
			[  헤더  ] ---> [  헤더  ] ---> [  헤더  ]
			[  40   ]      [  50   ]      [   60  ]
				0			   1			  2
		*/
		
		//LinkedList 배열에 저장된 1 index 위치에 저장된 객체 50 하나 삭제
		linkedList.remove(1);
		/*
			[  헤더  ]  ---> [  헤더  ]
			[  40   ]       [   60  ]
				0		        1			
		*/
		
		for(int i : linkedList) {	
			System.out.print(i + "  ");			
		}
		//출력결과 : "40  60  "
		
		
		 /*
			 위 코드들을 실행하면 ArrayList와 LinkedList 배열에 객체를 추가하고 
			 제거하는 동작에서는 어떻게 다른지 확인할수 있는데.. 
			 ArrayList배열에 저장된 객체들을 제거하면
			 객체들이 각  다른 index위치 칸으로 이동이 발생하고
			 LinkedList배열은 링크(선)으로 연결되어 있기 때문에 
			 객체를 제거할때 링크만 수정됩니다.
		 */	
		
		
		//LinkedList와 ArrayList 삽입/삭제는 동일하나,
		//메모리 내부 구조가 다르다는 차이점이 있다.
		//즉, LinkedList는 객체를 만들면 객체의 주소가 생기게 되는데, 노드(link)마다 각기 객체의 주소를 서로 참조함으로서 연결 형태를 구성하는 것이다.
	
			
	}

}
