package 리플렉션;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
	기능 : 타입(클래스, 인터페이스)가 가지고 있는 멤버(변수, 생성자, 메소드)정보 얻기
	
	리턴타입				메소드									용도
	Constructor[] 		getDeclaredConstructors()				생성자 정보 읽기
	Field[]		  		getDeclaredFields()						변수(필드) 정보 읽기
	Method[]			getDeclaredMethods()					메소드 정보 읽기
	
*/

class Car2 {
	
	//변수(필드)
	private String model;
	private String owner;
	
	//생성자
	public Car2() {	}
	public Car2(String model) {
		this.model = model;
	}
	
	//메소드(setter, getter)
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
}

public class ReflectionExample {
	
	//생성자 및 메소드의 매개변수 정보를 출력하는 기능
	private static void printparameters(Class[] parameters) {
		for(int i=0; i<parameters.length; i++) {
			
			System.out.print(parameters[i].getName());
			
			if( i < (parameters.length - 1) ) {
				System.out.print(", ");
			}
		}
	}
	
	public static void main(String[] args) {
		
		//방법1. Class claszz = 클래스이름.class;
							//class Car2의 메타정보(멤버)를 포함하고 있는
							//Classs라는 이름의 new Class 객체메모리 얻기
		Class claszz = Car2.class;
		
		System.out.println("[생성자 정보]");
	
		Constructor[] contConstructors = claszz.getDeclaredConstructors();
		
		for(Constructor i : contConstructors ) {
			System.out.print(i.getName() + "(");
			Class[] parameters = i.getParameterTypes();
			
			printparameters(parameters);
			
			System.out.println(")");

		}
		
		System.out.println();
		System.out.println("[변수(필드) 정보]");
		
		Field[] fields = claszz.getDeclaredFields();
		
		for (Field i : fields) {
			System.out.println(i.getType().getName() + " " + i.getName());	
								//타입명(java.lang.String)	 //변수명(model)
		}
		
		System.out.println();
		System.out.println("[메소드 정보]");
		
		Method[] methods = claszz.getDeclaredMethods();
		
		for(Method i : methods) {
			System.out.print(i.getName() + "(");
			
			Class[] parameters = i.getParameterTypes();
			printparameters(parameters);
			
			System.out.println(") {");
		}
		

	}

}
