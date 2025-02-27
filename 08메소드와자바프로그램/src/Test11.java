public class Test11 {
    
	// 문제: findSecondMax 메소드는 정수 배열을 입력받아 배열에서 두 번째로 큰 값을 찾아 출력해야 합니다.
    public static void findSecondMax(int[] numbers) {
        int max = numbers[0];       // 최댓값을 배열의 첫 번째 요소로 초기화
        int secondMax = numbers[0]; // 두 번째 최댓값도 초기에는 첫 번째 요소로 설정

        for (int i = 1; i < numbers.length; i++) { // 배열의 두 번째 요소부터 반복
            if (numbers[i] > max) {   
                secondMax = max;  // 기존 최댓값을 secondMax로 변경
                max = numbers[i]; // 새로운 최댓값을 max에 저장
            } else if (numbers[i] > secondMax && numbers[i] != max) {
                // 현재 값이 secondMax보다 크고, max와 다를 경우 secondMax 갱신
                secondMax = numbers[i]; 
            }
        }

        System.out.println("두 번째로 큰 값: " + secondMax); // 최종 결과 출력
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 9, 2, 9, 7, 3}; // 정수 배열 선언 및 초기화
        findSecondMax(arr); // 메소드 호출 -> 출력: 두 번째로 큰 값: 7
    }
}
