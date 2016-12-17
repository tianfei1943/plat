package redis.excetion;


public class RuleException extends Exception{

	private static final long serialVersionUID = 3371629700621921332L;

	public RuleException() {
		super();
	}

	public RuleException(String message, Throwable cause) {
		super(message, cause);
	}

	public RuleException(String message) {
		super(message);
	}

	public RuleException(Throwable cause) {
		super(cause);
	}

}
