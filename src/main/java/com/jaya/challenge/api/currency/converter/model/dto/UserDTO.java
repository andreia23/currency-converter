package com.jaya.challenge.api.currency.converter.model.dto;

import com.jaya.challenge.api.currency.converter.model.entity.User;

/**
 * @author andreia
 *
 */
public class UserDTO {

	private Long idUser;

	private String userName;

	private String userLastName;

	public UserDTO(User user) {
		this.idUser = user.getIdUser();
		this.userName = user.getUserName();
		this.userLastName = user.getUserLastName();
	}

	/**
	 * @return the idUser
	 */
	public Long getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

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
