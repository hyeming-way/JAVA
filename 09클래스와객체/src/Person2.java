
public class Person2 {
	
	//변수
	String name;
	
	//메소드
	public void setName(String newName) {
		name = newName;
	}
	
	public void greet() {
		System.out.println("Hello, my name is " + name);
	}
	

	public static void main(String[] args) {
		
		Person2 person2 = new Person2();
				person2.setName("Alice");
				person2.greet();
	}

}



/*

주제 : java.exe프로그램과  jvm 의 관계

  1. java.exe
   - 자바 프로그램(.class)를 실행하기 위한 실행파일입니다.
     주로 커멘드창(cmd) 명령줄에서 사용되며,
     사용자가 .class실행파일을 실행할때  사용됩니다.
   - 기능
   		 :자바 바이트코드가 포함된 .class파일이나 .jar압축파일을 JVM에 로드합니다.
   		 :JVM을 시작시키고, JVM내에에서 바이트코드를 실행합니다.
   
   2.JVM(Java Virtual Machine)
   - JVM은 자바 바이트코드를 실행하기 위한 가상머신 메모리 입니다.
     플랫폼 독립성을 제공하여 , 자바프로그램이 다양한 운영체제에서 
     동일하게 실행될수 있도록 하는 가상머신 메모리 입니다.
     jvm.dll 파일
   - 메모리관리, 스레드관리 등 기능을 가지고 있습니다.
   - 자바 프로그램이 실행되는 환경을 제공합니다.
     
     
   3. 관계
   - 작동방식 : 개발자가 java.exe를 통해 자바프로그램을 실행하면,
              (java Person)
              java.exe는 JVM메모리를 시작시킵니다.
              이후 JVM이 바이트코드들을 해석하고 실행하는 과정을 담당합니다.
   - 플랫폼(OS)독립성:
      java.exe는 특중 운영체제에 맞게 컴파일된 실행 파일이지만,
      JVM은 다양한 플랫폼에서 동일한 바이트코드를 실행할수 있도록 설계 된 메모리임
                   
    결론 : java.exe는 JVM을 호출하여 자바프로그램을 실행하는 역할을 하며,
          JVM은 실제로 바이트코드를 실행하는 환경을 제공하는 메모리 입니다.

*/
//예제. Person2.java파일 컴파일하여 Person2.class파일로 만들고,
//     class파일을 실행하는 과정에서 java.exe와 JVM이 어떻게 동작하는지
//     단계별로 알아보는 예제.

//1단계. 자바소스 파일 작성
//      파일 생성 : Person2.java라는 이름의 파일 생성 
//      코드 작성 : Person2.java로 가서 코드 작성

//2단계. 자바소스파일 컴파일
//      명령어 실행 : 명령프롬포터에서 다음과 같은 명어를 입력합니다
//					javac Person2.java
//작동방식
//   javac.exe(컴파일러)로 Person2.java을 
//   바이트코드로 변환해서 Person2.class파일을 생성
//   만약 문법오류가 있을 경우 오류 메세지가 출력됩니다.

//3단계. 자바프로그램 .class파일을 실행합니다
//   명령어 작성후 실행 : java Person2
//   java->java.exe 이다

//  순서1. java.exe는 JVM 메모리를 시작합니다
//  순서2. JVM은 Person2.class파일의 클래스를 JVM메모리에 로드합니다
//        이과정에서 클래스의 메타데이터와 바이트코드가 JVM메모리에 적재됩니다
//  순서3. JVM은 main메소드를 찾아 실행합니다
//  순서4. main메소드 내부에서 Person2객체를 생성하고, JVM의 heap에 올립니다
//        그뒤 greet메소드를 호출하여 "Hello, my name is Alice"라는
//	      메세지를 출력합니다

//4단계. 프로그램 종료
//작동방식
//  순서1. greet메소드의 실행이 완료되면, main메서드도 JVM에서 없어져 종료됩니다
//  순서2. JVM은 프로그램의 실행이 끝났음을 인식하고, JVM메모리에서
//        로드된 해당 클래스와 객체를 정리합니다

/*
 요약 :
   1. Person2.java파일을 작성합니다
   2. javac Person2.java 명령어로 컴파일 하여 Person2.class파일을 생성함
   3. java Person명령어로 java.exe를 호출하여 JVM을 시작하고,
      Person2.class파일을 실행합니다.
   4. 프로그램이 종료되면 JVM이 객체메모리들과 클래스 메모리를 정리합니다
*/




