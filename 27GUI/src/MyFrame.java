
//프레임? 윈도우 창 같은 컨테이너

//프레임 창 만들기 두가지 방법
//방법1. main()메소드 내부에 자바문법에서 제공하는 JFrame클래스의 객체를 생성해서 사용
//방법2. 자바문법에서 제공하는 JFrame클래스를 상속받은 개발자가 만드는 사용자정의 프레임창 클래스 설계 후
//		main()메소드 내부에서 객체를 생성해서 사용 (추천)


//방법2. 자바문법에서 제공하는 JFrame클래스를 상속받은 개발자가 만드는 사용자정의 프레임창 클래스 설계 후
//		main()메소드 내부에서 객체를 생성해서 사용 (추천)

//순서1. awt패키지, swing패키지 사용을 위한 import
import java.awt.*; //<--- 디자인 관련 클래스나 인터페이스 포함
import java.awt.event.*; //<--- 이벤트 처리 관련 클래스나 인터페이스 포함

import javax.swing.*; //<--- 디자인 관련 클래스나 인터페이스 포함
import javax.swing.event.*; //<--- 이벤트 처리 관련 클래스나 인터페이스 포함

//순서2. 자바 문법에서 제공되는 JFrame클래스를 상속받아 사용자정의 프레임창(MyFrame)클래스 설계
public class MyFrame extends JFrame {
	
	//순서3. 생성자 내부에서 프레임창 제목, 컴포넌트 생성 후 프레임창에 부착, 너비, 높이, 보이게 설정
	public MyFrame() {
		//프레임창 제목 설정 (this 생략가능)
		this.setTitle("방법2. 프레임");
		
		//버튼 컴포넌트 생성
		JButton jButton = new JButton("클릭");
		//만든 버튼 컴포넌트 MyFrame프레임창 내부에 있는 컨텐트팬에 부착
		this.add(jButton);
		
		this.setSize(300, 300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		//순서4. 사용자정의 프레임창(MyFrame)클래스의 객체 생성
		new MyFrame();

	}

}

//결론 : 개발자는 MyFrame()생성자에 필요한 코드를 마음대로 추가 할수 있다.
//방법2는 방법1보다 가독성 측면에서 좋으며.. 
//MyFrame클래스에 마음대로 메소드를 추가 할수 있기 때문에..
//확장성, 융통성이 띄어나다. 방법2 권장함.

