package mvc.view;

import mvc.controller.Controller;
// import mvc.controller.exception.InvalidateUserException;

/*
 * 프로그램의 시작점 역할을 하며, 사용자 요청을 Controller에 전달합니다.
 * MVC pattern에서 View(StartView)를 구현한 class입니다.
 * StartView는 사용자 요청을 Controller에 전달합니다.
 */
public class StartView {
	public static void main(String[] args) {
		
		System.out.println("--- 이름 검색 ---");
		// 1의 사용자 요청을 Controller에 전달.
		Controller.reqRes(1);
		
		System.out.println("--- 고객 검색 ---");
		// 2의 사용자 요청을 Controller에 전달.
		Controller.reqRes(2);
		
		System.out.println("--- 고객 실수로 1과 2가 아닌 데이터 요청시 ---");
		// 잘못된 사용자 요청을 Controller에 전달.
		Controller.reqRes(5);
		
		System.out.println("--- 로그인 요청 ---");
		Controller.reqValid("test", "11");
	}
}
