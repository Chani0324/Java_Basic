// step04예제에서 예외 발생하는 코드를 직접 설계해보기

package mvc.view;	// class 공유

import mvc.controller.Controller;	// Controller에 class 사용 예정
import mvc.user.exception.UserException;


public class StartView {	// 접근제한이 없는 class 타입의 StartView 생성
	
	static int userReq;
	
	
	static boolean UserExceptionErr(int reqNo) throws UserException {
		if(reqNo == 1 || reqNo == 2) {
			return true;
		}else {
			throw new UserException("잘못된 요청입니다. 정확한 요청을 보내주세요");
		}
	}
	
	
	public static void main(String[] args) {	// 접근제한이 없고 class내에서 인스턴스 만들필요없이 공유되는 return값을 받지않는 main메소드 생성 
		userReq = 66;	// 유저가 보내는 Req
		try {
			
			boolean req = UserExceptionErr(userReq);
				if(userReq == 1) {
					System.out.println("--- 이름 검색 ---");
					Controller.reqRes(userReq);
				}else if(userReq == 2) {
					System.out.println("--- 고객 검색 ---");
					Controller.reqRes(userReq);
				}
		}catch(UserException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
		
		
//		System.out.println("--- 이름 검색 ---");	// "이름검색"출력
//		Controller.reqRes(1);	// Controller에 있는 reqRes메소드에 parameter값으로 1입력
//		
//		System.out.println("--- 고객 검색 ---");
//		Controller.reqRes(6);	// // Controller에 있는 reqRes메소드에 parameter값으로 2입력
				
//		System.out.println("--- 고객 실수로 1과 2가 아닌 데이터 요청시 ---");
//		Controller.reqRes(5);	// Controller에 있는 reqRes메소드에 parameter값으로 1입력
		
	}

}
