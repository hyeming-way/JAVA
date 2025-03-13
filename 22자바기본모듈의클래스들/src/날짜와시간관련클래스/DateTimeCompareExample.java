package 날짜와시간관련클래스;

import java.time.LocalDateTime; //LocalDateTime클래스를 사용하기위해 import
import java.time.temporal.ChronoUnit; //시간단위를 사용하기위해 import

/*
	LocalDateTime 클래스는 날짜와 시간을 비교할 수 있는 메소드들도 제공합니다.
	
	표
	
		리턴타입			메소드(매개변수)			설명
						isAfter(other)			이후 날짜인지?
		boolean			isBefore(other)			이전 날짜인지?
						isEqual(other)			동일한 날짜인지?
		
		long			until(other, unit)		주어진 단위(unit) 차이를 리턴
		
		
*/


public class DateTimeCompareExample {
	public static void main(String[] args) {
		
		//현재 컴퓨터의 날짜와 시간정보 가져오기 위해 LocalDateTime 클래스의 객체 얻기
		LocalDateTime now = LocalDateTime.now(); //2025-03-13
		
		//현재 컴퓨터 날짜와 시간에서 5일을 더한 날짜 생성
		LocalDateTime futureDate = now.plusDays(5); //2025-03-18
		
		//현재 컴퓨터 날짜와 시간에서 3일을 뺀 날짜 생성
		LocalDateTime pastDate = now.minusDays(3); //2025-03-10
		
		//isAfter() : futureDate(2025-03-18)가 now(2025-03-13)보다 이후 날짜인지 확인
		System.out.println("futureDate가 now보다 나중인가? " + futureDate.isAfter(now));
		//출력결과 : "futureDate가 now보다 나중인가? true"
		
		//isBefore() : pastDate(2025-03-10)가 now(2025-03-13)보다 이전 날짜인지 확인
		System.out.println("pastDate가 now보다 이전인가? " + pastDate.isBefore(now));
		//출력결과 : "pastDate가 now보다 이전인가? true"
		
		//isEqual() : sameDate가 now와 동일한 날짜인지 확인
		LocalDateTime sameDate = now; //now와 동일한 LocalDateTime 객체의 주소를 대입해서 저장
		System.out.println("sameDate가 now와 같은가? " + sameDate.isEqual(now));
		//출력결과 : "sameDate가 now와 같은가? true"
		
		//until() : 두 날짜 사이의 차이 계산 (단위 : DAYS)
		long daysBetween = now.until(futureDate, ChronoUnit.DAYS);
					  //2025-03-13	//2025-03-18
		System.out.println("현재 날짜와 futureDate 사이의 날짜 차이 : " + daysBetween + "일");
		//출력결과 : "현재 날짜와 futureDate 사이의 날짜 차이 : 5일"

		
		
	}

}
