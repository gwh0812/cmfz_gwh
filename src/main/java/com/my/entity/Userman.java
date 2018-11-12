package com.my.entity;

import java.util.Objects;

public class Userman {
    private String id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "Userman{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Userman userman = (Userman) o;
        return Objects.equals(id, userman.id) &&
                Objects.equals(username, userman.username) &&
                Objects.equals(password, userman.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, password);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Userman(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Userman() {
    }
}
