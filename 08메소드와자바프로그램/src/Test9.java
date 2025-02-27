
public class Test9 {
	
	//문제 : sumArray 메소드 정의
	// 정수들이 저장되어있는 배열메모리의 주소값을 매개변수로 받아서
	// 매개변수로 받은 배열 안의 모든 값을 더한 후 출력합니다.
	

	public static int sumArray(int[] Num) {
		
		int total = 0;
		
		for(int a : Num) {
			
			total += a;
			
		}
		
		return total;
		
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		int sum = 0;
		sum = sumArray(arr);
		System.out.println("배열의 총합 : " + sum);

		
		/*
			배열의 총합 : 15
		*/

	}

}
