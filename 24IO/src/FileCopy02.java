
//예제 : CMD창에 두개의 파일이름을 입력받아
//		FileReader문자스트림통로를 통해 문자단위로 파일의 내용을 읽어서
//		문자 단위로 파일에 내용을 쓰기위한 FileWriter문자스트림 통로 역할을 하는
//		클래스들을 사용해보자.

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy02 {
	
	//CMD에서 입력할 것
	//java FileCopy02 원본파일명 복사할새파일명
	//java FileCopy02 FileTest02.java FileTest05.java
	
	public static void main(String[] args) {
		
		//파일에 저장된 데이터를 2바이트 크기로 읽어 저장할 변수
		int data = 0;
		
		//재료
		FileReader reader = null; 
		FileWriter writer = null;

		//복사할새파일명을 입력하지않으면?
		//사용법을 알려주자
		if(args.length < 2) {
			System.out.println("java FileCopy02 원본파일명 복사할새파일명");
			System.exit(0);
		}
		
		try {
			//원본파일에 저장된 데이터를 영문 한문자(2바이트) 단위로 읽어올
			//FileReader 입력 문자스트림 통로 객체 생성
			reader = new FileReader(args[0]); //원본파일명
			
			//복사할새파일에 원본파일에서 읽어들인 데이터를 영문 한문자(2바이트)단위로
			//기록할 FileWriter출력 문자스트림 통로 객체 생성
			writer = new FileWriter(args[1]);
			
			//원본파일에서 2바이트단위로 읽어들인 데이터가 존재하면 계속 반복해서 읽어들여
			while( (data = reader.read()) != -1 ) {
				//한번 읽어들인 data변수(2바이트 크기의 데이터)를 복사할 새파일과 연결된
				//FileWriter출력스트림을 통해 2바이트 내보냄
				writer.write(data);
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { //try 블럭과 catch 블럭의 실행과 상관없이 무조건 한번 실행코드를 작성하는 곳
			//위 만들어서 사용한 문자입출력스트림 통로들을 사용하지않으면
			//메모리 낭비이니 JVM메모리 영역에서 제거하자
			try {
				if(reader != null) {reader.close();}
				if(writer != null) {writer.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
