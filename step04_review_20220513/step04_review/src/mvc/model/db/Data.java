//Database라 가정

package mvc.model.db;	// class 공유

import mvc.model.domain.Car;	// Car에 class 사용 예정
import mvc.model.domain.Customer;	// Customer에 class 사용 예정

public class Data {	// 접근제한이 없는 class 타입의 Data 생성
	//모든 요청하는 user들이 공유하는 단일 데이터라 가정
	private static String [] names = {"영자", "동엽"};		// 외부에서 접근할 수 없는 class내에서 인스턴스 만들필요없이 공유되는 String 타입의 array names변수에 {"영자", "동엽} array주소값 할당
	private static Customer[] cust = {new Customer("tester", "11", new Car("BMW", "77")),
					   				  new Customer("master", "22", new Car("sonata", "88"))};
	// -> 외부에서 접근할 수 없는 class내에서 인스턴스 만들필요없이 공유되는 Customer 타입의 array cust 참조변수에다가 
	// {Customer생성자를 만들어서 parameter값으로 ("tester", "11, Car생성자만들어서 ("BMW", "77"))값을 가지는 array주소값 할당
	
	private static Data instance = new Data();	// 외부에서 접근불가한 class내에서 인스턴스 만들필요없이 공유되는 Data 타입의 참조변수 instacne에다가 Data 생성자를 만든후 주소값 할당.
	private Data() {}	// Data 생성자. 값 초기화.
	public static Data getInstance() { // 접근제한이 없는 class 내에서 인스턴스만들필요없이 공유되는 Data타입의 getInstance메소드 생성
		return instance;	// instance 참조변수값을 return함,
	}
	
	//이름들만 반환 - 두명
	public String[] getNames() {	// 접근제한이 없는 String 타입의 array getNames메소드 생성
		return names;	// names 참조변수값 return
	}
	
	//고객들만 반환 - 두명 고객
	public Customer[] getCustomers() {	// 접근제한이 없는 Customer 타입의 array getCustomer메소드 생성
		return cust;	// cust 참조변수값 return
	}
}