import javax.swing.*; // GUI 구성 요소들을 제공하는 라이브러리
import java.awt.*; // 레이아웃 및 그래픽 관련 기능 제공
import java.awt.event.*; // 버튼 클릭, 키 입력 등의 이벤트 처리를 위한 라이브러리
import java.io.*; // 입출력 (I/O) 처리를 위한 라이브러리 (파일, 네트워크 등)
import java.net.*; // 네트워크 소켓을 다루는 라이브러리
import java.util.*; // 리스트, 맵 등의 자료구조를 위한 유틸리티 라이브러리

// 채팅 클라이언트 프로그램
public class ChatClient {
    // 서버와의 연결을 담당하는 네트워크 관련 변수들
    private static Socket socket; // 서버와 직접 통신할 소켓 객체 (네트워크 연결 역할)
    private static PrintWriter out; // 서버로 데이터를 전송하는 스트림 (문자 기반 출력)
    private static BufferedReader in; // 서버에서 데이터를 읽어오는 스트림 (문자 기반 입력)

    // GUI (그래픽 사용자 인터페이스) 관련 요소들
    private static JTextArea textArea; // 채팅 메시지를 표시하는 다중 줄 텍스트 영역 (출력 전용)
    private static JTextField textField; // 사용자가 입력하는 단일 줄 텍스트 필드 (메시지 입력)
    private static String userName; // 사용자의 닉네임을 저장하는 변수 (사용자 식별용)
    private static DefaultListModel<String> userListModel; // 사용자 목록을 관리하는 데이터 모델 (JList와 연결됨)
/*
+----------------------------+
|      DefaultListModel      |
|----------------------------|
|  [ 사용자 1 ]             	 |
|  [ 사용자 2 ]                |
|  [ 사용자 3 ]                |
|  [ 사용자 4 ]                |
|  [ 사용자 5 ]                |
+----------------------------+
            |
            | (연결)
            v
+----------------------------+
|           JList            |
|----------------------------|
|  [ 사용자 1 ]                |
|  [ 사용자 2 ]                |
|  [ 사용자 3 ]                |
|  [ 사용자 4 ]                |
|  [ 사용자 5 ]                |
+----------------------------+
설명:
DefaultListModel: 사용자 목록을 관리하는 데이터 모델입니다. 이 모델은 사용자 목록을 동적으로 추가하거나 제거할 수 있는 기능을 제공합니다.
JList: 실제 사용자에게 보여지는 리스트 컴포넌트입니다. DefaultListModel과 연결되어 사용자의 목록을 표시합니다.

이 구조를 통해 사용자가 리스트에서 선택할 수 있는 사용자 목록을 동적으로 업데이트할 수 있습니다. 
DefaultListModel에 사용자를 추가하거나 제거하면, JList가 자동으로 그 변화를 반영합니다.
     */
    private static JList<String> userList; // 채팅방에 접속한 사용자들의 목록을 화면에 표시하는 리스트 UI

    // 메인 실행 메서드
    public static void main(String[] args) {
        // 프레임 생성 (창)
        JFrame frame = new JFrame("채팅 클라이언트");
        textArea = new JTextArea(20, 50); // 채팅 메시지를 출력할 공간 (20줄, 50칸 크기)
        textArea.setEditable(false); // 메시지 창을 읽기 전용으로 설정
        textField = new JTextField(50); // 메시지를 입력할 텍스트 필드
        userListModel = new DefaultListModel<>(); // 사용자 목록 모델 생성
        userList = new JList<>(userListModel); // 사용자 목록을 JList로 생성
        /*
         ListSelectionModel은 Java Swing에서 리스트 컴포넌트(JList)의 선택 상태를 관리하는 인터페이스입니다. 
         이 모델은 사용자가 리스트에서 항목을 선택하거나 선택 해제할 때의 동작을 정의합니다. 
         ListSelectionModel을 사용하면 리스트의 선택 모드(단일 선택 또는 다중 선택)를 설정할 수 있습니다.

			주요 기능 및 구성 요소
			 1. 선택 모드 설정 상수 :			
				 - SINGLE_SELECTION: 사용자가 하나의 항목만 선택할 수 있습니다.
				 - SIMPLE_SELECTION: 사용자가 여러 항목을 선택할 수 있지만, 선택된 항목은 서로 연결되어 있어야 합니다.
				 - CONTIGUOUS_SELECTION: 사용자가 여러 항목을 선택할 수 있으며, 선택된 항목은 인접해야 합니다.		
			 2. 선택 상태 관리 :	
				- 선택된 항목의 인덱스를 얻거나 설정할 수 있습니다.
				- 선택 상태가 변경될 때 이벤트를 발생시킬 수 있습니다.		 
			 3. 이벤트 리스너:
				- ListSelectionListener 인터페이스를 구현하여 선택 상태가 변경될 때의 동작을 정의할 수 있습니다.
         */
        // 리스트의 선택 모드를 단일 선택으로 설정
        userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 사용자가 하나의 항목만 선택 가능
        //자신의 이름을 비활성화하는 커스텀 렌더러를 JList에 적용
        //이 메서드는 리스트 항목을 어떻게 표시할지를 결정하는 렌더러를 설정합니다. 
        //DisabledItemCellRenderer는 특정 조건(자기 자신)에서 항목을 비활성화하여 회색으로 표시하게 됩니다.
        userList.setCellRenderer(new DisabledItemCellRenderer()); // 자신의 이름을 비활성화하는 렌더러 적용
        
        // 메시지 전송 버튼을 생성하고 "메시지 전송" 텍스트를 설정
        JButton sendButton = new JButton("메시지 전송");

        // 버튼에 클릭 이벤트 리스너를 추가
        sendButton.addActionListener(new ActionListener() { // ActionListener의 익명 클래스를 생성
            @Override
            public void actionPerformed(ActionEvent e) { // 버튼이 클릭되면 실행될 동작 정의
                sendMessage(textField.getText()); // 입력 필드에서 텍스트를 가져와 서버로 전송
                textField.setText(""); // 메시지를 전송한 후 입력 필드를 초기화하여 비우기
            }
        });

        
       // 귓속말 보내기 버튼을 생성하고 "귓속말 보내기" 텍스트를 설정
        JButton whisperButton = new JButton("귓속말 보내기");

        // 버튼에 클릭 이벤트 리스너를 추가
        whisperButton.addActionListener(new ActionListener() { // ActionListener의 익명 클래스를 생성
            @Override
            public void actionPerformed(ActionEvent e) { // 버튼이 클릭되면 실행될 동작 정의
                sendWhisper(); // 귓속말 전송 기능 실행
            }
        });


     // 👥 사용자 목록 및 버튼 영역 설정
     // 1. 사용자 목록을 담을 패널 생성 (BorderLayout: 상/하/좌/우/중앙 구분)
     JPanel userPanel = new JPanel(new BorderLayout()); // 🖼️ 빈 액자 생성 (5개 구역)

     // 2. 사용자 목록을 스크롤 가능하게 설정 ➡️ 액자 중앙에 부착
     userPanel.add(new JScrollPane(userList), BorderLayout.CENTER); // 📜 두루마리 명단을 액자 가운데

     // 3. 버튼들을 담을 작은 패널 생성 (GridLayout: 1행 2열 표 형식)
     JPanel buttonPanel = new JPanel(new GridLayout(1, 2)); // 🔳 2칸 빈 상자 준비

     // 4. 버튼들을 상자에 차례로 넣기
     buttonPanel.add(sendButton);    // 왼쪽 칸에 [메시지 전송] 버튼 부착
     buttonPanel.add(whisperButton); // 오른쪽 칸에 [귓속말] 버튼 부착

     // 5. 버튼 상자를 사용자 패널의 아래쪽에 부착
     userPanel.add(buttonPanel, BorderLayout.SOUTH); // 🔽 액자 하단에 버튼 상자 고정

     // 🖼️ 전체 창 레이아웃 구성
     // 6. 메인 창을 3개 구역으로 분할 (BorderLayout)
     frame.setLayout(new BorderLayout()); // 🎪 공연장 무대 설계도

     // 7. 채팅 내용 표시 영역 (가운데 70% 차지)
     frame.add(new JScrollPane(textArea), BorderLayout.CENTER); // 📜 두루마리 채팅창 무대 중앙

     // 8. 메시지 입력창 (아래쪽 15% 차지)
     frame.add(textField, BorderLayout.SOUTH); // ⌨️ 키보드 입력창 무대 맨 아래

     // 9. 사용자 목록 패널 (오른쪽 15% 차지)
     frame.add(userPanel, BorderLayout.EAST); // 👥 명단판 무대 오른쪽

     // 10. 창 설정 마무리
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ❎ 창 닫으면 프로그램 종료
     frame.pack(); // 👕 옷 접듯 창 크기 자동 맞춤 (컴포넌트 크기 기준)
     frame.setVisible(true); // 👀 창을 보이게 설정 (전원 ON)

        // 엔터 키로 메시지 전송
     	//->JTextField(텍스트 입력 필드)에 액션 이벤트(ActionEvent) 리스너를 추가합니다.
     	//  사용자가 엔터(Enter) 키를 누를 때 이벤트가 발생합니다.
        textField.addActionListener(e -> {
        	//textField.getText()를 통해 사용자가 입력한 텍스트를 가져옵니다.
        	//endMessage() 메서드를 호출하여 입력한 메시지를 서버로 전송합니다.
            sendMessage(textField.getText());
            //메시지를 전송한 후, textField의 내용을 빈 문자열("")로 설정하여 이전 입력을 지웁니다.
            //이를 통해 사용자가 다음 메시지를 입력할 때 기존 메시지가 남아있지 않도록 합니다.
            textField.setText("");
        });

     // 🔹 서버 연결 시도
        try {
            // ✅ 1. 서버에 연결 (IP 주소: localhost, 포트: 12344)
            //    - `localhost`: 현재 실행 중인 PC에서 서버를 찾음 (같은 컴퓨터 내에서 실행 중인 서버에 연결)
            //    - `12345`: 서버가 열어둔 포트 번호
            //    - `socket` 객체를 생성하면 자동으로 서버에 연결을 시도함
            socket = new Socket("localhost", 12344); 

            // ✅ 2. 서버에서 보낸 데이터를 읽기 위한 입력 스트림 설정
            //    - `socket.getInputStream()`: 소켓의 입력 스트림을 가져옴 (바이트 스트림)
            //    - `InputStreamReader`: 바이트 스트림을 문자 스트림으로 변환
            //    - `BufferedReader`: 성능 향상을 위해 한 줄씩 읽을 수 있도록 버퍼링 기능 제공
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // ✅ 3. 서버로 데이터를 보내기 위한 출력 스트림 설정
            //    - `socket.getOutputStream()`: 소켓의 출력 스트림을 가져옴 (바이트 스트림)
            //    - `PrintWriter`: 문자 기반 출력 스트림 (자동 줄바꿈 옵션 사용)
            //    - `true` 설정: `autoFlush` 기능 활성화 (데이터를 즉시 서버로 전송)
            out = new PrintWriter(socket.getOutputStream(), true);

            // ✅ 4. 사용자 이름 입력 받기
            //    - `JOptionPane.showInputDialog()`: 팝업 창을 띄워 사용자에게 이름을 입력받음
            userName = JOptionPane.showInputDialog("이름을 입력하세요:");

            // ✅ 5. 서버로 사용자 이름 전송
            //    - 서버에서 클라이언트의 닉네임을 등록하고 사용자 목록을 업데이트하는 데 사용됨
            out.println(userName);

            // ✅ 6. 서버에서 오는 메시지를 처리하는 스레드 실행
            //    - 새로운 `IncomingReader` 객체를 생성하고, 이를 별도의 스레드에서 실행
            //    - 서버에서 실시간으로 오는 메시지를 계속 수신하여 화면에 출력하는 역할을 함
            new Thread(new IncomingReader()).start();

        } catch (IOException e) {
            // ❌ 7. 연결 오류 발생 시 예외 처리
            //    - 서버가 실행 중이지 않거나, 네트워크 문제가 있는 경우 예외 발생
            //    - `printStackTrace()`: 오류 정보를 출력하여 디버깅 가능하도록 함
            e.printStackTrace();
        }

    }

 // ✅ 메시지를 서버로 전송하는 메서드
 
    private static void sendMessage(String message) {
        // 🔹 1. 서버와의 연결이 정상적으로 되어 있는지 확인 (`out`이 null이 아니어야 함)
        //    - 만약 `out`이 null이면 소켓 연결이 끊어진 상태일 가능성이 있음
        //    - 이 체크를 추가함으로써 NullPointerException 방지
        if (out != null) {
            // 🔹 2. 메시지가 비어 있지 않은지 확인 (공백 문자열 전송 방지)
            //    - `trim()`: 문자열 양 끝의 공백 제거
            //    - `isEmpty()`: 공백을 제거한 후 문자열이 완전히 비어 있는지 확인
            if (!message.trim().isEmpty()) {
                // 🔹 3. 서버로 메시지 전송
                //    - `out.println(message)`: 서버로 입력된 메시지를 전송
                //    - 서버는 이 메시지를 받아 모든 클라이언트에게 브로드캐스트(전파)함
                out.println(message);
            }
        } else {
            // 🔹 4. 서버 연결이 끊어졌을 경우 사용자에게 경고 메시지 출력
            System.err.println("❌ 서버 연결이 끊어졌습니다. 메시지를 보낼 수 없습니다.");
        }
    }
    /*
    ✅ 실행 흐름:
  			1. 서버와 연결이 유지되고 있는지 확인
  			- out이 null이면 연결이 끊어진 것이므로 메시지를 보낼 수 없음.
  			- null 체크를 통해 NullPointerException 방지.
  			
  			2.입력된 메시지가 공백인지 검사
  			 - trim().isEmpty()를 사용하여 공백 문자열을 전송하지 않도록 함.
  			
  			3.서버로 메시지 전송
  			 - out.println(message)를 통해 메시지를 서버로 보냄.
  			 - 서버는 이 메시지를 받아서 모든 클라이언트에게 전달함.
  			
  			4.서버 연결이 끊어졌을 경우 오류 메시지 출력
  			 - System.err.println()을 사용해 콘솔에 경고 메시지를 출력.   
    */
    
    
    


 // ✅ 선택된 사용자에게 귓속말(개인 메시지)을 보내는 메서드
    private static void sendWhisper() {
        // 🔹 1. 현재 사용자가 선택한 채팅 참여자의 이름을 가져옴
        //    - `userList.getSelectedValue()`: GUI의 사용자 목록에서 선택된 사용자의 이름을 반환
        String selectedUser = userList.getSelectedValue();

        // 🔹 2. 선택된 사용자가 존재하고, 자신에게 귓속말을 보내려는 것이 아닐 경우에만 실행
        if (selectedUser != null && !selectedUser.equals(userName)) {
            // 🔹 3. 텍스트 입력 필드에서 사용자가 입력한 메시지를 가져옴
            String message = textField.getText();

            // 🔹 4. 메시지가 공백이 아닐 경우에만 실행 (빈 메시지 전송 방지)
            if (!message.trim().isEmpty()) {
                // 🔹 5. 귓속말 명령어를 서버로 전송
                //    - `/whisper [대상 사용자] [메시지]` 형식으로 서버에 전달
                //    - 서버는 이를 분석하여 해당 사용자에게만 메시지를 보냄
                out.println("/whisper " + selectedUser + " " + message);

                // 🔹 6. 메시지를 보낸 후 입력 필드를 초기화 (비워줌)
                textField.setText("");
            }
        } else {
            // 🔹 7. 사용자가 아무도 선택되지 않았거나 자기 자신을 선택한 경우
            //    - 경고 메시지를 띄워 올바른 사용자를 선택하도록 유도
            JOptionPane.showMessageDialog(null, "귓속말을 보낼 사용자를 선택하세요.");
        }
    }



 // ✅ 서버에서 오는 메시지를 처리하는 스레드 클래스
    private static class IncomingReader implements Runnable {
        public void run() {
            String message; // 서버에서 받은 메시지를 저장할 변수
            try {
                // 🔹 1. 서버로부터 지속적으로 메시지를 읽어오는 루프
                while ((message = in.readLine()) != null) {
                    // 🔹 2. 서버가 클라이언트 목록을 전송한 경우 (USERLIST로 시작하는 메시지)
                    if (message.startsWith("USERLIST")) {
                        //    - "USERLIST 사용자1 사용자2 ..." 형태로 전송됨
                        //    - 공백을 기준으로 메시지를 분리하여 배열로 저장
                        String[] users = message.split(" ");

                        // 🔹 3. 기존 사용자 목록을 초기화
                        userListModel.clear();

                        // 🔹 4. 새로운 사용자 목록을 추가 (첫 번째 요소 'USERLIST'는 제외)
                        for (int i = 1; i < users.length; i++) {
                            userListModel.addElement(users[i]);
                        }
                    } else {
                        // 🔹 5. 일반 채팅 메시지인 경우 채팅창(textArea)에 출력
                        textArea.append(message + "\n");

                        // 🔹 6. 채팅창의 스크롤을 가장 아래로 이동 (새 메시지가 보이도록)
                        textArea.setCaretPosition(textArea.getDocument().getLength());
                    }
                }
            } catch (IOException e) {
                // 🔹 7. 서버 연결이 끊어지거나 오류 발생 시 예외 처리
                e.printStackTrace();
            }
        }
    }

  
    
	 /*   
	    🔹 이 클래스의 역할
	    ✅ JList의 항목(사용자 이름)을 어떻게 그릴지 결정하는 ListCellRenderer를 커스터마이징
	    ✅ 현재 로그인한 사용자의 이름은 비활성화(회색, 기울임꼴)로 표시
	    ✅ 마우스를 올리면 툴팁이 나타나서 설명 제공
	 */   
	 // 👤 사용자 목록에서 자기 이름을 특별히 표시하는 클래스 선언  
	//  - DisabledItemCellRenderer: "명단 디자인 전문가"를 고용한다고 생각
	//  - extends DefaultListCellRenderer: "기본 명단 디자인 매뉴얼"을 상속받음
	private static class DisabledItemCellRenderer extends DefaultListCellRenderer {
	  
	  // 🖌️ 각 사용자 이름을 화면에 그리는 방법을 정의하는 메서드 오버라이딩
	  @Override
	  public Component getListCellRendererComponent(
	      JList<?> list,       // 사용자 목록 객체 (전체 명단판)
	      Object value,        // 현재 그릴 항목의 값 (예: "영희")
	      int index,           // 항목의 순번 (0번부터 시작)
	      boolean isSelected,  // 현재 항목이 선택되었는지 (파란 배경 여부)
	      boolean cellHasFocus // 항목에 포커스가 있는지 (키보드 선택 여부)
	  ) {
	      // 🔹 1. 기본 스타일 가져오기: 부모 클래스의 기본 스타일을 적용
	      //    - `super.getListCellRendererComponent()`: 기존 스타일 유지 + 새 항목 적용
	      JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	
	      // 🔹 2. 내 이름인지 확인 (null 체크 포함)
	      //    - `==`는 참조 비교, `equals()`는 값 비교 (둘 다 사용하여 안전하게 확인)
	      boolean isSelf = (value != null) && 
	                      (value == userName || value.equals(userName));
	
	      // 🔹 3. 내 이름일 경우 특별한 스타일 적용
	      if (isSelf) {
	          label.setEnabled(false);  // 비활성화 (선택 불가능)
	          label.setForeground(new Color(0x666666)); // 글자색: 어두운 회색 (#666666)
	          label.setBackground(list.getBackground()); // 배경색: 기본 목록 배경과 동일하게 설정
	          label.setFont(label.getFont().deriveFont(Font.ITALIC)); // 글꼴: 기울임꼴 (Italic)
	      }
	
	      // 🔹 4. 툴팁 설정: 마우스를 올리면 설명이 표시됨
	      //    - 본인 계정이면 "본인 계정" 표시, 아니면 "다른 사용자" 표시
	      label.setToolTipText(isSelf ? "본인 계정" : "다른 사용자");
	
	      // 🔹 5. 완성된 디자인 반환 (이 설정들이 적용된 라벨을 목록에 전달)
	      return label;
	  }
	}

}
