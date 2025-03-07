package sec04.exam04;
/*
	로컬 중첩클래스 내부에 만들어지는 
	로컬변수(생성자나 메소드의 매개변수 또는 내부에서 선언된 변수)를
	로컬 중첩클래스에서 사용할 경우 
	로컬 변수는 final특성을 갖게되므로 값을 불러와 사용할수만 있고
	수정할수 없게 된다.
	이것은 로컬 중첩 클래스 내부에서 값을 변경하지 못하도록 제한하기 때문입니다.
	
	참고. java 8버전 이후부터는 명시적으로 final키워드를 붙이지 않아도 되지만
	     로컬 변수에 final키워드를 추가해서 final 상수메모리임을 명확히 작성할수도 있습니다
	     참고로 java 7버전 이전에는 final키워드를 반드시 붙여야 했다.
*/


public class A { //바깥클래스
	
	//메소드
	public void method1(int arg) { //final int arg
		
		//로컬(지역)변수 선언
		int var = 1; //아래의 class B {} 중괄호 내부에서 var 변수의 값을 변경하려고 하면
					 //final이 붙으면서 상수메모리로 전환되어 더이상 값 변경할 수 없음
					 //final int var = 1;
		
		//로컬중첩클래스 B 선언
		class B {
			
		//	var = 2;
		//위 로컬(지역)변수 final int var = 1;로 인식해 값 변경 불가능	
		
		void method2() {
			//주제1. 로컬변수(method1메소드의 매개변수 또는 로컬변수) 값 불러와 사용가능?
			System.out.println("arg : " + arg); //불러와 사용가능
			System.out.println("var : " + var); //불러와 사용가능
		}
		
		//주제2. 로컬변수값 변경가능?
		//arg = 2; 변경불가능
	    //var = 2; 변경불가능
			
		}//class B
		
		//로컬중첩 B클래스 객체생성
		B b = new B();
		//로컬중첩 B객체의 메소드 호출
		b.method2();
		
		//로컬 변수값 변경
		arg = 3; //매개변수(로컬) 변경 가능
		var = 3; //지역(로컬) 변경 가능
		
	}//method1
	
}//class A
