/* 과제1 
[생성자를 포함하는 클래스의 정의]

---------문제1----------

밑변과 높이 정보를 저장할 수있는 Triangle 클래스를 정의하자. 

그리고 객체를 생성과 동시에 초기화가 가능한 생성자도 정의하자. 

끝으로 밑변과 높이 정보를 변경시킬 수있는 메소드와  

삼각형의 넓이를 계산해서 반환하는 메소드도 함께 정의하자.

끝으로 생성자를 이용한 객체생성 후 삼각형의 넓이를 출력하고,

setter메소드 호출후 밑변 7.5로 변경, 높이 9.2로 변경 후 

다시 삼각형의 넓이를 출력해보자. 


Tip!)

TriangleMain.java파일

클래스2개  Triangle, TriangleMain

밑변 bottom  실수형(8) 
높이 height  실수형(8)

밑변과 높이 정보를 변경시킬수 있는 메소드 : setter : this사용

삼각형의 넓이를 계산해서 반환하는 메소드 : getArea()


Triangle 객체생성과 동시에 밑변10.2, 높이17.w3 초기화

*/

package test1;



class Triangle { // 삼각형
	
	//밑변과 높이 정보값을 넣을 실수형 변수 선언
	double bottom, height; 
	
	//기본생성자
	public Triangle(double bottom, double height) {
		
		this.bottom = bottom;
		this.height = height;
		
	}
	
	//메소드 생성
	//밑변과 높이 정보를 변경
	public void setBottom(double bottom) {
		this.bottom = bottom;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	//삼각형의 넓이를 계산해서 반환
	public double getArea() {
		return bottom * height / 2;	
	}

/*
밑변과 높이 정보를 변경시킬수 있는 메소드 : setter : this사용

삼각형의 넓이를 계산해서 반환하는 메소드 : getArea()


Triangle객체생성과 동시에 밑변10.2, 높이17.3 초기화
*/
	
}

public class TriangleMain {
	public static void main(String[] args) {
		
		Triangle triangle = new Triangle(10.2, 17.3);
		
		System.out.println("삼각형의 넓이: " + triangle.getArea());
		
		triangle.setBottom(7.5);
		triangle.setHeight(9.2);
		
		System.out.println("삼각형의 넓이: " + triangle.getArea());
		
	}
}
/*
출력결과

삼각형의 넓이: 88.23
삼각형의 넓이 : 34.5
 */


