
/*
 문제. 두 개의 주사위를 던졌을 때, 
      눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을 
      main메소드 내부에 다중for 소스를 작성하시오.
 
 출력결과
 1+5=6
 2+4=6
 3+3=6
 4+2=6
 5+1=6
 
 */
public class test3 {
	public static void main(String[] args) {
		
		for(int i=1; i<=6; i++) {
			
			for(int j=1; j<=6; j++) {
				
				if(i+j == 6) {
					System.out.println(i + "+" + j + "=" + (i+j));
				}
				
			}
			
		}

	}

}
