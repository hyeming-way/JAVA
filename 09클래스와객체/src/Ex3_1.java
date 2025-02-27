
//예제1 : 학생정보를 저장하는 객체 배열

//Student2 클래스 만들기
class Student2{
	
	//학생의 이름을 저장할 객체 변수(인스턴스) name 선언
	String name;

	//학생의 점수를 저장할 객체 변수(인스턴스) score 선언
	int score;
	
	//학생 이름(name)을 반환하는 기능의 메소드 getName()선언
	String getName() {
		
		return name;
		
	}
	
}

public class Ex3_1 {
	public static void main(String[] args) {
		
		//학생 정보를 저장할 Student 객체 배열 students 선언하고 크기를 5로 설정
		Student2[] students = new Student2[5];
		
		//for 반복문을 사용하여 students 객체 배열의 각 칸에 Student 객체를 생성해서 저장
		for(int i=0; i<students.length; i++) {
			
			//Student 객체 생성 및 객체 배열의 각 칸에 저장
			students[i] = new Student2();
			
			//students[i]의 name 인스턴스 변수에 "학생1", "학생2", "학생3" 형식으로 이름 저장
			students[i].name = "학생" + (i+1);
			
			//students[i]의 score 인스턴스 변수에 80부터 시작하여 2씩 증가하는 점수를 저장
			students[i].score = 80 + (i*2);

		}
			
		
		//for 반복문을 사용하여 students 객체 배열에 Student 객체들의 정보를 차례로 얻어 출력하는 구문 작성
		for(int i=0; i<students.length; i++) {
			
			System.out.println("students 배열의 " + i + "번째 인덱스에 저장된 학생 정보:");
			
			//students[i]위치의 객체를 꺼내고 이 객체의 name 인스턴스 변수값을 얻어 출력
			//System.out.println("이름: " + students[i].name);
			System.out.println("이름: " + students[i].getName());
			
			//students[i]위치의 객체를 꺼내고 이 객체의 score 인스턴스 변수값을 얻어 출력
			System.out.println("점수: " + students[i].score);
			
			System.out.println(); //줄바꿈 출력
			
			/*
				출력결과
				students 배열의 0번째 인덱스에 저장된 학생 정보:
				이름: 학생1
				점수: 80
				
				students 배열의 1번째 인덱스에 저장된 학생 정보:
				이름: 학생2
				점수: 82
				
				students 배열의 2번째 인덱스에 저장된 학생 정보:
				이름: 학생3
				점수: 84
				
				students 배열의 3번째 인덱스에 저장된 학생 정보:
				이름: 학생4
				점수: 86
				
				students 배열의 4번째 인덱스에 저장된 학생 정보:
				이름: 학생5
				점수: 88
				
			*/
		
		}
		
	}
	
}
