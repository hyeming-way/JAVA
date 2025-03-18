

//주제 : 파일복제 프로그램을 업그레이드 시키되
//BufferedInputStream 입력스트림 통로와
//BufferedOutputStream 출력스트림 통로와 내부 버퍼메모리를 사용한 예제

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;

public class FileCopy01 {
	
	//입출력할 데이터를 수용할 만큼의 버퍼메모리 크기 설정
	final static int BUFFER_SIZE = 256;
	
	public static void main(String[] args) {
		
		//명령프롬프트 창에 입력될 모습
		//java FileCopy01 "원본파일명" "복사될새파일명"
		//					  0			  1        index
		
		int i = 0; //원본파일에서 한번 읽어들일때마다 읽어들인 바이트수를 저장할 변수
		int len = 0; //원본파일에서 읽어들인 총 바이트수 저장할 변수
		
		//원본파일에서 읽어들인 데이터를 저장하거나 내보낼 256byte 크기의 배열 생성
		byte[] buffer = new byte[BUFFER_SIZE]; //256
		
		//복사될 파일명을 입력하지않고 원본파일명까지만 입력했을 경우
		if(args.length < 2) {
			System.out.println("java FileCopy01 원본파일명 복사될새파일명");
			//FileCopy01.class 복사 프로그램 강제 종료
			System.exit(0);
		}
	
		try {
			//순서1. 원본 파일의 데이터를 1바이트 단위로 접근해서 읽어들일 입력스트림 통로 생성
			FileInputStream fis = new FileInputStream(new File(args[0]));
			
			//순서2. 업그레이드 
			//원본파일의 데이터를 256바이트 단위로 접근해서 읽어들이기 위해
			//BufferedInputStream 내부 기본 버퍼메모리크기인 512byte공간에 저장해두었다가
			//512바이트 크기의 데이터를 한번에 읽어들이기 위한
			//BufferedInputStream 입력스트림 통로로 업그레이드 시키기
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			//-----------------------------------------------------------------
			
			//순서1. 복사될 새파일에 BufferedInputStream 입력스트림통로로부터 읽어들인
			//		데이터들을 1바이트 단위로 출력하기위한 FileOutputStream 출력스트림 통로 객체를 생성후
			//		업그레이드해서 내부 버퍼메모리 공간 512바이트에 모아두었다가
			//		512바이트씩 출력하기위한 출력스트림 통로 생성
		    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(args[1])));
		    
		    //위 작성해놓은 byte[] buffer = new byte[256]; 배열을
		    //read 메소드 호출시 매개변수로 전달하면
		    //buffer 배열의 크기만큼 원본파일의 전체 데이터 중에서 일겅와
		    //buffer 배열에 저장시킵니다. 그리고 읽어들인 256바이트 크기만큼의 int로 형변환해줍니다.
		    //만약 int로 형변환해서 주는 값이 -1일 경우에는 더이상 읽어들일 데이터가 없음을 알 수 있습니다.
		    while((i=bis.read(buffer)) != -1 ) {
		    	
		    	//256바이트씩 읽어와 512byte크기의 내부버퍼메모리를 가지고 있는
		    	//BufferedOutputStream객체 내부의 내부버퍼메모리에 모아두었다가
		    	//복사될 새파일에 512바이트 단위로 쓰기
		    	bos.write(buffer);
		    	
		    	//512바이트 내부버퍼메모리가 가득차지 않았을때
		    	//강제로 복사될 파일에 읽어들인 만큼(256)만 내보냄
		    	bos.flush();
		    	
		    	//256바이트씩 읽어들인 바이트수를 len변수에 누적
		    	len += i;
		    	
		    	System.out.println("process : read[" + i + ", " + len + "], avail[" + bis.available() + "]");
		    	
		    }
		    //자원해제
		    bis.close();
		    bos.close();
		    
		    System.out.println(len + " bytes are copied..................");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
