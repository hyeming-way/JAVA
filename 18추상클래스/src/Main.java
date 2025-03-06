

//게시판 기능 구현에 관한 미완성 설계도(추상클래스) 선언
//추상클래스명 : Board
//질문1. 추상클래스는 무엇인가?
//답변1. 구현되지않은 추상메소드를 포함하고 있는 미완성 클래스이며,
//		상속을 통해서만 사용할 수 있는 클래스입니다.
abstract class Board {
	//글 제목, 글 내용, 글 작성자, 글 작성날짜를 저장할 변수 선언
	//질문2. protected 키워드는 무엇인가요?
	//답변2. 동일한 패키지나 상속받은 자식클래스에서만 접근 가능한 접근제어자
	protected String title, content, author, date;
	
	//생성자
	//역할 : 자식클래스의 객체 생성시 글제목, 글내용, 글작성자, 글작성날짜를 모두 초기화
	public Board(String title, String content, String author, String date) {
		//질문3. this 키워드는 왜 사용하나요?
		//답변3. 생성자의 매개변수이자 지역변수와 인스턴스변수의 이름이 같기때문에
		//		인스턴스변수를 구분하기위해 사용됨
		this.title = title;
		this.content = content;
		this.author = author;
		this.date = date;
	}
	
	//게시글 정보(제목, 작성자, 작성일, 글내용) 각각 출력후 줄바꿈할 일반 printInfo 메소드 선언
	public void printInfo() {
		System.out.println("제목:" + this.title);
		System.out.println("작성자:" + author);
		System.out.println("작성일:" + date);
		System.out.println("글내용:" + this.content);
	}
	
	//새 게시글을 추가하는 이름을 가진 추상메소드 addPost 선언
	//질문4. 추상메소드는 무엇인가?
	//답변4. 자식클래스가 반드시 재구현해야하는 메소드입니다. 구현부가 없습니다.
	public abstract void addPost();
	
	//게시글을 수정하는 이름을 가진 추상메소드 updatePost 선언
	//단! 수정한 문자열 정보 하나를 매개변수로 받아서 수정할 수 있게 선언
	//질문5. 추상메소드를 사용하는 이유가 무엇인가요?
	//답변5. 상속받은 자식클래스마다 다른 방식으로 기능을 재구현할 수 있도록 강제성을 줍니다.
	public abstract void updatePost(String newContent);
	
	//게시글을 삭제하는 의미있는 이름을 가진 추상메소드 deletePost 선언
	public abstract void deletePost();
	
}

//--------------------------------------------------------------------------

//일반게시판 자식클래스 GeneralBoard 선언
//추상클래스 Board를 상속받아 선언
class GeneralBoard extends Board {

	//생성자
	//새글 제목, 내용, 작성자, 작성날짜를 매개변수로 받아서
	//위 Board 추상클래스의 멤버에 초기화시킬 생성자 작성
	public GeneralBoard(String title, String content, String author, String date) {
		//질문6. super()는 어떤 역할을 하나요?
		//답변6. 부모 추상클래스 생성자를 메소드를 강제로 호출할 때 사용됩니다.
		super(title, content, author, date);
	}
	
	//새 게시글을 추가하는 기능의 Board 추상클래스의 addPost 추상메소드를 강제로 메소드 오버라이딩
	@Override
	public void addPost() {
		System.out.println("일반게시판에 새 글을 추가했습니다.");
	}

	@Override
	public void updatePost(String newContent) {
		System.out.println(newContent); //수정할 글내용
		System.out.println("일반게시판에 글 내용을 수정했습니다.");
	}

	@Override
	public void deletePost() {
		System.out.println("일반게시판의 글을 삭제했습니다.");		
	}
	
}

//----------------------------------------------------------------------------------------

//공지사항 게시판 자식클래스 NoticeBoard 선언
//추상클래스 Board를 상속받아 선언
class NoticeBoard extends Board {
	
	//생성자작성
		//새글 제목, 내용, 작성자, 작성날짜를 매개변수로 받아서
		//위 Board 추상클래스의 멤버에 초기화시킬 생성자 작성
	public NoticeBoard(String title, String content, String author, String date) {
		super(title, content, author, date);
	}

	//새 게시글을 추가하는 기능의 Board 추상메소드의 addPost 메소드 오버라이딩
		//"공지사항 게시판에 글을 추가했습니다" 출력
	@Override
	public void addPost() {
		System.out.println("공지사항 게시판에 글을 추가했습니다.");
	}
	
	//게시글을 수정하는 기능의 Board 추상메소드의 updatePost 메소드 오버라이딩
			//"공지사항 게시판에 글을 수정했습니다" 출력
	@Override
	public void updatePost(String newContent) {
		System.out.println("공지사항 게시판에 글을 수정했습니다.");
	}
	
	//게시글을 삭제하는 기능의 Board 추상메소드의 deletePost 메소드 오버라이딩
	//"공지사항 게시판의 글을 삭제했습니다" 출력
	@Override
	public void deletePost() {
		System.out.println("공지사항 게시판의 글을 삭제했습니다.");
	}

}


public class Main {
	public static void main(String[] args) {
		
		//업캐스팅
		//추상부모클래스자료형 참조변수 = new 자식클래스의생성자();
		
		Board board = new GeneralBoard("일반 글", "이것은 일반 게시판의 글내용입니다.", "홍길동", "2024-09-09");
		
		board.printInfo();
		/*
		 	제목:일반 글
			작성자:홍길동
			작성일:2024-09-09
			글내용:이것은 일반 게시판의 글내용입니다.
		*/
		
		board.addPost(); //"일반게시판에 새 글을 추가했습니다."
		
		board.updatePost("이것은 수정된 일반게시판의 글내용입니다.");
		/*
			이것은 수정된 일반게시판의 글내용입니다.
			일반게시판에 글 내용을 수정했습니다.
		*/
				
		board = new NoticeBoard("공지", "이것은 공지사항입니다.", "관리자", "2024-09-09");
		
		board.printInfo();
		/*
			제목:공지
			작성자:관리자
			작성일:2024-09-09
			글내용:이것은 공지사항입니다.
		*/
		
		board.addPost();
		/*
			글내용:이것은 공지사항입니다.
			공지사항 게시판에 글을 추가했습니다
		*/
		
		board.updatePost("이것은 수정된 공지사항글의 내용입니다.");
		//공지사항 게시판에 글을 수정했습니다.
		
		board.deletePost();
		//공지사항 게시판의 글을 삭제했습니다.

	}

}
