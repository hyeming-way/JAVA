

// 주제 : Map 부모인터페이스를 구현한 자식 HashTable 클래스로 배열 만들어 사용해보기

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableTest {
	public static void main(String[] args) {
		
		//해쉬테이블 배열메모리에 데이터를 저장할때
		//(key-value)한쌍 형태로 묶어서 저장됩니다. 키, 값 모두 객체로 넣어야함.
		//인덱스 번호가 없으므로 값을 얻기 위해서는 key로 접근해야한다.
		Hashtable hashtable = new Hashtable();
		
		//해쉬테이블 배열메모리에 데이터(key-value)를 저장할때
		//put 메소드 사용
		//key, value 모두 객체형태로 넣습니다.
		//			   key,   value
		hashtable.put("사과", "Apple");
		hashtable.put("딸기", "Strawberry");
		hashtable.put("포도", "Grapes");
		
		
		
		//해쉬테이블 배열메모리에 저장된 데이터 중
		//value를 얻기 위해서는 get 메소드를 이용하자
		//Key를 get메소드의 매개변수로 전달하면
		//Key와 같이 한쌍으로 저장했던 value를 얻을 수 있다.
//		Object obj = hashtable.get("포도"); // <- get메소드는
										   //    부모Object클래스 자료형의 참조변수에 저장시킨
										   //    자식 value 객체를 반환해줍니다.
		
		//Object obj = "Grapes"; <--- 업캐스팅을 통해 저장 가능
		
		//다운캐스팅
//		String value = (String)obj;
		//			   (String)"Grapes";
		//String 메소드를 사용하려면 다운캐스팅을 해주어야함
		
		//위 업캐스팅/다운캐스팅의 코드 두 줄을 아래처럼 한 줄로 처리할 수 있음
		//업캐스팅이 일어나는 동시에 다운캐스팅해서 "Grapes"저장
		String value = (String)hashtable.get("포도");
		
		
		
		if(value != null) {
			System.out.println("포도 key와 함께 연결되어 저장된 value -> " + value);
		}
		//출력결과 "포도 key와 함께 연결되어 저장된 value -> Grapes"

		
		
		/*
			HashTable 배열에 저장된 모든 Key(객체)들을 일일이 기억하지못하므로
			모든 key(객체)들만 뽑아내서 Enumeration 배열에 담아
			Enumeration 배열 주소 자체를 반환
				-> keys() 메소드
		
		*/
		
		Enumeration enumeration = hashtable.keys();
								  //["사과", "딸기", "포도"]
		
		while (enumeration.hasMoreElements()) {
			//1. Enumeration 배열에 저장되어 있는 key들을 차례대로 얻어 저장
			String key = (String)enumeration.nextElement();
			
			//2.key들을 이용해 Hashtable 메모리에 저장된 value들을 차례대로 얻어 저장
			String var = (String)hashtable.get(key);
										//"사과" -> "Apple"
			//3. Hashtable에 저장되어 있었던
			//   key - value 형태의 문자열로 반복해서 출력
			System.out.println(key + " - " + var);
			/*
				출력결과
				딸기 - Strawberry
				사과 - Apple
				포도 - Grapes
			*/
			//HashTable은 값을 입력한 순서대로 저장되지않기때문에
			//출력문이 입력한 순서대로 나오지않는다.
			
		}
		
	}

}
