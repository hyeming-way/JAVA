package 연습문제;

/*
	문제 : 배열 arr에 담긴 모든 값을 더하는 프로그램을 완성하시오.
		   즉 (1)영역에 들어갈 코드를 작성하시오.
		   
	출력결과
	sum=150
*/

public class test7 {

	public static void main(String[] args) {
		
		int[] arr = {10,20,30,40,50};
				  //  0  1  2  3  4
		
		int sum=0;
		
		//(1)
		for(int i=0; i<5; i++) {
			
			sum += arr[i];
			
		}
		
		/*
		<향상된 for문>
		
		for(배열에서차례대로 꺼내어서 저장할 변수 선언 : 배열){
		
			위 변수에서 받은 값을 반복해서 사용
			
		}
		
		향상된 for문은 배열에 저장된 값의 갯수만큼 차례대로 꺼내어서 반복실행할 문장을 수행하는 반복문입니다.
		for(int number : arr){
		
			sum += number;
			
			10,20,30,40,50을 차례대로 꺼내 number에 저장. 
			number에 저장된 값을 sum에 누적
		
		}
		*/	
				
		System.out.println("sum=" + sum);
		
	}

}
