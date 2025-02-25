

//예제 : 1부터 10사이의 짝수들의 총 합 30을 구해 출력
// 2+4+6+8+10 = 30

public class While02 {

	public static void main(String[] args) {
		
		int i=1;
		int tot = 0;
		
		while(i<=10) {
			
			if(i % 2 == 0) {
				
				tot += i;
				
			}
			
			i++;
			
		}
		System.out.println("tot = " + tot); //출력결과 : tot = 30

	}

}
