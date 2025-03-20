import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex5 {
	public static void main(String[] args) {
		
		//람다식, Stream API 활용
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6); //Integer 객체들이 저장된 고정크기 배열
		
		//스트림 통로 종류 크게 일반스트림(InputStream, OutputStream)과 
		//데이터스트림(컬렉션 배열에 저장된 객체가 흘러가는 통로)로 나뉜다
		

		List<Integer> eventNumbers = numbers.stream().filter( n -> n % 2 == 0 ) //2, 4, 6
		                                    .collect(Collectors.toList()); //최종연산 후 결과데이터 산출
		
		System.out.println(eventNumbers.toString()); //"[2, 4, 6]"

	}

}
