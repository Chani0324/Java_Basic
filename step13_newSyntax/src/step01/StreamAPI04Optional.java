package step01;

import java.util.Optional;

public class StreamAPI04Optional {

	static void m1() {
		String v = null;
		System.out.println(v.length());	// java.lang.NullPointerException
	}
	
	static void m2() {
		String v = null;
		Optional<String> opt = Optional.ofNullable(v);
		System.out.println(opt);	// Optional.empty
		
		// 데이터 존재여부 확인 가능한 메소드
		System.out.println(opt.isPresent());	// false
		
//		System.out.println(opt.ifPresent());	// void 반환. 문법 err
		
		// null과 무관하게 예외없이 정상 실행
		// end user의 요청시마다 데이터가 null인 상태가 돼도 NullPointerException 볼 수 없음.
		opt.ifPresent(i -> {
			 System.out.println(i.length());
		});
	}

	static void m3() {
		String v = "playdata";
		Optional<String> opt = Optional.ofNullable(v);
		System.out.println(opt);	// Optional[playdata]
		
		System.out.println(opt.isPresent());	// true
		
//		System.out.println(opt.ifPresent());	// void 반환. 문법 err
//		System.out.println(opt.ifPresent(i -> i.length()));	// void 타입 출력 불가
		
		/*
		 * opt가 참조하는 내부 데이터인 String의 playdata 값을 v2 변수에 대입
		 * lambda 식을 활용해서 처리
		 * {} 내부엔 일반 메소드 구현처럼 다양한 코드 적용 가능
		 * v2 변수는 {} 내부에서 사용 가능.
		 */
		
		opt.ifPresent(i -> {
			 System.out.println(i.length());
		});
	}
	
	// ofElse()
	static void m4() {
		String v = null;
		
		Optional<String> opt = Optional.ofNullable(v);
		System.out.println(opt.isPresent());	// false
		System.out.println(opt.isEmpty());	// true
		System.out.println(opt.orElse("null인 경우에만 반환"));	// null인 경우에만 반환되도록 설정
	}
	
	// ofElse()
	static void m5() {
		String v = "encore";
		
		Optional<String> opt = Optional.ofNullable(v);
		System.out.println(opt.isPresent());	// true
		System.out.println(opt.isEmpty());	// false
		System.out.println(opt.orElse("null인 경우에만 반환"));	// encore
	}
		
	public static void main(String[] args) {
//		m1();	// NullPointerException 연출
//		m2();	// ifPresent() 확인 및 null임에도 NullPointerException 발생 안 되는 안정적인 구현 연출
//		m3();	// ifPresent() 확인.
//		m4();
		m5();
		
	}

}
