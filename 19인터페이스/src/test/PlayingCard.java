/*
 문제1. 다음 코드에 정의된 변수들을 종류별로 구분해서 적으시오
 
 클래스변수 : width, height
 static 키워드가 붙은 변수. JVM 실행시 Method 영역에 올라감. 
 		　　 생성된 여러 객체메모리들이 공용으로 사용할 데이터를 저장하는데 사용함
 인스턴스변수 : kind, num
 static 키워드가 붙지않은 변수. JVM 실행시 heap 영역에 올라감.
 			 객체변수라고도 부름
 지역변수  : kind, num
 {} 안에 있는 변수 
*/
package test;


public class PlayingCard {
	int kind;
	int num;
	
	static int width;
	static int height;
	
	public PlayingCard(int k, int n) {
		kind = k;
		num = n;
	}
	public static void main(String[] args) {
		PlayingCard card = new PlayingCard(1, 1);

	}

}





