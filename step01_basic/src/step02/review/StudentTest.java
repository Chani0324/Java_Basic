package step02.review;

public class StudentTest {

    public static void main(String[] arg) {
        Student st1 = new Student(); //st1, st2는 로컬 변수
        Student st2 = new Student();

        st1.name = "유재석";    // name, age같은 경우 멤버 변수
        st1.age = 20;

        st2.name = "노홍철";
        st2.age = 38;

        System.out.println(st1.name + " " + st2.name);

    }
    
}
