package game.data;

public class BetException extends RuntimeException {

	private static final long serialVersionUID = -407728796332479774L;
	public BetException() { super(); }
	public BetException(String message) { super(message); } 
	public BetException(String message, Throwable cause) { super(message, cause); }
	public BetException(Throwable cause) { super(cause); }
}
