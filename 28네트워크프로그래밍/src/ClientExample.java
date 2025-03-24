
import java.io.*; 
import java.net.*; //네트워크 관련 클래스(ServerSocket, Socket)

public class ClientExample {
	public static void main(String[] args) {
		try {
			//1. Socket : Socket클래스의 객체를 생성해서 서버와 연결을 시도합니다.
			//접속 요청할 ServerExample.class 서버프로그램의 ip주소와 포트번호 정보를 부여해서 만듭니다.
			//자기 자신 컴퓨터 IP주소를 나타내는 영문 -> localhost
			//자기 자신 컴퓨터 IP주소를 나타내는 ip주소 -> 127.0.0.1
			Socket socket = new Socket("192.168.0.12", 12345); //객체 생성한 순간 서버프로그램의 accept()메소드가 연결을 허용
		//	Socket socket = new Socket("localhost", 12345);
		//	Socket socket = new Socket("127.0.0.1", 12345);
			
			System.out.println("ServerExample.class서버프로그램에 접속을 요청하여 연결되었습니다.");
			
			//2. 입출력 스트림 통로 얻기 : 서버와 데이터를 주고 받기 위해 PrintWriter와 BufferedReader얻기
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			//서버로부터 응답을 받을 수 있도록 입력스트림 생성
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//3. 메세지 보내기 : 클라이언트 프로그램은 출력스트림 통로를 통해 서버에게 메세지를 보냅니다.
			String message = "안녕하세요, 서버!";
			out.println(message); //서버프로그램으로 메세지 전송
			
			//4. 메세지 받기(응답 받기) : 서버프로그램이 보낸 메세지는 입력스트림 통로를 통해 읽어들여 받습니다.
			String response = in.readLine();
			System.out.println("서버 응답: " + response);
			
			//5. 자원해제
			in.close(); out.close(); socket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
