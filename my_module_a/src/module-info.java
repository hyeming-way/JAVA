module my_module_a {
	
	//my_module_a 모듈 프로젝트가 포함하고 있는
	//두개의 pack1와 pack2 패키지를
	//외부 프로젝트에서 사용할 수 있도록
	//모듈기술자파일(module-info.java)을
	//다음과 같이 작성한다.
	
	//방법
	//export 키워드는 모듈프로젝트가 가지고 있는 패키지를 외부 프로젝트에서
	//사용할 수 있도록 외부에 노출시키는 역할을 하기때문에 아래와 같이 작성
	//문법
	//	export 노출시킬패키지명;
	exports pack1;
	//exports pack2;
	
	//export pack2; <-- 안 적을 경우 : 외부에서 사용할 수 없도록 보호(은닉화)
	
	//my_module_a에서 my_module_b모듈을 전이의존설정을 해서
	//my_application_2에서도 my_module_b를 사용할 수 있도록 하자.
	requires transitive my_module_b; //<-- 전이 의존
			
}