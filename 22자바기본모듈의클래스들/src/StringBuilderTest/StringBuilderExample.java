package StringBuilderTest;



public class StringBuilderExample {
	public static void main(String[] args) {
		
		StringBuilder data = new StringBuilder("ABC");
		
		//"ABC" + "DEF" 하나의 문자열로 합친
		//"ABCDEF" 문자열을 다시 기존 위 new StringBuilder 객체메모리에 저장한 후
		//기존에 만들어 놨던 StringBuilder 객체메모리 자체를 반환
		StringBuilder data2 = data.append("DEF");
		
		//data2 참조변수에 저장된 기존 new StringBuilder 객체메모리 내부에 저장된
		//"ABCDEF" 문자열을 꺼내서 String 객체메모리에 담아 String 객체메모리 자체를 반환
		System.out.println(data2.toString()); //.toSting() 생략가능
		//출력결과 : "ABCDEF"
		//          012345
		
		//data2참조변수에 저장된 new StringBuilder("ABCDEF")객체 메모리에 저장된
		//전체 문자열 "ABCDEF"중에서 3 index위치에 있는 문자 D를 삭제시킨~
		//"ABCEF" 문자열을 다시~ new StringBuilder객체 메모리에 저장후 ~
		//new StringBuilder("ABCEF")객체 메모리 자체를 반환합니다.
		//그런 후 ~  toString()메소드가 자동으로 호출되어 저장된 문자열 "ABCEF"를 반환받아 출력
		data2.delete(3, 4);
		System.out.println(data2.toString()); //.toSting() 생략가능
		//출력결과 : "ABCEF"
		
		//전체 저장된 문자열 "ABCEF"에서 0 index 위치에 G문자열을 대입해서 추가시키면
		//기존 0 index위치에 있던 문자 A가  1 index위치로 이동하고
	 	//그 뒤에 있던 문자가 차례로 1씩 index가 이동하여 저장된 전체 문자열 "GABCEF"의
		//StringBuilder객체 메모리 주소를 반환함
		StringBuilder data3 = data2.insert(0, "G");
		
		//StringBuilder객체 메모리에 저장된 문자열 꺼내어 반환후 출력
		System.out.println(data3);
		//출력결과 : "GABCEF"
		
		System.out.println("----------------------------------------");
		
		//메소드 체이닝 기법?
		//		. 도트연산자를 사용해서 메소드로부터 반환받은 객체의 메소드를 다시 호출하는 기법
		
		StringBuilder sb2 = new StringBuilder("안녕하세요").delete(0, 2).append(" 공부");
		System.out.println(sb2);
		//출력결과 : "하세요 공부"
		

		
		
		
	}

}
