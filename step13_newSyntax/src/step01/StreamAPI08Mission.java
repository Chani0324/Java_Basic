/*
 * 미션?
 * 	- 용어.txt 파일로부터 데이터 read
 * 	- 각 문장들을 단어로 분리 후 단어별로 길이가 3이상 되는 단어들만 출력
 * 
 * 	- 2번째 스스로 구성한 문제(미션)
 */

package step01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class StreamAPI08Mission {

	public static void fileRead() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("용어.txt"));

			// read한 데이터를 대입받는 변수, 데이터가 있으면 String객체, 없을 경우 null
			String readData = null;
			ArrayList<String> readDatas = new ArrayList<>();
			String [] word = null;
			
			while ((readData = in.readLine()) != null) {
				word = readData.split(" |\\(|\\)|:");
				for (String i : word) {
					i = i.replace(".", "");
					i = i.replace(",", "");
					readDatas.add(i);
				}
			}
			
			readDatas.stream().filter(i -> i.length() >= 3).peek(i -> System.out.println(i)).collect(Collectors.toList());
			
		} catch (FileNotFoundException e) { // file이 없을 경우 실행
			e.printStackTrace();
		} catch (IOException e) { // 데이터 read시에 예외 발생시
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		
		fileRead();
		
	}

}
