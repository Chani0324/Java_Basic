package step01.practice;

public class StudentTest {
    
    public static void main(String[] args) {
        Student st1 = new Student();

        st1.setName("윤홍찬");
        st1.setAge(31);

        Student st2 = new Student();

        st2.setName("찬홍윤");
        st2.setAge(13);

        System.out.println(st1.getName() + ", " + st1.getAge());
        System.out.println(st2.getName() + ", " + st2.getAge());
        
    }

}
