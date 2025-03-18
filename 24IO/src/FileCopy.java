
/*
	Window 운영체제에서 파일 복사 방법
	  -> copy.exe 프로그램 사용
	     예) cmd(명령프롬프트) 열기
	     
	     copy 원본파일명 복사해서새로생성할파일명
	     
	주제 : 윈도우 운영체제에서 제공하는 파일을 복사할 수 있는 기능의 copy.exe 프로그램처럼
	      FileCopy.class 자프로그램을 자바언어로 만들자.
	     
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {
							//["원본파일명", "복사될새파일명"] <- String 배열
	public static void main(String[] args) throws Exception {
		
		//명령프롬프트 창에 입력할 모습
		
		//java FileCopy "원본파일명" "복사될새파일명" <--- 입력
		//					0    		1		index
		
		int data = 0; //원본파일 전체 데이터 중에서 한 바이트씩 읽어들여 저장할 변수
		int size = 0; //원본파일에서 읽어들인 bytes 크기를 계산해서 저장할 변수
		
		//원본파일명만 입력하고 복사될 새 파일명을 입력하지 않았다면?
		if(args.length < 2) {
			//입력할 사용문법을 알려주자
			System.out.println("java FileCopy 원본파일명 복사될새파일명");
			//잘못된 입력은 FileCopy.class 자바프로그램 강제 종료
			System.exit(0);
		}
		
		//첫번째로 입력받은 "원본파일명" 문자열 경로를 이용해 원본파일의 내용을 
		//바이트 단위로 읽어들이기 위한 FileInputStream 입력스트림통로 객체 생성
		FileInputStream fis = new FileInputStream(args[0]);
		
		//두번째로 입력받은 "복사될새파일명" 문자열 경로를 이용해
		//원본파일의 데이터를 복사될새파일에 바이트 단위로 출력하기 위해
		//FileOutputStream 출력스트림 통로 객체 생성
		FileOutputStream fos = new FileOutputStream(args[1]);
		
		//원본파일에 저장되어 있는 데이터를 한바이트씩 읽어들여
		//복사될새파일에 기록(내보냄, 저장, 출력, 쓰기)하자
		while( (data = fis.read()) != -1 ) {
			
			fos.write(data); //복사될 새파일에 읽어들인 한 바이트의 데이터 단위로 기록(내보냄)
			//한 바이트씩 읽어들인 바이트 크기 ++해서 1증가
			size++;
		}
		//자원해제(FileInputStream, FileOutputStream 스트림 통로 JVM에서 제거)
		fis.close();
		fos.close();
		
		//복사된 총 글자 수 출력
		System.out.println(size + "bytes are copied............");

	}

}
