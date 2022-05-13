package mvc.controller;
import mvc.controller.exception.InvalidateUserException;
import mvc.model.Model;
import mvc.view.EndView;

/*
 * MVC pattern 중 Controller를 구현한 class 입니다.
 * Controller는 View(StartView)를 통해 전달받은 사용자 요쳥을 처리한 뒤, 결과를 View(EndView)로 전달합니다.
 */
public class Controller {

	/*
	 * public : View의 요청을 Controller에 전달하기 위해 public으로 선언합니다.
	 * static : 객체 생성 없이 method를 사용하기 위해 static으로 선언합니다.
	 * void : StartView의 요청은 EndView를 통해 화면에 출력하기 때문에 void로 선언합니다.
	 * reqRes method : StartView의 사용자 요청을 Controller에 전달하는 method입니다.
	 */
	public static void reqRes(int reqNo) {
		// 사용자 요청에 맞는 응답을 처리하기 위해 if - else문을 사용합니다.
		if(reqNo == 1) {
			// 요청에 맞는 결과를 EndView에 전달합니다.
			EndView.printName(Model.getName()); 
			
		}else if(reqNo == 2) {
			EndView.printCustomer(Model.getCustomer());
			
		}else {
			EndView.printMsg("잘못된 요청입니다. 재확인 하셔요");
		}
	}
	
	// id와 pw가 Data의 cust array에 있는지 확인.
	public static void reqValid(String id, String pw) {
		try {
			EndView.printMsg(reqUser(id, pw));
		}
		catch (InvalidateUserException e) {
			EndView.printMsg(e.getMessage());
		}
	}
	
	public static String reqUser(String id, String pw) throws InvalidateUserException { 
		// Model Class에서 getCustomer method를 불러서 cust(Customer array)의 첫번째 Id와 Pw를 가져옴.
		// 첫 번째 값을 가져오는 이유는 Model Class에서 첫번째 값을 받아오게 했기 때문.
		if (id.equals(Model.getCustomer().getId()) && pw.equals(Model.getCustomer().getPw())) {	
			return "유효한 회원입니다.";
		}
		else {
			throw new InvalidateUserException("없는 회원입니다.");
		}
	}
}
