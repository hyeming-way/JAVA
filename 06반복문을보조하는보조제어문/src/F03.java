
//예제. while반복문을 이용한 무한 루프 

/*
  while(true){
  
  	조건식 자리에 true가 존재하면 무한 실행될 반복코드;
  
  }


  while문은 조건식의 결과가 참이면 반복을 계속하고
  거짓이면 반복문을 벗어납니다
  while문을 이용한 무한 루프는 일반적으로 조건식자리에 true를 기술하여
  표현합니다.
*/

public class F03 {

	public static void main(String[] args) {
	
		//초기식
		int n = 0;
		
		while(true) {//무한 반복해서 실행문을 실행함
			
			System.out.println("Fall Wonderland");
			
			if(++n  >= 10) {
				break; //while반복문 벗어남
			}
		}
		System.out.println("The End");
	}

}
/*
Fall Wonderland
Fall Wonderland
Fall Wonderland
Fall Wonderland
Fall Wonderland
Fall Wonderland
Fall Wonderland
Fall Wonderland
Fall Wonderland
Fall Wonderland
The End
*/




