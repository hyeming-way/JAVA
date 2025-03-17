
import java.io.IOException; //입출력 예외처리
import java.io.InputStream; //데이터를 1바이트씩 읽어들일 입력스트림 통로
import java.io.OutputStream;

//주제 : 키보드로부터 입력된 문자열의 문자 총 갯수 세기

public class IOTest01 {
	public static void main(String[] args) {
	
		//키보드 장치에서 입력받은 전체 데이터 중에서 한바이트 크기의 데이터를 저장할 변수
		int data = 0;
		
		//읽어들인 문자열의 총 문자객수를 계산해서 저장시킬 변수
		int cnt = 0;
		
		//키보드로 부터 입력한 전체 데이터 중 한바이트 단위로 읽어 들일 입력스트림 통로 역할의 
		//InputStream 추상부모클래스의 BufferedInputStream 자식클래스 객체 얻기
		InputStream myIn = System.in; //<-- 바이트 입력스트림 통로
		
		//BufferedInputStream 입력스트림 통로를 통해 한바이트씩 읽어들인 데이터를
		//모니터 등의 출력장치에 한바이트씩 내보낼 역할의 출력스트림 PrintStream 객체 얻기
		OutputStream myOut = System.out; //<-- 바이트 출력스트림 통로
		
		System.out.println("문자를 입력하세요. IOTest01.class프로그램을 끝내려면 x 혹은 X나 ctrl + z 단축키를 누르세요.");
		
		try {
			//위 입력스트림 통로(BufferedInputStream)을 통해 
			//한 바이트씩 읽어들이는데
			//입력 스트림 통로에 읽어들일 데이터가 존재할때만 반복해서 계속 읽어들이자
			while ( (data = myIn.read()) != -1 ) {
				
				//소문자 x나 대문자 X를 누르면
				//더이상 읽어들이지 않고 while 반복문 빠져나가기
				if( data == 'x' || data == 'X') {
					break; //while 반복문 빠져나가기
				}
				
				//입력받은 문자열의 문자갯수를 카운팅하기위해서 cnt변수의 값을 1증가
				cnt++;
				
				//입력받아 한바이트씩 읽어들인 데이터를 모니터화면에 출력시
				//출력스트림 통로(PrintStream객체)를 이용해 한바이트 단위로 모니터에 내보내어 출력
				myOut.write(data); //<--------------------------------------------------- write()쓰면 한글 안 깨짐~!!!!!!
	
			}
	
		} catch (Exception e) {
			//예외가 발생하면 발생한 예외 메세지 출력
			e.printStackTrace();
		}
		
		System.out.println("입력받은 총 문자의 갯수 -> " + cnt);
	

	}

}
