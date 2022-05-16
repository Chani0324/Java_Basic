package mvc;

import lombok.AllArgsConstructor;	// lombok에 있는 AllArg, Data, NoArg 사용 예정
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // getXxx, setXxx 등등 자동 생성
@NoArgsConstructor	// 파라미터 안받는 기본생성자 자동 생성
@AllArgsConstructor  // 파라미터를 받는 생성자 자동 생성
public class Car {	// 접근제한이 없는 class 타입의 Car 생성
	String carName;	// String 타입의 참조변수 carName
	String carNo;	// String 타입의 참조변수 carNo
}