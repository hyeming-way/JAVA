
//예제 : 1부터 10사이의 짝수의 합과 홀수의 합을 각각 for문을 이용해 구해서 출력

public class E01 {

	public static void main(String[] args) {
		
		//두개의 for문을 제어할 제어변수 n선언
		int n;
		
		//홀수들의 합과 짝수들의 합을 각각 누적해서 저장시킬 변수 2개 선언
		int odd_tot, even_tot;
		
		//제어변수 n값이 짝수가 구해지도록하여 그 제어변수값을 누적해서 짝수의 합 구함
		for(even_tot=0, n=2; n<=10; n+=2) {
			
			even_tot += n; // 2+4+6+8+10 = 30
			
		}
		
		System.out.println("even_tot 변수값(2+4+6+8+10) = " + even_tot); 
		//even_tot 변수값(2+4+6+8+10) = 30
		
		
		
		//제어변수 n값이 홀수가 구해지도록하여 그 제어변수값을 누적해서 홀수의 합 구함
		for(odd_tot=0, n=1; n<=10; n+=2) {
			
			odd_tot += n; // 1+3+5+7+9 = 
			
		}
		
		System.out.println("odd_tot 변수값(1+3+5+7+9) = " + odd_tot); 
		//odd_tot 변수값(1+3+5+7+9) = 25		

	}

}
