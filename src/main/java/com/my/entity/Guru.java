package com.my.entity;

import java.util.Objects;

public class Guru {
    private String id;
    private String headPic;
    private String name;
    private String staus;

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", headPic='" + headPic + '\'' +
                ", name='" + name + '\'' +
                ", staus='" + staus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guru guru = (Guru) o;
        return Objects.equals(id, guru.id) &&
                Objects.equals(headPic, guru.headPic) &&
                Objects.equals(name, guru.name) &&
                Objects.equals(staus, guru.staus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, headPic, name, staus);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStaus() {
        return staus;
    }

    public void setStaus(String staus) {
        this.staus = staus;
    }

    public Guru(String id, String headPic, String name, String staus) {
        this.id = id;
        this.headPic = headPic;
        this.name = name;
        this.staus = staus;
    }

    public Guru() {
    }
}
