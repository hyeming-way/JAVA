

//예제. 1부터 5까지의 총합을 구해 출력
//1+2+3+4+5 -> 15
public class For06 {

	public static void main(String[] args) {
	
		//출력결과
		//"1부터 5까지의 합은 :15"
		
		int total=0;
		
		for(int i=1; i<=5; i++) {
			
			total += i;
			
		}
		
		System.out.println("1부터 5까지의 합은 : " + total); //출력결과 : "1부터 5까지의 합은 : 15"
		
	}

}
