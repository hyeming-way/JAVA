package 연습문제;

/*
 	문제 : 다음은 배열을 선언하거나 초기화한것이다.
 		  잘못된 것을 고르고 그 이유를 작성하시오. 4, 5
 		  
 		  1. int[] arr[];	올바른구문
 		  
 		   	 풀이 : 2차원배열 주소를 담을 참조변수를 선언할때
 		   	 int[][] arr;	가능
 		   	 int[] arr[];	가능
 		   	 int arr[][];	가능
 		  
 		  
 		  
 		  2. int[] arr = {1,2,3,};	올바른구문
 		  	 
 		  	 풀이 : 마지막의 쉼표, 는 있어도 상관없음
 		  	 
 		  	 
 		  
 		  3. int[] arr = new int[5];	올바른구문
 		  
 		  
 		  
 		  4. int[] arr = new int[5]{1,2,3,4,5};		잘못된구문
 		  	 
 		  	 풀이 : 두번째 대괄호[5]에 숫자를 넣으면 안 됨
 		  	       두번째 대괄호는 []안에 배열의 크기를 지정할 수 없음
 		  	       중괄호 {}안의 데이터의 갯수에 따라 자동적으로 배열의 크기(칸수)가 결정되기 때문
 		  
 		  
 		  
 		  5. int arr[5];	잘못된구문
 		  
 		  	 풀이 : 배열메모리의 주소를 담을 참조변수 arr선언에 배열크기 지정할 수 없음
 		  
 		  
 		  
 		  6. int[] arr[] = new int[3][];	올바른구문
 		  
  
 */

public class test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
