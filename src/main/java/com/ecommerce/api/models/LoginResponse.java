package com.ecommerce.api.models;

public class LoginResponse {
    private String auth_token;
    private String errorMessage;

    public String getAuth_token() {
        return auth_token;
    }
    public void setAuth_token(String auth_token) {
        this.auth_token = auth_token;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
