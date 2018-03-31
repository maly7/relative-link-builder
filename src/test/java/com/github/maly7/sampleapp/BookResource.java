package com.github.maly7.sampleapp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.ResourceSupport;

public class BookResource extends ResourceSupport {
    @JsonIgnore
    private String bookId;
    private String author;
    private String title;

    public BookResource() {
        this("", "", "");
    }

    public BookResource(String bookId, String author, String title) {
        this.bookId = bookId;
        this.author = author;
        this.title = title;
    }

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

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
