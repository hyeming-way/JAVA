
/*
 문제. 아래의 다중 for문을 while문으로 변경 하시오.

출력결과
*
**
***
****
*****
******
*******
********
*********
**********
***********
*/
public class test2 {

	public static void main(String[] args) {
		
	/*	
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}//안쪽 for 닫기
			
			System.out.println();
		}//바깥 for 닫기
	*/	
		
		int i=0;
		
		while(i<=10) {
			
			int j=0;
			
			while(j<=i) {
				
				System.out.print("*");
				j++;
				
			}
			
			System.out.println();
			i++;
			
		}	
		
	}//main메소드 닫기

}//test2 class 닫기
