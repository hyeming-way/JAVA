package StringTest;

public class Ex2 {
	public static void main(String[] args) {
		
		/*
			String 클래스에 이미 만들어져 있어 제공하는 equals메소드, subString메소드
			
			public boolean equals(Object o)메소드
			-> 두 String 객체메모리 내부에 저장된 특정문자열이 같으냐?라고 물어보는 메소드로
			   같으면 true, 틀리면 false 반환하는 메소드
			   = 동등비교!
		*/
		
		System.out.println("다른 문자열 비교하기");
		
		String str1 = new String("Coffee");
		String str2 = new String("House");
		
		//위 두 객체메모리의 내부의 문자열이 같으냐?
		if(str1.equals(str2)) {
			System.out.println("각각의 String 객체메모리에 저장된 특정 문자열은 같다.");
		}else {
			System.out.println("각각의 String 객체메모리에 저장된 특정 문자열은 다르다.");
		}
		//출력결과 : 각각의 String 객체메모리에 저장된 특정 문자열은 다르다.
		
		
		
		String str3 = new String("House");
		
		if(str2.equals(str3)) {
			System.out.println("각각의 String 객체메모리에 저장된 House 문자열은 같다.");
		}else {
			System.out.println("각각의 String 객체메모리에 저장된 House 문자열은 다르다.");
		}
		//출력결과 : 각각의 String 객체메모리에 저장된 House 문자열은 같다.
		
		
		
		String str4 = "저장할문자열1";
		String str5 = "저장할문자열2";
		
		if( !(str4.equals(str5)) ) {
			System.out.println("다르다.");
		}else {
			System.out.println("같다.");
		}
		//출력결과 : 다르다.
		
		System.out.println("-------------------------------------------------");
		
		//String 객체메모리를 생성하는 동시에 "저장할문자열1" 특정문자열을 저장해놓고
		//String 객체메모리 하나 더 생성하는 동시에 "저장할문자열2" 특정문자열 저장 후
		//두 개의 문자열이 같으냐? 라고 물어볼때 아래와 같이 작성해도 된다.
		if("저장할문자열1".equals("저장할문자열2")) {
			System.out.println("같다.");
		}else {
			System.out.println("다르다.");
		}
		//출력결과 : 다르다.
		
		System.out.println("-------------------------------------------------");

/*
		subString메소드
		- String객체 내부에 저장된 전체 문자열 중에서
		  특정 index위치 사이에 있는 문자열을 잘라서 자른 문자열을 반환하는 메소드
		  
		 [메소드 오버로딩되어 만들어져 있는 subString메소드 2가지]
		  
		  String subString(int index,  int index2)
		  -> 첫번째 index매개변수로 전달한 index위치의 문자부터
		     두번째 index2매개변수로 전달한 index위치 이전 index위치의
		     문자열까지를 잘라서 문자열객체에 담아 문자열객체 자체를 반환합니다.
		     
		  String subString(int index)
		  -> 매개변수 index로 전달한 index위치에있는 문자부터~~~
		     끝 문자까지를 모두 잘라서 문자열객체에 담아 문자열객체 자체를 반환합니다	        
*/			
		
		System.out.println("전체 특정문자열에서 특정 index위치에 있는 문자열 잘라서 얻기");
		
		String a = new String("AndroidJSPJAVA");
		//                     0123456789   13
		
		//문자열 잘라서 저장할 변수들
		String temp1, temp2;
		
		temp2 = a.substring(7, 10);
		System.out.println(temp2.toString()); // <---- .toString() 생략가능
		//출력결과 : JSP
		
		temp1 = a.substring(7);
		System.out.println(temp1);
		//출력결과 : JSPJAVA
		
		System.out.println("-------------------------------------------------");
		
		/*
			String 클래스에서 제공해주는 trim(), concat()메소드
			
			trim()메소드
			  - 전체 문자열 중에서 양쪽 앞뒤 공백이 있으면 
			    모두 없앤 새로운 문자열을 새로운 문자열객체에 담아 반환해주는 메소드
			    
			concat()메소드
			  - 두개의 문자열을 하나로 합쳐 하나의 새로운 문자열을 문자열객체에 담아 반환해주는 메소드   
		*/
		
		System.out.println("전체 문자열의 양쪽 공백을 제거한 문자열 얻기");
		
		String b = new String("       JA  VA      ");
		String temp3 = b.trim();
		System.out.println("temp3변수[" + temp3 + "]");
		//출력결과 : temp3변수[JA  VA]
		
		System.out.println("concat메소드를 호출하여 두 문자열을 하나로 합쳐 얻기");
		//Stritn concat(String s)메소드
		// - 기준이 되는 문자열과 매개변수 s로 전달되는 문자열을 하나로 연결해 합친 새로운 문자열 객체를 반환
		String c = "JAVA";
		String d = new String("PG");
		
		String temp4, temp5;
		
		temp4 = c.concat(d);
		System.out.println("temp4변수[" + temp4 + "]");
		//출력결과 : temp4변수[JAVAPG]
		
		temp5 = c + d; //<--- 이 방법을 더 추천
		System.out.println("temp5변수[" + temp5 + "]");
		//출력결과 : temp5변수[JAVAPG]
		
		System.out.println("-------------------------------------------------");
	
		/*
		  String 클래스에서 제공해주는 contains메소드, replace메소드
		  
		  1.  public boolean contains(CharSequence  s)
		      
		      - 전체 문자열 중에서 매개변수s로 전달 하는 문자열이 있으면?
		        true반환, 없으면 false 반환 하는 메소드 
		*/
		
		String e = new String("필요없는문자열해당문자열필요없는문자열");
		
		boolean result = e.contains("해당문자열");
		System.out.println("해당문자열 <- 포함되어있느냐? " + result);
		//출력결과 : 해당문자열 <- 포함되어있느냐? true
		
		result = e.contains("JAVA");
		System.out.println("JAVA <- 포함되어있느냐? " + result);
		//출력결과 : JAVA <- 포함되어있느냐? false
		/*
		결론 : 매개변수로 CharSequence클래스인데 사용법은 String처럼 사용하면됨.
			  -> 아무리 긴문자열에도 우리가 원하는 문자열 단어가 있는지 없는지 찾을수 있다.
		*/	
		
		//--------------------------------------------------------------------------
		/*
		 2. public String replace메소드 
		    -> 전체문자열에서 원하는 문자열을 찾아 치환한 후 
		       치환된 전체 문자열을 반환해주는 메소드 
		    -> 메소드 오버로딩 되어 있다
		    
		       public String replace(char oldChar, char newChar)
				-> 문자 단위로 치환 후 수정된 전체문자열을 반환
				
			   public String replace(charSequence target, charSequence replacement)
			   ->  문자열 단위로 치환 후 수정된 전체문자열을 반환 	
		*/		
		String f = new String("JAVAJSPC");
		
		//위 문자열중에서 "C" -> "!"로 치환(변경)한 후
		//변경된 전체문자열 "JAVAJSP!"을 반환합니다.
		
		String result2 = f.replace("C", "!");
		System.out.println("문자 단위로 변경시킨 새로운 전체 문자열=> " +result2);
		//출력결과 : 문자 단위로 변경시킨 새로운 전체 문자열=> JAVAJSP!
		
		//"JAVAJSPC" 전체문자열 중에서 "JSPC"문자열 부분을
		//"PROGRAMMING"문자열로 치환(변경)한 후
		//변경된 전체문자열 "JAVAPROGRAMMING"을 만들어 반환후 result2에 다시 저장
		result2 = f.replace("JSPC", "PROGRAMMING");
		System.out.println("문자열 단위로 변경시킨 새로운 전체 문자열=> " +result2);
		//출력결과 : 문자열 단위로 변경시킨 새로운 전체 문자열=> JAVAPROGRAMMING
		
		System.out.println("-------------------------------------------------");
		/*
		String클래스에서 제공해주는 toLowerCase메소드, toUpperCase메소드,
							   valueOf메소드
							   
		1. public String toLowerCase()
			-> 전체문자열을 각문자들을 모두 소문자로 변경한 후 
			   변경된 전체문자열을 반환 하는 메소드 
		 */	
		
		String lowedStr = "Hello World".toLowerCase();
		System.out.println(lowedStr);
		//출력결과 : hello world
		/*
		  2. public String toUpperCase()
		   -> 전체 문자열에서 각문자들을 모두 대문자로 변경한 후 
		      변경된 전체문자열을 반환 하는 메소드 
		*/								  //"HELLO WORLD"
		
		System.out.println("hello world".toUpperCase());
		//출력결과 : HELLO WORLD
	    /*
	     3. public static String valueOf(int num)
	    	-> 매개변수 num으로 숫자 하나를 집어 넣으면
	    	   그 숫자를 문자열로 변경한 후  변경된 문자열 자체를 반환
	    */	
		
		int num = 10;
		String str10 = String.valueOf(num);
		System.out.println(str10);
		//출력결과 : "10"
		

		
	}

}
