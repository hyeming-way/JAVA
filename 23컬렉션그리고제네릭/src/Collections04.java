

import java.util.ArrayList;
//주제 : List부모인터페이스의 자식 ArrayList가변길이 배열에
//		저장된 객체(요소)를 index 위치번호로 접근하여 꺼내와서 사용하는 예제

public class Collections04 {
	public static void main(String[] args) {
		
		//가변으로 늘어나는 배열공간인 ArrayList클래스의 객체 생성
		ArrayList list = new ArrayList(6);
		
		list.add("하나");
		list.add(new Integer(2));
		list.add(new Double(3.42));
		list.add("넷");
		list.add("five");
		list.add(6);
		
		//참고. ArrayList가변으로 늘어나는 배열메모리의 특정 index 위치에
		//	   저장된 객체를 꺼내올때 사용되는 메소드
		//	   ->	E	    get(int index)
		//	   ->	Object	get(int index)
		
		
		 //일반 for반복문을 이용하여 ArrayList가변길이 배열에 저장된
		 //객체의 갯수만큼 반복하여 
		 //0 index위치에 저장된 객체부터 ~~~ 5 index위치에 저장된 객체까지
		 //index위치번호를 1씩 증가하면서 객체들을 반복해 꺼내와 출력
		for(int i=0; i<list.size(); i++) {
			//참고. ArrayList가변으로 늘어나는 배열메모리에 저장된 객체의 총 갯수를
			//	   정수값으로 얻을때 사용되는 메소드
			//	   -> int size()
			
			System.out.println(i + "번째 index칸에 저작된 객체는? " + list.get(i));
			/*
				출력결과
				0번째 index칸에 저작된 객체는? 하나
				1번째 index칸에 저작된 객체는? 2
				2번째 index칸에 저작된 객체는? 3.42
				3번째 index칸에 저작된 객체는? 넷
				4번째 index칸에 저작된 객체는? five
				5번째 index칸에 저작된 객체는? 6
			*/		
		}
		
		System.out.println("-------------------------------------");
		
		//향상된 for 반복문을 이용해 ArrayList 가변길이 배열에 저장된
		//객체(요소)들을 순서대로 얻어 출력
		
		for( Object i : list ) {
			
			System.out.print("[" + i + "] ");
			//출력결과
			//[하나] [2] [3.42] [넷] [five] [6] 
			
		}


	}

}
