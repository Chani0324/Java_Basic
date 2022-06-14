package step01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI07Peek {

	public static void main(String[] args) {

		List<String> datas = new ArrayList<>();
		datas.add("playdata");
		datas.add("encore data");
		datas.add("kim");
		datas.add("Ice cream");
		datas.add("cream");
		datas.add("coffee cream"); 
		
		datas.stream().filter(s -> s.length() > 7) .peek(e -> System.out.println("첫번째 filter: " + e)) 
		.filter(s -> s.startsWith("I")) .peek(e -> System.out.println("두번째 filter: " + e)).collect(Collectors.toSet()); 
	}
}
