//Database라 가정

package mvc.model.db;

import mvc.model.domain.Car;
import mvc.model.domain.Customer;

/* 
 * Singleton pattern을 적용한 class입니다.
 * Data class를 db로 가정합니다.
 */
public class Data {
	
	// db에 저장된 data들입니다.
	private static String [] names = {"영자", "동엽"};
	private static Customer[] cust = {new Customer("tester", "11", new Car("BMW", "77")),
					   				  new Customer("master", "22", new Car("sonata", "88"))};
	/*
	 * Singleton pattern 적용
	 * 1. 하나의 객체만 생성하고 외부 객체 생성을 제한하기 위해 Data type의 instance를 생성해 private static으로 선언한 변수에 초기화합니다.
	 * 2. 외부 객체 생성을 제한하기 위해 생성자를 private으로 선언합니다.
	 * 3. Data instance를 외부에서 객체 생성 없이 접근하기 위해 public static으로 선언한 getInstance method를 정의합니다.
	 */
	private static Data instance = new Data();	
	private Data() {}
	public static Data getInstance() {
		return instance;
	}
	
	// db에 저장된 이름들을 반환합니다.
	public String[] getNames() {
		return names;
	}
	
	// db에 저장된 고객 정보들을 반환합니다.
	public Customer[] getCustomers() {
		return cust;
	}
}