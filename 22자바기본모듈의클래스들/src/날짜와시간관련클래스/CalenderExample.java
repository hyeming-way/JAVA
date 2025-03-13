package 날짜와시간관련클래스;

import java.util.Calendar;

/*
	Calendar 클래스
	- java.util 패키지에 만들어져있는 추상클래스
	- Calendar클래스는 달력을 표현하는 추상클래스이다.
	- 날짜와 시간을 계산하는 방법이 지역과 문화에 따라 다르기 떄문에 특정 역법(날짜와 시간을 매기는 방법)에 따르는
	  달력은 자식클래스에서 구현하도록 되어 있다.
	- 특별한 역법을 사용하는 경우가 아니라면 직접 하위 클래스를 만들 필요는 없고,
	  Calender추상클래스의 정적메소드인 getInstance()메소드를 이용하면
	  컴퓨터에 설정되어 있는 시간대(TimeZone)을 기준으로 Calender추상부모클래스의 하위자식객체를 반환받아 얻을수 있다
	  예)  Caldener now = Calender.getInstance();
	
	Calender 클래스가 제공하는 날짜와 시간에 대한 정보를 얻기 위해 get() 메소드를 이용한다.
	get()메소드 호출시 전달되는 인자값으로 Calender추상클래스에 정의된 상수메모리를 넣어주면 상수에 저장된 의미값을 반환한다
	
	 예)  
	 		int year = now.get(Calendar.YEAR); //현재 년도를 리턴
	 		int month = now.get(Calendar.MONTH) + 1; //현재 월을 리턴
	 		int day = now.get(Calendar.DAY_OF_MONTH); //현재 일을 리턴
	 		int week = now.get(Calendar.DAY_OF_WEEK); //현재 요일을 리턴
	 		int amPm = now.get(Calendar.AM_PM); //현재 오전 또는 오후 리턴
	       int hour = now.get(Calendar.HOUR); //현재 시  리턴
	       int minute = now.get(Calendar.MINUTE); //현재 분  리턴
	       int second = now.get(Calendar.SECOND); //현재 초  리턴
       
*/

public class CalenderExample {
	public static void main(String[] args) {
		
		//Calender 추상클래스의 하위 구현 자식　GregorianCalendar객체메모리 얻기
		Calendar now = Calendar.getInstance();
		//참고. 테스트할 줄번호 더블 클릭하면 브레이크포인트 찍을 수 있음.
		//	   해당 줄 테스트하려면 F11을 눌러주면 된다.
		
		int year = now.get( Calendar.YEAR ); //현재 년도 리턴
		int month = now.get( Calendar.MONTH ) + 1; //현재 월 정보를 1적게 리턴하기 때문에 +1을 해주어야 함
		int day = now.get( Calendar.DAY_OF_MONTH ); //현재 일 리턴
		int week = now.get( Calendar.DAY_OF_WEEK ); //현재 요일을 숫자로 리턴
		
 		String strWeek = null;
  		
  		switch (week) {//현재 요일이 ~ 
	  					 //월요일 이면?
			case Calendar.MONDAY:  strWeek = "월"; break;
						//화요일 이면?
			case Calendar.TUESDAY:  strWeek = "화"; break;			
				 		//수요일 이면?
			case Calendar.WEDNESDAY:  strWeek = "수"; break;			
				 		//목요일 이면?
			case Calendar.THURSDAY:  strWeek = "목"; break;			
				 		//금요일 이면?
			case Calendar.FRIDAY:  strWeek = "금"; break;			
				 		//토요일 이면?
			case Calendar.SATURDAY:  strWeek = "토"; break;

			default://일요일이면?
									 strWeek = "일";
		}
  		
  		//현재 오전 또는 오후를 리턴
  		int amPm = now.get(Calendar.AM_PM);
  
  		String strAmPm = null;
  		
		if(amPm == Calendar.AM) {
			strAmPm = "오전";
		}else {
			strAmPm = "오후";
		}
		
		int hour = now.get(Calendar.HOUR); //현재 시 리턴
		int minute = now.get(Calendar.MINUTE); //현재 분 리턴
		int second = now.get(Calendar.SECOND); //현재 초 리턴
		
		System.out.print(year + "년 ");
		System.out.print(month + "월 ");
		System.out.println(day + "일");
		System.out.print(strWeek + "요일 ");
		System.out.print(strAmPm + " ");
		System.out.print(hour + "시 ");
		System.out.print(minute + "분 ");
		System.out.print(second + "초");
		/*
			출력결과
			2025년 3월 13일
			목요일 오전 9시 41분 30초
		*/

	}

}
