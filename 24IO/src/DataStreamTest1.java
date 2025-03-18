
//주제 : DataOutputStream 출력스트림 통로를 통해
//		각 기본자료형의 변수에 저장된 데이터들을 파일에 쓰기

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataStreamTest1 {
	public static void main(String[] args) {
		
		char c = 'a';
		byte b = 10;
		short s = 20;
		int i = 100;
		float f = 3.14f;
		double d = 1.5;
		String str = "hello";
		
		try {
			//data.txt파일에 위 변수에 저장된 값들을 쓰기(내보내기)위한 메소드를 제공하는
			//DataOutputStream 출력스트림 통로 역할의 객체 생성
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
			
			//void wirteChar(int i) 매개변수 i로 전달받는 문자의 하위 16비트(2바이트)를 
			//DataOutputStream출력스트림 통로를 통해 파일에 출력!(기록)
			dos.writeChar(c);
			
			//void writeByte(int i) 매개변수 i로 전달한 정수 데이터 8비트(1바이트)를 
			//DataOutputStream 출력스트림 통로를 통해 파일에 출력!(기록)
			dos.writeByte(b);
			
			//void writeShort(int i) 매개변수 i로 전달한 정수 데이터 16비트(2바이트)를
			//DataOutputStream 출력스트림 통로를 통해 파일에 출력!(기록)
			dos.writeShort(s);
			
			//void writeInt(int i) 매개변수 i로 전달한 100데이터 32비트(4바이트)크기에 저장될 데이터를
			//DataOutputStream 출력스트림 통로를 통해 파일에 출력!(기록)
			dos.writeInt(i);
			
			//void writeFloat(float f) 매개변수 f로 전달받은 3.14f를 
			//기본자료형인 float의 4바이트 크기의 데이터를 DataOutputStream 출력스트림 통로를 통해
			//한방에 파일에 출력
			dos.writeFloat(f);
			
			//void writeDouble(double d) 매개변수 d로 전달받은 1.5D를 
		    //기본자료형인 double의 8바이트 크기의 데이터를 한방에 파일에 출력
			dos.writeDouble(d);
			
			//void writeUTF(String str) 매개변수로 str로 전달받은 
			//문자열 객체 메모리 내부에 저장된 "hello"라는 문자열을 UTF-8방식으로 문자를 인코딩한후
			//출력스트림통로를 통해 파일에 출력
			dos.writeUTF(str);
			
			//자원해제
			dos.close();

		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

}
