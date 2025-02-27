public class Test12 { 
    // 문제: reverseArray 메소드는 정수 배열을 입력받아, 원본 배열을 뒤집은 새로운 배열을 반환해야 합니다.

    public static int[] reverseArray(int[] numbers) { 
        // 1. 원본 배열과 동일한 크기의 새로운 배열을 생성합니다.
        //    이 배열에는 뒤집힌 값들이 저장될 것입니다.
        int[] reversed = new int[numbers.length]; 

        // 2. 배열을 순회하며 값을 뒤집어 저장하는 과정입니다.
        //    i는 0부터 시작해서 배열 길이만큼 반복합니다.
        for (int i = 0; i < numbers.length; i++) { 
            // 3. 원본 배열의 마지막 요소부터 하나씩 가져와 새로운 배열에 저장합니다.
            //    numbers.length - 1 - i를 사용하여 끝에서부터 값을 가져옵니다.
            reversed[i] = numbers[numbers.length - 1 - i]; 
        }

        // 4. 뒤집힌 배열을 반환합니다.
        return reversed; 
    }

    public static void main(String[] args) { 
        // 5. 정수 배열을 선언하고 값을 저장합니다.
        //    이 배열이 원본 데이터가 됩니다.
        int[] arr = {1, 2, 3, 4, 5}; 

        // 6. reverseArray 메소드를 호출하여 arr 배열을 뒤집습니다.
        //    그리고 뒤집힌 결과를 result 배열에 저장합니다.
        int[] result = reverseArray(arr); 

        // 7. 뒤집힌 배열의 내용을 출력하는 과정입니다.
        System.out.print("뒤집힌 배열: "); 

        // 8. 향상된 for문을 사용하여 배열의 모든 값을 출력합니다.
        //    result 배열의 각 값을 하나씩 num에 저장하여 출력합니다.
        for (int num : result) { 
            System.out.print(num + " "); // 값을 공백과 함께 출력합니다.
        }
        // 출력 결과: 5 4 3 2 1
    }
}
