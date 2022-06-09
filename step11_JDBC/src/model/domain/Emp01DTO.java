package model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@RequiredArgsConstructor // 기본 생성자 추가. @NonNull을 변수에 사용시 선언된 멤버 변수들을 초기화하는 생성자를 동적으로 생성함.
@ToString(exclude = "comm")	// lombok에 ToString에서 멤버 제거 가능한 설정
public class Emp01DTO {
	
	@NonNull	// 생성자 통해서 값 초기화 필수라는 애노테이션
	private int empno;
	@NonNull
	private String ename;
	@NonNull
	private int sal;
	@NonNull
	private int t_sal;
	
	private int comm;
	
}
