
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex2 {
	public static void main(String[] args) {
		
		//Arrays.asList()메소드는 제공된 배열의 요소들을 포함하는 고정 크기의
		//ArrayList배열을 생성해서 반환해줌
		//반환된 ArrayList는 인스턴스이지만, 고정 크기의 리스트로 다룰 수 있으며
		//요소(객체)의 추가나 삭제는 허용되지 않습니다.
		
		List<Integer> scores = Arrays.asList(65, 70, 80, 90, 85, 50, 40); //오토박싱에 의해 Integer 객체들이 고정크기의 배열로 저장됨
										//  0   1   2    3   4   5   6   index
		
		//60점 이상의 성적만 필터링(걸러내고)하고 평균을 계산하려고 한다.
		
		//순서1. 컬렉션 배열이나 고정크기 배열에 저장된 데이터가 흘러가는 스트림 통로 만들기
		//scores.stream()메소드를 호출하면 생성되는 스트림 통로는
		//컬렉션(ArrayList배열)에 저장된 요소(객체)들이 순서대로 흘러가는 입력스트림을 생성해서 반환받음
		Stream<Integer> stream = scores.stream();
		/*
			 IntegerStream통로 
			-------------------------------------------	  
			new Integer(40), 50, 85, 90, 80,  70,  65   >>>>>>>>   
			-------------------------------------------
	    */	
		
		//순서2. 중간연산 - 필터링
		//필터링 : .filter(람다식) 메소드를 사용하여 각 성적을 검사하고, 60점이상인 성적만남김
		stream = stream.filter( score ->  score >= 60 );
		/*
			 IntegerStream통로 (Integer객체들이 저장된 통로)
			-------------------------------------------	  
			             85, 90, 80,  70,  65   >>>>>>>>   
			-------------------------------------------
		*/		
		
		//순서2-1. 변환연산 - IntegerStream통로를 IntStream통로로 변환 Integer(객체) -> int(기본값. 정수형)
		/*
			mapToInt()메소드
			  - 스트림에 있는 객체(요소)를 정수형(int)으로 변환하여 IntStream통로에 담아
			    IntStream통로를 반환하는 메소드
			  - 일반적으로 객체가 저장된 스트림을 처리할때, 숫자계산이나 통계처리를 하기위해
			    객체(요소)들을 기본자료형 스트림(IntStream, DoubleStream, LongStream)으로 변환할때 사용되는 메소드
			    
			스트림의 각 Integer객체(요소)들을 매개변수 score로 받아
			스트림에 있는 Integer객체들을 정수형으로 변환해서 반환할 뿐입니다.    
			
			이 메소드 이유
			: 스트림의 요소가 객체타입(Integer)이라면 자바에서 기본형 연산을 효율적으로 처리할 수 있도록
			  IntStream으로 변환해 주는 것이 좋습니다.
			  IntStream 통로는 추가적인 average(), sum(), min(), max()등의
			  숫자연산을 더 쉽게 처리할 수 있습니다.
			    
		*/
		IntStream stream2 = stream.mapToInt( score -> score );
		/*
			 IntStream통로 (int들이 저장된 통로)
			-------------------------------------------	  
			            85, 90, 80,  70,  65   >>>>>>>>   
			-------------------------------------------
		 */		
		//순서3. 최종연산결과값 산출 - 평균값 산출!
		double average = stream2.average().orElse(0.0);
		
		System.out.println("Average Score : " + average); 
		//Average Score : 78.0
		
		/*
		    참고.
		    average() 메서드는 숫자형 스트림에서 평균값을 계산하는 역할을 합니다. 
		    Stream<Integer>가 아니라 IntStream, DoubleStream, LongStream과 같은
		    기본형 스트림에서만 사용 가능합니다. 
		    즉, .mapToInt()로 IntStream으로 변환한 후 호출하는 메서드입니다.
		 
		 	.average() 메서드의 특징:
				반환 타입: OptionalDouble입니다. 
				        이는 계산된 평균값을 담을 수 있는 컨테이너입니다. 
				        평균값이 없을 경우(예를 들어, 스트림이 비어있는 경우)를 처리하기 위해 사용됩니다.
						비어있는 스트림의 경우 OptionalDouble.empty()가 반환되며, 
						평균값이 있을 경우 그 값을 포함합니다.
		    
		    평균값이 없을 때 받을값 추출    
		 	.orElse(0.0)의 역할:
		 		.average()는 OptionalDouble을 반환하므로,
		 		만약 스트림에 값이 없을 경우 empty 상태가 됩니다. 
		 		이때 .orElse(0.0)을 사용하면 평균값이 없을 때 기본값을 설정하는 것이며,
		 		0.0을 반환합니다.
		 */		

	}

}
