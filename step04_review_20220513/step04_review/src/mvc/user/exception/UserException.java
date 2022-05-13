package mvc.user.exception;

public class UserException extends Exception {
	public UserException() {}
	public UserException(String m) {
		super(m);	// Exception(String m) {message = m;} 생성자 호출 의미
	}
	
}
