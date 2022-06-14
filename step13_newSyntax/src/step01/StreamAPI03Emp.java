package step01;

import java.util.ArrayList;
import java.util.List;

import model.domain.Employee;

public class StreamAPI03Emp {

	public static void main(String[] args) {
		List<Employee> peoples = new ArrayList<>();
		peoples.add(new Employee(101, "Victor", 23));
		peoples.add(new Employee(102, "Rick", 21));
		peoples.add(new Employee(103, "Sam", 25));
		peoples.add(new Employee(104, "John", 27));
		peoples.add(new Employee(105, "Grover", 23));
		peoples.add(new Employee(106, "Adam", 22));
		peoples.add(new Employee(107, "Samy", 224));	// age가 이상치
		peoples.add(new Employee(108, "Duke", 29));
		
		// 나이값들 평균. 단 출력되는 데이터는 double
		// mapToInt (parameter로 유입된 데이터를 int로 변환)
		double ageAvg = peoples.stream().mapToInt(i -> i.getAge()).average().getAsDouble();
		
		System.out.println(ageAvg);
		
		System.out.println(peoples.stream());	// java.util.stream.ReferencePipeline$Head@490d6c15
		System.out.println(peoples.stream().mapToInt(i -> i.getAge()));	// java.util.stream.ReferencePipeline$4@449b2d27
		System.out.println(peoples.stream().mapToInt(i -> i.getAge()).average());	// OptionalDouble[49.25]
		
		// 나이가 100을 초과하는 직원들 데이터를 제외한 나머지 직원들의 평균 나이 계산 및 출력.
		System.out.println(peoples.stream().mapToInt(i -> i.getAge()).filter(age -> age <= 100).average().getAsDouble());
		
		// mapToInt와 filter의 순서를 바꾸게 되면 age(여기서는 Employee type이 됨)의 타입과 int 타입을 비교할 수 없다고 나오게 된다.
		// 즉, 먼저 mapToInt로 비교할 대상을 가져온 후에 filter를 적용하는게 옳음.
//		System.out.println(peoples.stream().filter(age -> age <= 100).mapToInt(i -> i.getAge()).average().getAsDouble());
		
		
	}

}
