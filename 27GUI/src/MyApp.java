
//프레임? 윈도우 창 같은 컨테이너

//프레임 창 만들기 두가지 방법
//방법1. main()메소드 내부에 자바문법에서 제공하는 JFrame클래스의 객체를 생성해서 사용
//방법2. 자바문법에서 제공하는 JFrame클래스를 상속받은 개발자가 만드는 사용자정의 프레임창 클래스 설계 후
//		main()메소드 내부에서 객체를 생성해서 사용 (추천)


//방법1. main()메소드 내부에 자바문법에서 제공하는 JFrame클래스의 객체를 생성해서 사용
//순서1. awt패키지, swing패키지 사용을 위한 import
import java.awt.*; //<--- 디자인 관련 클래스나 인터페이스 포함
import java.awt.event.*; //<--- 이벤트 처리 관련 클래스나 인터페이스 포함

import javax.swing.*; //<--- 디자인 관련 클래스나 인터페이스 포함
import javax.swing.event.*; //<--- 이벤트 처리 관련 클래스나 인터페이스 포함

public class MyApp {
	public static void main(String[] args) {
		
		//순서2. JFrame클래스의 객체 생성 (프레임 창 만들기 위함)
		//-> 프레임창 생성시 생성자로 창제목 설정
		JFrame jFrame = new JFrame("첫번째 프레임");
		
		//-> 프레임창의 창제목 변경
		jFrame.setTitle("방법1. 프레임");
		
		/*
			AWT패키지   -> Frame	    프레임창 만들 때 사용
			SWING패키지 -> JFrame		프레임창 만들 때 사용
			
			생성된 JFrame객체의 3공간
			  - 공간1 : MenuBar	   -> 상단 메뉴 영역
			  - 공간2 : Frame	   -> 전체 프레임 창 영역
			  - 공간3 : ContentPane -> 화면에 출력되는 모든 컴포넌트들이 부착되는 공간(도화지)
			  						  예) 컴포넌트들 : JButton, JLabel, JTextField 등등...
			  						  
		*/
		
		//중요! SWING에서는 ContentPane에만 컴포넌트를 부착할 수 있다.
		//중요! ContentPane은 JFrame객체가 처음 생성될 때 자동으로 생성되어 JFrame에 포함되어 있다.
		//	   ContrentPane을 JFrame컨테이너에서 떼어내서(얻어서) 여러 컴포넌트들을 부착해야한다.
		
		//순서2-1. JFrame객체의 getContentPane()메소드를 호출하면
		//		  반환값으로 JFrame창에 부작된 ContentPane컨테이너(도화지)객체 영역을 얻을 수 있다.
		Container contentPane = jFrame.getContentPane();
		
		//순서2-2. 부착된 ContentPane컨테이너(도화지)에 부착할 버튼 생성
		//버튼 생성방법 -> JButton클래스의 객체를 생성하면 됨
		JButton jButton1 = new JButton("Click");
	
		//순서2-3. JButton클래스로 만든 Click버튼 컴포넌트를 순서2-1에서 작성한 ContentPane(도화지)에 부착(추가)
		contentPane.add(jButton1);
		
		//순서2-5. ContentPane컨테이너(도화지) 변경하기
		//설명 : JFrame객체 생성시 자동으로 붙어있는 ContentPane을 제거하고
		//		새로운 컨테이너(도화지)(JPanel클래스의 객체 생성)를 만들어 JFrame창에 붙이기
//		JPanel jPanel = new JPanel();
//		jFrame.setContentPane(jPanel);
		
		//순서2-4. JFrame창 너비 300px, 높이 300px 크기로 설정 후 화면에 보이게 설정
		jFrame.setSize(300, 300); //너비, 높이 설정
		jFrame.setVisible(true); //화면에 보이게 설정
		
		
		//결론1: 방법1은 단순하지만 권장되지 않는다.
		//프레임에 스윙 컴포넌트를 추가하는 과정이 불편하며,
		//확장성, 융통성이 결여되는 단점이 있기 때문임.
			
		//결론2: JDK1.5버전부터는 JFrame을 수정하여..
		//개발자가 내부적으로 JFrame의 add()메소드는..
		//추가되는컴포넌트를 자동으로 컨텐트 팬에 부착하도록 하고 있음
		//따라서.. 개발자들은 컨텐트팬을 의식하지 않고..
		//직접 JFrame에 컴포넌트를 추가할 수 있다.
		/*
		JFrame frame = new JFrame();
		JButton b1 = new JButton("Click");
		frame.add(b1); //add()메소드가 컨텐트팬에 b1을 부착한다.

		*/
		
	}

}
