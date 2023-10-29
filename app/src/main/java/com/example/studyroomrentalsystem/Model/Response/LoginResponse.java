package com.example.studyroomrentalsystem.Model.Response;


import java.io.Serializable;

public class LoginResponse implements Serializable {
    private String accessToken;
    private int id;
    private String email;
    private String role;
    private String status;

    public LoginResponse(String accessToken, int id, String role, String admin, String status) {
        this.accessToken = accessToken;
        this.id = id;
        this.email = email;
        this.role = admin;
        this.status = status;
    }

    public LoginResponse() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setAdmin(String admin) {
        this.role = admin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
