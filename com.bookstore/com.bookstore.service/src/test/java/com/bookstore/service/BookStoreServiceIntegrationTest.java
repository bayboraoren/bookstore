package com.bookstore.service;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.domain.Book;
import com.bookstore.domain.Category;
import com.bookstore.repository.config.RepositoryConfiguration;
import com.bookstore.service.config.ServiceConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ServiceConfiguration.class,RepositoryConfiguration.class})
@Transactional
public class BookStoreServiceIntegrationTest {

	@Autowired
	private BookstoreService bookstoreService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Test
	public void bookStoreServiceIsNotNull(){
		assertNotNull(bookstoreService);
	}
	
	@Test
	public void findRandomBooks(){
		
		Book book = new Book();
		book.setTitle("Effective Java");
		book.setIsbn("9827262661");
		book.setDescription("Brings together seventy-eight indispensable programmer's rules of thumb.");
		book.setAuthor("Joshua Bloch");
		book.setYear(2008);
		book.setPrice(new BigDecimal("31.20"));
		
		Category category = new Category();
		category.setName("IT");
		categoryService.addCategory(category);
		
		book.setCategory(category);		
		
		bookstoreService.addBook(book);
		
		book = new Book();
		book.setTitle("Java 101");
		book.setIsbn("9827262661");
		book.setDescription("Brings together seventy-eight indispensable programmer's rules of thumb.");
		book.setAuthor("Joshua Bloch");
		book.setYear(2008);
		book.setPrice(new BigDecimal("31.20"));
		
		category = new Category();
		category.setName("IT");
		categoryService.addCategory(category);
		
		book.setCategory(category);		
		
		bookstoreService.addBook(book);		
		
		
		List<Book> findRandomBooks = bookstoreService.findRandomBooks();
		for (Book randomBook : findRandomBooks) {
			System.out.println(randomBook.getTitle());
		}
		
		assertNotNull(findRandomBooks);
		
	}
	
	
}
