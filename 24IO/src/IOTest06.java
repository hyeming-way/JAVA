
//주제 : 키보드에서 입력받은 내용을 입력스트림통로(FileInputStream)를 통해 읽어들여
//      특정파일에 저장(쓰기, 기록, 내보냄, 출력)하기 위해
//      출력스트림통로(FileOutStream)를 사용한 예제

import java.io.*;

public class IOTest06 {
	public static void main(String[] args) {
		
		//요약 : 키보드에서 입력한 데이터를 파일에 기록
		
		//키보드로부터 입력받은 데이터를 1바이트를 읽어서 저장할 변수
		int data = 0;
		
		System.out.println("파일에 기록할 내용을 입력하세요.");
		System.out.println("지금 입력한 내용은 파일에 기록됩니다.");
		
		//재료
		File f = null;
		FileOutputStream fos = null;
		InputStream is = null;
		
		try {
			//Test.txt 파일에 접근할 수 있도록 File 클래스의 객체 생성
			f = new File("Test.txt");
			
			//Test.txt 파일에 키보드로 입력한 내용을 한 바이트 단위씩 출력하기 위한
			//FileOutputStream 클래스의 객체(출력스트림 통로) 생성
			fos = new FileOutputStream(f, true); //true -> 만약 Test.txt 파일에 데이터가 있다면
												 //출력스트림을 통해 파일로 내보낸 데이터를 추가
			                                     //false -> 덮어씌운다.
			
			//키보드로부터 입력받은 내용을 한바이트 단위씩 읽어들이기 위한
			//InputStream 부모추상클래스를 구현한 자식 BufferedInputStream클래스의 객체(입력스트림 통로)생성
			is = System.in;
			
			//키보드로부터 입력받은 전체 데이터 중에서 한 바이트 크기의 데이터를 읽어들여
			//data 변수에 저장시키는데
			//data 변수에 한 바이트 크기의 읽어들인 데이터가 저장되어 있으면?
			//(계속 입력스트림통로에서 읽어들일 데이터가 있으면?)
			while( (data = is.read()) != -1) {
				//입력스트림 통로로부터 읽어들인 한 바이트의 크기의 데이터를
				//FileOutputStream 출력스트림 통로를 통해 
				//Test.txt 파일에 한 바이트 단위로 기록(내보낸다, 출력)합니다.
				fos.write(data);
			}
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//무조건 한번 실행할 코드
				//입력스트림통로, 출력스트림통로 모두 사용 후 메모리 제거
				//요약 : 자원해제
				if(fos != null) { fos.close(); }
				if(is != null) { is.close(); }
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}

}
