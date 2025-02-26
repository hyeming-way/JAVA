
//예제. break문의 사용예 1

//break문?
//반복문을 빠져나갈때 사용하는 보조제어문

public class F01 {
	public static void main(String[] args) {
		//1부터 10까지 자연수를 반복해서 출력
		//1 2 3 4 5 6 7 8 9 10
	
		int n; //for문에서 사용할 제어변수(초기식)
		
		for(n=1;  n<=10;  n++) {
			System.out.print(" " + n);
		}
		
		System.out.println();
		
		//1부터 10까지의 자연수를 반복해서 출력 시도 하되
		//제어변수 n변수의 값을 3으로 나누었을때 나머지가 0과 같으면?
		// 1  2 출력하고 for반복문을 벗어나자
		for(n=1; n<=10;  n++) {
		
			//n변수의 값이 3의 배수가 되면  for반복문의 중괄호 {} 완전히 벗어나기
			if(n % 3 == 0) {
				break;//for반복문 벗어남 
			}
			
			System.out.print(" " + n);
		}//for
		
		System.out.println("\n break에 의해 두번째 for()의 {}중괄호 빠져나옴");
		
		/*
		  - switch 문에서 벗어나고자 할때는 break문을 사용합니다
		    break문은 switch ~ case문 이외 for문과 같은 반복문에서도 사용합니다
		  - for문에서 반복처리를 하다가 break문을 만나면 반복문 밖으로 제어가 이동됩니다.
	
		*/
	}

}









