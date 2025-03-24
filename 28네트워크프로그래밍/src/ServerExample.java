
import java.io.*; 
import java.net.*; //네트워크 관련 클래스(ServerSocket, Socket)

/*
	동작 과정
	1.서버는 ServerSocket을 통해 연결을 기다리고 있습니다.
	2.클라이언트는 Socket을 사용해 서버와 연결을 시도하고, 연결되면 메시지를 보냅니다.
	3.서버는 클라이언트가 보낸 메시지를 받고, 응답을 보내며 연결을 유지합니다.
	4.클라이언트는 서버로부터 응답을 받고, 연결을 종료합니다.
*/

public class ServerExample {
	public static void main(String[] args) {
	
		try {
			//1. ServerSocket : 서버는 ServerSocket객체를 사용해 클라이언트의 연결을 기다립니다.
			//					여기서는 포트 12345로 정해 기다리게 하자
			ServerSocket serverSocket = new ServerSocket(12345);
			System.out.println("서버가 시작되었습니다. 클라이언트의 연결을 기다립니다....");
			
			//2. accept() : 클라이언트가 연결을 요청하면 이 메소드가 연결을 수락해서
			//				연결이 이루어지면 요청한 클라이언트와 통신을 할 수 있는 Socket 객체가 생성되어 
			//				반환을 받을 수 있습니다.
			Socket clientSocket = serverSocket.accept(); //요청한 클라이언트 프로그램과 연결된 전용 소켓
			System.out.println("클라이언트가 연결되었습니다. (접속했습니다.)");
			
			//3. 입력스트림 통로 : 클라이언트가 보낸 메세지를 읽기 위해 BufferedReader와 InputStreamReader를 사용
			//					BufferedReader로 데이터를 효율적으로 한 줄씩 읽을 수 있게 입력스트림 만듬
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			//getInputStream() <---- 1바이트 단위
			//InputStreamRead  <---- 2바이트 단위
			//BufferedReader   <----한 줄 단위
			
			//4. 출력스트림 통로 : 클라이언트에게 응답 메세지를 보내기 위해 PrintWriter 사용
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			
			//5. 클라이언트의 응답 처리 : 클라이언트가 보낸 메세지를 읽고, 그 메세지에 대한 응답을 클라이언트로 전송합니다.
			String clientMessage = in.readLine();
			System.out.println("클라이언트: " + clientMessage);
			//클라이언트프로그램에게 응답 메세지 보냄
			out.println("서버에서 응답: " + clientMessage);
			
			//6. 사용이 끝난 후 스트림과 소켓을 닫음
			in.close(); out.close(); clientSocket.close(); serverSocket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
