package com.github.maly7.sampleapp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/book")
public class BookController {

    @RequestMapping(path = {"/{id"})
    public BookResource getBook(@PathVariable String id) {
        BookResource book = new BookResource(id, "Brandon Sanderson", "Oathbringer");
        book.add(linkTo(methodOn(BookController.class).getBook(book.getBookId())).withSelfRel());
        return book;
    }
}
