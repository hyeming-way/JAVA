
// 예제 : 실수 형태의 자료형 저장하기

public class Data06 {

	public static void main(String[] args) {
		
	//	int a = (int)23.7; //캐스팅(강제형변환)작업을 해서 23.7 -> 23으로 변환하여 저장
		
		//그러나 자바에서는 실수형 데이터를 저장하기위한 변수메모리 만들 때 사용되는 
		//2가지 자료형을 제공해줍니다.
		
		//참고
		//	1. float : 4byte크기의 실수값 저장할 변수메모리 만들 자료형
		//	2. double : 8byte크기의 실수값 저장할 변수메모리 만들 자료형
		
	//	float b = 23.7; //23.7은 자바에서 23.7D로 인식하여 double변수(8byte)에 저장될 값으로 인식합니다.
		
		double c = 23.7;
		
		float d = 23.7f; //float자료형으로 선언된 변수 d에 float자료형 실수(4byte 변수 메모리에 저장된 실수값)에
						 //저장되게 하려면 접미사 f를 붙여서 실수값을 저장해야 합니다.
		
		System.out.println("c : " + c); //23.7 <-double c변수에 저장된 23.7D
		System.out.println("d : " + d); //23.7 <- float d변수에 저장된 23.7F		

	}

}
