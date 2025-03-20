
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


//주제 : 배치관리자 없는 컨테이너에 컴포넌트 위치와 크기를 절대적으로 지정

public class NullContainerEx extends JFrame {
	
	public NullContainerEx() {
		
		setTitle("NullFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//프레임창에 자동으로 부착된 ContentPane내부의 기본값 제거
		setLayout(null);
		
		//JLabel컴포넌트를 생성하고 직접 프레임창 내부의 도화지에 배치할 위치와 크기를 지정한다
		JLabel jLabel = new JLabel("Hello, Press Buttons!");
		
		//JLabel컴포넌트를 x축 130px, y축 50px 위치에 배치
		jLabel.setLocation(130, 50);
		
		//JLabel컴포넌트 영역 크기를 너비 200px, 높이 20px로 설정
		jLabel.setSize(200, 20);
		
		//프레임창 내부의 ContentPane도화지영역에 추가
		add(jLabel);
		
		//9개의 JButton컴포넌트를 생성하고 모두 동일한 크기로 설정
		for(int i=1; i<=9; i++) {
			//JButton컴포넌트 생성
			JButton jButton = new JButton(Integer.toString(i));
			//JButton컴포넌트를 수동으로 배치할 위치 설정
			jButton.setLocation(i*15, i*15);
			//JButton컴포넌트의 크기를 동일하게 너비50px, 높이20px 크기로 설정
			jButton.setSize(50, 20);
			//JButton컴포넌트를 ContentPane에 부착
			add(jButton);
			
		}

		setSize(300, 300);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new NullContainerEx();

	}

}
