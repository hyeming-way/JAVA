
//예제 : for문을 제어하는 제어변수값 반복해서 출력

public class For02 {

	public static void main(String[] args) {
		
		//for문을 제어할 제어변수 i선언
		int i;
		
		//i변수의 초기값을 1로 저장하여 1씩 증가시키면서 4가 될 때까지 4번 반복해서 i변수값 계속 출력
		for(i=1; i<=4; i++) {
			
			System.out.println(i);
			/*
				출력결과
				1
				2
				3
				4
			*/
			
		}
		System.out.println("---------->>" + i); //출력결과 : ---------->>5
	}

}
