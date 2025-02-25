

//예제 : 1부터 5사이의 숫자들을 1씩 증가하면서 반복해서 출력

public class While01 {

	public static void main(String[] args) {
		
		for(int i=1; i<=5; i++) {
			
			System.out.print(i + " "); //1 2 3 4 5 
			
		}
		System.out.println("\n------------------------------");
		
		int i=1;
		
		while(i<=5) {
			
			System.out.print(i + " "); //1 2 3 4 5 
			
			i++;
			
		}

	}

}
