/* 객체 생성 순서 학습

Java에서 method를 사용할 때는 main() { method } 이렇게 해야지 method가 실행된다.
단순 class 내에서 main()없이 method는 실행할 수 없다.

*/

package step01.practice;

class A {
    String name = "홍찬";
    int age = 20;

    A() { // 생성자 -> 이 부분이 없으면 class에서 method는 실행할 수 없다. class가 아닌 main()을 사용할 경우 컴파일러 시 접근 err가 발생할 수 있다.
            // 이 경우 main 스위치와 진입점으로 사용할 Main 메소드가 정의되어 있는 클래스의 전체 이름을 사용하면 된다.
            // 생성자가 아닌 경우 void B(){} 와 같은 형태로 method사용이 가능하다. 생성자는 반환값이 없지만 void A(){}와 같은 형태를 쓰지 않음.
            System.out.println(); // 이 부분은 method로 간주되기 때문에 method 바로 밖에 있는 class에서는 사용할 수 없고
                                // A(){} 생성자이자 method 안에서 사용 가능하다.
    }
    
    void m1() {

    }
}

class B {
    A a = new A();
    
    B() {
        System.out.println("B 생성자");
    }

}

public class MethodTest02 {
    B b = new B();

    public static void main(String[] args) {
        MethodTest02 mt = new MethodTest02(); //  생성자는 new 연산자를 통해서 인스턴스를 생성할 때 반드시 호출이 되고
                                            // 제일 먼저 실행되는 일종의 메소드(하지만 메소드와는 다르다.)이다. 매개인자도 넣기 가능.
                                            // 생성자는 인스턴스 변수(필드 값 등)를 초기화 시키는 역할을 한다. 
        
               
        String n = mt.b.a.name;
        System.out.println(n);
        
    }
    
}
