package mvc;

import mvc.Customer;	// Customer class 사용 예정

public class EndView {	// 접근 제한이 없는 class 타입의 EndView를 만듦.
	public static void printName(String name) {	// 접근제한이 없고 class 내에서 인스턴스를 만들 필요없이 공유되면서 return값이 필요없는 printName메소드를 만듦(parameter로 String 타입의 name변수를 받음)
		System.out.println("검색된 이름 : " + name);	// 메소드 실행시 "검색된 이름 : "과 name 변수값 출력
	}
	public static void failMsg(String msg) {	// 접근제한이 없고 class내에서 인스턴스를 만들 필요 없이 공유되면서 return 값이 필요없는 failMsg메소드를 만듦(parameter로 String타입의 msg변수를 받음)
		System.out.println(msg);	// msg변수 출력
	}
	
	public static void printCustomer(Customer customer) {	// 접근제한이 없고 class내에서 인스턴스를 만들 필요없이 공유되면서 return값이 필요없는 printCustomer메소드를 만듦(parameter로 Customer타입의 customer변수를 받음)
		System.out.println(customer.getId() + " " + customer.getPw()	// customer변수에 있는 (getId메소드), (getPw메소드), (getCar메소드에 getCarName메소드) 출력
						 + " " + customer.getCar().getCarName());
	}
}