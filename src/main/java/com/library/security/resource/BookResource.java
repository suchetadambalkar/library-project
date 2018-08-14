package com.library.security.resource;

import com.library.security.exception.UserNotFoundException;
import com.library.security.model.Book;
import com.library.security.repository.BookRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by soham on 02-08-2018.
 */

@RequestMapping("rest/books")
@RestController
public class BookResource {


    @Autowired
    BookRepositoryCustom bookRepositoryCustom;


    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookRepositoryCustom.findAll();
    }

    @GetMapping("/getbyid")
    public Book getBookbyid() {
        return bookRepositoryCustom.find("2");
    }

    @PostMapping("/addbook")
        public String addBook(@Valid @RequestBody Book book){
        bookRepositoryCustom.save(book);
        return book.getBookid();
    }

    @GetMapping("/getbooks")
    public List<Book> getAllBooks(@RequestParam ("bookTitle") String bookTitle, @RequestParam("bookauthor") String bookauthor) {
       return bookRepositoryCustom.findbooksNameandAuthor();


    }

    @GetMapping("/findbybooksNameandAuthor")
    public List<Book> findbybooksNameandAuthor(@RequestParam ("bookTitle") String bookTitle, @RequestParam("bookauthor") String bookauthor) {

        List<Book> booklist = new ArrayList<Book>();
        booklist  = bookRepositoryCustom.findbybooksNameandAuthor(bookTitle, bookauthor);
        if(booklist.size() == 0){
            throw new UserNotFoundException(bookTitle + "not found");
        }else {
            return booklist;
        }


    }




}
