package mvc;


import mvc.Controller;	// Controller에 class 사용 예정

public class StartView {	// 접근제한이 없는 class 타입의 StartView 생성
	public static void main(String[] args) {	// 접근제한이 없고 class내에서 인스턴스 만들필요없이 공유되는 return값을 받지않는 main메소드 생성
		
		System.out.println("--- 이름 검색 ---");	// "이름검색"출력
		Controller.reqRes(1);	// Controller에 있는 reqRes메소드에 parameter값으로 1입력
		
		System.out.println("--- 고객 검색 ---");
		Controller.reqRes(2);	// // Controller에 있는 reqRes메소드에 parameter값으로 2입력
		
		System.out.println("--- 고객 실수로 1과 2가 아닌 데이터 요청시 ---");
		Controller.reqRes(5);	// Controller에 있는 reqRes메소드에 parameter값으로 1입력
		
	}
}
