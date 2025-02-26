
/*
문제. int타입의 변수 num 이 있을 때,
     각 자리의 합을 더한 결과를 출력하는 코드를 완성하라.
     만일 변수 num의 값이 12345라면 '1+2+3+4+5'의 결과인 15를 출력하라.
     (1)에 알맞은 코드를 넣으시오.
     
출력결과
15     
     
     [주의] 문자열로 변환하지 말고 숫자로만 처리 해야 한다.
     [힌트] 숫자의 마지막 자리를 어떻게 뽑아내는지만 알아내면 나머지는 쉽게 해결된다.
*/
public class test4 {
	public static void main(String[] args) {
		int num = 12345;
		int sum = 0;
		
		while(num>0) {
			
			sum += num%10;
			
			num = num/10;
			//num /= 10; <- 이렇게 써도 됨

		}
		
		System.out.println("sum="+sum);

	}

}
