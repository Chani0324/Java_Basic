package step01.syntax;

public class CustomerTest {

    String name;
    int age;
    String grade;
    
    public static void main(String[] args) {
        CustomerTest ct1 = new CustomerTest();
        CustomerTest ct2 = new CustomerTest();
        CustomerTest ct3 = new CustomerTest();

        ct1.name = "유재석";
        ct1.age = 20;
        ct1.grade = "vvip";

        ct2.name = "박명수";
        ct2.age = 15;
        ct2.grade = "Platinum";

        ct3.name = "정형돈";
        ct3.age = 35;
        ct3.grade = "vip";

        System.out.println(ct1.name + ct2.name + ct3.name);

    }

}
