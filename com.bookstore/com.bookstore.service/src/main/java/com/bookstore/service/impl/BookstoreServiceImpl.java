package com.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.domain.Book;
import com.bookstore.domain.Category;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.CategoryRepository;
import com.bookstore.service.BookstoreService;


/**
 * @see BookstoreService
 * @author Marten Deinum
 * @author Koen Serneels
 *
 */
@Service("bookstoreService")
@Transactional(readOnly = true)
public class BookstoreServiceImpl implements BookstoreService {

    private static final int RANDOM_BOOKS = 2;

    @Autowired
    private BookRepository bookRepository;


    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Book> findBooksByCategory(Category category) {
        return this.bookRepository.findByCategory(category);
    }

    @Override
    public List<Book> findRandomBooks() {
        return this.bookRepository.findRandom(RANDOM_BOOKS);
    }


    @Override
    public Book findBook(long id) {
        return this.bookRepository.findById(id);
    }


    @Override
    public List<Category> findAllCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void addBook(Book book) {
        this.bookRepository.storeBook(book);

    }
}
