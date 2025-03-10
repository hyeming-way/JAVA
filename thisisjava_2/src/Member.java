
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



//롬복(Lombok)라이브러리?
// - JDK에 포함된 라이브러리가 아니지만 개발자들이 즐겨 쓰는 라이브러리
// - 자동으로 setter, getter, 생성자 메소드 등을 자동으로 생성해주는 라이브러리

//이클립스에서 롬복라이브러리 설치하려면 lombok.jar(라이브러리) 파일 다운로드해서 넣어주어야 함
//다운로드 사이트 주소 : https://projectlombok.org/download



//@AllArgsConstructor 
//	-> 모든 인스턴스변수들의 값을 초기화 시킬 생성자 자동으로 추가시켜줌

//@Setter 
//	-> 모든 인스턴스 변수 하나당 set으로 시작하는 모든 setter 메소드들을 자동으로 추가시켜줌

//@Getter 
//	-> 모든 인스턴스 변수 하나당 get으로 시작하는 모든 getter 메소드들을 자동으로 추가시켜줌

//@NoArgsConstructor
//	-> 기본생성자를 자동으로 추가시켜줌



@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Member { //회원 한사람의 정보

	//인스턴스변수
	private String id;
	private String name;
	private int age;
	
	public static void main(String[] args) {
		Member member = new Member("admin", "관리자", 50);
		
		member.setId("abc");
		member.setName("에이비씨");
		member.setAge(20);
		
		System.out.println(member.getId()); //abc
		System.out.println(member.getName()); //에이비씨
		System.out.println(member.getAge()); //20
	}
	
	
	
	
/*	
	롬복 라이브러리를 사용하면 아래처럼 따로 쓰지않아도 됨!
	코드 길이를 줄일 수 있음!
	
	
	
	//생성자 (위 변수들을 초기화할 생성자)
	public Member(String id, String name, int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}

	//getter, setter 메소드
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
*/		
		
}
