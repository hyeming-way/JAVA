package event5;

//문제 주제 : 마우스 이벤트 리스너작성 연습-마우스로문자열이동시키기 (어댑터 사용)
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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//사용자 정의 프레임창 
public class MouseAdapterEx extends JFrame  {
	//JLabel 객체를 생성하여 텍스트 "Hello"를 화면에 표시 할수 있도록 생성
	private JLabel la = new JLabel("Hello");
	
	//생성자 : 프레임창을 설정하고, 마우스 이벤트를 처리할 리스너를 등록하고, JLabel영역 배치 
	public MouseAdapterEx() {
		//프레임창 제목 
		this.setTitle("Mouse...");
		
		//프레임창 닫을때 자바프로그램까지 완정 종료되도록 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//프레임창 객체를 생성하면 자동으로 부착되어 있는 ContnetPane(도화지) 객체 얻기
		Container c = this.getContentPane();
		
		//*************************************************
		//ContentPane(도화지)이벤트소스에 마우스를클릭했을때 이벤트를 처리할 이벤트리스너 등록
		c.addMouseListener( new MyMouseListener());
		//*************************************************		
		
		//컨텐트팬의배치관리자: BoardLayOut배치관리자삭제
		c.setLayout(null);
		
		// JLabel(la)의 크기를 50x20으로 설정
		// JLabel은 텍스트를 표시하는 컴포넌트로,
		//          크기를 명시적으로 설정하여 레이블을 화면에 맞게 조정한다.
		la.setSize(50, 20);
		
		// JLabel(la)의 위치를 (30, 30)으로 설정
		// 레이블을 화면의 (30, 30) 위치에 배치한다.
		// 위치는 좌측 상단을 기준으로 (x, y) 좌표로 설정된다.
		la.setLocation(30, 30);
		
		//ConentPane(도화지)에 JLabel(la)을 추가하여 화면에 표시
		c.add(la);
		
		//프레임창 사이즈(너비,높이) 및 보이게 설정
		this.setSize(200, 200);  this.setVisible(true);	
		
	}//외부 class MouseListenerEx extends JFrame{}창의 생성자 
	
//내부 MyMouseListener클래스로 - 이벤트 리스너 클래스 정의 
	//-> MouseListener인터페이스를 구현한 MyMouseListener클래스로 만들기
	
	 // MouseAdapter를 상속받아 마우스 이벤트를 처리할 리스너 클래스를 작성
	 // MouseAdapter 클래스는 MouseListener 인터페이스의 구현체로, 
	 // 모든 메서드를 기본 구현(빈 구현)으로 제공
	 // 그래서 필요한 메서드만 오버라이드할 수 있다.
	class MyMouseListener extends MouseAdapter{

		//마우스 버튼을 눌러질때 호출되는 콜백메소드 오버라이딩 
		@Override
		public void mousePressed(MouseEvent e) {
			//마우스가 눌린 위치의 X, Y좌표를 가져옵니다.
			//e.getX() 메소드는 마우스가 눌러진 위치의 X좌표를 반환
			//e.getY() 메소드는 마우스가 눌러진 위치의 Y좌표를 반환
			 int x = e.getX();
			 int y = e.getY();
			 
			// JLabel(la)의 위치를 마우스가 눌린 X, Y 좌표로 이동
			// 즉, 사용자가 마우스를 눌렀을 때 "Hello" 레이블이 해당 위치로 이동
			// 이때 레이블의 기존 위치는 변경되며, 마우스를 클릭한 좌표로 다시 그려지게 된다.
			 la.setLocation(x, y);	
		}

	}

	public static void main(String[] args) {
		new MouseAdapterEx(); //사용자 정의 프레임창 클래스의 객체 생성 

	}

}
/*
	결론
	MouseAdapter를 이용한 코드는 
	MouseListener인터페이스 대신 MouseAdapter추상클래스를 사용하여 
	이벤트 메서드 중 필요한 메서드만 오버라이드할 수 있습니다. 
	MouseAdapter는 MouseListener를 구현하는 추상 클래스로, 
	기본적으로 MouseListener의 모든 메서드에 대해 빈 구현을 제공하므로, 
	필요한 메서드만 오버라이드하여 간결한 코드를 작성할 수 있습니다.
*/











