/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.Account_DTO;

/**
 *
 * @author Anh
 */
public class UserSession {
    private static UserSession instance;
    private boolean isLoggedIn;
    private Account_DTO loggedInAccount;

    private UserSession() {
        // Private constructor to ensure singleton pattern
    }

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void login(Account_DTO account) {
        isLoggedIn = true;
        loggedInAccount = account;
    }

    public void logout() {
        isLoggedIn = false;
        loggedInAccount = null;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public Account_DTO getLoggedInAccount() {
        return loggedInAccount;
    }
    public void setLoggedInAccount(Account_DTO account) {
        this.loggedInAccount = account;
    }
}
