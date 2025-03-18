
//주제 : 키보드에서 입력받은 내용을 입력스트림통로(FileInputStream)를 통해 읽어들여
//      특정파일에 저장(쓰기, 기록, 내보냄, 출력)하기 위해
//      출력스트림통로(FileOutStream)를 사용한 예제
/*
 참고.
 try-with-resources 문법은 Java SE 7 (JDK 1.7) 에서 처음 도입되었습니다.
 이전에는 finally 블록에서 close()를 호출해야 했지만, 
 try-with-resources를 사용하면 자동으로 자원이 해제돼서 코드가 더 간결하고 안전합니다.



 try-with-resources 기본 문법과 사용법
 - try-with-resources는 자동으로 자원을 닫아주는 기능을 제공하는 try문입니다.
 - java.lang.AutoCloseable 인터페이스를 구현한 클래스(예: FileInputStream, BufferedReader, Scanner 등)는 
   try-with-resources를 사용하면 자동으로 close()가 호출돼서 명시적으로 닫을 필요가 없습니다.
   
   
  try-with-resources 기본 문법
   
		try (자원 선언) {
		    // 자원을 사용한 코드
		} catch (예외 타입 e) {
		    // 예외 처리
		}
  
  설명
	() 안에 선언된 자원(객체)은 try 블록이 끝나면 자동으로 닫힘.
	여러 개의 자원을 선언할 수도 있음(쉼표 , 사용).
	finally 블록 없이도 자원이 자동 해제됨.
 */
import java.io.*;

public class IOTest06_1 {
	public static void main(String[] args) {
		
		//요약 : 키보드에서 입력한 데이터를 파일에 기록
		
		System.out.println("파일에 기록할 내용을 입력하세요.");
		System.out.println("지금 입력한 내용은 파일에 기록됩니다.");
		
		//File 클래스의 객체 생성(파일 이름 : Test.txt)
		File file = new File("Test.txt");
		
		//try-with-resources 구문을 이용하여 자원을 자동으로 닫게 하기
		try(
			//파일 출력 스트림 통로 생성 (파일이 존재하면 기존 내용에 추가모드)
			FileOutputStream fos = new FileOutputStream(file, true);
			//키보드로 입력받은 데이터 읽어들일 입력스트림 통로 생성 (System.in 사용)
			InputStream is = System.in
		){
			int data;//한 바이트 단위씩 데이터를 읽거나 쓸때 사용될 변수
			
			//키보드에서 입력받은 데이터를 한 바이트씩 읽어서 파일에 기록
			while ( (data=is.read()) != -1 ) {
				fos.write(data);
			}
			//파일 기록 완료 메세지 출력
			System.out.println("파일 기록이 완료되었습니다." + file.getAbsolutePath());
					
		}catch(IOException e) {
			System.out.println("파일 처리 중 예외 발생 : " + e.getMessage());
		}

	}

}
