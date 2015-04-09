package com.bookstore.service;

import java.util.List;


import com.bookstore.domain.Book;
import com.bookstore.domain.Category;


/**
 * Main entry point for the bookstore.
 * 
 * @author Marten Deinum
 * @author Koen Serneels
 * 
 */
public interface BookstoreService {

    List<Book> findBooksByCategory(Category category);

    Book findBook(long id);


    List<Book> findRandomBooks();


    /**
     * Find all the categories available.
     * 
     * @return list with all the categories
     */
    List<Category> findAllCategories();

    /**
     * Store a book in the repository.
     * 
     * @param book the book to store.
     */
    void addBook(Book book);
}
