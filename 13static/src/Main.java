
//회원 한사람의 정보를 관리하는 Member클래스 만들기

class Member{
	
	//참고. private는 클래스 내부에서만 사용할 수 있음
	
	//회원의 이름을 문자열로 저장하는 인스턴스변수 name 선언
	private String name;
	//회원의 이메일을 문자열로 저장하는 인스턴스변수 email 선언
	private String email;
	//회원의 고유 ID를 정수로 저장하는 인스턴스변수 id 선언
	private int id;
	//회원 ID를 자동 생성하기위한 클래스변수 idCounter선언후 1로 초기화해서 선언
	/*
	 	모든 Member객체들에서 공유하는 static변수로,
	 	회원 ID를 자동으로 1씩 증가시켜 생성하는데 사용합니다.
	 	이 클래스 변수값은 Member객체가 생성될때마다 생성자에의해 1씩 증가되어 저장됨
	*/
	private static int idCounter = 1;
	
	//생성자 : 이름과 이메일을 매개변수로 받아서 새로운 회원의 인스턴스변수값 초기화
	public Member(String name, String email) {
		this.name = name;
		this.email = email;	
		//현재 idCounter변수값을 id로 저장하고
		//그 후, idCounter변수값을 1증가
		//예를들어, 첫번째 Member객체회원이 생성되면 id는 1이 되고,
		//idCounter변수는 1증가되어 2가 됩니다.
		this.id = Member.idCounter++;
	}
	
	//Member객체 회원 id를 반환하는 인스턴스getId메소드 만들기
	public int getId() {
		//현재 Member객체 내부에 만들어져 있는 id인스턴스변수의 값 반환
		return this.id;
	}
	
	//회원의 ID와 이름, 이메일 정보를 출력하는 기능의 displayInfo인스턴스메소드 만들기
	public void displayInfo() {
		System.out.println("ID: " + this.id);
		System.out.println("Name: " + this.name);
		System.out.println("Email: " + this.email);
	}

} //Member class

//-------------------------------------------------------------------------------------------

//회원 관리 담당하는 MemberManager클래스 만들기

class MemberManager{
	
	//Member객체들을 10개 생성해서 저장시킬 members 배열메모리 생성
	//단! static을 붙여 참조변수 members를 만들고
	// 최대 10명까지의 Member객체들 저장가능하게 배열메모리 생성
	private static Member[] members = new Member[10];
	
	//현재 members배열에 저장된 Member객체들의 갯수를 카운팅하는
	//클래스변수 memberCount만들고 0으로 초기화
	private static int memberCount = 0;
	
	//새로운 Member객체(회원) 한명을 매개변수로 받아
	//members배열 공간에 있을때만 현재 Member객체(회원)수 index위치에 새로운 회원 추가
	//memberCount클래스 변수값을 1증가시켜 회원수 증가시키는 기능의 addMember클래스 메소드 만들기
	public static void addMember(Member member) {
		
		//members 배열공간이 있을때만
		//현재 회원수(memberCount)가 members 배열의 길이보다 작을 경우에만
		//members배열에 Member객체 추가
		if(memberCount < members.length) {
			//현재 Member객체 수 index위치에 새로운 회원 추가
			members[memberCount] = member;
			//memberCount클래스변수값을 1증가시켜 회원수 증가
			memberCount++;
		}else {
			//members배열에 Member객체 10개가 모두 존재해서 가득차면
			//새로운 Member객체를 생성해서 members배열에 추가할 수 없다라고 메세지 출력
			System.out.println("Can not add more members. Array is full");
		}
		
	} //addMember 메소드
	
	//회원 ID 하나를 매개변수로 전달받아 전달받은 회원 ID로 특정 회원을 검색하여 반환하는 기능의 getMember클래스메소드 만들기
	public static Member getMember(int id) {
		
		for(int i=0; i<memberCount; i++) {
			
			if(id == members[i].getId()) {
				//해당 Member객체(회원)을 반환
				return members[i];
			}
			
		}//for
		
		//일치하는 회원Member객체의 id가 없으면 null을 반환
		return null;
		
	} //getMember 메소드
	
	//----------------------------------------------------------------------------------------------------------
	
	//회원 ID하나를 매개변수로 전달받아 전달받은 회원 ID로 특정회원을 삭제하는 기능의
	//removeMember클래스메소드 만들기
	public static void removeMember(int id) {
		
		//바깥쪽 for 반복문
		for(int i=0; i<memberCount; i++) {
			
			//memberCount클래스변수값(총회원수)만큼 반복하여 members배열을 끝까지 순회하는데
			//만약 매개변수로 전달받은 id와 members배열의 각 인덱스위치의 Member객체의 회원 id가 같으면? (검색된것임)
			if(id == members[i].getId()) {
				
				//안쪽 for 반복문
				for(int j=i; j<memberCount-1; j++) {
					
					//members배열에서 해당 Member객체(회원)를 삭제하고
					//나머지 Member객체들을 members배열의 각 index위치 칸을 한칸씩 이동하여 저장
					members[j] = members[j+1];
					
				}//안쪽 for
				
				//members배열의 마지막 index위치를 null값으로 설정
				members[memberCount - 1] = null;
				
				//회원수 감소를 위해 memberCount클래스변수값 1 차감
				memberCount--;
				
				//회원삭제 완료메세지 출력
				System.out.println("\n\nMember with ID " + id + " removed");
				
				return;
				
			} //if문
			
		}//바깥쪽 for
		
		//ID와 일치하는 회원이 없을 경우 오류메세지 출력
		System.out.println("No member found with ID " + id);
		
	} //removeMember 메소드 끝
	
	//모든 회원의 정보를 출력하는 기능의 클래스 메소드
	public static void displayAllMembers() {
		
		//members배열에 회원이(Member객체들이) 없을 경우
		if(memberCount == 0) {
			//회원이 없다는 메세지 출력
			System.out.println("No members found");
		}else {
			//members배열에 저장된 모든 회원(Member객체들)을 순회하면서 반복해서 얻어 출력
			for(int i=0; i<memberCount; i++) {
				//각 회원의 정보를 출력
				members[i].displayInfo();
				//회원 정보 사이에 빈 줄 추가
				System.out.println();
			}
			
		}
		
	} //displayAllMembers 클래스 메소드 끝
	
} //MemberManager 클래스 끝


public class Main {

	public static void main(String[] args) {
		
		//새로운 회원들을(Member객체들을)생성
		Member member1 = new Member("John Doe", "john@example.com"); //첫번째 회원 생성
		Member member2 = new Member("Jane Doe", "jane@example.com"); //두번째 회원 생성
		Member member3 = new Member("Alice Smith", "alice@example.com"); //세번째 회원 생성
		
		//생성한 회원들을(Member객체들을) 회원관리 배열메모리에 추가
		MemberManager.addMember(member1);
		MemberManager.addMember(member2);
		MemberManager.addMember(member3);
		
		//모든 회원의 정보 출력
		System.out.println("All Members:");
		MemberManager.displayAllMembers();
		
		//특정 ID로 members배열에 저장된 회원(Member객체)을 검색
		int searchId = 2; //검색할 회원 ID설정
		
		Member searchedMember = MemberManager.getMember(searchId);
		
		if(searchedMember != null) { //검색된 회원Member객체가 있을 경우
			
			System.out.println("Member Found with ID " + searchId);
			searchedMember.displayInfo(); //회원정보 출력

		}else { //검색된 회원 Member객체가 없을 경우
			
			System.out.println("No member found with ID " + searchId);
			
		}
		
		//특정 ID로 회원(Member객체)를 members배열에서 삭제
		int deleteId = 2; //삭제할 회원 ID 설정
		
		MemberManager.removeMember(deleteId);
		
		//삭제 후 members배열에 저장된 남은 모든 회원(Member객체들)의 정보 다시 출력
		System.out.println("\nAll Members After Deletion");
		MemberManager.displayAllMembers();

	}

}
