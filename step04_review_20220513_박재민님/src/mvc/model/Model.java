package mvc.model;

import mvc.model.db.Data;
import mvc.model.domain.Customer; 

/*
 *  MVC pattern에서 Model을 구현한 class입니다.
 *  Model은 사용자 요청을 처리하기 위해 필요한 data를 handling합니다.
 */
public class Model {
	
	/*
	 * Controller에서 Model 객체 생성 없이 사용하기 위해 public static으로 선언합니다.
	 * db 역할을 하는 Data class에 저장된 이름들 중 첫번째 이름을 반환합니다.
	 */
	public static String getName() {
		return Data.getInstance().getNames()[0];
	}
	
	
	/*
	 * Controller에서 Model 객체 생성 없이 사용하기 위해 public static으로 선언합니다.
	 * db 역할을 하는 Data class에 저장된 고객 정보 중 첫번째 고객 정보를 반환합니다.
	 */
	public static Customer getCustomer() {
		return Data.getInstance().getCustomers()[0];
	}
		
}



