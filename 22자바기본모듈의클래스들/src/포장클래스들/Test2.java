package 포장클래스들;

//박싱(수동박싱)과 언박싱(수동언박싱) 연습

public class Test2 {
	public static void main(String[] args) {
		
		//기본자료형 int값 10을 수동박싱하자
		//방법1
		//Integer i = new Integer(10);
		
		//방법2
		Integer i = Integer.valueOf(10);
		
		//수동박싱된 int값 10을 수동언박싱해서 문자열"10" 변환 후 출력하자
		System.out.println(String.valueOf(i.intValue()));
		
		
		
		//기본자료형 double값 3.14를 수동박싱하자
		//방법1
		//Double d = new Double(3.14);
		
		//방법2
		Double d = Double.valueOf(3.14);

		//기본자료형 double값 3.14를 수동언박싱해서 문자열"3.14" 변환 후 출력하자
		System.out.println(String.valueOf(d.doubleValue()));

		
		//valueOf()?
		// ->괄호안의 해당 객체를 String 객체로 변환시키는 역할. String 객체로 형변환 시킴
		
		
	}

}
