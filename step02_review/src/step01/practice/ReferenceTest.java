package step01.practice;

class C {
    String msg = "play data";

    C(){}
    C(String msg){
        this.msg = msg; // 여기서 this.msg는 class A에서 msg멤버변수를 나타낸다. msg는 method내의 로컬변수
                        // python에서는 self.변수로 하지만 따로 class내에 변수를
                        // 선언하지 않아도 되기 때문에 java와는 차이점이 있다. 
    }
}

class D {
    C a = new C();

    C getC() {
        return new C("반환되는 객체"); // method getA()를 실행시키는 것은 class B에서 A타입을가지는 getA() method를 실행시킨다는 것.
    }

    void printA(C v) {
        System.out.println(v.msg);
    }

}


public class ReferenceTest {

    public static void main(String[] args) {
        // ? B 객체 생성
        D d = new D();
        
        // ? B 객체가 보유하고 있는 getA() 호출해서 A 객체 받아오기
        d.getC();

        // ? B 객체의 printA() 메소드 호출. 단, getA()가 반환한 A객체를 parameter로 적용. 주소값 보기
        System.out.println(d.getC());
        

        // "반환되는 객체" 출력
        d.printA(d.getC());
        

    }    
    
}
