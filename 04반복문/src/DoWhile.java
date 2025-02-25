

//예제 : do while 반복문을 이용하여 1부터 5까지 1씩 증가하면서 5번 반복하여 i변수값 출력

public class DoWhile {

	public static void main(String[] args) {
		
		//초기식
		int i = 1;
		
		do {
			//한번 무조건 실행한 후 다시 조건식이 참일 경우 반복실행할 문장
			System.out.println(i);
			
			//증감식
			i++;
			
		}while(i<=5); //조건식
		
		/*
		  	출력결과
			1
			2
			3
			4
			5
		*/
		
	}

}
