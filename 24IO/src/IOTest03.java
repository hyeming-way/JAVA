
/*
	FileInputStream 클래스
	  - java.io 패키지에 존재
	  - 파일에서 바이트 단위로 데이터를 읽어오는 입력 스트림 통로 역할을 합니다.
	  - 이 클래스의 객체를 생성하면 지정한 경로의 파일을 바이트 단위로 읽을 수 있는 입력스트림 통로를 생성할 수 있습니다.
	  
	  
	FileInputStream 객체 생성 방법
	
	  1. 생성자로 읽어들일 파일의 경로를 문자열로 전달해서 생성
	     예) FileInputStream fis = new FileInputStream("파일경로");
	  
	  2. File 클래스의 객체 생성시 파일 경로를 문자열로 전달해서 생성한 후
	     FileInputStream의 생성자로 File 객체의 주소번지를 전달해서 생성
	     예) File f = new File("파일경로");
	         FileInputStream fis = new FileInputStream(f);   
	         
	
	FileInputSstream 주요 메소드
	
	  1. int read()         
	       - 파일에서 1바이트씩 데이터를 읽어옵니다.
	         더이상 읽을 데이터가 없으면 -1을 반환합니다.
	         
	  2. int read(byte[] b)
	       - 파일에서 데이터를 읽어서 바이트 배열 b에 저장합니다.
	       - 실제로 읽은 바이트 수를 반환합니다.
	       - 더이상 읽을 데이터가 없으면 -1을 반환합니다.
	       
	  3. void close()
	       - 파일 입력스트림(new FileInputStream)을 닫고, 사용중인 시스템 자원을 해제합니다.          

*/

//주제 : C:\workspace_java\23컬렉션그리고제네릭\src\Collections01.java <-- 파일에 기록된 데이터들을 모두 읽어와 출력

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOTest03 {
	public static void main(String[] args) {
	
		int data = 0; //Collections01.java 파일의 전체 데이터 중에서 
					  //1byte(8bit)메모리에 저장할 크기의 데이터를 읽어서 저장할 변수
		
		//읽어들일 Collections01.java 파일의 전체경로를 문자열로 만들어서 변수에 저장
		String path = "C:\\workspace_java\\23컬렉션그리고제네릭\\src\\Collections01.java";
		
		try {
			
			//방법1
			FileInputStream fis = new FileInputStream(path);
			
			//방법2
			//File file = new File("파일경로");
			//FileInputStream fis = new FileInputStream( file );
			
			//Collections01.java 파일의 정보를 1바이트 단위로 읽어들여
			//모니터(출력장치)에 반복해서 출력
			while((data = fis.read()) != -1) {
				
				//read 메소드를 이용해 한번 읽어들인 Collections01.java 파일의 내용을 
				//모니터에 1바이트 단위로 내보내어 출력
				System.out.write((char)data);
				
			}
			
		} catch (Exception e) { //FileNotFoundException 또는 IOException 자식 객체의 예외 모두 처리
			e.printStackTrace();
		} 

	}

}
