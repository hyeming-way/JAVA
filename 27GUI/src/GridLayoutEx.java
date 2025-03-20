
/*
	GridLayout배치방법
	  - 컨테이너 공간을 동일한 사각형 격자(그리드)로 분할하고 각 셀에 하나의 컴포넌트 배치
	  - 격자 구성은 생성자에 행수와 열수 지정
	  - 셀에 왼쪽에서 오른쪽으로 다시 위에서 아래로 순서대로 배치
*/

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


//사용자 정의 프레임창 역할을 하는 클래스 설계
//4행 2열 그리드형태의 표를 구성해서 컴포넌트 배치
public class GridLayoutEx extends JFrame {
	public GridLayoutEx() {
		setTitle("GridFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout gridLayout = new GridLayout(4, 2);
		
		//배치되는 컴포넌트사이의 수직 간격을 5px로 설정
		gridLayout.setVgap(5);
		
		//GridLayout배치관리자를 프레임창의 ContentPane에 등록
		setLayout(gridLayout);
		
		//JLabel컴포넌트
		// - JAVA SWING에서 텍스트, 이미지 또는 둘다를 표시하는 영역의 컴포넌트
		
		//JTextField컴포넌트
				// - 한 줄의 텍스트를 입력할 수 있는 컴포넌트(input태그와 동일)
		
		add(new JLabel(" 이름"));
		add(new JTextField(""));
		
		add(new JLabel(" 학번"));
		add(new JTextField(""));
		
		add(new JLabel(" 학과"));
		add(new JTextField(""));
		
		add(new JLabel(" 과목"));
		add(new JTextField(""));

		setSize(300, 200);		
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		
		new GridLayoutEx();
	
	}

}
