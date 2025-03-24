
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import com.toedter.calendar.JCalendar;

//주제 : 학생출석부관리시스템
public class AttendanceSystem {
	
	//Student 클래스 : 학생 정보를 저장하는 용도의 클래스
	static class Student {
		private String name; //학생이름
		private String status; //출석상태 (출석, 결석, 조퇴, 외출, 지각)
		
		//학생이름과 출석상태를 초기화할 생성자
		public Student(String name) { 
			this.name = name;
			this.status = "결석"; //학생 추가시 기본 상태
		}
		
		public String getName() {
			return this.name;
		}
		public String getStatus() {
			return this.status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
		//학생이름과 출석상태를 문자열로 반환할 toString
		@Override
		public String toString() {		
			return this.name + " - " + this.status;
		}
		
	} //class Student
	
	//AttendanceManager 클래스 : 출석부를 관리하는 클래스
	static class AttendanceManager {
		private List<Student> students; //학생 목록을 저장할 리스트
		
		//출석부를 초기화할 생성자
		public AttendanceManager() {
			students = new ArrayList<Student>(); //학생 목록을 초기화
		}
		
		//학생 추가 : 새로운 학생을 출석부에 추가
		public void addStudent(Student student) {
			students.add(student); //학생을 리스트에 추가
		}
		
		//학생 수정 : 특정 인덱스 위치에 있는 학생의 이름을 수정
		public void updateStudent(int index, String newName) {
			//주어진 인덱스에 해당하는 학생의 이름을 새로운 이름으로 변경
			students.get(index).name = newName.trim();
		}
		
		//학생 삭제 : 특정 인덱스에 있는 학생을 삭제
		public void deleteStudent(int index) {
			//주어진 인덱스에 해당하는 학생을 리스트에서 제거
			students.remove(index);
		}
		
		//학생 목록 반환 : 현재 출석부에 있는 모든 학생을 반환
		public List<Student> getStudents(){
			return students; //학생 목록 반환
		}
		
		//출석 상태 변경 : 특정 학생의 출석 상태를 변경
		public void setAttendanceStatus(int index, String Status) {
			//주어진 인덱스에 해당하는 학생의 출석 상태를 변경
			students.get(index).setStatus(Status);
		}

	} //class AttendanceManager
	
	//AttendanceGUI 클래스 : GUI 인터페이스를 구성하는 클래스
	static class AttendanceGUI {
		private JFrame frame; //메인 프레임창 저장할 변수
		private JList<String> studentList; //학생 목록을 표시할 JList컴포넌트 저장할 변수 (표시)
		private DefaultListModel<String> listModel; //학생 목록 데이터를 관리할 DefaultListModel 컴포넌트 저장할 변수 (관리)
		private AttendanceManager attendanceManager; //출석부 관리 클래스의 객체 저장할 변수
		private JCalendar calendar; //출석 날짜를 선택할 수 있는 달력 컴포넌트를 제공하는 객체 저장할 변수
		
		//출석부 관리 객체와 GUI 컴포넌트를 초기화할 생성자
		public AttendanceGUI() {
			attendanceManager = new AttendanceManager(); //출석부 관리 객체 생성
			frame = new JFrame("학생 출석부 관리"); //메인 프레임창 객체 생성하면서 창 제목 설정
			listModel = new DefaultListModel<String>(); //학생 목록을 관리하는 리스트모델 객체 생성
			studentList = new JList<String>(listModel); //학생 목록을 표시할 JList 생성
			calendar = new JCalendar(); //달력 컴포넌트 생성
			
			initialize(); //GUI 컴포넌트 초기화 메소드 호출			
		} //생성자
		
		//GUI 컴포넌트 초기화 메소드 호출
		public void initialize() {
			//프레임창 X 닫기 버튼을 누르면 프로그램 강제 종료
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//프레임창 너비, 높이 크기 설정
			frame.setSize(600, 500);
			//프레임창 내부에 부착된 ContentPane(도화지)에 컴포넌트 배치방법을 설정하기 위해
			//BorderLayout으로 설정
			frame.setLayout(new BorderLayout());
			
			//학생 리스트를 표시할 리스트(스크롤 가능한 영역)
			/*
				- JList는 화면에 리스트 항목을 표시하는 컴포넌트입니다.
				  그러나 항목의 수가 많아지면 화면에 다 표시할 수 없게 됩니다.
				- JScrollPane은 스크롤 기능을 제공하는 컴포넌트입니다.
				  JList와 같은 컴포넌트를 감싸면, 
				  그 컴포넌트의 내용이 화면에 다 들어가지 않으면 자동으로 스크롤바가 나타나게 됩니다.  
				- 이 코드는 studentList (학생 목록을 표시하는 JList)를 JScrollPane에 넣어줌으로써,
				  학생 목록이 길어지면 사용자가 스크롤을 통해 다른 학생들을 볼 수 있도록 만들고 있습니다.
			*/
			//JList를 JScrollPane으로 감싸 스크롤 기능 추가
			JScrollPane scrollPane = new JScrollPane(studentList);
			//프레임의 중앙에 학생리스트추가
			frame.add(scrollPane, BorderLayout.CENTER); 
			
			//달력추가
			JPanel calendarPane1 = new JPanel(); //달력을 부착할 도화지(패널)생성
			calendarPane1.add(calendar); //달력컴포넌트 추가
			frame.add(calendarPane1, BorderLayout.WEST); //프레임창의 왼쪽에 패널 추가
			
			//출석 상태 체크 버튼을 위한 패널
			JPanel buttonPanel = new JPanel();
			//버튼들을 가로 방향으로 배치하기 위한 그리드 레이아웃 설정
			buttonPanel.setLayout(new GridLayout(1, 5));
			
			//출석상태 버튼들을 배열로 설정
			String[] statuses = {"출석", "결석", "조퇴", "외출", "지각"};
			for(String status : statuses) {
				//각 상태에 해당하는 버튼컴포넌트 생성
				JButton statusButton = new JButton(status);
				//각 상태 버튼 클릭이벤트가 발생하면 이벤트처리 리스너객체를 내부 익명으로 등록
				statusButton.addActionListener(new ActionListener() {		
					//각 상태 버튼을 클릭할때마다 호출되는 콜백메소드
					@Override
					public void actionPerformed(ActionEvent e) {
						//JList화면에서 선택된 Student객체(학생)의 인덱스 얻기
						int selectedIndex = studentList.getSelectedIndex();
						//학생이 선택되었으면?
						if(selectedIndex != -1) {
							//출석상태 변경
							attendanceManager.setAttendanceStatus(selectedIndex, status);
							//학생 리스트 갱신할 메소드 호출
							updateStudentList();
						}else { //학생이 선택되지않았으면?
							//경고메세지를 보여주기위해 다이얼로그창 띄우기
							JOptionPane.showMessageDialog(frame, "학생을 선택하세요.");
						}
					} 
				}); //이벤트리스너
				
				//버튼들을 반복해서 차례로 패널에 추가
				buttonPanel.add(statusButton);
	
			} //for
			
			//프레임 창 하단에 출석 상태 버튼들이 부착된 패널 영역 추가
			frame.add(buttonPanel, BorderLayout.SOUTH);
			
			//학생 추가, 학생 수정, 학생 삭제, 출석 저장 버튼을 위한 패널(도화지)영역 만들기
			JPanel actionPanel = new JPanel();
			actionPanel.setLayout(new FlowLayout()); //버튼을 추가시킨 흐름에 맞게 왼쪽->오른쪽 방향으로 배치
			
			//학생 추가 버튼 생성 후 클릭이벤트 처리
			JButton addStudentButton = new JButton("학생 추가");
			addStudentButton.addActionListener(new ActionListener() {	
				//학생 추가 버튼 클릭시 자동으로 호출되는 콜백메소드 오버라이딩
				@Override
				public void actionPerformed(ActionEvent e) {
					//사용자로부터 학생이름을 입력받기 위한 입력창을 생성 후 입력받은 이름 저장
					String studentName = JOptionPane.showInputDialog(frame, "학생 이름을 입력하세요:");
					
					//학생이름을 입력했다면? (학생이름이 비어있지않으면?)
					if(studentName != null && !studentName.trim().isEmpty()) {
						//새로운 학생 Student 클래스의 객체를 생성할 때 생성자로 학생이름을 전달해서 초기화
						Student newStudent = new Student(studentName.trim());
						//출석부에 학생 객체 추가
						attendanceManager.addStudent(newStudent);
						//학생리스트 갱신
						updateStudentList();
					}	
				}
			}); //학생 추가 이벤트리스너

			//학생 수정 버튼 생성 후 클릭이벤트 처리
			JButton updateStudentButton = new JButton("학생 수정");
			updateStudentButton.addActionListener( (e) -> {
				//JList화면에서 선택된 Student객체(학생)의 인덱스 얻기
				int selectedIndex = studentList.getSelectedIndex();
				//학생 한명이 JList화면에서 선택되었으면?
				if( selectedIndex != -1 ) {
					//수정할 새로운 학생이름을 입력받아 얻기
					String newName = JOptionPane.showInputDialog(frame, "새로운 학생 이름을 입력하세요:");
					//새로운 학생이름을 입력했다면?
					if( newName != null && !newName.trim().isEmpty() ) {
						//이름수정
						attendanceManager.updateStudent(selectedIndex, newName);
						//학생리스트 갱신
						updateStudentList();						
					}
				} else { //JList화면에서 학생이 선택 안 되어있으면?
					//학생을 선택하지않으면 경고메세지
					JOptionPane.showMessageDialog(frame, "학생을 선택하세요.");
				}		
			} ); //학생 수정 이벤트리스너
			
			//학생 삭제 버튼 생성 후 클릭이벤트 처리
			JButton deleteStudentButton = new JButton("학생 삭제");
			deleteStudentButton.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					int selectedIndex = studentList.getSelectedIndex();
					if(selectedIndex != -1) {
						attendanceManager.deleteStudent(selectedIndex);
						updateStudentList();							
					} else {
						JOptionPane.showMessageDialog(frame, "학생을 선택하세요.");
					}	
				}
			}); //학생 삭제 이벤트리스너
			
			//출석 저장 버튼 생성 후 클릭이벤트 처리
			JButton saveButton = new JButton("출석 저장");
			saveButton.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					//출석 정보를 파일로 저장하는 메소드 호출
					saveAttendanceToFile();
				}
			}); // 출석 저장 이벤트리스너
			
			//생성한 버튼 컴포넌트를 패널에 추가
			actionPanel.add(addStudentButton);
			actionPanel.add(updateStudentButton);
			actionPanel.add(deleteStudentButton);
			actionPanel.add(saveButton);
			
			//프레임창 위쪽에 패널 영역 추가
			frame.add(actionPanel,BorderLayout.NORTH);
			
			//프레임창 화면 윈도우화면에 보이게 설정
			frame.setVisible(true);
			
		} //GUI 초기화 initialize 메소드
		
		//학생 리스트 업데이트 : 학생 목록을 최신 상태로 갱신
		public void updateStudentList() {
			listModel.clear(); //기존 데이터 목록 초기화				
			for (Student student : attendanceManager.getStudents()) {
									//Student객체들이 저장된 ArrayList배열을 반환받아 넣는다
				listModel.addElement(student.toString());
			}
		}//updateStudentList 메소드
		
		//출석부에 보이는 데이터들을 텍스트파일로 저장하는 메소드
		private void saveAttendanceToFile() {
			//1. 사용자가 달력에서 선택한 날짜 가져오기
			Date selectedDate = calendar.getDate();
			
			//2. 날짜를 "yyyy-MM-dd"형식으로 변환하는 객체 생성
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			//3. 파일이름을"attendance_yyyy-MM-dd.txt" 형식으로 생성
			String fileName = "attendance_" + dateFormat.format(selectedDate) + ".txt";
			
			//4. 파일 저장을 시도 (try-with-resource 사용 - 자동으로 자원해제)
			try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
				
				//5. 파일 첫 줄에 선택한 날짜와 출석부 제목 내보내기(출력, 쓰기, 기록)
				//예) "학생 출석부 - 2025-03-21"
				writer.write("학생 출석부 - " + dateFormat.format(selectedDate) + "\n");
				
				//6. 구분선 추가하여 가독성 높이기
				writer.write("---------------------------------------\n");
				
				//7. 출석부에 등록된 모든 Student(학생)객체의 정보를 파일에 한 줄 씩 내보내기
				for(Student student : attendanceManager.getStudents() ) {
					//학생 정보를 "이름 - 출석 상태" 형식으로 파일에 작성
					//예) "홍길동 - 출석"
					writer.write(student.toString() + "\n");
				}
				
				//8. 파일이 저장이 정상적으로 완료되었음을 사용자에게 알림
				//예) "출석부가 attendance_2025-03-01.txt로 저장되었습니다.
				JOptionPane.showMessageDialog(frame, "출석부가 " + fileName + "로 저장되었습니다.");
				
			}catch (IOException e) { //9. 파일 저장 중 오류가 발생할 경우 예외 처리
				//오류 발생시 사용자에게 메세지창 띄워 보여주기
				JOptionPane.showMessageDialog(frame, "파일 저장 중 오류가 발생했습니다.");
			}	
			
		} //saveAttendanceToFile메소드

	} //class AttendanceGUI

	public static void main(String[] args) {
		/*
			SwingUtilities클래스는 java Swing 애플리케이션에서 유용한 유틸리티클래스입니다.
			이 클래스의 invokerLater메소드는 주어진 작업을 이벤트 디스패치스레드(EDT)에서 실행하도록 해주는 역할을 합니다.
			Runnable은 작업(스레드)을 정의하는 객체로 여기서는 출석부 GUI프레임창을 띄우는 일을 합니다.
			
			- 왜 invokeLater메소드를 사용하는가?
				-> java SWING에서는 단일 스레드에서 실행해야합니다. 
				   그렇지않으면 여러 스레드가 GUI 요소를 동시에 수정하려고 할 때 오류가 발생합니다.
				   그래서 invokeLater메소드는 프로그램 GUI작업을 단 하나의 스레드에서 안전하게 실행하도록 보장해줍니다.
				   이는 디스패치 스레드에서 모든 GUI관련 작업을 처리하는 규칙을 따르기 위함입니다.

		*/
		
		SwingUtilities.invokeLater(new Runnable() { //새로운 스레드에서 GUI 실행			
			@Override
			public void run() {
				//이 코드가 실행되면, 새로운 new AttendanceGUI 객체를 생성하면서
				//출석부 GUI창을 실행함
				new AttendanceGUI();
			}
		});
		

	} //main

} //class AttendanceSystem


