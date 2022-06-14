package step01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream API 활용 mission 2022.06.13.월
 * 
 * @author 박재민
 *
 */

public class Mission {

	public static void main(String[] args) {

		// Read file
		BufferedReader in = null;
		List<String> words = null;

		try {
			in = new BufferedReader(new FileReader("용어.txt"));
			String datas = null;
			words = new ArrayList<>();
			
			while ((datas = in.readLine()) != null) {
				words.add(datas);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// Mission 1 : Print string length over 3
		List<String> wordList = words.stream().map(line -> line.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
		System.out.println(wordList.stream().filter(word -> word.length() > 3).collect(Collectors.toList()));
		
		// Mission 2 : print string average length
		System.out.println("길이 3 이상 단어 평균 길이 : " + wordList.stream().filter(word -> word.length() > 3).mapToInt(w -> w.length()).average().getAsDouble());
	}

}
