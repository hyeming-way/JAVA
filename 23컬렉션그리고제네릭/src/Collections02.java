
/*

	ArrayList 클래스
	- 부모 List인터페이스를 구현한 자식클래스로 가변으로 늘어나는 배열메모리를 만들때 사용.
	
	- 내부적으로는 Object[] 배열을 사용하여 요소를 저장하며, 
	  배열의 크기가 부족할 때마다 자동으로 크기를 늘립니다. 
	  
	- 아래는 ArrayList의 메모리 구조를 그림으로 표현한 것입니다.
	
	+-------------------+
	|    ArrayList      |
	|-------------------|
	|  elementData: Object[] |  -> +---+---+---+---+---+
	|  size: int         |         |   |   |   |   |   |
	|  ...               |         +---+---+---+---+---+
	+-------------------+
	
	설명:
		1. ArrayList 객체:
	
			- elementData: 실제 데이터를 저장하는 Object[] 배열입니다.
	
			- size: 현재 ArrayList에 저장된 요소의 개수를 나타냅니다.
	
		2. elementData 배열:
	
			- ArrayList는 내부적으로 Object[] 배열을 사용하여 요소를 저장합니다.
	
			- 배열의 크기(capacity)는 ArrayList의 초기 용량 또는 자동으로 확장된 크기입니다.
	
			- size는 현재 저장된 요소의 개수를 나타내며, size <= capacity입니다.

*/

//주제 : List인터페이스를 구현한 자식ArrayList클래스의 배열메모리 만들기

import java.util.ArrayList;
import java.util.List;

public class Collections02 {
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList(); //기본용량(보통 10칸)의 Object[]배열이 생성됩니다.
		
		list.add("apple"); //<--- 오토박싱한 String 객체가 저장됨
		list.add("banana"); //<--- 오토박싱한 String 객체가 저장됨
		list.add("cherry"); //<--- 오토박싱한 String 객체가 저장됨
		
		//ArrayList 배열에 저장된 객체(요소)의 갯수 
		System.out.println("ArrayList배열메모리에 저장된 객체의 갯수 -> " + list.size());
		//출력결과 "ArrayList배열메모리에 저장된 객체의 갯수 -> 3"
		
		
		
		//초기용량 2칸의 Object[]배열이 생성
		ArrayList list2 = new ArrayList(2);
		
		list2.add("apple");
		list2.add("banana");
		list2.add("cherry"); //<--- 1칸이 늘어나면서 객체가 저장됨
		list2.add("apple"); //<--- 위에 만들어진 "apple" 객체와 별개로 하나의 객체가 별도로 생성됨
		list2.add("apple"); //<--- 위에 만들어진 "apple" 객체와 별개로 하나의 객체가 별도로 생성됨
		
		System.out.println(list2.toString());
		//출력결과 [apple, banana, cherry, apple, apple]
	
		
		
		//업캐스팅
		List list3 = new ArrayList(2);
		//배열이 꽉 차면 내부적으로 배열의 크기를 늘립니다. (일반적으로 현재 크기의 1.5배 늘림)
		
		list3.add(1); //<--- 오토박싱한 Integer 객체가 저장됨
		list3.add("안녕"); //<--- 오토박싱한 String 객체가 저장됨
		list3.add(true); //<--- 오토박싱한 Boolean 객체가 저장됨
		
		System.out.println("list3 배열메모리에 저장된 객체의 갯수 -> " + list3.size());
		//출력결과 : "list3 배열메모리에 저장된 객체의 갯수 -> 3"
		
		/*
		
			List부모인터페이스로 구현한 자식클래스배열의 객체(요소)는 위치(index)를 이용해서 접근합니다.
			List부모인터페이스는 List의 부모인 Collection인터페이스로 부터 상속되었으므로
			Collection인터페이스에서 제공하는 메소드들을 모두 사용할수 있으며 
			다음과 같은 메소드가 더 추가되었습니다.
		
			메소드 						설명
			int indexOf(Object o)      전달인자로 준 객체를 앞에서부터 찾아 해당 위치(index)를 반환함
									   찾지 못하면 -1을 반환함.
									   
			int lastIndexOf(Object o)  저장된 객체를 배열의 마지막 index위치부터 거꾸로 찾음
									    찾으면 해당 위치(index)를 반환하고 찾지 못하면 -1을 반환함
			
			E   get(int index)		   매개변수 index로전달한 index위치에 저장된 객체를 반환
			 						    
			E	set(int index,  E  element)   
									   매개변수 index로 전달한 index위치에 저장된 객체를
									   매개변수 E element로 전달한 객체로 대체 하는 메소드 
			void add(int index, E  element)
									   매개변수 index로 전달한 index위치에 
									   매개변수 E element로 전달한 객체를 저장합니다.
									   매개변수 index로 전달한 index위치에 저장된 기존의 객체는
									   뒤로 밀려나 그다음 index위치에 저장되게 됩니다.
			
			E   remove(int index)      매개변수 index로 전달한 index위치에 저장된 객체를 삭제후
									   삭제에  성공하면 true반환 삭제에 실패하면 false반환
									    
			boolean remove(Object o)   매개변수로 전달하는 객체를 삭제 하는메소드
									   삭제에 성공하면 true반환 삭제에 실패하면 false반환
		
	*/		
		
		
	}

}
