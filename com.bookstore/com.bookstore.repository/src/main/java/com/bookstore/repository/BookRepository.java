package com.bookstore.repository;

import java.util.List;

import com.bookstore.domain.Book;
import com.bookstore.domain.Category;

/**
 * Repository for working with {@link Book} domain objects
 * 
 * @author Marten Deinum
 * @author Koen Serneels
 *
 */
public interface BookRepository {

	Book findById(long id);

	List<Book> findByCategory(Category category);

	List<Book> findRandom(int count);

	void storeBook(Book book);

}
