package cn.itcast.core.exception;

public abstract class SysException extends Exception {
	private String erroMsg;
	
	public SysException() {
		super();
	}

	public SysException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		erroMsg=message;
	}

	public SysException(String message, Throwable cause) {
		super(message, cause);
		erroMsg=message;
	}

	public SysException(String message) {
		super(message);
		erroMsg=message;
	}

	public SysException(Throwable cause) {
		super(cause);
	}

	public String getErroMsg() {
		return erroMsg;
	}

	public void setErroMsg(String erroMsg) {
		this.erroMsg = erroMsg;
	}
	
}
