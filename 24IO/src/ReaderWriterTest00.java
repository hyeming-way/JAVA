

//주제 : 문자 스트림(2바이트)으로 키보드로부터 입력받은 데이터 읽어와 모니터에 출력
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReaderWriterTest00 {
	public static void main(String[] args) throws IOException {
		
		int data = -1;
		
		//바이트스트림?
		//  - 한 바이트 단위로 읽어들일 입력스트림 통로 System.in
		
		//문자스트림?
		//  - 2바이트(영문 한문자) 단위로 읽어들일 입력스트림 통로
		//	  new InputStreamReader(System.in);
		
		//부모 문자스트림 추상 Reader 클래스의 참조변수에 업캐스팅해서 저장가능
		Reader myIn = new InputStreamReader(System.in);
		//요약 : 키보드와 연결된 2바이트 단위로 읽어들일 입력스트림 통로
		
		while(true) {
			
			//변환된 문자스트림통로(입력스트림) InputStreamReader를 통해 read메소드를 호출하면
			//키보드로부터 입력받은 전체 데이터 중에서
			//2바이트에 저장될 문자 데이터를 한번 읽어들입니다.
			data = myIn.read();
			
			if(data == -1) {break;} 
			
			//한번 읽어들일때마다 읽어들인 데이터 모니터에 출력
			System.out.print((char)data);
			
		}

	}

}
