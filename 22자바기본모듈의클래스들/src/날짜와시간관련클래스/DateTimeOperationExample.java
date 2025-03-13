package 날짜와시간관련클래스;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/* 
	LocalDateTime클래스
	- java.time패키지에 만들어져 있는 클래스
	- 제공되는 메소드로 날짜와 시간을 조작할수 있는 클래스
	
	제공되는 메소드들
	
	minusYears(long)    -    년 뺴기
	minusMonths(long)   -    월 빼기
	minusDays(long)   -    일 빼기
	minusWeek(long)   -    주 빼기
	minusHours(long)  -    시간 빼기
	minusMinutes(long)  -  분 빼기
	minusSeconds(long)  -  초 빼기
	minusNanos(long)  -  나노초 빼기
	
	plusYears(long)   -    년 더하기
	plusMonths(long)  -    월 더하기
	plusDays(long)  -      일 더하기
	plusWeek(long)  -      주 더하기
	plusHours(long)  -    시간 더하기
	plusMinutes(long)  -  분 더하기
	plusSeconds(long)  -  초 더하기
	
	
	LocalDateTime 클래스를 이용해서 현재 컴퓨터의 날짜와 시간정보가 저장된 객체를 얻는 방법
	
			LocalDateTime now = LoCalDateTime.now();
*/


//예제 : 현재 컴퓨터 시간에서 년, 월, 일을 연산하는 방법
public class DateTimeOperationExample {
	public static void main(String[] args) {
		
		//LocalDateTime 클래스의 객체를 얻는 방법
		LocalDateTime now = LocalDateTime.now();
		
		//참고.
		//DateTimeFormatter클래스는 날짜와 시간을 주어진 문자열 패턴으로 변환할때 사용하는 클래스로
		//LocalDateTime객체의 format()메소드 호출시 매개값으로 제공하며 문자열 패턴과 동일한 문자열을 얻을 수 있다.
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 a HH:mm:ss" + "\n");
		
		System.out.println("현재 시간 : " + now.format(dtf));
		//출력결과 : "현재 시간 : 2025년 03월 13일 오전 10:06:04"
		
		LocalDateTime result1 = now.plusYears(1);
		System.out.println("1년 덧셈 : " + result1.format(dtf));
		//출력결과 : "1년 덧셈 : 2026년 03월 13일 오전 10:06:04"

		LocalDateTime result2 = now.minusMonths(2);
		System.out.println("2월 뺄셈 : " + result2.format(dtf));
		//출력결과 : "2월 뺄셈 : 2025년 01월 13일 오전 10:06:04"
		
		LocalDateTime result3 = now.plusDays(7);
		System.out.println("7일 덧셈 : " + result3.format(dtf));
		//출력결과 : "7일 덧셈 : 2025년 03월 20일 오전 10:06:04"
		
	}

}
