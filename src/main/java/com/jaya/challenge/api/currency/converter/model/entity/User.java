package com.jaya.challenge.api.currency.converter.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * @author andreia
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String userName;

    private String userLastName;

    @OneToMany
    private List<Transaction> transactions;

    public User() {
    }

    public User(String userName, String userLastName) {
        this.userName = userName;
        this.userLastName = userLastName;
    }

    public Long getIdUser() {
        return idUser;
    }

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
