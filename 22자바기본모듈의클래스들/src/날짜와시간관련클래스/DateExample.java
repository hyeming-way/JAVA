package 날짜와시간관련클래스;

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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
												//우리가 원하는 포맷의 형태를 넣어주자
		
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);
		//2025년 03월 12일 17시 55분 49초

		
	}

}
