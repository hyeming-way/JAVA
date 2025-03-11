package exam04;

public class RecordExample {
	public static void main(String[] args) {
		
		Member m = new Member("winter", "눈송이", 25);
		
		//getter 역할을 하는 메소드들이 자동으로 만들어져 있는지 확인하자
		System.out.println(m.id());
		System.out.println(m.name());
		System.out.println(m.age());
		//출력결과
		//winter
		//눈송이
		//25
		
		System.out.println(m.toString());
		//출력결과
		//Member[id=winter, name=눈송이, age=25]
		
		//------------------------------------------------------------
		
		Member m1 = new Member("winter", "눈송이", 25);
		Member m2 = new Member("winter", "눈송이", 25);
		
		System.out.println("m1.hashCode() : " + m1.hashCode());
		//출력결과
		//m1.hashCode() : 306065155
		
		System.out.println("m2.hashCode() : " + m2.hashCode());
		//출력결과
		//m2.hashCode() : 306065155
		
		System.out.println("m1.equals(m2) : " + m1.equals(m2) );
		//출력결과
		//m1.equals(m2) : true
		
		//레코드나 클래스 선언시 개발자가 직접적으로 메소드 오버라이딩 하지않아도 메소드가 자동으로 오버라이딩 된다!!
		
	}

}
