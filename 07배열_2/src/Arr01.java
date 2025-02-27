
//예제 : 5명의 학생의 점수를 초기값으로 갖는 배열메모리를 생성한 후 
//점수의 총합을 구하고 평균을 구하는 예

public class Arr01 {

	//자바프로그램을 처음 실행하는 기능의 메소드(주 스레드)
	public static void main(String[] args) {
		
		//5명의 학생 점수들을 차례대로
		//95, 70, 80, 75, 100 점수들의 초기값을 갖는 score배열을 선언
		int[] score = {95, 70, 80, 75, 100};
		           //	0   1   2   3   4
		
		//점수의 총합을 구해 저장할 total변수 선언 후 0으로 초기화
		int total = 0;
		
		//for반복문을 이용하여 score배열에 각 점수를 차례로 얻어 total변수에 누적
		for(int i=0; i<score.length; i++) {
			
			total += score[i];
			
		}
		
		//점수들의 평균을 구해 avg변수 선언 후 저장
		//평균 = 총합 / 총갯수
		float avg;
		
		avg = total/score.length;
		
		/*
			출력형식
			Total = 420
			AVG = 84.0
		*/
		
		System.out.println("Total = " + total);
		System.out.println("AVG = " + avg);
		
	}

}
