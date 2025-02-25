

//예제 : 증가연산자 ++ 감소연산자 --의 선행처리와 후행처리

public class Opr08 {

	public static void main(String[] args) {
		
		int a=10, b=10;
		
		System.out.println(++a); //11
		System.out.println(a); //11
		//선위 증가 연산자로 변수에 1증가한 값 11을 출력하고, 11을 변수에 저장
		
		System.out.println(b++); //10
		System.out.println(b); //11
		//후위 증가 연산자로 10을 먼저 출력한 뒤 1증가한 값 11을 변수에 저장
		
		//a, b변수값 모두 10 저장하고싶다.
		a = b = 10;
		//b변수에 10을 저장하고,
		//a변수에 b변수에 저장된 10을 다시 저장.
		
		// a = 10, b = 10
		int c;
		
		c = ++a;
		//변수 a의 값을 1증가시켜 11이 되고, 그 값을 c에 대입
		
		System.out.println("c : " + c); //"c : 11"
		System.out.println("a : " + a); //"a : 11"
		
		// a = 11, b = 10, c = 11
		
		c = b++;
		
		System.out.println("c : " + c); //"c : 10"
		System.out.println("b : " + b); //"b : 11"
		
		// a = 11, b = 11, c = 10
		

	}

}
