package step01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Test01 {
	
	public static void readFile() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("용어.txt"));

			// read한 데이터를 대입받는 변수, 데이터가 있으면 String객체, 없을 경우 null
			String readData = null;
			ArrayList<String> li = new ArrayList<>();
			String [] word = null;

			while ((readData = in.readLine()) != null) {
				word = readData.split(" ");
				
				for (String i : word) {
					
					li.add(i);
				}
			}
			
			li.stream().filter(i -> i.length() >= 3).peek(i -> System.out.println(i)).collect(Collectors.toSet());

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
		
		readFile();
		
	}

}
