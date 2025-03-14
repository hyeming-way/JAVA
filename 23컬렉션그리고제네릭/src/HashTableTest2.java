

// 주제 : Map 부모인터페이스를 구현한 자식 HashTable 클래스로 배열 만들어 사용해보기
//		<>제너릭 기호를 사용하여 HashTableTest의 예제를 변경해보자

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableTest2 {
	public static void main(String[] args) {
		
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		
		hashtable.put("사과", "Apple");
		hashtable.put("딸기", "Strawberry");
		hashtable.put("포도", "Grapes");
		
		String value = hashtable.get("포도");
		
		if(value != null) {
			System.out.println("포도 key와 함께 연결되어 저장된 value -> " + value);
		}


		Enumeration<String> enumeration = hashtable.keys();
										//여기에 오브를 붙이지 않는 이유
										//hashtable 객체 생성시 <Strting, String>으로 설정했기 때문에
										//이 자리엔 String만 오게 되므로 <>를 붙이지 않아도 된다.
		
		while (enumeration.hasMoreElements()) {
			//1. Enumeration 배열에 저장되어 있는 key들을 차례대로 얻어 저장
			String key = enumeration.nextElement();
			
			//2.key들을 이용해 Hashtable 메모리에 저장된 value들을 차례대로 얻어 저장
			String var = hashtable.get(key);
										//"사과" -> "Apple"
			//3. Hashtable에 저장되어 있었던
			//   key - value 형태의 문자열로 반복해서 출력
			System.out.println(key + " - " + var);
			
		}
		
	}

}
