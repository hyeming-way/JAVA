/*
 문제2. 다음은 컴퓨터 게임의 병사(marine)를 클래스로 정의한 것이다.
 이 클래스의 멤버중에 static을 붙여야 하는 것은 어떤 것들이고
 그 이유는 무엇인가? (단, 모든 병사의 공격력과 방어력은 같아야 한다.) 
 
 weapon, armor
 
 이유 : 모든 병사들의 공격력과 방어력은 같아야한다. 
 	   그러므로 나중에 생성될 객체메모리들이 
 	   해당 변수를 같이 사용할 수 있게 static 키워드를 붙여주어야 한다.
*/
package test;

public class Marine {
	int x=0, y=0;  //Marine의 위치좌표(x,y)
	int hp = 60;   //현재 체력
	
	static int weapon = 6; //공격력
	static int armor = 0; //방어력
	
	static void weaponUp() { //static 변수의 값을 변경하려면 메소드에도 static을 붙여주어야한다.
		weapon++; 
	}
	static void armorUp() { //static 변수의 값을 변경하려면 메소드에도 static을 붙여주어야한다.
		armor++;
	}
	void movw(int x, int y) {
		this.x = x; //this.x는 인스턴스변수, x는 지역변수
		this.y = y;
	}

}
