package com.tangotab.exception;

public class ApplicationException extends Exception {
	private static final long serialVersionUID = 1L;
	private Object[] args;
	private String code;
	private String msg;
	private String action;
	private String type;

	public ApplicationException(String code) {
		this.code = code;
	}

	public ApplicationException(String code, String type) {
		this.code = code;
		this.type = type;
	}

	public ApplicationException(String code, String msg, String action) {
		this.code = code;
		this.msg = msg;
		this.action = action;
	}

	public ApplicationException(String code, Object[] args) {
		this.code = code;
		this.args = args;
	}

	public ApplicationException(String code, Object[] args, String msg) {
		super(msg);
		this.code = code;
		this.args = args;
	}

	public ApplicationException(String code, Object[] args, String msg, Throwable cause) {
		super(msg, cause);
		this.code = code;
		this.args = args;
	}

	public String getMsg() {
		return msg;
	}

	public String getCode() {
		return code;
	}

	public Object[] getArgs() {
		return args;
	}

	public String getAction() {
		return action;
	}

	public String getWebserviceMsg() {
		String finalMsg = code + msg;
		return finalMsg;
	}

	public String getType() {
		return type;
	}
}
