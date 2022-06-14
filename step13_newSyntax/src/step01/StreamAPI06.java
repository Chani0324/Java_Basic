/*
 * 1. 소스만 보고 API 기능들 이해하기
 * 2. 필요에 의해서 이해를 위한 sample 도우미 예제를 구성해 보기.
 * 3. review + 6단계 예제 미션 수행 - 16시까지.
 */

package step01;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI06 {

	public static void main(String[] args) {

//		printf
//		%d	정수형 출력
//		%s	문자형 출력
//		%f	실수형 출력
//		%c	문자열 출력
//		%n	줄 바꿈
//		%b	boolean 출력

//		map은 요소들을 특정조건에 해당하는 값으로 변환해 줍니다.
//		요소들을 대,소문자 변형 등 의 작업을 하고 싶을떄 사용 가능 합니다.
//
//		filter는 요소들을 조건에 따라 걸러내는 작업을 해줍니다.
//		길이의 제한, 특정문자포함 등 의 작업을 하고 싶을때 사용 가능합니다.
//
//		sorted는 요소들을 정렬해주는 작업을 해줍니다.

		System.out.println("-- 1 --");
		System.out.println("List 내에 빈 영역이 있으면 개수를 세어주도록 합니다.");
		List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
		long count = strList.stream().filter(String::isEmpty).count();
		System.out.printf("List %s has %d empty strings %n", strList, count);

		System.out.println("");
		System.out.println("-- 2 --");
		System.out.println("List 내 문자열이 길이가 3초과인 수를 세어줍니다.");
		long num = strList.stream().filter(x -> x.length() > 3).count();
		System.out.printf("List %s has %d strings of length more than 3 %n", strList, num);

		System.out.println("");
		System.out.println("-- 3 --");
		System.out.println("List 내 문자열 중 a로 시작하는 문자열의 개수를 세어줍니다.");
		count = strList.stream().filter(x -> x.startsWith("a")).count();
		System.out.printf("List %s has %d strings which startsWith 'a' %n", strList, count);

		System.out.println("");
		System.out.println("-- 4 --");
		System.out.println("List 내 비어있지 않은 element만 List로 모아줍니다.");
		List<String> filtered = strList.stream().filter(x -> !x.isEmpty()).collect(Collectors.toList());
		System.out.printf("Original List : %s, List without Empty Strings : %s %n", strList, filtered);

		System.out.println("");
		System.out.println("-- 5 --");
		System.out.println("List 내 문자열의 길이가 2 초과인 element들만 List로 모아줍니다.");
		filtered = strList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
		System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);

		System.out.println("");
		System.out.println("-- 6 --");
		System.out.println("List 내 문자열을 대문자로 만들고 / 로 구분지어 모아줍니다.");
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
		String G7Countries = G7.stream().map(String::toUpperCase).collect(Collectors.joining(" / "));
		System.out.println(G7Countries);

		System.out.println("");
		System.out.println("-- 7 --");
		System.out.println("Integer 타입의 List를 만들고, 이 List의 각 element를 제곱하여 중복되는 값을 제거한 후 List로 모아줍니다.");
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		System.out.printf("Original List : %s, Square Without duplicates : %s %n", numbers, distinct);

		List<Integer> data = numbers.stream().map(i -> i * i).collect(Collectors.toList());
		System.out.printf("--- distinct() 없이 %s - %s %n", numbers, data);

		System.out.println("");
		System.out.println("-- 8 --");
		System.out.println("Integer타입의 List의 통계적 요약을 보여줍니다. length(), sum(), min(), average(), max()");
		System.out.println("IntSummaryStatistics 객체 타입은 통계를 수집하기 위한 객체 타입입니다.");
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);

		IntSummaryStatistics stats = primes.stream().mapToInt(x -> x).summaryStatistics();
		System.out.println(stats);
		System.out.println("Highest prime number in List : " + stats.getMax());
		System.out.println("Lowest prime number in List : " + stats.getMin());
		System.out.println("Sum of all prime numbers : " + stats.getSum());
		System.out.println("Average of all prime numbers : " + stats.getAverage());

		// 다음 수 중 제곱근이 정수 형태인 수는 정수로 출력 소수인 수는 출력 X
		List<Integer> pownumber = Arrays.asList(81, 100, 9, 16, 1, 3, 7);
		List<Double> data1 = pownumber.stream().map(i -> Math.sqrt(i)).filter(x -> x % 1 == 0)
				.collect(Collectors.toList());

		System.out.println(data1);

	}

}
