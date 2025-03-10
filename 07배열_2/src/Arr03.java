
//예제 : 2차원 배열 전체 메모리를 선언한 후
//배열의 원소(칸)에 요소(값)를 대입하고,
//요소(값)를 얻어 출력하는 자바프로그램

public class Arr03 {

	public static void main(String[] args) {
		
	//2차원 표형태의 배열메모리 생성문법
		//자료형[][] 배열명 = new 자료형[행갯수][열갯수];
		
	//정수값을 저장시킬 5행 3열 15칸의 2차원 배열 메모리 생성
		int[][] score = new int[5][3];
		
	//2차원 배열 초기화 문법
		//배열명[행위치][행에대한열위치] = 저장할값;
		
	//행에 대한 열의 위치를 index로 지정하여 값 대입
		score[0][0] = 10;	score[0][1]=90;		score[0][2]=70;
		score[1][0] = 60;	score[1][1]=80;		score[1][2]=65;
		score[2][0] = 55;	score[2][1]=60;		score[2][2]=85;
		score[3][0] = 90;	score[3][1]=75;		score[3][2]=95;
		score[4][0] = 60;	score[4][1]=30;		score[4][2]=80;
		
	//다중 for반복문을 이용해 2차원 배열에 각원소(각칸)에 저장된 원소(값)을 꺼내어 출력
		
		for(int row=0; row<5; row++) { //행의 갯수만큼 반복
			
			for(int col=0; col<3; col++) { //행에대한 열의 갯수만큼 반복
				
				System.out.print(" " + score[row][col]);
				
			}
			System.out.println();
			
			/*
				 출력결과
				 10 90 70
				 60 80 65
				 55 60 85
				 90 75 95
				 60 30 80
			*/
		}

	}

}
