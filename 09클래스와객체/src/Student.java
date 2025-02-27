
//1단계 : 현실의 영희 학생 객체 모델링
// - 데이터 : 이름(name), 나이(age), 학번(studenId)
// - 기능 : 공부하기(study), 정보 출력(printInfo)

//2단계 : 자바코드로 class 설계 (데이터+기능)
public class Student {
	//클래스변수
		//학생 이름 저장할 변수
		String name;
		//학생 나이 저장할 변수
		int age;
		//학생 학번 저장할 변수
		String studenId;
		
	//클래스메소드
		//study : 학생이 공부하는 동작 출력
		//"영희 학생이 공부하고 있습니다."
		void study() {	
			System.out.println(name + " 학생이 공부하고 있습니다.");	
		}
		
		//printInfo : 학생 정보를 출력
		//"이름: 영희, 나이: 20, 학번: 2025001"
		void printInfo() {
			System.out.println("이름: " + name + ", 나이: " + age + ", 학번: " + studenId);
		}

	public static void main(String[] args) {
		//3단계 : 객체 생성 후 데이터 저장 및 사용
		
		//1. Student 객체 생성
		Student Student = new Student();
		
		//2. 이름 "영희" 저장
		//	 나이 20 저장
		//   학번 2025001 저장
		Student.name = "영희";
		Student.age = 20;
		Student.studenId = "2025001";
				
		//3. 학생 정보 출력 기능 실행
		//"이름: 영희, 나이: 20, 학번: 2025001"
		Student.printInfo();
		
		//4. 공부하기 기능 실행
		//"영희 학생이 공부하고 있습니다."
		Student.study();	

	}

}
