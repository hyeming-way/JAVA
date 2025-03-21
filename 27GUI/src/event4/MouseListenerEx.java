package event4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//문제 주제 : 마우스 이벤트 리스너작성 연습-마우스로문자열이동시키기
/*
	문제 내용
	아래실행화면과같이프레임의임의의위치에마우스버튼을누르면마우스포인터가있는위치에
	"Hello" 문자열을 출력하는 프로그램을 작성하라
	
	• 마우스버튼을누르면마우스가있는위치로"Hello" 문자열을이동시킨다.
	• 이벤트와리스너: MouseEvent와 MouseListener
	• 이벤트소스: 컨텐트팬
	• 컨텐트팬의배치관리자: 배치관리자삭제
	• 구현할리스너의메소드: mousePressed()
	• "Hello" 문자열 : JLabel 컴포넌트 이용

*/

public class MouseListenerEx extends JFrame {
	
	private JLabel la = new JLabel("Hello"); //생성자 안에 만들어도 상관 X
	
	public MouseListenerEx() {
		
		setTitle("Mouse 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.addMouseListener(new MouseListener() {
			
			//눌러진 마우스 버튼을 뗴었을때 호출되는 콜백메소드 오버라이딩 
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			//마우스 버튼을 눌러질때 호출되는 콜백메소드 오버라이딩 
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				la.setLocation(x, y);
			}
			
			//마우스 포인터가 컴포넌트에 진입해 있는 상황에서 다른곳으로 떠날때 호출되는 콜백메소드 오버라이딩
			@Override
			public void mouseExited(MouseEvent e) {}
			
			//마우스 포인터가 컴포넌트에 진입했을때 호출되는 콜백메소드 오버라이딩 
			//즉!~ JLabel영역이나 다른 컴포넌트에 진입할때 호출되는 콜백메소드 
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			//마우스를 클릭 한 순간 호출되는 콜백메소드 오버라이딩 
			@Override
			public void mouseClicked(MouseEvent e) {}
			
		});
		
		c.setLayout(null);
		la.setSize(50, 20);		
		la.setLocation(30, 30);
		c.add(la);
		
		setSize(200, 200);
		setVisible(true);
		
	}
	

	public static void main(String[] args) {
		
		new MouseListenerEx();

	}

}
