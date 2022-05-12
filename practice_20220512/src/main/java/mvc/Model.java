package mvc;

import mvc.Data;	// Data에 class 사용 예정
import mvc.Customer;	// Customer에 class 사용 예정

public class Model {	// 접근제한이 없는 class타입의 Model 생성
	//1단계
	public static String getName() {	// 접근제한이 없는, class내에서 인스턴스 만들 필요없이 공유되는 String타입의 getName메소드 생성
		Data d = Data.getInstance();	// Data 인스턴스를 만들었는데 참조변수 d에다가 Data class에 있는 getInstance메소드 주소값 할당
		String [] ns = d.getNames();	// String 타입을 가지는 array ns 변수에 참조변수 d에 getNames메소드 주소값 할당
		return ns[0]; //	array ns의 첫번쨰 값을 return함.
	}
	
	//2단계 - 개선
	public static String getName2() {	// 접근제한이 없는, class내에서 인스턴스 만들 필요없이 공유되는 String 타입의 getName2메소드 생성
		String [] ns = Data.getInstance().getNames();	// String 타입의 array ns에다가 Data에 있는 getInstance메소드 실행후 getNames메소드를 실행한 주소값을 할당
		return ns[0]; // array ns의 첫번째 값을 return함.
	}
	
	//3단계 - 개선
	/* Data.getInstance().getNames()[0]
		 * Data.getInstance() : Data
		 * Data.getInstance().getNames() : String[]
		 * Data.getInstance().getNames()[0] : String
	 */
	public static String getName3() {	// 접근제한이 없는, class내에서 인스턴스 만들필요 없이 공유되는 getName3메소드 생성
		return Data.getInstance().getNames()[0]; // Data에 있는 getInstance메소드 실행 -> getNames메소드 실행 후 array의 첫번쨰 값을 return 함.
	}
	
	
	public static Customer getCustomer() {	// 접근제한이 없는, class내에서 인스턴스 만들필요 없이 공유되는 Customer 타입의 getCustomer메소드 생성
		Customer [] cs = Data.getInstance().getCustomers();	// Customer 타입의 array cs에다가 Data에 있는 getInstance메소드 실행 -> getCustomers메소드 실행한 주소값 할당
		return cs[0];	// array cs의 첫번쨰 값을 return함.
	}
		
}
