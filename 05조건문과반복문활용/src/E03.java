

//예제 : 구구단 2단부터 9단까지 반복해서 출력
public class E03 {

	public static void main(String[] args) {
		
		int i, y;
		int result = 0;
		
		for(i=2; i<=9; i++) {
			
			System.out.println("** " + i + " 단 **");
			
			for(y=1; y<=9; y++) {
				
				result = i*y;
				
				System.out.println(i + " * " + y + " = " + result);
				
			}
			
		}		

	}

}
