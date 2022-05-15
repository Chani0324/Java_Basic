package mvc.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok을 사용해 default constructor, constructor, getter, setter등을 구현합니다.
@Data  
@NoArgsConstructor
@AllArgsConstructor 

// 자동차 정보를 담기 위한 class입니다.
public class Car {
	String carName;
	String carNo;
}


