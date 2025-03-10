module my_module {
	
	//my_module 모듈을 집합 모듈로 만들되
	//my_module_a모듈과 my_module_b모듈을 제공할 목적으로
	//두 모듈에 대한 전이 의존 설정
	requires transitive my_module_a;
	requires transitive my_module_b;
	
}