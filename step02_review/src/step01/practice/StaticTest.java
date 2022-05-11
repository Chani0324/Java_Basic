/*
1. API 활용을 용이하게 하기 위한 단계
2. static 설정
    1. 변수, 메소드, 블록 문법 사용

3. 특징
    1. 변수
        구현 문법 : static 타입 변수명 [=값];
        호출 문법 : 
            class명.변수명
            참조변수명.변수명
            변수명 - 동일한 클래스 내에서만 class 명 없이 호출 가능
        * 생성되는 모든 객체가 공유하는 데이터
            - id/pw처럼 고유한 데이터 표현하는 변수는 절대 사용 금지.

4. 멤버 변수 종류 두가지
    - 실제 사용 가능하도록 메모리에 생성 시점엔 각 타입별 기본값(default)으로 자동 대입
    - 정수 : 0 / 실수 : 0.0 / boolean : false / char : '\u0000'(null)
    - 기본이 아닌 모든 객체 타입 : null
    1. 일반 변수(non-static, instance 변수)
        - 객체 생성(instance) 직후에만 사용 가능한 변수.(같은 class내 다른 method에서 사용할 때 등등.)
    2. static 변수(class 변수)
        - 객체 생성과 무관하게 byte code(실행파일)가 메모리에 로딩될 때 사용 가능한 변수

5. 
*/


package step01.practice;

public class StaticTest {
    int no1;
    static int no2;

    StaticTest(){
        no1 += 1;
        no2 += 1;
    }

    void m1() {
        System.out.println("일반 메소드");
    }

    static void m2() {
        System.out.println("static 메소드");
    }    

    public static void main(String[] args) {
        m2();

        StaticTest t = new StaticTest();
        t.m1();

        System.out.println(no2);

        StaticTest s1 = new StaticTest();
        System.out.println(s1.no1 + " " + no2);

        StaticTest s2 = new StaticTest();
        System.out.println(s2.no1 + " " + no2);

    }



}
