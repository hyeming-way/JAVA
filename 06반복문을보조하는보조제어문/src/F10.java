//예제. break문의 사용예2
/*

 다중 반복문에서 break문이 사용되었을 경우에는 가장 근접한 반복문에서만 벗어난다
 
 그림
 	 바깥쪽 반복문(초기식; 조건식; 증감식){
 	 
 	 	안쪽 반복문(초기식; 조건식; 증감식){
 	 		
 	 		    break;
 	 		      |
 	 		      |
 	 	}         |
 	 			  |
 	           <---   안쪽 반복문 } 를 빠져 나감 
 	           
 	     코드;      
 	 }

   설명 
       만일 바깥쪽 반복문 밖으로 벗어나려면? 어떻게 해야 할까요?
       레이블을 사용해야 합니다
       break 다음에 레이블명을 기술하면 완전히 바깥쪽 반복문에서 벗어날수 있습니다.

*/
public class F10 {

	public static void main(String[] args) {
		
		//2개의 for문에서 사용될 제어변수 들
		int i, a;
		
		for(a=1; a<10; a++) {//바깥쪽 for
			
			for(i=1;  i<=10; i++) {//안쪽 for
				
				//i변수값이 3의 배수인 경우 안쪾 for 빠져나가자
				if(i % 3 == 0) { break; } //다중 for문에서 안쪽 for의 중괄호 {}만 빠져나감
				
				System.out.print(" i -> " + i);
			}//안쪽 for 닫기 
			
			//바깥쪽for문은 계속 반복되어 수행됩니다.
			System.out.println("\n a ->" + a);
		
		}//바깥 for 닫기
		
		System.out.println("-----------------------------\n");
		
		
		//레이블명을 exit_for:로 지정해 놓고
		exit_for:
			for(a=1;  a<10;  a++) {
			
				for(i=1; i<=10; i++) {
					
					if(i % 3 == 0) {
						//안쪽 for문 내에서 특정 조건에 만족하면
						//바깥쪽 for문 {} 중괄호 밖으로 벗어나기 위해서
						//break 레이블명;을 사용 합니다.
						break exit_for;
					}
					
					System.out.print(" i ->" + i);
				}//안쪽 for } 닫기 
						
				System.out.println("\n  a -> " + a);
			}//바깥 for } 닫기
		
		System.out.println("\n--------------------------");

	}

}








