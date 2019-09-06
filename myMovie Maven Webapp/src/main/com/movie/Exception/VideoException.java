package com.movie.Exception;

public class VideoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//�쳣��Ϣ
	public String message;
	//������쳣��Ϣ
	public VideoException(String message){
		super(message);
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
