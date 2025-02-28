package test2;

public class Unit {
	
	//1. 객체변수 생성 - 유닛의 정보
	//유닛 이름 (예 : "마린, "저글링", "탱크")저장할 객체 변수 name 선언
	String name;
	//체력(기본값:100) 저장할 객체 변수 hp 선언
	int hp;
	//공격력(기본값:10) 저장할 객체 변수 damage 선언
	int damage;
	
	
	//2. 첫번째 생성자 : 이름만 매개변수로 받는 (체력:100, 공격력:10 기본값 적용) this()생성자호출구문 사용
	public Unit(String name) {
		this(name, 100, 10);	
	}
	
	//두번째 생성자 : 이름과 체력 매개변수로 받는 생성자 (공격력 10 기본값 적용) this()생성자호출구문 사용
	public Unit(String name, int hp) { 
		this(name, hp, 10);	
	}
	
	//세번째 생성자 : 이름, 체력, 공격력 모두를 매개변수로 받는 생성자 this키워드 사용하여 모든 객체변수값 초기화
	public Unit(String name, int hp, int damage) { 
		this.name = name;
		this.hp = hp;
		this.damage = damage;
	}
	
	
	//3. 유닛들의 행동을 메소드로 표현하기위해 메소드 선언
	//첫번째 메소드(attack)
	public void attack(Unit target) {
		//		 조건문1 : 현재 생성된 Unit객체의 hp 객체변수의 값이 0보다 작거나 같으면 
		//		     this.name + "은(는) 이미 파괴되어 공격할 수 없습니다!" <- 출력
		//		     attack메소드 빠져나가기 
		
		if(this.hp <= 0) {
			System.out.println(this.name + "은(는) 이미 파괴되어 공격할 수 없습니다!");	
			return;
		}
		
		//   조건문2 : target 매개변수로 전달받은 Unit객체의 hp객체변수의 값이 0보다 작거나 같으면
		//			 target.name + "은(는) 이미 파괴되어 공격할 수 없습니다!" <- 출력
		//			 attack메소드 빠져나가기
		if(target.hp <= 0) {
			System.out.println(target.name + "은(는) 이미 파괴되어 공격할 수 없습니다!");
			return;
		}
		
		//상대 Unit객체(target 매개변수로 전달받은 Unit(객체)의 체력을 현재 생성된 Unit객체의 공격력 만큼 감소(차감)
		target.hp -= this.damage;
		System.out.println(this.name + "이(가)" + target.name + "을(를) 공격합니다!(공격력:" + this.damage + ")");
		
		//target매개변수로 전달받은 Unit 객체의 체력이 0이하가 되면 파괴된 상태로 표시
		if (target.hp <= 0) {
			target.hp = 0;
			System.out.println(target.name + "이(가) 파괴되었습니다!");
		}
	
	} //attack 메소드 닫기
	
	//두번째 메소드
	//메소드명 : status
	//기능 : 현재 유닛 상태 출력
	public void status() {
		System.out.println("[유닛 상태]" + name + " - 체력: " + hp + ", 공격력: " + damage);
	}

	public static void main(String[] args) {
		
		//Unit클래스의 첫번째 객체 생성시 이름만 매개변수로 받은 생성자를 호출해 생성
		//전달할 이름 : "마린"
		Unit marine = new Unit("마린");
		
		//Unit클래스의 두번째 객체 생성시 이름과 체력을 매개변수로 전달받는 생성자를 호출해 생성
		//전달할 이름 : "저글링"
		//전달할 체력 : 80
		Unit zergling = new Unit("저글링", 80);
		
		//Unit클래스의 세번째 객체 생성시 이름, 체력, 공격력을 매개변수로 전달받는 생성자를 호출해 생성
		//전달할 이름 : "시즈탱크"
		//전달할 체력 : 150
		//전달할 공격력 : 35
		Unit tank = new Unit("시즈탱크", 150, 35);
		
		//위 생성된 Unit클래스의 3가지 Unit객체의 객체변수 정보를 출력
	    marine.status();
        zergling.status();
        tank.status();
	
        System.out.println("\n=== 전투 시작 ===");
        
        // 전투 시뮬레이션
        marine.attack(zergling); // 마린이 저글링 공격
        zergling.attack(marine); // 저글링이 마린 공격
        tank.attack(zergling); // 시즈탱크가 저글링 공격 (강한 공격력)
        tank.attack(marine); // 시즈탱크가 마린 공격
        
        System.out.println("\n=== 전투 종료 후 상태 ===");

        // 전투 후 상태 출력
        marine.status();
        zergling.status();
        tank.status();
        /*
			=== 전투 시작 ===
			마린이(가) 저글링을(를) 공격합니다! (공격력: 10)
			저글링이(가) 마린을(를) 공격합니다! (공격력: 10)
			시즈탱크이(가) 저글링을(를) 공격합니다! (공격력: 35)
			시즈탱크이(가) 마린을(를) 공격합니다! (공격력: 35)
			
			=== 전투 종료 후 상태 ===
			[유닛 상태] 마린 - 체력: 55, 공격력: 10
			[유닛 상태] 저글링 - 체력: 35, 공격력: 10
			[유닛 상태] 시즈탱크 - 체력: 150, 공격력: 35
         */

	}

}
