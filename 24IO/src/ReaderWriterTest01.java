

//주제 : 키보드로 입력한 전체 데이터 중에서
//		줄단위로 읽어서 모니터에 출력하는 예제

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderWriterTest01 {
	public static void main(String[] args) throws IOException {
		
		//파일명을 입력받아 저장할 변수
		String fileName = null;
		
		//한줄 단위로 데이터를 읽어들일 문자입력스트림 통로 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("파일 이름을 입력하세요 :");

		//입력받은 파일이름을 한 줄 단위로 읽어들여 저장
		//  -> readLine()메소드는 엔터가 입력될때까지의 문자열을 한 줄 단위로 읽어서 반환해줍니다.
		fileName = br.readLine();
		
		System.out.println("입력한 파일명 : " + fileName);
		
		//BufferedReader 문자입력스트림 통로 메모리 자원해제
		br.close();
		
	}

}
