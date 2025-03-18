

//주제 : 하나의 주(메인)스레드로 여러가지 작업을 하면 단점이 있다.

public class SingleThreadEx1 {
	
	//주(메인) 스레드
	public static void main(String[] args) {
		//System.currentTimeMillis()메소드
		//  -> 1970년 1월 1일 0시 0분 0초부터 현재까지 경과된 시간을
		//	   long값(1/10000초 단위값)으로 리턴
		
		//주(메인)스레드가 작업을 할 때 걸린 시간을 측정하기위해 일단 시작한 시간 저장
		long startTime = System.currentTimeMillis();
		
		//주(메인)스레드 작업1
		//10번 반복해서 1초 간격으로 *을 하나씩 출력
		for(int i=0; i<10; i++) {
			try {
				//1초 휴식
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//* 출력
			System.out.print("*");
		}
		
		//주(메인)스레드 작업1을 하는데 소요된 시간 구하기 : 
		//(* 을 10번 출력한 후의 현재시간 -  * 10번 출력하기전 작업1시간) / 1000
		System.out.println("주(메인)스레드 작업1의 소요된 시간 : " 
							+ (System.currentTimeMillis() - startTime) / 1000 + "초");
		
		//주(메인)스레드 작업2
		//10번 반복하여 1초 간격으로 #을 하나씩 출력하는 작업
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("#");
		}
		
		//주(메인)스레드 작업1,2을 모두 하는데 소요된 시간 구하기 : 
		//(* 을 10번 출력한 후의 현재시간 -  * 10번 출력하기전 작업1시간) / 1000
		System.out.println("주(메인)스레드 작업1,2의 소요된 시간 : " 
							+ (System.currentTimeMillis() - startTime) / 1000 + "초");

	}
	/*
		결론 : 주(메인)스레드(main메소드)는 하나이기때문에 싱글스레드라고 부른다.
		      싱글스레드하나로 2개의 작업을 하면  
		      하나의 작업을 모두 마친 후~ 그다음 작업을 해야하기 떄문에
		      그다음 작업을 하기 위해서는 그전의 작업을 모두 마쳐야 
		      그다음 작업을 할수 있는 단점이 있다
	*/
	

}
