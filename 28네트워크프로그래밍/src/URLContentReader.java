import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLContentReader {
	public static void main(String[] args) {
		
		try {
			//URL클래스의 객체를 생성하면서 생성자로 웹 주소 전달
			URL url = new URL("https://www.naver.com");
			
			//URL객체에서 데이터를 읽을 수 있는 입력스트림 통로 얻기
			//openStream()메소드를 호출하여 웹페이지의 데이터를 읽을 수 있는 입력스트림 통로 연다.
			InputStream inputStream = url.openStream();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			
			//웹 페이지의 데이터를 한 줄씩 읽어오면서 출력
			String line; //한 줄씩 읽어 저장할 변수선언
			//readerLine메소드는 한 줄씩 읽어들이고 더이상 읽어들일 줄이 없으면 null 반환
			while( (line = reader.readLine()) != null ) {
				System.out.println(line); //읽어온 한 줄의 내용 반복해서 출력	
			}
			
			//읽어들인 BufferReader입력스트림 통로 닫기
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
