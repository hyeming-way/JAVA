
//예제2. Book 클래스를 정의하세요.
// - 'Book' 클래스는 책의 정보를 저장하는 설계도입니다.
class Book {
	
//도서 제목을 저장할 인스턴스 변수 title을 선언하세요.
    // - 각 객체(책)가 가지는 고유한 데이터를 저장하는 변수입니다.
    // - 예를 들어, 책 1은 "해리포터", 책 2는 "어린왕자" 같은 제목을 가질 수 있습니다.
	String title;
   
//도서 저자를 저장할 인스턴스 변수 author를 선언하세요.
    // - 책마다 저자가 다를 수 있으므로, 저자 이름을 저장하는 변수가 필요합니다.
	String author;
    
}

public class Ex3_2 {
    public static void main(String[] args) {
     //도서 정보를 저장할 Book 객체 배열 books를 선언하고, 크기를 5로 설정하세요.
        Book[] books = new Book[5];

     //반복문을 사용하여 books 배열의 각 요소에 Book 객체를 생성하여 저장하세요.
        // - 이 반복문은 books 배열의 각 위치(0~4)에 새로운 Book 객체를 만들어 저장합니다.
        for (int i = 0; i < books.length; i++) {       
        	// Book 객체를 생성하여 배열의 차례대로 0~4 index  위치에 저장
        	books[i] = new Book();

        	
            //books[i]의 title 인스턴스변수에 "책 제목 1", "책 제목 2" 형식으로 제목을 저장
            // - 'i'는 0부터 시작합니다.
            // - (i + 1)을 하면 책 번호가 1부터 시작하도록 만들 수 있습니다.
            // - 예를 들어, i가 0일 때 "책 제목 1", i가 1일 때 "책 제목 2"가 됩니다.
        	books[i].title = "책 제목" + (i+1);
          

            //books[i]의 author 인스턴스변수에 "작가 A", "작가 B" 형식으로 저자를 저장
            // - 'A'는 알파벳의 첫 번째 글자입니다.
            // - (char) ('A' + i)는 i가 증가할 때마다 'A', 'B', 'C', 'D', 'E'로 변합니다.
            // - 예를 들어, i가 0이면 "작가 A", i가 1이면 "작가 B"가 됩니다.
        	books[i].author = "작가 " + (char)('A' + i); 
        							//65 + i 값을 (char)로 강제형변환하여 출력
           
        }

        //모든 도서의 정보를 출력하는 for반복문을 작성하세요.
        // - books 배열에 저장된 모든 Book 객체의 정보를 하나씩 출력하는 for반복문입니다.
        for (int i = 0; i < books.length; i++) {
        
        	//books[i]의 title인스턴스 변수값 얻어 출력하세요.
            // - books[i]는 배열의 i번째 위치에 있는 Book 객체를 가리킵니다.
            // - books[i].title은 해당 책의 제목을 가져와 출력하는 코드입니다.
        	System.out.println("books 배열의 " + i + "번째 인덱스에 저장된 도서 정보:");
           

            // 제목 출력
        	System.out.println("제목: " + books[i].title);
          

            //books[i]의 author 필드를 출력하세요.
            // - books[i].author는 해당 책의 저자 이름을 출력합니다.
        	System.out.println("저자: " + books[i].author);
           

            // 보기 좋게 출력 형식을 정리하기 위해 빈 줄 추가
            System.out.println();
        }
    }
}
/*
출력결과

books 배열의 0번째 인덱스에 저장된 도서 정보:
제목: 책 제목 1
저자: 작가 A

books 배열의 1번째 인덱스에 저장된 도서 정보:
제목: 책 제목 2
저자: 작가 B

books 배열의 2번째 인덱스에 저장된 도서 정보:
제목: 책 제목 3
저자: 작가 C

books 배열의 3번째 인덱스에 저장된 도서 정보:
제목: 책 제목 4
저자: 작가 D

books 배열의 4번째 인덱스에 저장된 도서 정보:
제목: 책 제목 5
저자: 작가 E
 
 */
