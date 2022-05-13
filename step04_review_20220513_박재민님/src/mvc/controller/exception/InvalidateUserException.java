package mvc.controller.exception;

public class InvalidateUserException extends Exception{

	public InvalidateUserException() {}
	
	public InvalidateUserException(String msg) {
		super(msg);
	}
}