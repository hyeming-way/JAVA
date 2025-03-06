/*

	추상메소드란?
	- 자식클래스들이 가지고 있는 공통 메소드를 뽑아내어
	  추상클래스로 작성할때, 메소드 선언부(리턴타입, 메소드명, 매개변수)만 동일하고
	  구현부(기능을코드로 작성하는 부분)를 작성 해 놓지 않는 메소드.
	  
	- 문법
	  	 abstract 리턴타입 추상메소드명(매개변수,.......);
	
	- 일반 메소드와 차이점은 abstract 키워드가 붙고, 메소드의 실행 내용인 중괄호{}가 없다
	
	예)  
		public abstract class Animal{//추상클래스(미완성 설계도)
		
			//추상메소드
			abstract void sound(); 		
		}
*/

//추상클래스이자 부모역할을 하는 미완성 클래스
abstract class Animal { //동물
	
	//상수, 변수, 일반메소드, 추상메소드 등을 작성할 수 있다.
	
	//일반메소드 : 메소드의 선언부와 구현부가 모두 존재하는 메소드
	public void breatch() {
		System.out.println("숨을 쉽니다.");
	}
	
	//추상메소드 : 메소드의 선언부만 존재하는 메소드
	public abstract void sound();
	
}

//Animal 추상클래스를 상속받아 자식클래스 Dog 생성
class Dog extends Animal {
	
	//추상클래스 Animal을 상속받아 만들때는 
	//무조건 추상메소드를 강제로 메소드 오버라이딩해야함
	//이유는 추상클래스 Animal에는 아직 완성되지 않은 추상메소드가 존재하기 때문에
	//추상메소드의 선언부만 자식클래스 내부에 작성하되 구현부는 Dog자식클래스에서
	//재구현 해서 사용해야 합니다!~  꼬옥! 	

	@Override
	public void sound() {
		//재구현
		System.out.println("멍멍");
	}
	
}

//Animal 추상클래스를 상속받아 자식클래스 Cat 생성
class Cat extends Animal {

	@Override
	public void sound() {
		System.out.println("야옹");
	}
	
}

public class AbstractMethod {
	
	public static void animalSound(Animal animal) {
		animal.sound(); //매개변수 animal로 전달받는 자식객체의 종류에 따라
						//자식객체 내부에 오버라이딩된 sound()메소드가 실행됨
	}
	
	public static void main(String[] args) {
		
		AbstractMethod.animalSound(new Dog()); //"멍멍"

	}

}
