

//예제 : 절대값 구하기 (음수이면 부호를 변경)
//절대값 구하는 프로그램 작성

public class If01 {

	public static void main(String[] args) {
		
		int num;
		num = -5;
		
		if(num < 0) {
			
			//num변수에 저장된 -5를 5로 만들어서 num변수에 저장
			
			//num = -5 * -1;
			num = -(num); //-(-5)이므로 부호가 변경된 5를 num변수에 저장
			
		}
		//-5의 절대값 5출력
		System.out.println("absolute num = " + num); //"absolute num = 5"
		
		//변수 num에 저장된 값이 0보다 작은 음수냐?
		if(num < 0) {
			
			num = -num;
			//조건식에 만족하지않으므로 실행문은 실행되지않습니다.
			
		}
		System.out.println("absolute num = " + num); //"absolute num = 5"

	}

}
