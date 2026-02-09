package dev.engripaye.backend.model;

public class User {

    private String fullname;
    private String email;
    private String balance;

    public User(String fullname, String email, String balance) {
        this.fullname = fullname;
        this.email = email;
        this.balance = balance;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
