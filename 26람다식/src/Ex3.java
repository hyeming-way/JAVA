import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex3 {
	public static void main(String[] args) {
		/*
			1. 중간연산 
			
			filter(Predicate<T> predicate) 추상메소드
			
			  - 스트림의 각 요소에 대해 주어진 조건을 평가하며,
			    Predicate 함수형 인터페이스를 사용합니다.
			    Predicate 함수형 인터페이스는 boolean 값을 반환하는 test 추상메소드를 가지고 있음으로써
			    이 조건에 맞는 요소들만 다음 연산으로 넘깁니다.
			    
			  - filter 메소드는 여러번 체이닝 기법으로 호출할 수 있어
			    복잡한 조건을 단계적으로 나눠서 적용할 수도 있습니다.  
			  
		*/
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6); //ArrayList 고정크기 배열
																 //오토박싱에 의해 Integer 객체가 저장된 고정크기 배열
		//IntegerStream 입력스트림 통로 반환
		List<Integer> newNumbers = numbers.stream()
			    //스트림의 모든 요소에 대해 2보다 큰지 확인하고
				//조건을 만족하지 않는 요소들은 제외한 요소를 저장한 IntegerStream 통로 반호나
		       .filter( n -> n > 2 ) //3, 4, 5, 6
		       
		       //2의 배수만 IntegerStream통로에 남기고 IntegerStream통로 반환
		       .filter( n -> n % 2 == 0 ) //4, 6
		       
		       /*
		       		collect(Collerctor<T,A,R> collector)
		       		  - 메소드는 스트림의 결과를 리스트(list), 셋(Set) 또는 다른 컬렉션 배열에
		       		    수집해서 반환해줍니다.
		       */
		       .collect(Collectors.toList());
		
		System.out.println(newNumbers); //[4, 6]
		
		/*
			2. 중간연산
			
			map(Function<T,R> mapper) 메소드
			
			  - 이 메소드는 스트림의 각 객체(요소)를 변환할떄 사용됩니다.
			    주어진 함수에 따라 각 요소를 변환하며, 다른 형식으로 변환할수도 있습니다.
			    Function<T,R>인터페이스는 입력타입과 반환타입이 다른 함수형 인터페이스입니다.
		
		*/
		List<String> names = Arrays.asList("Alice", "Bob", "Chrlie"); //문자열객체들이 저장된 ArrayList 고정배열
		
		//각 문자열의 길이를 계산하여 새로운 리스트로 반환
		List<Integer> newLengths = names.stream()
										 .map(String::length) //각 문자열의 길이가 저장된 스트림
										 .collect(Collectors.toList()); //결과를 리스트에 담아 반환
		
		System.out.println(newLengths); //[5, 3, 6]
		
		
		/*	
			collect메소드
			- 스트림의 요소들을 특정 형식으로 수집하여, 결과를 새로운 컬렉션으로 반환함
			  즉, 스트림을 처리한 후 최종결과를 얻기 위해서 사용합니다.
			- collect메소드는 스트림의 종료연산을 수행하기 위한 종류중 하나의 메소드이다
			  
			Collectors클래스의 toList()
			  
			  1. Collectors클래스는 여러가지 형태로 데이터를 수집하기위한 유틸리티 클래스로
			     다양한 컬렉션으로 데이터를 수집할수 있는 메소드를 제공합니다
			  
			  2. toList()메소드는 스트림의 모든 요소를 ArrayList같은 리스트형태로 수집합니다
			     모든 데이터들을 List부모인터페이스 타입으로 변환해 ArrayList배열을 반환 해 줍니다.
		        	
		*/	

	}

}
