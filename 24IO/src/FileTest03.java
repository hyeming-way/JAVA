
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
File과 Files클래스 

- java.io패키지와 java.nio.file패키지는 파일과 디렉터리 정보를 가지고있는
  File과 Files클래스를 제공한다.
  Files클래스는 File클래스를 개선한 클래스로 , 좀더 많은 기능을 가지고 있다.

File클래스를 이용해서 객체를 생성하는 방법

	File file = new File("파일경로");

	참고. 파일경로를 적을때 윈도우에서는 \\ 또는 / 를 둘다 사용할수 있고,
	     맥 OS 및 리눅스에서는  / 를 사용합니다.
	참고 예.
			File file = new File("C:/Temp/file.txt");
			File file = new File("C:\\Temp\\file.txt");
	
						
Files클래스	

	- 정적메소드로 구성되어 있기때문에 File클래스처럼 객체를 만들필요가 없다.
	- Files클래스의 정적(static)메소드는 운영체제의 파일 시스템에게 파일 작업을 수행하도록 위임한다.
	
	기능				관련메소드
	복사				copy
	생성				createDirectories,  createDirectory,  createFile,
	                createLink,  createSymbolicLink, createTempDirectory,
	                createTempFile					
	
	이동 				move
	삭제				delete, deleteifExists
	..............	
				
	- 참고.
			위 메소드들은 리턴값으로 Path객체를 리턴해줍니다.
			Path객체는 파일이나 디렉토리를 찾기 위한 경로 정보를 가지고 있는데,
			정적 메소드인 get()메소드로 다음과 같이 얻을수 있다.
			
			Path path = Paths.get(String first, String more .....)			
				
			
			get()메소드의 매개변수로 전달하는 값은 파일 경로인데,
			전체 경로를 한꺼번에 지정해도 좋고,
			상위 디렉토리와 하위 디렉토리를 나열해서 지정해도 됩니다.
						
			Path path = Paths.get("C:/Temp/dir/file.txt"); 		
			Path path = Paths.get("C:/Temp/dir", "file.txt");
			Path path = Paths.get("C:", "Temp", "dir", "file.txt");			
						
				
			파일의 경로는 절대경로와 상대경로 모두 사용할수 있습니다.
			만약 현재 디렉터리 위치가 "C:/Temp"일 경우 "C:/Temp/dir/file.txt"는 다음과 같이 지정가능하다
			
			Path path = Paths.get("dir/file.txt"); //상대경로 
			Path path = Paths.get("./dir/file.txt"); //상대경로 
			
			
			현재 위치가 "C:/Temp/dir1"이라면? "C:/Temp/dir2/file.txt"는 다음과 같이 지정이 가능하다.
			. 이 현재 디렉토리경로를 의미한다면   .. 은 상위 디렉토리를 말한다.
			
			Path path = Paths.get("../dir2/file.txt"); //상대경로
									
*/

//주제 : Files 클래스를 이용해 C:\Temp 디렉터리에 user.txt 파일을 생성하고 읽는 방법을 보여주는 예제

public class FileTest03 {
	public static void main(String[] args) throws Exception{
		
		try {
			String data = "id: winter\n" + "email: winter@mycompany\n" + "tel: 010-1234-1234";
			
			//Path 객체 얻기
			Path path = Paths.get("C:/Temp/user.txt");
			
			//파일 생성 및 데이터 저장
			Files.writeString(Paths.get("C:/Temp/user.txt"), data, Charset.forName("UTF-8"));
			
			//파일 정보 얻기
			System.out.println("파일 유형 : " + Files.probeContentType(path)); //text/plain <--- 주타입/보조타입
			System.out.println("파일 크기 : " + Files.size(path) + "bytes");
			
			//파일에 저장된 데이터를 읽어오기
			String content = Files.readString(path, Charset.forName("UTF-8"));
			System.out.println(content);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//결론:
		//probeContentType()메소드는 파일 확장자명에 따른 파일유형을 리턴한다.
		//예를 들어 .txt파일은  text/palin으로     .jpg파일은   image/jpeg 로 리턴한다
		//        .html파일은  text/html
		//Files클래스는 입출력 스트림을 사용하지 않아도 파일의 데이터를 쉽게 읽고 쓸수 있다.
		//writeString()메소드는 문자열을 파일에 저장하고,
		//readString()메소드는 텍스트파일의 내용을 전부 읽고  String으로 리턴한다.
		
		//------------------------------------------------------------------------------------------------
		
		//주제 : C:\Temp 디렉터리에 images 디렉터리와 file1.txt, file2.txt, file3.txt 파일을 생성하고
		//		Temp 디렉터리에 있는 내용을 출력하는 예제. <---- File 클래스 이용
		
		//File 클래스의 객체들 생성
		File dir = new File("C:/Temp/images");
		File file1 = new File("C:/Temp/file1.txt");
		File file2 = new File("C:/Temp/file2.txt");
		File file3 = new File("C:/Temp/file3.txt");
		
		//File 객체를 생성했다고해서 파일이나 디렉터리가 생성되는 것이 아니다.
		//그리고 경로에 실제 파일이나 디렉터리가 없더라도 예외가 발생하지않는다.
		//파일이나 디렉터리가 실제 있는지 확인하고 싶다면? File 객체를 생성하고나서 exists()메소드를 호출해보면 된다.
		if(dir.exists() == false) {dir.mkdirs();}
		if(file1.exists() == false) {file1.createNewFile();}
		if(file2.exists() == false) {file2.createNewFile();}
		if(file3.exists() == false) {file3.createNewFile();}	
		
		//Temp 폴더 내부의 내용을 출력하기 위해 Temp 폴더 경로를 전달한 File 클래스의 객체 생성
		File temp = new File("C:/Temp");
		
		//참고
		//File 클래스에서 제공해주는 메소드
		//File[]  listFiles() 메소드
		// -> 디렉터리에 포함된 파일 및 서브 디렉터리 목록 전부를 File 객체 배열에 담아 File 객체 배열 자체를 반환해줍니다.
		File[] contents = temp.listFiles();
		
		//contents File[] 배열에 저장된 File 객체들의 갯수만큼 반복해서 File 객체를 얻어 Temp 폴더 아래의 파일 정보를 반복해서 출력
		for( File file : contents ) {
			//디렉터리 전체 경로가 저장된 new File 객체이냐?
			if(file.isDirectory()) {
				System.out.println(file.getName()); //디렉터리명 반환받아 출력
			}else {
				System.out.println(file.getName()); //파일명 반환받아 출력
			}
			System.out.println();
			/*
				file1.txt
	
				file2.txt
				
				file3.txt
				
				images
				
				user.txt
			*/
			
		}
		
	}

}
