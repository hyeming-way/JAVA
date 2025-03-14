
/*
	주제 : 제네릭 기법이 나오게 된 배경
		  Vector 배열에 저장된 객체들을 get 메소드를 이용하여 얻는데
		  부모 Object 클래스 자료형의 참조변수에 저장할 자식객체를 반환하기때문에
		  업캐스팅 후 다운캐스팅을 위해 코드를 작성해야하는 불편함이 있었다.
		  
		  코드 소스 길이를 줄일 수 있음
*/
import java.util.List;
import java.util.Vector;


public class Collections05 {
	public static void main(String[] args) {
		
		//업캐스팅을 하여 Vector 배열 생성
		List vector = new Vector();
		
		//Vector 배열에 문자열 객체 추가
		vector.add("Apple");
		vector.add("banana");
		vector.add("oRANGE");
		
		//다운캐스팅을 하여 얻을 문자열객체들을 저장할 용도의 String 변수 선언
		String temp;
			
		for(int i=0; i<vector.size(); i++) {
			
		//	  temp = vector.get(i)
			//컴파일 에러 이유
			//get()은 무조건~~~~~~~~~~!!!!!!!!!
			//Object 부모자료형의 참조변수에 저장할 자식객체를 반환함 
			//(부모가 Object 이므로 부모가 String인 temp에 값을 저장할 수 없음!!!!!!!!!!)
			
			
			
			//Vector 배열에 저장된 문자열객체들을 얻기 위해 get(index)메소드 호출!
			//get 메소드를 호출하면 무조건!!! 부모 Object의 참조변수 obj에 저장시킬 자식문자열객체를 반환해줌
			Object obj = vector.get(i); //업캐스팅
			
			//문자열들을 대문자로 바꾸는 메소드를 사용하기 위해서
			//다운캐스팅을 해주어야함! toUpperCase() <-- 메소드는 String의 메소드이므로 Object에서는 사용할 수 없음!!!
			
			//다운캐스팅을 하여 String 클래스에 만들어져 있는 toUpperCase 메소드를 호출할 수 있게 해야함
			temp = (String)obj;
			
			System.out.println(temp.toUpperCase());
			/*
				출력결과
				APPLE
				BANANA
				ORANGE
			*/
			
			/*	
				Vector에 모든 종류의 객체를 저장할수 있습니다.
	
				이는 Vector에 저장되는 객체는 자바의 모든 최상위 클래스 Object클래스로 관리되기 떄문입니다.
	
				저장된 객체를 가져다가 사용하기 위한 get메소드 역시 Vector배열에 저장된 특정 index위치의 객체를
	
				자바의 모든 최상위 클래스인 Object 클래스자료형으로 반환합니다.
	
				그러므로 이렇게 반환된 Object클래스 자료형을  String클래스 자료형 참조변수에 저장하려 하면
	
				위와 같이 컴파일 에러가 발생합니다.
	
				자식 클래스자료형의 참조변수에 부모클래스자료형의 자식객체의 주소를 저장하려면
	
				반드시 강제로 다운캐스팅 해야합니다. 
	
				이런 불편함을 해결하고자 나오는 기법이 제네릭 기법입니다.
						
			*/	
			
			
		}
			
	}

}



