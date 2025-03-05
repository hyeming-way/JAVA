/*

super와 super()를 실무에서 어떻게 사용하는지 이해하기 위한 문제입니다.


실무 예제: 회사 직원 관리 시스템

[시나리오]  
- Employee (직원) 클래스가 있고, 이를 상속받아 Manager(관리자) 클래스와 Developer(개발자) 클래스가 있음  
- 모든 직원은 이름(name), 급여(salary)를 가짐  
- 관리자는 추가적으로 팀 정보(teamName)를 가짐  
- 개발자는 추가적으로 프로그래밍 언어(language)를 가짐  
- super()를 사용하여 부모 클래스의 생성자를 호출  
- super를 사용하여 부모 클래스의 메서드를 호출  
*/


// 부모 클래스 Employee 정의
class Employee {
    // 직원 이름을 문자열로 저장할 name변수 선언
	String name;
	
    // 직원 급여를 실수값으로 저장할 salary변수 선언
	double salary;

    //Employee 생성자: 이름과 급여를 매개변수로 받아 초기화하는 생성자를 작성하세요.
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

    //직원 정보를 하나의 문자열로 만들어 출력하는 showInfo()메서드를 작성하세요.
    	//이름: 김철수, 급여: 7000000.0  <--이런 형태로 출력되게 
	public void showInfo() {
		System.out.println("이름: " + this.name + ", " + "급여: " + this.salary);
	}
  
}

// 자식 클래스 Manager 정의 (Employee를 상속받음)
class Manager extends Employee {
	
    // 관리하는 팀 이름을 문자열로 저장할 teamName변수 선언
	String teamName;

    //Manager 생성자: 이름, 급여, 팀 이름을 매개변수로 받아 초기화하는 생성자를 작성하세요.
    //super()를 사용하여 부모 생성자를 호출하세요.
	public Manager(String name, double salary, String teamName) {
		
		super(name, salary); //부모클래스의 생성자 호출해서 이름과 급여 저장
		this.teamName = teamName;
   
    //부모의 showInfo() 메서드를 super를 사용하여 호출하고, 
	//팀 정보를 추가로 출력하는 showInfo()메서드를 작성하세요.
    	//팀: 개발팀 <-- 이런 형태로 출력되게 
	super.showInfo();
	
	}
	
	public void showInfo() {
		System.out.println("팀: " + this.teamName);
		
	/*
		public void showInfo(){
			super.showInfo();
			System.out.println("팀: " + this.teamName);	
		}
	*/
	}

  
}

// 자식 클래스 Developer 정의 (Employee를 상속받음)
class Developer extends Employee {
    // 개발자가 사용하는 프로그래밍 언어를 문자열로 저장할 language 변수선언
	String language;

    //Developer 생성자: 이름, 급여, 사용 언어를 매개변수로 받아 초기화하는 생성자를 작성하세요.
    //super()를 사용하여 부모 생성자를 호출하세요.
	public Developer(String name, double salary, String language) {
		super(name, salary);
		this.language = language;		
	
    //부모의 showInfo() 메서드를 super를 사용하여 호출하고, 
	//사용 언어 정보를 추가로 출력하는 showInfo()메서드를 작성하세요.
		super.showInfo();
	}
	
	public void showInfo() {
		System.out.println("사용 언어: " + this.language);
		
	/*
		public void showInfo() {
		super.showInfo();
		System.out.println("사용 언어: " + this.language);
		}
	*/
	}
	
}

// 메인 클래스
public class Company {
    public static void main(String[] args) {
        //Manager 객체를 생성하고 showInfo()를 호출하세요.
    	Manager manager = new Manager("김철수", 7000000.0, "개발팀");
    	
    	manager.showInfo();
       

        System.out.println("-----------------");

        //Developer 객체를 생성하고 showInfo()를 호출하세요.
        Developer developer = new Developer("이영희", 6000000.0, "Java");
        
        developer.showInfo();

        /*
         실행 출력 결과
         
            이름: 김철수, 급여: 7000000.0
			팀: 개발팀
			-----------------
			이름: 이영희, 급여: 6000000.0
			사용 언어: Java
         */
        
    }
}
/*

## super와 super() 이해하기
super() : 부모 생성자 호출
- super()는 부모 클래스의 생성자를 호출하는 역할을 한다.  
- Manager와 Developer의 생성자는 Employee의 생성자를 super()로 호출하여 name과 salary를 초기화함.

super : 부모 메서드 호출
- showInfo() 메서드에서 super.showInfo();를 사용하면 부모 클래스의 메서드를 먼저 실행 한 후, 
  자식 클래스의 추가 정보를 출력할 수 있음.

##정리
✔ super()는 부모 클래스의 생성자를 호출하는 데 사용됨  
✔ super`는 부모 클래스의 메서드나 변수를 호출하는 데 사용됨  
✔ 실무에서는 객체 생성 시 부모 인스턴스변수를 초기화하거나, 공통 기능을 상속받아 확장할 때 많이 사용됨  

*/