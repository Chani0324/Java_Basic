package view;

import controller.Controller;

public class StartView {
	// 브라우저 요청으로 간주
	
	
	public static void main(String[] args) {
		// 모든 고객 정보 요청
//		Controller.allRequestResponse("all");
		
		// 사번 입력해서 해당 사원의 정보만 검색 요청
		Controller.allRequestResponse("안녕");
		
	}

}
