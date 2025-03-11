package exam04;

/*
	DTO(Data Transfer Object)역할을 하는 클래스(설계도)?
	  - 데이터들을 하나의 객체 단위로 저장하여 전달하는 용도로 사용되는 설계도(클래스)
*/

/*
public class Member { //<---DTO (회원 한사람의 정보가 저장될 용도)

	//Member의 데이터들은 읽기만 가능하고 값을 변경하지못하게 변수들을 private final로 선언
	private final String id;
	private final String name;
	private final int age;
	
	//생성자 (모든 필드(상수)값들을 초기화할 생성자)
	public Member(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	//상수명들과 동일한 이름의 getter 역할을 하는 메소드들 선언
	public String id() { return id; }
	public String name() { return name; }
	public int age() { return age; }

	//동등비교(객체의 변수값들 비교)를 위한 hashCode메소드와 equals메소드 오버라이딩
	@Override
	public boolean equals(Object obj) { return false; } //구현생략
	
	@Override
	public int hashCode() { return 0; } //구현생략

	//의미있는 Member 객체의 인스턴스 변수들의 값을 하나의 문자열로 만들어서 반환할
	//toString메소드 오버라이딩
	@Override
	public String toString() {
		return "Member[id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
*/

// java 14버전부터 도입된 record 기능을 이용해 위 Member 클래스 전체를 작성해보자
// - record 기능은 class와 비슷하지만,
//	 주로 데이터를 저장하는 용도로 사용되는 **불변 객체**를 간단하게 정의할때 사용합니다.
public record Member(String id, String name, int age) {
		
}



