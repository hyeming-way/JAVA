

//예제 : 확장 대입 연산자 +=

public class Opr06_02 {

	public static void main(String[] args) {
		
		int a=10;
		
		System.out.println(a+10); //20 - 1번
		System.out.println(a); //10 - 2번
		
		a = a+10;
		
		System.out.println(a); //20 - 3번
		
		// a = 20
		
		a += 10;
		System.out.println(a); //30 - 4번
		

	}

}
