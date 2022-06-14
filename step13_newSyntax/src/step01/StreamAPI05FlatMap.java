/* flatMap()
 * 
 * 하나의 Stream을 다른 Stream으로 변환하는 데 사용
 * map()  연산 에서 사용하는 함수가 단일 값 을 반환
 */

package step01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI05FlatMap {

	public static void main(String[] args) {
		
		List<String> teamKorea = Arrays.asList("손흥민", "홍명보", "안정환");
		List<String> teamAustralia = Arrays.asList("Warner", "Watson", "Smith");
		List<String> teamEngland = Arrays.asList("Alex", "Bell", "Broad");
		List<String> teamNewZeland = Arrays.asList("Kane", "Nathan", "Vettori");
		List<String> teamSouthAfrica = Arrays.asList("AB", "Amla", "Faf");
		List<String> teamWestIndies = Arrays.asList("Sammy", "Gayle", "Narine");
		List<String> teamSriLanka = Arrays.asList("Mahela", "Sanga", "Dilshan");
		List<String> teamPakistan = Arrays.asList("Misbah", "Afridi", "Shehzad");

		// List타입 내부에 String 객체들을 보유한 List가 element로 저장 가능.
		List<List<String>> playersInWorldCup2022 = new ArrayList<>();
		
		playersInWorldCup2022.add(teamKorea);
		playersInWorldCup2022.add(teamAustralia);
		playersInWorldCup2022.add(teamEngland);
		playersInWorldCup2022.add(teamNewZeland);
		playersInWorldCup2022.add(teamSouthAfrica);
		playersInWorldCup2022.add(teamWestIndies);
		playersInWorldCup2022.add(teamSriLanka);
		playersInWorldCup2022.add(teamPakistan);

		/*
		 * 각 index별로 저장된 list들을 하나의 list에 새로 저장
		 * 필요성 : 로직 연출시 모든 선수들을 관리하는 List로 재생성을 해야하는 상황인 경우의 코드.
		 */
//		List<String> listOfAllPlayers = new ArrayList<>();
//		for (List<String> team : playersInWorldCup2022) {
//			for (String name : team) {
//				listOfAllPlayers.add(name);
//			}
//		}
//
//		System.out.println("world cup 선수들");
//		System.out.println(listOfAllPlayers);
		
		// step02 - jdk1.8부터 추구하는 코드
		// 문자열 list의 스트림을 문자열 스트림으로 평면화
		List<String> listOfAllPlayers = playersInWorldCup2022.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
		System.out.println(listOfAllPlayers);
		
		// printf : 출력 포멧
		// %라는 특수기호로 문자열 내부에 표현 - 해당 특수 기호에 적합한 타입의 데이터를 적용
		// %s - String 타입, %d - 숫자
		String s = "String";
		int i = 100;
		System.out.printf("문자열 %s, 숫자 %d", s, i);

	}

}
