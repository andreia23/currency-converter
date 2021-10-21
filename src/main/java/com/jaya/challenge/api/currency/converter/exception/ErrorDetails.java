package com.jaya.challenge.api.currency.converter.exception;

import java.util.Date;

/**
 * @author andreia
 *
 */
public class ErrorDetails {

	private Date timestamp;
	private String message;
	private int status;

	public ErrorDetails(Date timestamp, String message, int status) {
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
	}

	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
