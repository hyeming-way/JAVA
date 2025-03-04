
public class ArrayUtils {
	
	//정수들이 저장될 1차원 배열메모리 주소 하나를 매개변수로 전달받아서
	//배열에 저장된 모든 값의 합을 계산한 후 반환하는 기능의 sum 메소드 정의
	public int sum(int[] arr) {
		
		int result1 = 0;
		
		for(int num : arr){	
			result1 += num;
		}
	
		return result1;
		
	}

	
	//실수들이 저장될 1차원 배열메모리 주소 하나를 매개변수로 전달받아서
	//배열에 저장된 모든 값의 합을 계산한 후 반환하는 기능의 sum 메소드 정의
	
	public double sum(double[] arr) {
		
		double result2 = 0.0;
		
		for(double num : arr){
			result2 += num;	
		}
		
		return result2;
		
	}
	
	//정수들이 저장될 1차원 배열메모리 주소하나를 매개변수로 전달받아서
	//배열에 저장된 정수들의 합을 계산해서 출력하는 기능의 printSum 메소드 정의
		//구현내용
		//sum 메소드를 호출하여 결과 출력
		//출력형식 "정수 배열의 합 : 숫자"
	public void printSum(int[] arr) {
		System.out.println("정수 배열의 합 :" + sum(arr));		
	}
	
	
	//실수들이 저장될 1차원 배열메모리 주소하나를 매개변수로 전달받아서
	//배열에 저장된 실수들의 합을 계산해서 출력하는 기능의 printSum 메소드 정의
		//구현내용
		//sum 메소드를 호출하여 결과 출력
		//출력형식 "실수 배열의 합 : 숫자"
	public void printSum(double[] arr) {	
		System.out.println("실수 배열의 합 :" + sum(arr));	
	}
	
	

	public static void main(String[] args) {
		//ArrayUtils 클래스의 객체메모리 생성, 참조변수명 : arrayUtils
		ArrayUtils arrayUtils = new ArrayUtils();
		
		//정수들 1,2,3,4,5가 저장된 1차원 배열 메모리 생성, 참조변수명 : intArray
		int[] intArray = {1,2,3,4,5};
		
		//실수들 1.5, 2.5, 3.5가 저장된 1차원 배열 메모리 생성, 참조변수명 : doubleArray
		double[] doubleArray = {1.5,2.5,3.5};
		
		//위 intArray참조변수에 저장된 배열메모리 내부의 모든 값의 합을 계산해서 출력하는
		//기능의 printSum메소드 호출
		//출력결과 -> "정수 배열의 합 : 15"
		arrayUtils.printSum(intArray);
		
		
		//위 doubleArray참조변수에 저장된 배열메모리 내부의 모든 값의 합을 계산해서 출력하는 기능의
		//printSum메소드 호출
		//출력결과 -> "실수 배열의 합 : 7.5"
		arrayUtils.printSum(doubleArray);
		
	}

}
