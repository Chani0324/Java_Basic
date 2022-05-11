package step01.practice;

public class Student {
    String name;
    int age;


    public Student() {} // 이 문장이 없으면 바로 아래문장이 적용됨(생성자가 되면서 제일 먼저 적용. 따라서 무조건 parameter값을 넣어줘야함)
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}



