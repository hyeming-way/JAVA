
import java.net.MalformedURLException;
import java.net.URL;

/*

URL 클래스
	 	
     -  구조 ->  public class URL extends java.lang.Object

	 -  URL 클래스는 이런 웹 사이트 요청 주소를 객체로 만들어, 
	    그 안에 있는 웹 사이트 정보들을 쉽게 분석하거나, 웹 사이트 요청주소를 분석 사용할 수 있도록 돕습니다.
     
     - 간단한 예시: 웹 주소가 "https://www.naver.com/index.html"이라면, 이 주소를 URL 클래스가 어떻게 다루는지 볼 수 있습니다.
			1. 프로토콜: https (웹 주소에서 어떤 방식을 사용할지)
			2.호스트(도메인): www.naver.com (웹 사이트의 주소)
			3.경로: /index.html (웹 페이지의 위치)

*/

//주제 : URL 클래스의 객체로 웹 사이트 요청주소를 분석

public class URLExample {
	public static void main(String[] args) {

		try {
			//URL 객체를 생성하면서 요청할 웹사이트 주소를 생성자로 전달해서 객체 생성
			URL url = new URL("https://www.naver.com/index.html");
			
			//URL객체에 저장된 프로토콜 정보 추출하여 출력
			//URL(요청한 전체 주소)의 "https"부분을 출력함
			System.out.println("프로토콜 : " + url.getProtocol()); //프로토콜 : https
			
			//URL객체에서 도메인(호스트)명 추출하여 출력
			System.out.println("도메인(호스트) : " + url.getHost()); //도메인(호스트) : www.naver.com
			
			//**중요**URL객체에서 저장된 요청한 문서의 경로 정보 추출하여 출력
			System.out.println("요청한 문서의 경로 정보 : " + url.getPath()); //요청한 문서의 경로 정보 : /index.html
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
