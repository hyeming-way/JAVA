import java.util.List;
import java.util.Vector;

/*
	주제 : Vector객체 생성시 <>오브라는 기호와 함께 
	      String제네릭타입을 지정하여 
	      객체를 생성함으로써  Vector에 저장되는 객체를 String객체만 저장되기 떄문에
	      Vector의 get메소드를 호출하면 반환타입은 String으로 변경되서
	      업캐스팅과 다운캐스팅을 하지 않아도 되는 예
*/

public class Collections06 {
	public static void main(String[] args) {
		
		//업캐스팅을 하여 Vector 배열 생성
		//  - Vector 배열메모리를 생성할때 <>오브라는 기호와 함께 String 제네릭자료형을 함께 기술하면
		//    Vector 클래스 내부에 E라고 적혀있던 아직 결정되지않은 변수, 메소드의 매개변수 타입(자료형)이
		//    String 제네릭자료형으로 변경(결정)되어 모두 바뀌게 됩니다.
		List<String> vector = new Vector<String>();
		
		vector.add("Apple");
		vector.add("banana");
		vector.add("oRANGE");
		
		String temp;
		
		//일반 for 반복을 이용해 Vector 배열메모리에 저장된 문자열 객체들을 하나씩 얻어 출력
		for(int i=0; i<vector.size(); i++) {
			
			temp = vector.get(i); //위 <String>오브기호로 Vector 배열을 생성했기때문에
								  //Vector 클래스 내부에 get 메소드의 반환타입 또한 String으로 변경됩니다.
								  //다운캐스팅을 하지않아도 String temp 변수에 꺼낸 문자열객체 저장가능
			
			System.out.println(temp.toUpperCase());
			
		}
		
		
		System.out.println();
		
		//확장(향상된) for 반복문을 이용해 Vector 배열메모리에 저장된 문자열객체들을 하나씩 출력
		for (String str : vector) {
			System.out.println(str.toUpperCase());
		}
		
		/*
			출력결과
			APPLE
			BANANA
			ORANGE
		*/
			
		//get()와 toUpperCase() 사용을 위한 업캐스팅/다운캐스팅 없이
		//제너릭자료형을 String으로 설정하면 get()메소드를 사용하지않아도 되고,
		//toUpperCase()도 바로 사용이 가능하다.		

	}

}
