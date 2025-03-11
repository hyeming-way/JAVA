package exam02;

/*
	Object 클래스에 만들어져있는
	public int hashCode{ } 메소드
	
	  - 객체메모리를 생성했을때 객체메모리를 식별한 유일한 고유 정수값(해시코드값) 반환
	  
	  참고. 해시코드란? 객체메모리를 식별할 유일한 고유 정수값
*/
/*
	예제 : Student 클래스의 객체를 동등 비교하기위해 hashCode()와 equals() 메소드를 오버라이딩했다.
		  학생번호와 이름으로 해시코드를 생성하고,
		  학생번호와 이름이 동일한 경우에만 equals() 메소드의 호출결과가 true로 리턴되도록 한 예제
*/

class Student /*extends Object*/ {
	
	private int no;
	private String name;
	
	//생성자
	//단축키 : alt + shift + s  o
	Student(int no, String name){
		this.no = no;
		this.name = name;	
	}

	//getter 메소드
	//단축키 :  alt + shift + s  r
	public int getNo() {
		return no;
	}

	public String getName() {
		return name;
	}
	
	/*
		Object 클래스 내부에 만들어진 hashCode 메소드의 기능은
		객체를 생성했을때 그 객체메모리를 식별할 유일한 고유 정수값을 반환합니다.
		
		그러나 여기서는 Student 자식클래스의 기능에 맞게 hashCode 메소드를 오버라이딩한다.
	*/
	@Override
	public int hashCode() {
		//재구현
		//학생번호와 학생이름을 조합한 새로운 해시코드를 만들어 정수값 형태로 반환
		int hashCode = this.no + this.name.hashCode();
		//							"김길동".hashCode(); <-- 문자열 관련 hashCode()
		return hashCode;
	}
	
	/*
		Object 부모클래스 내부에 만들어져있는 equals 메소드는
		각 객체를 생성했을때 각 객체메모리의 주소번지가 같은지 비교할때 사용하는 메소드로
		
		그러나 여기서는 Student 자식클래스의 기능에 맞게 equals 메소드를 오버라이딩한다.
	*/
	@Override
	public boolean equals(Object obj) {
		
		//매개변수 obj로 전달받은 Student 객체가 Student 클래스를 이용해 만들어 졌는지 검사하고
		//만들어졌으면 target 변수에 저장
		if(obj instanceof Student target) {
			//각 Student 객체메모리 내부에 만들어져있는 인스턴스변수값들이 같은지 비교
			if(this.no == target.getNo() && this.name.equals(target.getName())) {
				return true;
			}		
		}
		return false;
		
	} //equals
	
} //class Student


public class HashCodeExample {
	public static void main(String[] args) {
		
		//Object 클래스의 객체메모리 2개 생성해서
		//각 객체메모리 식별할 유일한 고유정수(해시코드값)을 얻어 출력
		Object obj1 = new Object();
		System.out.println("첫번째 Object 객체메모리를 식별할 해시코드값 : " + obj1.hashCode()); 
		//출력결과
		//첫번째 Object 객체메모리를 식별할 해시코드값 : 664740647
		
		Object obj2 = new Object();
		System.out.println("두번째 Object 객체메모리를 식별할 해시코드값 : " + obj2.hashCode()); 
		//출력결과
		//두번째 Object 객체메모리를 식별할 해시코드값 : 321001045
		
		//-----------------------------------------------------------------------------------
		
		//Object를 상속받아 설계한 Student 자식클래스의 객체메모리 생성
		Student s1 = new Student(1, "홍길동");
		System.out.println("첫번째 Student 객체의 오버라이딩 해놓은 hashCode메소드 호출 : " + s1.hashCode());
		//출력결과
		//첫번째 Student 객체의 오버라이딩 해놓은 hashCode메소드 호출 : 54150063
		
		Student s2 = new Student(1, "홍길동");
		System.out.println("두번째 Student 객체의 오버라이딩 해놓은 hashCode메소드 호출 : " + s2.hashCode());
		//출력결과
		//두번째 Student 객체의 오버라이딩 해놓은 hashCode메소드 호출 : 54150063
		
		//hashCode()를 오버라이딩하여 객체메모리 주소값이 아닌 
		//this.no + this.name.hashCode();의 값이 출력되므로 해시코드의 값이 동일함
		
		//---------------------------------------------------------------------------------------------------
		
		
		//두 Student 객체메모리의 해시코드가 동일한지 검사
		if(s1.hashCode() == s2.hashCode()) {
			
			//두 Student 객체메모리 내부의 각각의 인스턴스변수값이 동일한지 검사
			if(s1.equals(s2)) {
				System.out.println("동등객체입니다.");
			}else {
				System.out.println("인스턴스 변수 데이터가 다르므로 동등객체가 아닙니다.");
			}
		}else {
			System.out.println("해시코드가 다르므로 동등객체 아닙니다.");
		}
		//출력결과
		//동등객체입니다.
		
		//동등객체? 인스턴스변수값이 같은 것
	
	}

}
