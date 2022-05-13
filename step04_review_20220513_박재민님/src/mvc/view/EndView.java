package mvc.view;

import mvc.model.domain.Customer;

/*
 * MVC pattern에서 View(EndView)를 구현한 class입니다.
 * View(EndVIew)는 Controller로부터 전달받은 data를 화면에 출력합니다.
 */
public class EndView {
	
	//method들은 외부에서 객체 생성 없이 호출하기 위해 public static으로 선언합니다.
	
	// 이름을 화면에 출력합니다.
	public static void printName(String name) {
		System.out.println("검색된 이름 : " + name);
	}

	
	// 고객 정보를 화면에 출력합니다.
	public static void printCustomer(Customer customer) {
		System.out.println(customer.getId() + " " + customer.getPw()
						 + " " + customer.getCar().getCarName());
	}
	
	public static void printMsg(String msg) {
		System.out.println(msg);
	}

}
