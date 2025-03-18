
import java.io.File;

//주제 : 현재 디렉터리 내부에 저장되어 있는 파일 및 폴더 목록 정보 출력하기

public class FileTest02 {
	public static void main(String[] args) {
		
		//현재 24IO 디렉터리에 접근하기 위해
		//File 클래스의 객체메모리 생성
		//참고. 현재 디렉터리 	.
		
		File fileDir = new File(".");
		
		//절대경로 -> C:\workspace_java\24IO
		
		//현재 24IO 디렉처리 내부에 만들어져 있는 파일명들(문자열들)을 String[] 배열에 담아 얻어오기
		//File 클래스의 list 메소드 사용
		String[] strs = fileDir.list();

		for(int i=0; i<strs.length; i++) {
			System.out.println(strs[i]);
		}
		/*
		 	출력결과
			.classpath
			.gitignore
			.project
			.settings
			bin
			src
			자바 입출력 IO.pdf
		*/
		
		//d.java파일에 접근해서 정보를 보기 위해 File 클래스의 객체 생성
		File file = new File("C:\\a\\d.java");
		
		//File 객체 생성시 전달한 경로를 이용해 File 객체로 d.java 파일 삭제
		//->파일 삭제 : file 클래스의 delete()메소드 사용
		//			  파일을 삭제하고 삭제에 성공하면 true, 삭제에 실패하면 false 반환
		/*
		if(file.delete()) {//d.java 파일 삭제에 성공했다면? <---------------------------- 많이 쓰임!
			System.out.println("파일 삭제 완료!");
		}else {
			System.out.println("파일 삭제 실패!");
		}
		*/
		
		//만들어져 있지 않은 b 디렉터리를 a 디렉터리 내부에 새로 만들기 위해
		//File 객체 메모리 생성
		//방법 : 만들 b 디렉터리의 경로를 생성자로 전달해서 사용
		File file2 = new File("C:\\a\\b"); //b 디렉터리를 생성해놓을 전체 경로를 포함해 작성
		
		//File 클래스에서 제공해주는 mkdir()메소드를 호출하면
		//경로로 지정된 부모 디렉터리가 존재해야 지정한 경로에 새로운 디렉터리를 생성합니다.
		//디렉터리 생성에 성공하면 true, 실패하면 false 반환
	//	file2.mkdir();
		
		//File 클래스에서 제공해주는 isDirectory()메소드는 
		//File 객체 생성자로 전달한 전체 경로의 주소가 실제 디렉터리이냐? 라고 물어보는 메소드로
		//디렉터리이면 true, 디렉처리가 아니면 false 반환하는 메소드
		if(file2.isDirectory()) { //<---------------------------------------------------알아놓으셈~!
			System.out.println("b는 디렉터리입니다.");
		}else {
			System.out.println("b는 파일입니다.");
		}
		//b는 디렉터리입니다.
		
		file2 = new File("C:\\a\\a.java");
		
		//File 클래스에서 제공해주는 isFile()메소드
		//File 객체 생성시 생성자로 전달한 전체경로의 주소가 실제 파일이냐? 라고 물어보는 메소드
		//파일이면 true, 아니면 false 반환
		if(file2.isFile()) {
			System.out.println("a.java는 파일입니다.");
		}else {
			System.out.println("a.java는 디렉터리입니다.");
		}
		//a.java는 파일입니다.
		
		File file3 = new File("C:\\c");
		//File 클래스에서 제공해주는 mkdirs()메소드를 호출하면
		//지정한 경로에 디렉터리가 존재하지 않으면 생성합니다.
		file3.mkdirs();
		
	}

}
