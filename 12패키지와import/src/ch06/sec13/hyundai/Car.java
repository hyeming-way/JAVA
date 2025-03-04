package ch06.sec13.hyundai;

/*
	패키지란?
	- 관련된 클래스와 인터페이스를 그룹화하여
	  논리적으로 조직하는 디렉터리 전체 경로를 의미
	  
	import?
	- 다른 패키지에 만들어져있는 클래스를 현재 .java파일에 불러와서 사용하기 위한
	  import문을 이용해서 어떤 패키지의 클래스를 사용하는지 자바컴파일러에게 알려주기 위해 명시해야합니다.
	- 문법
		import 다른최상위디렉터리명.다른하위디렉터리명.사용할클래스명;
	- import 구문은 일반적으로 package 선언문 아래줄에 작성하되
	  class 설계도 윗줄에 작성합니다.
*/

//ch06.sec13.hyundai 패키지 내부에 만들어 놓은 Car 클래스에서 
//ch06.sec12.hankook 패키지 내부에 만들어 놓은 Tire클래스와 SnowTire클래스를 사용하기위해
//import구문을 작성해서 자바컴파일러(javac.exe)프로그램에 알려주자.
import ch06.sec12.hankook.Tire;
import ch06.sec12.hankook.SnowTire;

//ch06.sec13.hyundai 패키지 내부에 만들어 놓은 Car 클래스에서 
//ch06.sec12.kumho 패키지 내부에 만들어 놓은 모든 클래스나 인터페이스들을 사용하기 위해
//가장 끝에 사용할 클래스명 대신에 * 를 작성
import ch06.sec12.kumho.*; //작성할 코드가 많으면 *, 적으면 import를 쓰는 것을 추천

public class Car {

	public static void main(String[] args) {
		// 패키지 내부에 만들어져있는 class들을 사용해 객체 생성
		Tire tire = new Tire();
		
		SnowTire snowTire = new SnowTire();
		
		//두개의 패키지 안에 만들어 놓은 Tire 클래스명이 동일할 때
		//구분을 위해 참조변수를 만들거나 객체메모리 생성시 생성자 호출구문에 직접
		//외부 패키지명.사용할 클래스명을 기술하여 작성한다.
		ch06.sec12.kumho.Tire tire2 = new ch06.sec12.kumho.Tire();
		AllseasonTire allseasonTire = new AllseasonTire(); // -> import ch06.sec12.kumho.*;를 작성해주어서 길게 안 써도 됨
		
	}

}
