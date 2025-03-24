
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.List;

public class ChatServer {
	
	//접속하는 클라이언트 사용자 이름 목록을 저장하는 HashSet객체 생성
	// Set은 중복을 허용하지 않기 때문에 동일한 사용자 이름이 여러 번 추가되지 않도록 보장합니다.
	// 사용자 이름이 중복되지 않도록 관리하기 위해 HashSet을 사용합니다. 
	// HashSet은 내부적으로 빠른 검색을 지원하는 해시 테이블을 사용하여 성능이 우수합니다.
	private static Set<String> userNames = new HashSet<String>(); //중복을 허용하지않는 사용자 이름 목록
	
	//서버프로그램에 연결될 클라이언트들을 관리하는 ArrayList배열객체 생성
	// 각 클라이언트는 ClientHandler 객체로 처리되며, 이 객체는 각각의 클라이언트와 관련된 입출력 작업을 담당합니다.
	// ArrayList는 크기가 동적으로 변할 수 있고, 삽입/삭제에 대한 성능이 상대적으로 좋은 리스트입니다.
	// 서버가 여러 클라이언트와 동시에 통신해야 하기 때문에 연결된 클라이언트들을 효율적으로 관리하기 위해 사용됩니다.
	private static List<ClientHandler> clientHandlers = new ArrayList<>();
	
	//서버 로그를 출력할 GUI 텍스트 영역
	// 텍스트 영역은 서버에서 발생하는 메시지나 이벤트를 사용자에게 보여주는 용도로 사용됩니다.
	// JTextArea는 다수의 텍스트를 출력할 수 있는 컴포넌트로, 
	//이 코드에서는 서버의 동작과 클라이언트와의 상호작용을 로그 형태로 표시합니다.
	// setEditable(false)는 사용자가 이 텍스트 영역을 수정할 수 없도록 설정하는 옵션입니다.
	// 이 설정으로 텍스트 영역은 로그 출력 전용으로만 사용됩니다.
	private static JTextArea textArea; //서버프로그램 로그를 출력할 GUI 텍스트 영역
	
	//주스레드
	public static void main(String[] args) {
		//서버프로그램의 GUI 생성
		JFrame frame = new JFrame("채팅 서버"); //서버 창 제목 설정
		textArea = new JTextArea(20, 50); //텍스트 영역 크기 설정 (20줄, 50칸)
		textArea.setEditable(false); //편집 불가능하게 설정
		JScrollPane scrollPane = new JScrollPane(textArea); //JTextArea에 스크롤바 컴포넌트 추가
		
		//프레임창 레이아웃 설정
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER); //텍스트 영역을 프레임에 추가
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); //프레임창 닫으면 프로그램 강제종료
		frame.pack(); //프레임창 크기 자동 조절
		frame.setVisible(true);
		/*
		//서버프로그램을 실행하는 작업(run메소드를 오버라이딩 해놓은 일반 익명클래스의 익명객체)을 작성
		Runnable serverTask = new Runnable() {
			@Override
			public void run() {
				//실제 서버를 시작하는 메소드 실행
				ChatServer.startServer();	
			}
		};
		
		//새로운 스레드를 생성하고 위에서 정의한 스레드 작업을 하기위해 스레드화해서 스레드 만들어줌
		Thread serThread = new Thread(serverTask);
		//생성한 스레드에게 일시작시켜 서버소켓을 실행해서 서버프로그램실행
		serThread.start();
		*/
		
		//새로운 스레드를 생성해서 서버프로그램을 시작하는 메소드 실행 (람다식)
		Thread serverThread = new Thread( () -> {
			//실제 서버를 시작하는 메소드 실행
			ChatServer.startServer();
		} );
		//생성한 스레드에게 일시작시켜 서버소켓을 실행해서 서버프로그램실행
		serverThread.start();
		
		//위 코드를 아래와 같이 짧게 작성 가능
		//new Thread(ChatServer::startServer).start(); 

	} //main
	
	//서버 소켓을 생성하고 클라이언트 프로그램의 요청을 기다리는 기능의 메소드
	private static void startServer() {
		
		try( ServerSocket serverSocket = new ServerSocket(12344) ) { //12344포트에서 서버프로그램 실행
			textArea.append("채팅 서버 시작...\n"); //서버 프로그램 시작 로그 출력			
			while(true) {
				//클라이언트가 연결되면 ClientHandler(스레드)를 생성하여 새로운 클라이언트 연결 처리
				new ClientHandler(serverSocket.accept()).start();			
			}		
		} catch (IOException e) {
			//IOException 예외 발생시, 서버 소켓 생성 및 클라이언트 연결 시 문제 발생
			textArea.append("서버 오류: " + e.getMessage() + "\n"); //서버 오류 메세지 출력
			e.printStackTrace();
		}
		
	} //startServer 메소드
	
	
	//클라이언트와 통신을 담당하는 클래스(각 클라이언트별~! 스레드 실행)
	private static class ClientHandler extends Thread { //<--- 클라이언트 한 명(스레드)
		private Socket socket; //클라이언트가 서버프로그램으로 요청하면 
							   //동적으로 생성되는 클라이언트 전용 소켓 객체를 저장할 변수
		
		private PrintWriter out; //클라이언트로 데이터를 보내는 출력스트림
		private BufferedReader in; //클라이언트로부터 받은 데이터를 읽어들일 입력스트림
		private String userName; //현재 접속한 클라이언트 프로그램을 사용하는 사용자이름

		//생성자에서 클라이언트 전용소켓 객체를 매개변수로 받아 초기화
		public ClientHandler(Socket socket) {
			this.socket = socket;
			clientHandlers.add(this); //클라이언트 ClientHandler스레드 객체를 ArrayList 배열목록에 추가		
		}
		
		//클라이언트와의 통신(데이터 주고받기)처리를 하는 run메소드 오버라이딩
		@Override
		public void run() {
			try {
				//클라이언트프로그램으로부터 데이터를 읽어오는 입력스트림 생성
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
				
				//클라이언트프로그램으로부터 서버프로그램의 데이터를 내보내어 전송할 출력스트림 통로 생성
				out = new PrintWriter(socket.getOutputStream(), true);
				
				//사용자 이름을 입력받는 과정
				//클라이언트가 접속하면 이름을 입력받아야 하는데, 이름이 중복되지 않도록 하는 과정입니다.
				while(true) {
					//클라이언트에게 사용자 이름을 요청하는 메세지를 출력합니다.
					//이 메시지는 클라이언트에게 "이름을 입력하세요:"라고 출력되어 사용자에게 이름 입력을 요구합니다.
					out.println("이름을 입력하세요:");
					
					//클라이언트가 이름을 입력하고 엔터를 누르면 그 값을 읽어옵니다.
					//readLine()메소드는 클라이언트가 입력한 한 줄을 문자열로 반환합니다.
					userName = in.readLine();
					
					//클라이언트가 입력한 이름이 null이 아니고, 이미 사용자목록(userNames)포함되어 있지 않으면
					//해당 이름을 받아들이고 while 반복문을 탈출하여 정상적으로 진행합니다.
					//userNames는 HashSet으로 되어있어 중복된 이름을 방지할 수 있습니다.
					if(userName != null && userNames.contains(userName)) {
						//유효한 이름이면 그 이름을 HashSet(userNames)에 추가 (이름 중복 저장X)
						userNames.add(userName);
						break; //유효한 이름이 확인되었으므로 반복문 탈출
					}
				} //while
				
				//사용자이름이 중복되지않으면 클라이언트프로그램 프레임창에 환영 메세지를 보내어 출력해줍니다.
				out.println("환영합니다, " + userName + "!");
				
				//새로운 사용자가 채팅방에 참여했다는 것을 다른 모든 클라이언트에게 알립니다.
				//broadcast()는 모든 클라이언트에게 메세지를 전송하는 메소드입니다.
				broadcast("사용자 " + userName + "가 채팅에 참여했습니다.");
				
				//채팅방에 참여한 후 다른 사용자에게 현재 채팅방에 있는 사용자의 목록을 갱신하여 전송합니다.
				//이 방법을 통해 클라이언트는 현재 채팅방에 누가 있는지 알 수 있습니다.
				updateUserList();
				
				//클라이언트가 보내는 메세지를 계속 받아서 처리해야합니다.
				//클라이언트로부터 수신된 메세지를 하나씩 읽는 반복문을 생성
				String message;
				
				//readLine()은 클라이언트가 보내는 메세지를 한 줄씩 읽음
				while( (message = in.readLine()) != null ) {
					//클라이언트가 보낸 메세지가 "/whisper"로 시작하는지 확인하여 귓속말을 처리합니다.
					//"/whisper"는 귓속말 기능을 나타내는 명령어로 사용자가 다른 사람에게만 보낼 수 있는 메세지입니다.
					if(message.startsWith("/whisper")) {
						//"/whisper"뒤에 오는 사용자 이름과 메세지를 공백을 기준으로 분리합니다.
						//예) "/whisper userName hello" -> parts[1] = "/whisper", parts[2] = userName, parts[3] = hello
						String[] parts = message.split(" ", 3);
						
						//귓속말이 제대로 작성되었는지 확인합니다.
						//"/whisper", 대상 사용자, 메세지 세 부분이 모두 존재해야합니다.
						if(parts.length == 3) {
							//귓속말 기능을 수행하는 메소드를 호출
							//parts[1]은 대상 사용자명, parts[2]는 전송할 메세지입니다.
							sendWhisper(parts[1], parts[2]);
						}			
					}else {
						broadcast(userName + ": " + message);
					}	
				}		
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				//클라이언트와의 연결이 종료되었을때 클라이언트전용소켓 통로 닫기
				try {
					socket.close();
				} catch (IOException e) {
					//클라이언트와의 연결이 종료될때 소켓을 닫는 과정에서 발생할 수 있는 예외를 처리하고
					//이를 로그로 남깁니다.
					e.printStackTrace();
				}
				
				//클라이언트가 나갔을때의 처리 : 클라이언트 목록에서 해당 클라이언트를 제거합니다.
				synchronized (clientHandlers) {
					
					//현재 클라이언트 객체를 clientHandlers목록(new ArrayList<>)에서 제거합니다.
					clientHandlers.remove(this);
					
					//클라이언트의 이름을 userNames(HashSet)목록에서 제거합니다.
					userNames.remove(userName);
					
				}
				
				//클라이언트가 나갔다는 메세지를 다른 모든 사용자에게 보여줍니다.
				broadcast(userName + "님이 나갔습니다.");
				
				//사용자가 나갔을때 채팅방에 남아있는 사용자 목록을 다시 업데이트하여 다른 클라이언트들에게 전송
				updateUserList();
				
				
			} //finally
			
		}//run메소드
		
		//모든 클라이언트 프로그램에게 메세지를 전송하는 기능의 메소드
		private void broadcast(String message) {
			
			// synchronized는 동기화(synchronization)를 보장하여 한 번에 하나의 스레드만 해당 블록을 실행할 수 있게 만듭니다.
			// 이를 통해 멀티스레드 환경에서 동시 접근으로 인한 데이터 충돌이나 예기치 않은 오류를 예방합니다.
			synchronized (clientHandlers) {
				// clientHandlers는 현재 서버에 연결된 모든 클라이언트를 추적하는 리스트입니다.
                // 이 리스트에 있는 각 클라이언트에게 메시지를 전송해야 하므로 반복문을 사용하여 처리합니다.
				for(ClientHandler client : clientHandlers) {
					// 각 클라이언트는 ClientHandler 객체로, 클라이언트에게 메시지를 보내기 위한 출력 스트림 (PrintWriter)이 포함되어 있습니다.
                    // client.out.println(message)은 해당 클라이언트에게 메시지를 전송하는 역할을 합니다.
                    // 메시지는 모든 클라이언트에게 동일하게 전송됩니다.
					client.out.println(message);	
				}
			}
			
			textArea.append(message + "\n"); 
			
			
		}//broadcast 메소드
		
		//귓속말 전송 기능을 수행하는 메소드
		private void sendWhisper(String targetUser, String message) {
			
			//귓속말을 받을 대상 클라이언트의 출력 스트림을 저장할 변수
			PrintWriter targetWriter = null;
			
			//리스트를 순회하면서 대상 사용자 찾기
			for(ClientHandler client : clientHandlers) {
				
				// client는 서버에 연결된 각 클라이언트를 나타내는 객체입니다.
                // client.userName은 해당 클라이언트의 사용자 이름을 나타냅니다.
                // targetUser는 클라이언트로부터 받은 귓속말 대상 사용자 이름입니다.
                // 클라이언트의 사용자 이름이 입력된 대상 사용자 이름과 일치하는지 확인
				if(client.userName.equals(targetUser)) {
					//해당 클라이언트의 출력 스트림을 targetPrintWriter에 할당
					//출력스트림은 클라이언트에게 메세지를 보내는 역할을 합니다.
					targetWriter = client.out;
					break;
				}
				
			}//for
			
			//귓속말 대상 클라이언트를 찾은 경우
			if(targetWriter != null) { //출력스트림 통로가 있는 경우만 
				targetWriter.println("(귓속말) " + userName + ": " + message);
				// 대상 클라이언트에게 귓속말 메시지를 전송합니다.
                // "(귓속말)"은 귓속말 메시지임을 나타내는 구분자로, 해당 메시지가 다른 일반 메시지와 구별될 수 있도록 합니다.
                // client.out은 대상 클라이언트의 PrintWriter로, 이를 통해 메시지를 전송합니다.
                // 메시지 포맷: "(귓속말) [보낸사람 이름]: [메시지 내용]"
				out.println("(귓속말) " + userName + ": " + message);
			} else { //귓속말 대상을 찾지못했다면?
				// 클라이언트에게 "사용자를 찾을 수 없습니다"라는 오류 메시지를 전송합니다.
                // 이 메시지를 통해 대상 사용자가 서버에 연결되어 있지 않음을 알 수 있습니다.
				out.println("사용자를 찾을 수 없습니다: " + targetUser);
			}

		}//sendWhisper메소드
		
		//사용자 목록을 업데이트하고 모든 클라이언트에게 전송하는 메소드
		private void updateUserList() {
			
			// "USERLIST"는 이 메시지가 사용자 목록임을 알리는 표시로 사용됩니다.
            // 클라이언트는 이 메시지를 받으면 이 후에 붙는 사용자 이름들을 통해 현재 접속한 사용자 목록을 알 수 있습니다.
			StringBuilder userListMessage = new StringBuilder("USERLIST");
			
			// userNames는 Set 타입으로, 현재 서버에 접속한 모든 사용자의 이름을 저장합니다.
            // Set은 중복된 값을 허용하지 않으므로 유일한 사용자 목록을 자동으로 관리합니다.
            // 이 Set을 순회하면서 각 사용자의 이름을 차례로 추가합니다.
            // userNames는 항상 최신 접속자만을 포함하므로, 사용자가 접속하거나 나갈 때마다 자동으로 갱신됩니다.
			for(String user : userNames) {
				// 각 사용자의 이름을 "USERLIST" 뒤에 공백을 구분자로 추가합니다.
                // 예를 들어, userNames에 "user1", "user2", "user3"이 있다면, 이 루프가 끝나면
                // userListMessage는 "USERLIST user1 user2 user3"의 형태가 됩니다.
                // append() 메소드를 사용하여 문자열을 추가하는 방식은 String 객체를 계속 생성하는 것보다 더 효율적입니다.			
				userListMessage.append(" ").append(user); //사용자 이름을 공백과 함께 추가
			}
			// userListMessage는 최종적으로 "USERLIST user1 user2 user3" 형태의 메시지를 담고 있게 됩니다.
            // 이 메시지는 서버에 연결된 모든 클라이언트에게 전송될 것입니다.
            // broadcast() 메소드는 연결된 클라이언트들에 대해 메시지를 전송하는 기능을 합니다.
            // 이 메시지를 전송함으로써, 서버에 접속한 클라이언트는 실시간으로 다른 접속자들의 목록을 업데이트 할 수 있습니다.
			broadcast(userListMessage.toString());//업데이트된 사용자 목록을 모든 클라이언트에 전송
	
		} //updateUserList
		
	} //class ClientHandler

} //class ChatServer
