
/*
	JFrame창을 생성하면 자동으로 부착되어 있는 ContentPane(도화지)을 얻어
	도화지의 배경색을 오렌지색으로 설정하고, 도화지에 Ok버튼, Cancel버튼, Ignore버튼 3가지 버튼 컴포넌트들을 생성해서
	부착하는 GUI프로그램 작성
*/

//순서1. import
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//순서2. 사용자정의 프레임창 설계도(클래스) 작성 - JFrame클래스 상속받아 만듬
public class ContentPaneTest extends JFrame {
	
	//순서3. 생성자를 이용해서 프레임창 디자인 설정
	public ContentPaneTest() {
		setTitle("ContentPane과 JFrame"); //프레임창 제목 설정
		
		//프레임창 오른쪽 상단 x를 누르면 프레임창을 닫으면서
		//ContentPaneTest.class프로그램 강제종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Swing에서만 가능, awt에서는 이벤트 처리 해줘야 함
		
		//프레임창에 부착된 ContentPane 얻기
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.ORANGE);
		
		//배치관리자? ContentPane(도화지)컨테이너에 컴포넌트들의 배치 위치와 크기를 관리하는 클래스
		//종류1. FlowLayout 배치관리자 클래스
		// - ContentPane에 컴포넌트를 부착(추가)하는 순서대로 왼쪽에서 오른쪽방향으로 수평배치
		// - 오른쪽 화면에 더이상 배치할 공간이 없으면 왼쪽 아래로 내려와서 다시 왼쪽에서 오른쪽방향으로 수평배치합니다.
		
		//	배치관리자 클래스의 객체를 생성해서
		//ContentPane에 추가(등록)
		contentPane.setLayout(new FlowLayout());
		
		//버튼 컴포넌트들을 생성해서 ContentPane에 배치
		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("Cancel"));
		contentPane.add(new JButton("Ignore"));
		
		//프레임창 사이즈(너비, 높이)설정
		setSize(350, 150);
		setVisible(true);
	
	}	
	
	public static void main(String[] args) {
		
		new ContentPaneTest();
		
}

}
