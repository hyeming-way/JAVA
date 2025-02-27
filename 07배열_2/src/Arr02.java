

//예제 : 5개의 실수값 중에서 최대값 하나 구하기

public class Arr02 {

	public static void main(String[] args) {
		
		//double실수값들을 9.5, 7.0, 13.6, 7.5, 10.0을 초기값으로 갖는 data배열 생성
		double[] data = {9.5, 7.0, 13.6, 7.5, 10.0};
		
		//data배열에 최대값 하나를 최종 저장할 변수 max 선언
		double max;
		
		//for반복문을 수행하기전에 data배열에 0 index위치의 9.5를 꺼내서
		//max변수에 최대값으로 설정하기위해 저장
		max = data[0];
		
		//for반복문을 이용하여 5번반복하면서
		//1 index ~ 4 index 위치에 저장된 값(요소)를 반복해서 얻어서
		//max변수에 저장된 값보다 크면? max변수에 다시 저장 시킴
		for(int i=1; i<data.length; i++) {
			
			if(max < data[i]) {
				
				max = data[i];
				
			}
			
		}
		System.out.println("max = " + max);
		
		//출력형식
		//max = 13.6
		
		//결론
		// 이 예제는 배열의 첫번째 요소9.5를 최대값으로 먼저 max변수에 저장 해놓고
		// 나머지 요소들과 비교하여 최댓값을 찾아내는 구조로 되어 있는 예제 입니다.


	}

}
