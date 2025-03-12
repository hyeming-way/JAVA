package 포장클래스들;

public class Ex4 {
	public static void main(String[] args) {
		
		//자동(오토)박싱, 자동(오토)언박싱
		// -> JDK 5버전 이후부터 나온 기술
		
		int n1 = 10; //<--- 기본자료형 값
		int n2;
		
		Integer num1;
		
		//수동박싱
		//방법2. Integer 래퍼클래스의 static 메소드 valueOf 메소드 사용
		num1 = Integer.valueOf(n1); 
		         //new Integer(10);
		//자동(오토)박싱
		num1 = n1;
			  //Integer.valueOf(n1);
		
		System.out.println("오토박싱");
		System.out.println("기본자료형 변수 n1 : " + n1);		
		System.out.println("참조자료형 변수 num1 : " + num1.toString());
		/*
			오토박싱
			기본자료형 변수 n1 : 10
			참조자료형 변수 num1 : 10
		
		*/
			
		//오토박싱
		Integer num3 = 10; //new Integer(10);
						   //또는
						   //Integer.valueOf(10);
						   //위와 같이 수동으로 박싱한 것과 같은 의미입니다.
		
		//오토언박싱
		int value = num3; //num3.intValue();
						  //위와 같이 수동으로 언박싱한 것과 같은 의미입니다.
	
//-----------------------------------------------------------------------------------
		
		//정수 10을 Integer 래퍼객체에 저장하기위한 오토박싱하기
		//참조변수 it
		Integer it = 10; //new Integer(10);
						 //Integer.valueOf(10);
		
		//오토박싱된 10을 문자열로 변환 후 반환받아 출력 후 줄바꿈
		//"10"
		System.out.println(it);
		//출력결과 : "10"

		//참조변수 it에 저장된 Integer 래퍼객체 내부에 저장된 정수 10을 오토언박싱해서
		//int a변수에 저장
		int a = it; //it.intValue();
		
		//int a변수에 저장된 10을 출력후 줄바꿈
		//10
		System.out.println(a);
		//출력결과 : 10
		
		//실수 double 3.14를 Double 래퍼객체에 저장하기 위해서 오토박싱하기
		//참조변수 du
		double du = 3.14; //new double(3.14);
						  //double.valueOf(3.14);
		
		//오토박싱된 3.14를 문자열로 변환후 반환받아 출력후 줄바꿈
		//"3.14"
		System.out.println(du);
		//출력결과 : "3.14"
		
		//오토언박싱하여 Double 래퍼객체에 저장되어있는 3.14를 오토언박싱을 통해 얻어
		//double b변수에 저장
		double b = du; //du.doubleValue;
		
		//double b변수에 저장된 값 출력후 줄바꿈
		//3.14
		System.out.println(b);
		//출력결과 : 3.14
		
		System.out.println("---------------------------------------------------");
		
		//주제 : 오토박싱과 오토언박싱을 통해서 산술연산 가능하게 해보기
		
		//오토박싱
		Integer c1 = 10;
		Integer c2 = 20;
		
		c1++;
/*
		기본자료형이 아닌데 어떻게 증감연산자를 사용할 수 있을까?
		
			순서1. c1참조변수가 참조하고 있는 new Integer(10); 객체메모리에서
				  기본자료형 값 int 10을 언박싱합니다.
				  c1.intValue(); -> 10 언박싱이 일어납니다.
					
			순서2. 10 + 1 -> 11로 만들어줍니다.
			
			순서3. 11을 new Integer(11);에 저장 (박싱이 일어남)
			
			순서4. c1 = new Integer(11); 주소를 저장
*/
		
		c2 += 3;
		
/*		
		c2 = new Integer( c2.intValue() + 3 );
		
		순서1. c2참조변수가 참조하고 있는 new Integer(20); 객체메모리에서
			  기본자료형 값 int 20을 언박싱합니다.
			  c2.intValue(); -> 20 언박싱이 일어남
		
		순서2. 20 + 3 -> 23으로 만들어줍니다.
		
		순서3. 23을 new Integer(23); 저장 -> 박싱이 일어남
		
		순서4. c2 = new Integer(23); 주소를 저장
		
*/		
		int addResult = c1 + c2; 
		//각각 c1, c2 참조변수가 사용하는 Integer 객체 내부의 정수 값을
		//오토언박싱된 후 + 연산하게 됩니다. ---> c1.intValue() + c2.intValue()
		
		System.out.println("addResult 변수값 : " + addResult);
		//출력결과
		//"addResult 변수값 : 34"
		
		int minResult = c1 - c2; //---> c1.intValue() - c2.intValue()
		System.out.println("minResult 변수값 : " + minResult);
		//출력결과
		//"minResult 변수값 : -12"
		
		
		//결론 : 자동으로 발생하는 오토박싱과 오토언박싱으로 인해서
		//		포장(래퍼)객체들에 저장된 기본자료형값끼리 산술연산이 가능하다
		
		
		
	}

}
