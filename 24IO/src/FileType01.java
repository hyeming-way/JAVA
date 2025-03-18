

//주제 : 파일명을 입력받아 입력받은 파일명의 파일내용을 읽어와 모니터 화면에 출력

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileType01 {
	public static void main(String[] args) {
	
		//명령 프롬프트 창(CMD창)에 입력하는 모습
		//java FileType01 FileTest02.java
		
		int data = 0; //입력받은 파일의 정보를 한 바이트씩 읽어 저장할 변수
		int size = 0; //입력받은 파일의 크기를 계산해서 저장할 변수
		
		//명령 프롬프트 창에 파일명을 하나만 입력했다면?
		if(args.length < 1) {
			//입력받는 방법을 알려주기 위해 메세지 출력
			System.out.println("입력하는 방법 : java Filetype01 읽어들일파일명");
			//FileType01.class 프로그램 강제로 종료
			System.exit(0); //<--- 1은 정상종료, 0은 강제종료
		}
		
		//명령 프롬프트 창에서 입력한 첫번째 문자열을 얻어 저장
		String path = args[0]; //FileTest02.java <- 읽어들일 파일 문자열로 저장
		System.out.println(path);
		
		/*
			FileInputStream 객체 생성 문법2
				
				순서1. File f = new File("읽어올데이터가저장된_파일경로");
				
				순서2. FileInputStream fis = new FileInputStream(f);
		*/
		
		//예외 단축키 : alt + shift + z  y
		try {
			//FileTest02.java 의 파일에 접근해서 읽어들일 입력스트림 통로 생성
			File f = new File(path);
							//"FileTest02.java"
			
			FileInputStream fis = new FileInputStream(f);
			
			//FileTest02.java 파일에 저장되어 있는 전체 데이터들을 1바이트 단위로 읽어서
			while( (data = fis.read()) != -1 ) {
				//FileTest02.java 파일에서 1바이트 크기의 읽어들인 데이터를 모니터 화면에 출력
				System.out.write((char)data);
				
				//한번씩(1바이트 단위씩) 읽어들여 출력할때마다 문자 갯수 계산
				size++;
				
				//참고. 한글 한문자 -> 3바이트 크기에 저장할 데이터
				//	   영문 한문자 -> 1바이트 크기에 저장할 데이터
			}
			System.out.println("파일 크기 : " + size + "byte");
		} catch (FileNotFoundException e) {
			System.out.println("지정된 경로에 FileTest02.java 파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("지정된 경로에 FileTest02.java 파일에서 데이터를 읽어들일 수 없습니다.");
			e.printStackTrace();
		}

	}

}
