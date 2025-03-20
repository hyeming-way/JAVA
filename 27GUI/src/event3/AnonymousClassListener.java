package event3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//주제 : 내부 익명 클래스 & 내부 익명 객체로 Action 이벤트 리스너 만들기


//사용자정의 프레임 클래스 설계
public class AnonymousClassListener extends JFrame {
	
	//사용자정의 프레임창을 설정하고 버튼을 배치하는 생성자
	public AnonymousClassListener() {
		
		setTitle("Action 이벤트 리스너 작성");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//프레임창에 자동으로 부착되어있는 ContentPane영역 얻기
		Container c = this.getContentPane();
		c.setLayout( new FlowLayout() );
		
		JButton btn = new JButton("Action");
		c.add(btn);
		
		/*
			사용자정의 프레임창 역할을 하는 AnonymousClassListener 외부클래스의 생성자 내부에
			내부 익명 클래스 형태이자 내부 익명 객체 형태의 이벤트리스너를 생성해서 
			JButton에 등록(추가!)
			
			Action 이벤트 종류가 발생할 것이니 ActionListener 부모인터페이스를 구현한
			내부익명클래스를 구현하는 동시에 new 통해 내부익명객체를 생성해서 넣자
		*/
		
									 //부모인터페이스명
		btn.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Object obj = e.getSource();
				
				JButton jButton = (JButton)obj;
				
				if(jButton.getText().equals("Action")) {
					jButton.setText("액션");
					
					//외부 AnonymousClassListener의 멤버를 호출할 수 있음
					setTitle(jButton.getText());
				} else {
					jButton.setText("Action");
					setTitle(jButton.getText());
				}
			}
			
		} ); //addActionListener
		
		/*
          [람다식 사용] 버튼 클릭 이벤트 처리 
          - 람다식은 함수를 간단하게 표현하는 방법으로, 인터페이스를 구현하는 익명 클래스를 간결하게 대체한다.
          - ActionListener는 함수형 인터페이스(추상메소드를 단 하나만가지는 인터페이스)이므로 람다식을 사용하여 간결하게 표현할 수 있다.
        
        btn.addActionListener( (e) -> {
            // 사용자가 클릭한 버튼의 정보를 가져온다.
            JButton b = (JButton) e.getSource();

            // 버튼의 현재 텍스트(버튼 위에 적힌 글자)를 확인한다.
            if (b.getText().equals("Action")) {
                b.setText("액션");  // 버튼의 글자를 "액션"으로 변경한다.
                // 버튼의 글자가 변경되었으므로, 창의 제목도 그에 맞게 바꿔준다.
                setTitle(b.getText());  // 버튼의 현재 텍스트를 가져와서 창의 제목을 설정한다.
            } else {
                b.setText("Action");  // 버튼의 글자를 "Action"으로 변경한다.
                // 버튼의 글자가 변경되었으므로, 창의 제목도 그에 맞게 바꿔준다.
                setTitle(b.getText());  // 버튼의 현재 텍스트를 가져와서 창의 제목을 설정한다.
            }
        });
        */
		
		setSize(350, 150);
		setVisible(true);
		
	} //생성자
	
	public static void main(String[] args) {
		
		new AnonymousClassListener();

	}

}
