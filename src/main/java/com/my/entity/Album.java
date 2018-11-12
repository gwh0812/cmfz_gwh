package com.my.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Album {
    private  String id;
    private  String thumbnail;
    private  String title;
    private Integer set_count;
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_date;
    private Integer score;
    private String author;
    private String broadcast;
    private String biref;
    private List<Chapter> children=new ArrayList<>();

    public Album() {
    }

    public Album(String id, String thumbnail, String title, Integer set_count, Date create_date, Integer score, String author, String broadcast, String biref, List<Chapter> children) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.title = title;
        this.set_count = set_count;
        this.create_date = create_date;
        this.score = score;
        this.author = author;
        this.broadcast = broadcast;
        this.biref = biref;
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSet_count() {
        return set_count;
    }

    public void setSet_count(Integer set_count) {
        this.set_count = set_count;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getBiref() {
        return biref;
    }

    public void setBiref(String biref) {
        this.biref = biref;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id) &&
                Objects.equals(thumbnail, album.thumbnail) &&
                Objects.equals(title, album.title) &&
                Objects.equals(set_count, album.set_count) &&
                Objects.equals(create_date, album.create_date) &&
                Objects.equals(score, album.score) &&
                Objects.equals(author, album.author) &&
                Objects.equals(broadcast, album.broadcast) &&
                Objects.equals(biref, album.biref) &&
                Objects.equals(children, album.children);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, thumbnail, title, set_count, create_date, score, author, broadcast, biref, children);
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                ", set_count=" + set_count +
                ", create_date=" + create_date +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", biref='" + biref + '\'' +
                ", children=" + children +
                '}';
    }
}
