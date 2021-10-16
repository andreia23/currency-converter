package com.jaya.challenge.api.currency.converter.model.request;

import javax.validation.constraints.NotNull;

/**
 * @author andreia
 *
 */
public class UserRequest {
	
	@NotNull(message = "Username cannot be null")
	private String userName;

	@NotNull(message = "User last name cannot be null")
	private String userLastName;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userLastName
	 */
	public String getUserLastName() {
		return userLastName;
	}

	/**
	 * @param userLastName the userLastName to set
	 */
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

}
