
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;



//배치관리자 -> FlowLayout클래스 역할
// - 컨테이너 공간 내에 왼쪽에서 오른쪽 방향으로 컴포넌트들을 배치하되
//   공간이 없으면 아래로 내려와 왼쪽에서 오른쪽방향으로 컴포넌트들을 다시 배치함



//사용자 정의 프레임창 역할을 하는 클래스 설계
class FlowFrame extends JFrame {
	
	public FlowFrame() {
		
		setTitle("FlowFrame"); //프레임 창 제목 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임창 닫으면ㄴ서 자바프로그램 강제 종료 설정
		setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40)); //배치관리자 설정
						//컴포넌트 정렬, 컴포넌트 수평 간격(디폴트 5), 컴포넌트 수직 간격 설정(디폴트 5)
	
		//버튼 컴포넌트 생성
		add(new JButton("add"));
		add(new JButton("sub"));
		add(new JButton("mul"));
		add(new JButton("div"));
		add(new JButton("Calculate"));
		
		//프레임창 크기 설정
		setSize(300, 250);
		
		//프레임창 보이게 설정
		setVisible(true);
		
	}
	
} 

public class FlowLayoutEx {
	public static void main(String[] args) {
		
		new FlowFrame();
		
	}

}
