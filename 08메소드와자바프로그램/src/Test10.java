
public class Test10 {
    // 문제: countOccurrences 메소드는 정수 배열과 특정 숫자를 입력받아, 
    // 해당 숫자가 배열에 몇 번 등장하는지 세어 출력해야 합니다.
    public static void countOccurrences(int[] numbers,                int target) {
        int count = 0;					//{1, 3, 7, 3, 2, 3, 9, 3}           3

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                count++; // target과 같은 값이 나오면 개수 증가
            }
        }

        System.out.println(target + "의 등장 횟수: " + count + "회");
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 3, 2, 3, 9, 3};
        countOccurrences(arr, 3); // 출력: 3의 등장 횟수: 4회
    }
}






