import java.sql.ResultSet;
import java.util.Comparator;

public class Ex6 {
	public static void main(String[] args) {
		
/*	
		Comparator.reversOrder()는 Comparator<T>타입의 객체를 반환하며
		이객체는 두 값을 비교할때 사용하는 compare(값1,값2)메소드를 제공합니다.
		
		compare(A,B) 메소드에서
		   A.comare(B)의 결과를 뒤집어 반환합니다.
		   즉! 만약 A.compareTo(B)가 양수라면, 
		   reverseOrder()는 음수를 반환하여 내림차순으로 정렬합니다
		   
		   A.compare(B)가 음수라면,
		   reverseOrder()는 양수를 반환하여 내림차순으로 정렬합니다
		   
		   A.compare(B)가 0이면
		   동일하므로 0을 반환합니다.
		   
*/	
		
		Comparator<Integer> reComparator = Comparator.reverseOrder();
		
		int reuslt1 = reComparator.compare(10, 20);
		//20이 더 크므로 원래는 음수 -1를 반환받는데
		//-> reversOrder()호출하여 거꾸로 판단하는 객체를 반환받아서 사용하기때문에
		//양수 1을 반환합니다.
		System.out.println(reuslt1); //1
		
		int result2 = reComparator.compare(20, 10);
		System.out.println(result2); //-1
		
		int result3 = reComparator.compare(10, 10);
		System.out.println(result3); //0
	
	}

}
