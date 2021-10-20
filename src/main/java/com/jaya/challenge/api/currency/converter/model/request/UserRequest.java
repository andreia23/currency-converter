package com.jaya.challenge.api.currency.converter.model.request;

import com.jaya.challenge.api.currency.converter.model.entity.User;

import javax.validation.constraints.NotNull;

/**
 * @author andreia
 */
public class UserRequest {

    @NotNull(message = "Username cannot be null")
    private String userName;

    @NotNull(message = "User last name cannot be null")
    private String userLastName;

    public UserRequest(String userName, String userLastName) {
        this.userName = userName;
        this.userLastName = userLastName;
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

    public User toModel() {
        return new User(userName, userLastName);
    }

}
