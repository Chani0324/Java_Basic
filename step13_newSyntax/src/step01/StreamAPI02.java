package step01;

import java.util.Arrays;
import java.util.List;

public class StreamAPI02 {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
		
		// 짝수 합
//		System.out.println(nums.stream().filter(i -> i % 2 == 0).mapToInt(i -> i).sum());
		
		// 홀수 합
//		System.out.println(nums.stream().filter(i -> i % 2 == 1).mapToInt(i -> i).sum());
		
		// 홀수 개수 구하기
//		System.out.println(nums.stream().filter(i -> i % 2 == 1).mapToInt(i -> i).count());
		
		// 홀수 중 최대값 구하기
//		System.out.println(nums.stream().filter(i -> i % 2 == 1).mapToInt(i -> i).max().getAsInt());
		
		// 최대값
//		System.out.println(nums.stream().mapToInt(i -> i).max().getAsInt());

		// 2만 제외하고 출력
		// skip() : 지정한 데이터 순번까지는 skip / forEach()
//		nums.stream().skip(2).forEach(System.out::println);
//		nums.stream().filter(i -> i != 2).forEach(System.out::println);
		
		List<Integer> nums2 = Arrays.asList(11, 12, 13, 14, 15);
		nums2.stream().skip(2).forEach(System.out::println);

		
	}

}
