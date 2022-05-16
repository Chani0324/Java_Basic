package mvc;

import lombok.AllArgsConstructor;	// lombok에있는 AllArg 사용 예정
import lombok.Getter;	// Getter 사용 예정
import lombok.NoArgsConstructor;	// NoArgs 사용 예정
import lombok.Setter;	// Setter 사용 예정

@NoArgsConstructor // 파라미터 없는 기본 생성자 자동생성
@AllArgsConstructor  	// 파라미터를 받는 생성자 자동생성
@Getter  // getXxx 메소드 자동 생성
@Setter  // setXxx 메소드 자동 생성
public class Customer {	// 접근제한이 없는 class 타입의 Customer생성
	String id;	// String타입의 멤버변수 id
	String pw;	// Sring 타입의 멤버변수 pw
	Car car;  // Car 타입의 멤버변수 car
}