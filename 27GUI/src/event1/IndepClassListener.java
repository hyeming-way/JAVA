
package event1;

//필요한 라이브러리 가져오기
import java.awt.*; //GUI(화면 구성)관련 클래스, 인너페이스 기능 제공
import java.awt.event.*; //이벤트 처리 관련 기능 제공
import javax.swing.*; //SWING패키지 - GUI(화면구성요소제공)
import javax.swing.event.*; //이벤트 처리 관련 기능 제공


//주제 : 독립 클래스로 Action 이벤트 리스너 클래스 만들기

//프레임창 클래스
public class IndepClassListener extends JFrame {
	
	public IndepClassListener() {
		
		setTitle("Action 이벤트 리스너 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//프레임창 생성시 자동으로 부착된 ContentPane얻기
		Container c = getContentPane();
		
		//배치관리자 설정
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		
		//버튼을 클릭했을 때 실행할 동작(이벤트) 설정*****************************
		btn.addActionListener(new MyActionListener());
		
		c.add(btn);
		
		setSize(250, 120);
		setVisible(true);
	}
		
	public static void main(String[] args) {
		
		new IndepClassListener();
		
	}

} //public class IndepClassListener

//독립된 클래스로 이벤트를 처리할 이벤트 리스너 클래스 만들기
//독립적인 클래스로 분리하여 재사용 가능하게 합니다.
class MyActionListener implements ActionListener {
	
	//버튼이 클릭될 때 자동으로 실행되는 메소드(이벤트 핸들러)
	//-> 사용자가 버튼을 누르면 아래의 코드가 실행됩니다.
	@Override
	public void actionPerformed(ActionEvent e) { //<-- Action 이벤트가 발생하면
												 //현재 자바프로그램에 의해 이벤트 분배스레드가 만들어지고
												 //이벤트 분배스레드는 ActionEvent객체를 생성해 매개변수 e로 전달해줍니다.
		
		System.out.println("클릭했다.");
		//사용자가 클릭한 버튼 컴포넌트 객체를 가져온다.
		//e.getSource()메소드는 이벤트가 발생한 객체를 반환하는데
		//이 객체는 기본적으로 Object 참조변수에 저장할 객체이므로 JButton타입으로 다운캐스팅해서 저장해야함
		JButton b = (JButton)e.getSource();
		
		//버튼의 현재 텍스트(버튼 위에 써 있는 글자)를 가져옵니다.
		//JButton의 getText()메소드를 호출하면 반환받을 수 있음
		
		//만약 클린한 버튼의 글자가 "Action"이라면 "액션"으로 변경
		if(b.getText().equals("Action")) {
			//클릭한 버튼의 글자를 한글 "액션"으로 변경해서 설정
			b.setText("액션");
			
		} else { //만약 클릭한 버튼의 글자가 "액션"이라면?
			b.setText("Action");
		}
		
	} //actionPerformed
		
}


