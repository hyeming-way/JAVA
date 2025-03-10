

//my_application_2 모듈 프로젝트는
//my_module_a와 my_module_b 모듈프로젝트들에서
//제공하는 패키지들을 사용해야하므로
//두 모듈 프로젝트에 대해 의존(의지)설정이 필요하다.

module my_application_2 {
	
	//my_module_a와 my_module_b 모듈 프로젝트 2개를
	//직접적 의존을 처리하지않는 대신 나중에 집합 모듈인 my_module을 의존시키면 된다.
	requires my_module;

//	requires my_module_a;
	//이 부분은 my_module 모듈의 기술자파일 내부에 작성된 아래의 코드에 의해
	//전이 의존 설정되므로 위 코드 한 줄을 주석 처리했다.
	//	-> 	requires transitive my_module_a;
	//		requires transitive my_module_b;
	
//	requires my_module_b;
	//이 부분은 module_a 모듈의 기술자파일 내부에 작성된 아래의 코드에 의해
	//전이 의존 설정되므로 위 코드 한 줄을 주석 처리했다.
	//	-> requires transitive my_module_b;
	
	//컴파일 에러가 발생할 경우
	//필요한 의존 모듈 라이브러리파일의 경로를 아직 모르기때문에
	//즉! 빌드패스를 설정하지않았기때문에 에러발생
	
	
	
}