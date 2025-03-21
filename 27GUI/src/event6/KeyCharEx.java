package event6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//주제 : 컨텐트팬에<Enter> 키를 입력할 때마다배경색을랜덤하게바꾸고, 'q' 키를 입력하면 프로그램을종료시켜라.

//조건
//• 컨텐트팬에키리스너를달고,포커스를주어,키입력을받도록해야한다. 
//• 색은 new Color(int r, int g, int b)로 생성한다. 
//  r(red), g(green), b(blue)는 색의 3요소로서 0~255 사이의 값이다.

//프레임창
public class KeyCharEx extends JFrame {
	
	private JLabel la = new JLabel("<Enter>키로 배경색이 바뀝니다.");
	
	//프레임창 설정하고, 키 이벤트를 처리할 내부 리스너클래스의 객체를 등록
	public KeyCharEx() {
		
		//프레임창 제목을 저장
		super("keyListener의 문자키 입력 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(la);
		
		//컨텐트팬에 Key이벤트를 처리할 이벤트리스너 객체 생성 후 등록 
		c.addKeyListener(new MyKeyListener());
		
		setSize(250, 150);
		setVisible(true);
	
		//ContentPane 키 입력 받을 수 있도록 포커스를 강제로 설정
		//포커스를 주지않으면 키 입력을 받을 수 없다.
		c.setFocusable(true); //포커스 강제 설정
		
		//ContentPane에 포커스를 요청하여 키 입력을 받을 수 있도록 함
		c.requestFocus(); //키 입력 받을 수 있도록 ContentPane에 포커스 설정

	} //KeyCharEx 클래스의 생성자
	
	//내부 클래스로 Key 이벤트가 발생하면 처리할 이벤트리스너 클래스 (어댑터 사용)
	private class MyKeyListener extends KeyAdapter {

		//keyPressed 메소드는 키가 눌렸을 때 호출되는 메소드
		//이 메소드 안에 키 입력에 따른 동작을 정의한다.
		@Override
		public void keyPressed(KeyEvent e) {
			
			//랜덤한 배경색을 만들기 위해 r, g, b 값 (0~255 범위) 무작위로 생성
			//Math.random()을 사용하여 0.0과 1.0사이의 실수를 얻고,
			//이를 256과 곱해 0 ~ 255 사이의 값을 생성합니다.
			int r = (int) (Math.random() * 256); //빨간색
			int g = (int) (Math.random() * 256); //초록색
			int b = (int) (Math.random() * 256); //파란색
			
			//사용자가 누른 키가 어떤 문자인지 확인(입력된 키를 기준으로 조건을 나누기 위해
			//e.getKeyChar()는 사용자가 눌렀던 키 문자를 반환한다.
			switch (e.getKeyChar()) {
			
				case '\n': //<Enter>키가 눌리면
					//JLabel에 생성된 색상 값(r, g, b)을 텍스트로 표시
					//사용자 <Enter>키를 눌렀을 때 랜덤 색상이 생성되어 화면에 표시
					la.setText("r=" + r + ", g=" + g + ", b=" + b);
					
					//배경색으로 랜덤으로 변경(Color 클래스에 생성된 색상 값 전달)
					//new Color(r, g, b)는 빨강, 초록, 파랑의 성분을 섞어서 하나의 색으로 만듭니다.
					//ContentPane을 얻어 배경색 랜덤으로 변경
					getContentPane().setBackground(new Color(r, g, b));	
					break;
					
				case 'q': //'q'키가 눌리면
					//자바프로그램 강제 종료
					System.exit(0);
					break;
					
			}
			
		}

	} 
	
	public static void main(String[] args) {
		
		new KeyCharEx();

	}

}
