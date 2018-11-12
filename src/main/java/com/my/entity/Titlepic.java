package com.my.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

public class Titlepic {
    private String id;
    private String thumbnail;
    private String content;
    private String status;
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    @Override
    public String toString() {
        return "Titlepic{" +
                "id='" + id + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Titlepic titlepic = (Titlepic) o;
        return Objects.equals(id, titlepic.id) &&
                Objects.equals(thumbnail, titlepic.thumbnail) &&
                Objects.equals(content, titlepic.content) &&
                Objects.equals(status, titlepic.status) &&
                Objects.equals(date, titlepic.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, thumbnail, content, status, date);
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Titlepic(String id, String thumbnail, String content, String status, Date date) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.content = content;
        this.status = status;
        this.date = date;
    }

    public Titlepic() {
    }
}
