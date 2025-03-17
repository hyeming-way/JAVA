
import java.io.IOException; //입출력 예외처리
import java.io.InputStream; //데이터를 1바이트씩 읽어들일 입력스트림 통로

/*
	스트림(Stream)이란?
	  - 키보드 또는 기기를 통해서 입력된 데이터가 바이트 단위로 흘러 가는 통로
	
	
	
	
	System.in -> 
		System클래스 내부에 in상수에 저장된 
		InputStream입력스트림 통로역할을 하는 객체
	
	InputStream클래스의 read() 메소드 ->
		참고.  1.입력스트림 통로에서 1바이트를 읽습니다.
		      2.읽은 바이트값을 int타입으로 반환합니다.
		        반환값은 읽은 바이트의 정수표현이며 0부터 255사이의 값입니다.
		        만약 입력스트림 통로 끝에 도달하면 -1을 반환합니다.
		        (더이상 읽어들일 byte단위의 데이터가 없으면 -1을 반환합니다.)
		        
	System.out -> System클래스 내부에 만들어져 있는 out상수에 저장된
		          PrintStream객체(출력스트림 통로 역할을 하는 객체)
		          을 반환해 올수 있다.
		       -> PrintStream객체는 출력장치인 모니터장치와 연결되어 있는 
		          1바이트 단위로 모니터에 내보내어 출력할 출력스트림 통로역할의 객체    
		
*/

//주제 : 키보드로부터 한글자를 입력받아 모니터 화면에 출력

public class IOTest00 {
	public static void main(String[] args) {
	
		//키보드 장치에서 입력받은 전체 데이터 중에서 1바이트씩 읽어 저장할 변수
		int data = 0;
		
		
		System.out.print("하나의 문자를 입력하세요. 끝내라면 ctrl+z를 누르세요");
		
		//사용자가 입력을 안 할 수도 있어서 입력예외가 발생할 수 있음! 예외처리 필요
		try {
			//1. 키보드 장치로 부터 입력한 데이터를 1바이트씩 읽어올
			//	 입력스트림 통로 역할을 하는 InputStream 객체메모리 얻어오기
			InputStream inputStream = System.in;
			
			//1.1 입력한 전체 데이터 중에서 1바이트 크기의 데이터만 읽어
			//	  읽어들인 바이트 수를 정수로 반환해서 저장
			data = inputStream.read();
			
			//1.2 키보드로부터 입력된 전체 데이터 중에서
			//	  읽어들인 데이터가 InputStream 입력스트림 통로에 존재하면
			//	  계속 반복해서 1바이트 단위로 반복해서 읽어서 data 변수에 저장
			while(data != -1) {
				//1.3 그리고 1바이트씩 읽어들인 데이터를 모니터장치화면에 출력스트림 통로를 통해 내보낸다(출력)
				System.out.print( (char)data ); //<--- 글자가 깨질 수 있기 때문에 (char)캐스팅함
				
				//1.4 while 반복문 내부에서 InputStream 입력스트림 통로에서 계속 반복해서 읽어들임
				data = inputStream.read();
			}

		}catch (IOException e) {
			//입출력시 발생한 예외메세지 출력
			e.printStackTrace();
		}

	}

}
