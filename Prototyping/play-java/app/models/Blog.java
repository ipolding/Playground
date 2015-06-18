package models;

import java.util.Date;

public class Blog {

    public String title;
    public String author;
    public Date publishDate;
    public String content;

    public Blog(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.publishDate = new Date();
        this.content = content;
    }

}