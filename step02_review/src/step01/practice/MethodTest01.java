package step01.practice;

public class MethodTest01 {

    // 두 숫자값을 받아서 더한 결과 값을, 기능을 요청한 곳으로 반환해보기

    int sum(int a1, int a2) {
        return a1 + a2;
    }

    String sum2(int b1, int b2) {
        int b3 = b1 + b2;
        return "합 = " + b3;
    }
        
    public static void main(String[] args) {
        MethodTest01 m1 = new MethodTest01();
        System.out.println(m1.sum(1, 10) + ", " + m1.sum2(1, 10));

        int k1 = m1.sum(10, 11);
        String k2 = m1.sum2(33, 21);

        System.out.println(k1 + ", " + k2);


    }

}
