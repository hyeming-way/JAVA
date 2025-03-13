package 날짜와시간관련클래스;

/*
	날짜와 시간 정보를 제공하거나 조작할수 있게 도와 주는 클래스들
	
	 Date 클래스  - 날짜 정보를 전달하기 위해 사용
	 
	 Calender 클래스 - 다양한 시간대별로 날짜와 시간을 얻을때 사용
	 
	 LocalDateTime 클래스  - 날짜와 시간을 조작할때 사용
	
	
	Date 클래스
	- java.util패키지의 클래스 
	- 날짜를 표현하는 클래스로 객체 간에 날짜 정보를 주고받을때 사용된다.
	- Date클래스에는 여러개의 생성자가 선언되어 있지만 대부분 Date() 기본생성자만 주로 사용된다.
	Date() 생성자는 컴퓨터의 현재 날짜를 읽어 저장시킨 Date객체를 생성할떄 주로 호출해서 사용한다.
	예)  Date now = new Date();
*/

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
	public static void main(String[] args) {
		
		//참고
		//현재 날짜 정보를 문자열로 얻고 싶다면 toString()메소드를 사용할수 있지만 영문으로 출력되기떄문에
		//우리가 원하는 형식이 아니다. 원하는 문자열로 얻고 싶다면 SimpleDataFormat클래스와 함꼐 사용해야한다.		
		
		Date now = new Date(); //Date() 생성자는 컴퓨터의 현재 날짜를 읽어 저장시킨 Date 객체를 생성
		
		String strNow1 = now.toString();
		
		System.out.println(strNow1);
		//Wed Mar 12 17:45:14 KST 2025 <--- 영문 형식으로 출력됨
		
		//위 영문으로 저장된 현재 날짜와 시간정보를 우리 개발자가 원하는 포맷형식으로 만들어서 출력하게
		//도와주는 SimpleDateFormat 클래스를 사용하자
			//순서1.SimpleDataFormat 클래스의 생성자를 호출할 때 원하는 포맷형식을 문자열로 전달해서 객체 생성
														//패턴 문자 
														//y   년도 의미 
													    //M   월을 의미
														//d   일을 의미
														//D	  월 구분이 없는 일(1 ~ 365)
														//E   요일
														//a   오전/오후
														//w   년의 몇번째 주
														//W   월의 몇번째 주 
														//H   시간을 의미 (0 ~ 23)
														//h   시간을 의미 (1 ~ 12)
														//K   시간을 의미 (0 ~ 11)
														//k	  시간을 의미 (1 ~ 24)
														//m   분을 의미
														//s   초를 의미 
														//S	  밀리세컨드(1/1000초)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
												//우리가 원하는 포맷의 형태를 넣어주자
		
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);
		//2025년 03월 12일 17시 55분 49초

		
	}

}
