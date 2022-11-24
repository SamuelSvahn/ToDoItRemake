package se.lexicon.model;

import java.util.Objects;

public class AppUser {

    private int id;
    private String username;
    private String password;
    private AppRole role;

    //Constructors


    public AppUser(int id, String username, AppRole role) {
        setId(id);
        setUserName(username);
        setRole(role);
    }

    //Setters and Getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        if (userName == null) throw new IllegalArgumentException("Username can not be null");
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null) throw new IllegalArgumentException("Password can not be null");
        this.password = password;
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        if (role == null) throw new IllegalArgumentException("Role can not be null");
        this.role = role;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "userName='" + username + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return username.equals(appUser.username) && role == appUser.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, role);
    }
}
