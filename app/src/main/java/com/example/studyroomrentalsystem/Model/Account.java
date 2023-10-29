package com.example.studyroomrentalsystem.Model;

public class Account {
    private int Id;
    private String Email ;
    private String Password;
    private String Phone;
    private String DateOfBirth;
    private String Gender ;
    private String Role;
    private String Status;
    private String Token;

    public Account(int accountId, String email, String password, String phone, String birthday, String gender, String role, String status) {
        Id = accountId;
        Email = email;
        Password = password;
        Phone = phone;
        DateOfBirth = birthday;
        Gender = gender;
        Role = role;
        Status = status;
    }

    public Account(String email, String password) {
        Email = email;
        Password = password;
    }

    public int getAccountId() {
        return Id;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getPhone() {
        return Phone;
    }

    public String getBirthday() {
        return DateOfBirth;
    }

    public String getGender() {
        return Gender;
    }

    public String getRole() {
        return Role;
    }

    public String getStatus() {
        return Status;
    }

    public void setAccountId(int accountId) {
        Id = accountId;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setBirthday(String birthday) {
        DateOfBirth = birthday;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setRole(String role) {
        Role = role;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
