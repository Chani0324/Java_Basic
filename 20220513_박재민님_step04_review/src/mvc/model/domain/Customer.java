package mvc.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//lombok을 사용해 default constructor, constructor, getter, setter등을 구현합니다.
@NoArgsConstructor 
@AllArgsConstructor  
@Getter  
@Setter

// 고객 정보를 담기 위한 class입니다.
public class Customer {
	String id;
	String pw;
	Car car;
}






