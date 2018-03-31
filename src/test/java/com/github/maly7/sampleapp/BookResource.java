package com.github.maly7.sampleapp;

import org.springframework.hateoas.ResourceSupport;

public class BookResource extends ResourceSupport {
    private String author;
    private String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
