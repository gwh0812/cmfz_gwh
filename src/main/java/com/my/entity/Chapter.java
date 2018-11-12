package com.my.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Chapter {
    @JsonProperty("cid")
    private String id;
    private String title;
    private String download_url;
    private String memory;
    private String duration;
    private String album_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDownload_url() {
        return download_url;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", download_url='" + download_url + '\'' +
                ", memory='" + memory + '\'' +
                ", duration='" + duration + '\'' +
                ", album_id='" + album_id + '\'' +
                '}';
    }

    public Chapter(String id, String title, String download_url, String memory, String duration, String album_id) {
        this.id = id;
        this.title = title;
        this.download_url = download_url;
        this.memory = memory;
        this.duration = duration;
        this.album_id = album_id;
    }

    public Chapter() {
    }
}
