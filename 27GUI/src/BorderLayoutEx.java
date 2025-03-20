
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
	배치관리자 종류 : BorderLayout클래스
	
	  - 컨테이너 공간을 5구역으로 분할해서 배치하는 배치관리자 클래스 종류 중 하나
	  	(East, West, South, North, Center)
	  	
	  - add 메소드를 이용한 배치 방법
	  		
	  		add(component comp, int index)
	  		- comp를 indext의 공간에 배치
	  		
	  - 컨테이너의 크기가 변경되면 컴포넌트들을 재배치 하게됨		
	  
*/

//사용자정의 프레임창 역할의 클래스 생성
class BorderFrame extends JFrame {
	
	public BorderFrame() {
		
		setTitle("BorderFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		add(new JButton("add"), BorderLayout.NORTH);
		add(new JButton("sub"), BorderLayout.SOUTH);
		add(new JButton("mul"), BorderLayout.EAST);
		add(new JButton("div"), BorderLayout.WEST);
		add(new JButton("Calculate"), BorderLayout.CENTER);
		
		setSize(300, 300);
		setVisible(true);
		
	}
	
}

public class BorderLayoutEx {
	public static void main(String[] args) {
		
		new BorderFrame();
	
	}
}
