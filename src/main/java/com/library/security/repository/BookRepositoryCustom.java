package com.library.security.repository;

import com.library.security.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by soham on 03-08-2018.
 */


public interface BookRepositoryCustom  {

    public List<Book> findbooksNameandAuthor();

    List<Book> findAll();
    public Book find(String bookid) ;

    public List<Book> findbybooksNameandAuthor(String bookTitle, String bookauthor) ;

    public Book save(Book book);

}
