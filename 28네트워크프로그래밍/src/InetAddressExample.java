

//주제 : 로컬 컴퓨터의 IP와 네이버 웹 사이트의 IP정보 출력
import java.net.InetAddress; //DNS(도메인네임서버)에 저장된 도메인과 연결된 IP를 찾아주는 역할의 클래스

/*
	 InetAddress 클래스 
	 - DNS(도메인네임서버)에 저장된 도메인과 연결된 ip를 찾아주는 역할
	 
	 
	 InetAddress클래스의 getLocalHost()메소드
	 
	 public static InetAddress getLocalHost() throws UnknownHostException
	
	 - 이 메서드는 로컬 시스템(즉, 현재 실행 중인 컴퓨터)의 호스트(도메인) 정보를 담고 있는 InetAddress 객체를 반환합니다.
	반환된 InetAddress 객체에는 그 컴퓨터의 호스트(도메인) 이름과 IP 주소가 포함되어 있습니다.
	   
	 - 예외: UnknownHostException을 던질 수 있습니다. 
	        이는 로컬 호스트(도메인)를 찾을 수 없거나 네트워크 관련 문제로 호스트(도메인) 이름을 확인할 수 없을 때 발생합니다.
	
	InetAddress 객체      	 
	  - InetAddress 클래스는 네트워크 주소를 표현하는 객체입니다.
	  - getHostAddress() 메서드를 호출하면, 해당 객체에 저장된 IP 주소를 문자열 형식으로 반환합니다.
	  
*/

public class InetAddressExample {
	public static void main(String[] args) {
	
		try {
			//1. 로컬 컴퓨터의 IP주소를 가져옵니다.
			//-> 이 부분은 로컬 컴퓨터의 IP 주소를 가져옵니다. 우리가 직접 사용하는 컴퓨터의 주소입니다.
			InetAddress localInetAddress = InetAddress.getLocalHost();
			
			//getHostAddress()메소드는 로컬 컴퓨터의 실제 IP주소를 반환합니다.
			System.out.println("내 컴퓨터 IP 주소 : " + localInetAddress.getHostAddress());
			//내 컴퓨터 IP 주소 : 192.168.0.146
			
			  /*
	          InetAddress클래스의 getAllByName(String host)메소드
	         
	          public static InetAddress[] getAllByName(String host) throws UnknownHostException
	         
	          - InetAddress.getAllByName() 메서드는 
	            주어진 호스트(도메인) 이름(예: "www.naver.com")에 해당하는 모든 IP 주소를 가져오는 메서드입니다. 
	            이 메서드는 DNS(Domain Name System) 서버를 통해 주어진 호스트(도메인)을 조회하고, 
	            그 호스트(도메인)에 대한 여러 개의 IP 주소를 반환합니다.
	          
			     - 반환값: 해당 호스트(도메인) 이름에 연결된 모든 IP 주소를 포함하는 InetAddress 객체 배열을 반환합니다.
			    
	         */	
			
			
			//2. 네이버 웹사이트의 IP주소를 가져옵니다.
			//여기서는 네이버 웹사이트의 IP 주소를 가져옵니다. 
			//네이버 웹사이트가 여러 서버를 운영할 수 있기 때문에 여러 개의 IP 주소를 가져옵니다.
	        //InetAddress 객체 배열에 여러 개의 IP 주소를 저장하고, 이를 하나씩 출력합니다.
			InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
			
			for(InetAddress remoAddress : iaArr) {
				//반복문을 사용하여 여러개의 IP주소를 InetAddress객체 각각에서 꺼내어 출력
				System.out.println("www.naver.com IP 주소 : " + remoAddress.getHostAddress());
			}
			/*
				www.naver.com IP 주소 : 223.130.200.236
				www.naver.com IP 주소 : 223.130.192.248
				www.naver.com IP 주소 : 223.130.192.247
				www.naver.com IP 주소 : 223.130.200.219
			*/
			
		} catch (Exception e) {
			//예외가 발생하면 예외메세지 출력
			e.printStackTrace();
		}

	}

}
