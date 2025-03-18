
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//주제 : 바이트 출력 스트림 통로 역할을 하는 PrintStream을 사용한 예제

public class IOTest0A {
	public static void main(String[] args) {
		
		//키보드로 부터 입력받은 전체 데이터 중에서 
		//한 바이트만 입력스트림 통로로부터 얻어와 저장할 변수
		int data = 0;
		
		//사용자에게 입력을 요청하는 메세지를 출력
		System.out.print("문자를 입력하세요 : ");

		try {
			//System.out은 printStream 출력 스트림 통로 역할을 하는 객체입니다.
			//이 객체를 통해 모니터로 데이터를 출력할 수 있습니다.
			OutputStream myOut = System.out;
			
			//키보드로부터 입력된 데이터를 입력스트림 통로를 통해 한 바이트씩 읽어들입니다.
			//입력 스트림 통로 생성
			InputStream myIn = System.in;
			
			//입력스트림통로 (InputStream)에서 더이상 읽을 데이터가 없을때까지 반복해서
			//System.in.read()는 입력스트림 통로에서 한 바이트를 읽어서 반환합니다.
			//read()메소드는 입력스트림 통로에서 더이상 읽어들일 데이터가 없으면 -1을 반환합니다.
			while( (data = myIn.read()) != -1 ) {
				
				//입력받은 데이터는 입력스트림 통로에 저장되어 있습니다.
				//이 데이터를 한 바이트 단위로 모니터에 내보내기(출력)하기 위해
				//출력스트림 통로 역할을 하는 PrintStream의 write()메소드를 호출합니다.
				//write 메소드는 한 바이트씩 출력합니다.
				myOut.write(data);
				
				/*
					참고 : write 메소드는 오버로딩 되어있습니다.
					
					1. void write(int b)
					  - 1바이트를 출력합니다.
					  
					2. void write(byte[] b)
					  - 매개변수 b로 전달한 byte 배열 크기만큼 한 번에 출력합니다.
					
					3. void write(byte[] b, int off, int len) 
					  - 매개변수 b로 전달한 전체 byte 배열에 저장된 데이터 중에서
					    b[off]부터 len개의 바이트를 한 번에 출력합니다.
	
				*/
	
			}

		} catch (IOException e) {
			//입출력 작성 중 발생할 수 있는 예외를 처리합니다.
			e.printStackTrace();
			
		}

	}

}
