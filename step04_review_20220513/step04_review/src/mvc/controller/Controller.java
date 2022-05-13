package mvc.controller;	// 연관 class 공유
import mvc.model.Model;	// Model.java에 있는 class를 불러와서 사용 예정
import mvc.view.EndView; // EndView.java에 있는 class를 불러와서 사용 예정

public class Controller {	// 접근제한이 없는 class타입의 Controller 설정

	public static void reqRes(int reqNo) { // 접근제한이 없고 class 내에서 인스턴스를 만들 필요 없이 공유되면서 return값을 가지지 않는 reqRes 메소드생성(parameter 값으로 int타입의 reqNo 변수를 받음)
											// static으로 method를 만들었기 때문에 이 method사용시 인스턴스를 만들어서 참조변수를 통해 사용할 필요 없이 class이름.메소드 로 바로 사용 가능
		if(reqNo == 1) {  // 만약 reqNo의 값이 1이라는 input이 들어오면
			EndView.printName(Model.getName());	// EndView class에 있는 printName 메소드에다가 Model class에 있는 getName메소드를 파라미터로 입력
			
		}else if(reqNo == 2) { // 만약 reqNo의 값이 2라는 input이 들어오면
			EndView.printCustomer(Model.getCustomer());	// EndView class에 있는 printName 메소드에다가 Model class에 있는 getCustomer메소드를 파라미터로 입력
		
//		}else { // 만약 위 조건이 모두 아닌 다른 조건이 input 된다면
//			EndView.failMsg("잘못된 요청입니다. 재확인 하셔요"); // EndView class에 있는 failMsg 메서드에 "잘못된 요청입니다.~"를 파라미터로 넣음
		}
	}
}
