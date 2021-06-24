/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhnd.dtos;

/**
 *
 * @author Admin
 */
public class UserErrorDTO {
    private String userIDError;
    private String fullnameError;
    private String roleIDError;
    private String passwordError;
    private String confirmError;

    public UserErrorDTO() {
    }

    public UserErrorDTO(String userIDError, String fullnameError, String roleIDError, String passwordError, String confirmError) {
        this.userIDError = userIDError;
        this.fullnameError = fullnameError;
        this.roleIDError = roleIDError;
        this.passwordError = passwordError;
        this.confirmError = confirmError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public String getFullnameError() {
        return fullnameError;
    }

    public String getRoleIDError() {
        return roleIDError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public void setFullnameError(String fullnameError) {
        this.fullnameError = fullnameError;
    }

    public void setRoleIDError(String roleIDError) {
        this.roleIDError = roleIDError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }
    
    
}
