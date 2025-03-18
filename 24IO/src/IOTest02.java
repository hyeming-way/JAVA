
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
//주제 : 입력된 전체 문자열의 문자 총 갯수 출력


public class IOTest02 {
	public static void main(String[] args) {
	
		//키보드로 부터 입력한 전체 데이터 중에서 
		//한번 읽어들인 한 바이트 크기의 데이터를 저장할 변수 선언
		int data = 0;
		
		//읽어들인 전체 문자열의 문자 총 갯수를 계산해서 저장할 변수 선언
		int cnt = 0;
		
		//키보드로부터 한 바이트씩 데이터를 읽어올 입력스트림 통로를 얻어옵니다.
		//InputStream은 바이트 단위로 데이터를 읽는 부모 추상클래스입니다.
		InputStream myIn = System.in;
		
		//모니터(출력 장치)로 한 바이트씩 데이터를 내보낼 출력스트림 통로를 얻어옵니다.
		//OutputStream은 바이트 단위로 데이터를 츨력(내보내는) 부모 추상클래스입니다.
		OutputStream myOut = System.out;
		
		//사용자에게 입력을 요청하는 메세지를 출력
		System.out.print("문자를 입력하세요 : ");
		
		try {
			//키보드로부터 입력된 데이터를 한 바이트씩 읽어옵니다.
			//더이상 읽을 데이터가 없을때까지 반복합니다.
			//System.in.read()는 입력스트림 통로에서 한 바이트를 읽어서 반환합니다.
			//더이상 읽을 데이터가 없으면 -1을 반환합니다.
			while( (data = myIn.read()) != -1 ) {
				
				//소문자 'x' 또는 대문자 'X'를 입력하고 엔터를 누르면
				//더이상 InputStream 입력스트림 통로에서 읽어들이지 않고
				//while 반복문을 빠져나가자(break)
				if(data == 'x' || data == 'X') { //<---- 아스키코드를 이용해서 비교가능하다!!!!
					break;
				}
				//입력받은 문자의 개수를 1증가시킵니다.
				cnt++;
				
				//입력받아 읽어들인 한 바이트 크기의 데이터를 모니터 화면에 한 바이트 내보냅니다.(출력합니다.)
				//1byte = a
				//2byte = 가
				myOut.write(data);
				
			}
			
			
		} catch (IOException e) {
			//입출력 작업 중 발생할 수 있는 예외 정보 및 예외 처리 구문 작성
			e.printStackTrace();
			
		}
		
		//입력받은 총 문자 개수를 출력합니다.
		System.out.println("입력받은 총 문자 갯수 -> " + cnt); //엔터도 포함임!

	}

}
