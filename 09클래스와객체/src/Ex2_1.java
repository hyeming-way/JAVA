

//1단계. 현실에 존재하는 객체를 모델링(데이터 + 기능(동작) 추출)
//	보라색 원, 파란색 원, 빨간색 원 <- 객체들
//	데이터 : 보라색, 원의 반지름
//	기능 : 보라색 원의 면적 구하는 기능...

//2단계. 원 클래스(설계도)만들기
class Circle {
	
	//클래스변수 생성
	double radius; //원의 반지름값, 기본값 : 0.0d
	
	//클래스메소드 생성
	//기능 : 매개변수로 전달받은 반지름 값을 위 radius 클래스 변수에 저장하는 기능
	public void setRadius(double newRadius) {
		radius = newRadius;	 //클래스변수 = 매개변수;
	}
	
	//기능 : 원의 면적을 계산해서 반환(제공)하는 기능
	public double calculateArea() {
		//원의 면적 = 반지름 X 반지름 X 3.14
		return radius * radius * 3.14;
	}
	
}

public class Ex2_1 {

	public static void main(String[] args) {
		
		//3단계. 2단계에서 만든 Circle class(설계도) 하나를 이용해 객체메모리 생성 후 사용
		
		//1. 객체메모리 생성 후 참조변수에 주소값 저장
		Circle circle = new Circle();
		
		//2. 반지름 값 5를 double radius 객체변수 메모리에 저장
		//circle.radius = 5;
		circle.setRadius(5);
		
		//System.out.println(circle.radius); 5.0
		
		//3. new Circle()객체메모리의 원 면적을 계산해서 얻기 위해 
		//calculateArea()객체메소드 호출
		System.out.println(circle.calculateArea()); //78.5
		
//----------------------------------------------------------------
		
		//객체메모리 한번 더 생성하여 반지름 값 3 설정
		Circle circle2 = new Circle();
			
		circle2.setRadius(3);
		
		System.out.println(circle2.calculateArea()); //28.26			

	}

}
