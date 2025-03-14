import java.util.ArrayList;
import java.util.List;

/*

	- 자바 와일드카드 (?) 
	자바의 제네릭 와일드카드(?)는 제네릭 타입을 더 유연하게 사용하기 위해
	어떤 타입인지 정확히 지정할 수 없을 때 사용하는 일종의 "대체 기호"
	
	- 와일드카드 기호 종류 정리 표
	
	와일드카드					설명					읽기					쓰기					사용 예제
	? extends T			T의 하위 클래스 허용		가능						불가능	     List<? extends Animal>
	? super T		    T의 상위 클래스 허용		불가능(Object로 반환)		가능			 List<? super Dog>
	
	- 기억할 것
		1.  ? extends → 읽기만 가능 (get()) / 쓰기 불가능 (add())
		2. 	 ? super → 쓰기 가능 (add()) / 읽을 때 Object로 반환됨 (get() 사용 제한)
		3.   "읽을 때는 extends, 추가할 때는 super" 

*/


class Animal { //동물 설계도 (부모)
	void eat() {
		System.out.println("Animal is eating");
	}	
}

class Dog extends Animal { //강아지 설계도 (자식)
	void bark() {
		System.out.println("Dog is barking");
	}
}

class Cat extends Animal { //고양이 설계도 (자식)
	void meow() {
		System.out.println("Cat is meowing");
	}
}


public class WildCard {
	
	//주제1 : ? extends Animal 사용 (읽기전용)
	public static void feedAnimals( List<? extends Animal> animals ) {
										// > extends T
										//Animal을 상속받는 모든 자식객체를 리스트로 담아서 받을 수 있지만 읽기(사용)만 가능
		for(Animal a : animals) {
			a.eat(); //ArrayList 배열에 저장된 Dog객체를 얻어 사용할 수 있음(읽기만 가능)	
					 //ArrayList 배열에 저장된 Cat객체를 얻어 사용할 수 있음(읽기만 가능)	
		}
		
//		animals.add(new Dog()); //컴파일 오류 발생! 
								//새로운 자식 Dog 객체 추가 불가능 (쓰기 불가능)
		
	}
	
	
	//----------------------------------------------------------------------
	
	//주제2 : ? super Dog (쓰기가능)
	//		- Dog 또는 Dog의 상위클래스만 받을 수 있음
	//		- Dog 객체를 리스트에 추가할 수 있음
	
	public static void addDogs(List<? super Dog> dogs) {
									// ? super T
									//T의 상위 클래스 허용, 읽기 불가능(Object타입으로 반환), 쓰기가능
		
		dogs.add(new Dog()); //쓰기가능(추가가능)
		
		Dog d = (Dog)dogs.get(0); //직접 Dog 객체를 반환받아 올 수는 없지만 (읽기불가능)
								  //다운캐스팅을 통해 받을 수 있다.
		
		d.bark();
		
	}
	
	
	public static void main(String[] args) {
		
		List<Dog> dogList = new ArrayList<Dog>(); 
		dogList.add( new Dog() );
		
		List<Cat> catList = new ArrayList<Cat>();
		catList.add( new Cat() );
		
		feedAnimals(dogList); //List<Dog> 전달
		feedAnimals(catList); //List<Cat> 전달
		//Animal is eating
		//Animal is eating
		
		
		//--------------------------------------------------------
		
		List<Animal> animalList2 = new ArrayList<Animal>();
		
		addDogs(animalList2); //가능 (List<Animal> 전달)
		//Dog is barking
		
		
		List<Cat> catList2 = new ArrayList<Cat>();
		
//		addDogs(catList2); //컴파일 에러 (List<Cat>은 Dog의 상위 타입이 아님!)
		
		
		

	}

}
