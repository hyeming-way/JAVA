
//예제. 생성된 객체 메모리의 주소값들을 배열메모리의 각칸(원소)에 저장하여 사용해보기

/*
  객체지향프로그래밍 3단계 기법
   
   1단계 - 철수 객체를 모델링
   	  	  데이터 : 이름,  나이 
          행동(동작) : 자신의 이름을 알려주는 행동
   2단계 - 1단계의 철수객체 등의 공통점을 찾아내면 사람이라는 것을 알수 있다
          요약: 사람 클래스(설계도) 정의      
*/
class Person{
	//변수
	String name; //이름
	int age; //나이
	
	//메소드
	//name변수에 저장된 이름을 반환하는 기능의 메소드 
	public String getName() {
		return name;
	}
}
public class Ex3 {
	public static void main(String[] args) {
		//기본자료형(int, float, double, boolean .....) 값을 저장하기 위한 배열 메모리 만드는예
		
		//1. 정수들만 저장할 배열메모리를 생성후 배열메모리의 주소번지를 저장할 참조변수 선언
		int[] array;
		
		//2. 정수3개를 저장할 배열메모리 3칸 생성후 
		//   배열 메모리 전체 주소번지를 array참조변수에 저장
		array = new int[3];
		
		//3. 배열 메모리 전체 중 각원소(칸)에 정수들 저장
		array[0] = 10;
						//               0x120
						//[ 10 ,    20,        30   ]
						//  0       1           2              index
	    array[1] = 20;
	    array[2] = 30;
	    //------------------------------------------------------------------------
	    
	    //생성된 객체 메모리의 주소번지를 저장할 배열메모리(객체 배열메모리)
	    //- 생성된 객체메모리의 주소값 하나하나를 값으로 갖는 배열메모리 
	    
	    //1. 객체 배열 메모리의 주소번지를 저장하기 위한 참조변수 선언
	    //문법
	    //	클래스자료형명[]  참조변수명;
	    	Person[]       persons;
	    	
	    //2. new Person(); 객체메모리들을 10개 생성하여 객체 배열메모리의 각원소(칸)에 
	     //  생성된 객체메모리의 주소값을 저장할  10칸이 존재하는 객체 배열 메모리 생성
	     //  그리고 객체 배열메모리의 주소값을 참조변수에 저장
	     //문법
	     //    참조변수명 = new 클래스자료형명[칸갯수];
	           persons = new  Person[10];
				//										0x11
				//[0x11]  =  { 0x12 , 0x13, 0x14, null, null, null, null, null, null, null};
							//   0     1      2     3    4      5    6     7     8     9    index
	           
	      //3. 3단계 - 2단계에서 만든 Person 클래스를 이용해 Person객체 메모리들 생성해서 사용
	      for(int i=0;  i<persons.length;   i++) {
	    	  
	    	  	persons[i] = new Person();//0x12  0x13  0x14
	    	  	
	    	  	persons[i].age = 30 + i; //30  31  32  33  34 35 36 37 38 39
	    	  
	    	 	//i가 0일 때   Person객체 생성후 주소번지가 만약 0x12 한다면
				//persons객체배열의 0 index위치 칸에 0x12가 대입되어 null은제거되고 저장됨
	    	  	
	    	    //i가 1일 때   Person객체 생성후 주소번지가 만약 0x13 한다면
				//persons객체배열의 1 index위치 칸에 0x13가 대입되어 null은제거되고 저장됨
	    	  	
	    	    //i가 2일 때   Person객체 생성후 주소번지가 만약 0x14 한다면
				//persons객체배열의 2 index위치 칸에 0x14가 대입되어 null은제거되고 저장됨
				//
				//......
				//......
	    	    //i가 9일 떄까지 Person객체를 10개 생성해서 주소10개를 0 ~ 9 index 각칸에 저장하게 됨
	    	  	
	    	  	
//[0x11]  =  { 0x12, 0x13, 0x14, 0x15, 0x16, 0x17, 0x18, 0x19, 0x20, 0x21};
//				0    1      2     3    4      5    6     7     8     9    index			
		
//[0x11]  =  { Person, Person, Person, Person, Person, Person, Person, Person, Person, Person};
//				   0      1      2       3       4        5        6     7         8     9    index
	      
	      
	    		//persons 객체 배열 메모리의 각원소에 저장된 new Person();으로 생성한
	    	    //각 객체 메모리들을 차례로 얻어  객체 메모리 내부에 있는 변수값을 출력!
	    	    /*
	    	    	persons배열 0번째 인덱스의 Person객체1의 객체변수 age = 30
	    	    	persons배열 1번째 인덱스의 Person객체2의 객체변수 age = 31
	    	    	persons배열 2번째 인덱스의 Person객체3의 객체변수 age = 32
	    	    	persons배열 3번째 인덱스의 Person객체4의 객체변수 age = 33
	    	    	persons배열 4번째 인덱스의 Person객체5의 객체변수 age = 34
	    	    	persons배열 5번째 인덱스의 Person객체6의 객체변수 age = 35
	    	    	persons배열 6번째 인덱스의 Person객체7의 객체변수 age = 36
	    	    	persons배열 7번째 인덱스의 Person객체8의 객체변수 age = 37
	    	    	persons배열 8번째 인덱스의 Person객체9의 객체변수 age = 38
	    	    	persons배열 9번째 인덱스의 Person객체10의 객체변수 age = 39	
	    	     */	  
	    		System.out.println("persons배열 "+ i +"번째 인덱스의 Person객체"+(i+1)+"의 객체변수 age = " + persons[i].age);

	      }

	}

}






