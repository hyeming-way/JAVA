
/*
문제. 1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의
     총합을 구하시오. main메소드 내부에 코드를 작성해서
     출력결과가 73이 출력되도록 하시오.
 */
public class test1 {
	public static void main(String[] args) {
		
		int result=0;
		int i;
		
		for(i=1; i<=20; i++) {
			
			if(i % 2 != 0 && i % 3 != 0 ) {
				
				result += i;
				
			}
			
		}
		System.out.println(result);

	}

}
