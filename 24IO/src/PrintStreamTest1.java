

import java.io.FileNotFoundException;
import java.io.PrintStream;

//주제 : 파일에 데이터를 내보내어 출력하기 위해 PrintStream 클래스 사용

public class PrintStreamTest1 {
	public static void main(String[] args) {
		
		//ps.txt파일에 데이터를 기록하기 위한
		//출력스트림 통로 역할의 객체 생성
		try {
			PrintStream out = new PrintStream("ps.txt");
			out.println(10);
			out.println(3.4);
			out.println('A');
			out.println(true);
			out.println("Hello");
			
			//자원해제
			out.close();
									
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
