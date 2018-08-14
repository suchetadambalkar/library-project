package com.library.security.repository;

import com.library.security.model.Book;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


/**
 * Created by soham on 03-08-2018.
 */

@Repository
public class BookRepositoryCustomImpl implements BookRepositoryCustom {


    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    MongoOperations mongoOperations;


    @Override
    public List<Book> findbooksNameandAuthor() {

        MongoDatabase db = mongoClient.getDatabase("library");
        MongoCollection<Document> collection = db.getCollection("book");

        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("bookTitle", "Harry Potter");
        whereQuery.put("bookauthor", "J. K. Rowling");
        List<Book> books = new ArrayList<Book>();

        FindIterable<Document> docs = collection.find(whereQuery);
        for (Document doc : docs) {
            Book book = new Book();
            book.setBookid(doc.getString("bookid"));
            book.setBookTitle(doc.getString("bookTitle"));
            book.setBookauthor(doc.getString("bookauthor"));
            books.add(book);
        }

        // List<Book> books = collection.find(whereQuery, Book.class).into(new ArrayList<>());
        return books;

    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) mongoTemplate.findAll(Book.class);
    }


    public Book find(String bookid) {
        Query query = new Query(where("_id").is(bookid));
        return mongoTemplate.findOne(query, Book.class, "book");
    }


    public List<Book> findbybooksNameandAuthor(String bookTitle, String bookauthor) {
        List<Book> books = mongoOperations.find(query(where("bookTitle").is(bookTitle).and("bookauthor").is(bookauthor)), Book.class, "book");
        return books;
    }

    public Book save(Book book){
        mongoTemplate.save(book, "book");
        return book;
    }
}




