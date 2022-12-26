package com.cuongnguyen.model;

public class ApiResponse {
	private int code;
    private Boolean status;
    private String error;
    private String message;
    private Object data;
    
    public ApiResponse() {
    	
    }
    
	public ApiResponse(int code, Boolean status, String error, String message, Object data) {
		this.code = code;
		this.status = status;
		this.error = error;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
    
}
