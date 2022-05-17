package practice;

public class InvalidateUserException extends Exception {
    public InvalidateUserException() {}
    public InvalidateUserException(String m) {
        super(m);   // Exception(String m) {message = m;} 생성자 호출 의미
                    // super(m)같은 경우에 parent class의 같은 parameter를 가진 생성자를 불러온다.
                    // 따라서 Parent class인 Exception에서 Exception(String m)이라는 같은 파라미터를 가진 생성자를 불러온것.
    }
}
