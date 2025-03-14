

//주제 : Vector배열 메모리에 저장된 객체 얻기(검색)와 객체삭제

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest02 {
	public static void main(String[] args) {
		
		//기본생성자를 호출하여 생성된 백터배열은?
		//초기 용량(초기 칸의 갯수) : 10칸 공간을 가집니다.
		//증가량 : 저장 공간이 꽉 차면 2배로 늘어납니다.
		//		   예 ) 처음에 10칸이 꽉 차면 20칸 다시 꽉 차면 40칸으로 늘어납니다.
		Vector vector = new Vector();
		
		//백터 용량(칸의 갯수) 출력
		System.out.println( vector.capacity() ); //10
		
		//기본자료형 double 실수값들을 저장시킨 고정크기의 배열 6칸 생성
		double[] arr = new double[] {38.6, 9.2, 45.3, 6.1, 4.7, 1.6};
									//0     1     2    3    4    5
		
		//arr배열에 저장된 모든 실수 데이터들을 차례대로 반복해서 얻어
		//위 new로 선언한 Vector 가변길이 배열메모리에 차례대로 오토박싱하여 저장
		for(int i=0; i<arr.length; i++) {
			
			vector.add(arr[i]); //<--- 오토박싱되어 new Double(꺼내온실수); 객체들이 저장됨			
		}	
		
		System.out.println("Vector배열에 저장된 모든 객체들을 차례로 얻어 출력");
		for(int i=0; i<vector.size(); i++) {
			
			System.out.print(vector.get(i) + "  ");
			//"38.6  9.2  45.3  6.1  4.7  1.6  "			
		}
		
		System.out.println("-------------------------------------");
		
		//검색할 기본자료형의 데이터를 변수에 저장
		double searchData = 6.1;
		//searchData의 값을 오토박싱하여(객체로) 매개변수로 전달하여
		//vector에 저장된 객체 중 new Double(6.1)객체가 있다면 
		//저장된 index 위치번호를 int로 반환합니다. 없으면 -1을 반환합니다.
		int index = vector.indexOf(searchData);
		
		if(index != -1) {
			System.out.println("검색성공! " + index);
		}else {
			System.out.println("검색실패! " + index);
		}
		//검색성공! 3
		
		//참고. int indexOf(Object o)
		//	   전달인자로 준 객체를 배열의 앞 index 위치에서 부터 검색해서 찾습니다. 
		//	   만약 찾으면 찾은 객체의 index 번호를 반환, 없으면 -1을 반환합니다.
		
		
		//Vector 배열에 저장된 삭제할 데이터 변수에 저장
		double delData = 45.3;
		
		//참고.
		//boolean contains(Object obj)
		//-> Vector배열에 매개변수로 전달한 객체가 저장되어 있느냐?라고 물어보는 메소드로
		//   저장되어 있으면 true반환, 저장되어 있지 않으면 false를 반환 합니다.
		
		//Vector 배열에 new Double(45.3); 객체가 저장되어 있으면?
		if(vector.contains(delData)) {
			
			//저장되어 있기때문에 삭제하자
			//참고.  boolean remove(Object obj) 메소드
			//   -> 매개변수 obj로 전달한 객체를 Vector배열메모리에서 삭제한 후
			//       삭제에 성공하면 true반환 삭제에 실패하면 false반환
			boolean result = vector.remove(delData);
			
			if(result) {
				System.out.println("삭제성공");
			} else {
				System.out.println("삭제실패");
			}
			//삭제성공
			
		}
		
		System.out.println("삭제 후 Vector배열에 저장된 객체 모습 출력");
		
		System.out.println(vector.toString());
		//[38.6, 9.2, 6.1, 4.7, 1.6]
		
		System.out.println("삭제 후 백터의 용량 -> " + vector.capacity());
		//삭제 후 백터의 용량 -> 10
		
		//Vector의 elements 메소드를 호출하여
		//Enumeraction 인터페이스에서 제공해주는 메소드들을 활용하여
		//Vector에 저장된 요소(객체)들을 반복해서 차례로 얻어 출력
		
		//Vector배열의 elements메소드를 호출하면
		//Vector배열에 저장된 모든 Double객체들을 꺼내어서
		//Enumeration부모인터페이스를 구현한 자식 Enumeration배열메모리에
		//모두 저장한 후 자식 Enumeration배열메모리 자체를 반환	
		Enumeration enu = vector.elements();
		
		while (enu.hasMoreElements()) {
			
			System.out.print(enu.nextElement() + "  ");
			//38.6  9.2  6.1  4.7  1.6  	
		}

	}

}
