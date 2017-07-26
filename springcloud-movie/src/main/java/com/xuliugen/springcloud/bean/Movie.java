package com.xuliugen.springcloud.bean;

/**
 * Created by xuliugen on 2017/7/26.
 */
public class Movie {

    private String id;
    private String name;
    private String author;

    public Movie(String id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public java.lang.String getId() {
        return id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
