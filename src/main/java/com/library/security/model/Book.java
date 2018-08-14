package com.library.security.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.constraints.Size;

/**
 * Created by soham on 03-08-2018.
 */

@Document
public class Book {
    @Id
    private String bookid;
    @Size(min=2, message="Name should have atleast 2 characters")
    private String bookTitle;
    private String bookauthor;

    public Book() {
    }

    public Book(String bookid, String bookTitle, String bookauthor) {
        this.bookid = bookid;
        this.bookTitle = bookTitle;
        this.bookauthor = bookauthor;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        //if(bookid > 100){
        //    throw new MethodArgumentNotValidException();
       // }
        this.bookid = bookid;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }
}
