

//예제 : 1차원의 배열메모리에 데이터를 직접 초기화하는 동시에 배열메모리를 만드는 방법
public class G02 {

	public static void main(String[] args) {
		
	//방법2. 배열에 데이터를 직접 초기화(처음 저장시키는 것)하는 동시에 배열메모리 생성 문법
		//자료형[] 변수명 = {값1, 값2, 값3};
		
		//자료형 []변수명 = {값1, 값2, 값3};
		
		//자료형[] 변수명 = new 자료형[]{값1, 값2, 값3};
		
		
		
		//각 달의 날짜수(정수)를 초기값으로 갖는 배열메모리 생성
		int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
					// 0    1   2   3   4  5    6   7   8   9   10  11
		
		//1~12월까지 12번 반복해서 for문으로 꺼내어서 출력
		for(int i=0; i<12; i++) {
			
			System.out.println( (i+1) + "month =>" + month[i]);
			
			/*
			 	출력결과
			 	1month =>31
				2month =>28
				3month =>31
				4month =>30
				5month =>31
				6month =>30
				7month =>31
				8month =>31
				9month =>30
				10month =>31
				11month =>30
				12month =>31
			 */
			
		}
		
	}

}
