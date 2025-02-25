

//예제 : for문을 한번만 사용해서 짝수의 합, 홀수의 합을 각각 구하기 위해
// for문 내부에 if문 사용하기

public class E02 {

	public static void main(String[] args) {
		
		int even_tot=0, odd_tot=0;
		int n;
		
		for(n=1; n<=10; n++) {
			
			if(n % 2 == 0) {
				
				even_tot += n;
				
			}else {odd_tot += n;}
				
		}
		System.out.println("even_tot변수값(2+4+6+8+10) = " + even_tot); //even_tot변수값(2+4+6+8+10) = 30
		System.out.println("odd_tot변수값(1+3+5+7+9) = " + odd_tot); //odd_tot변수값(1+3+5+7+9) = 25

	}

}
