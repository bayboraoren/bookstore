package com.bookstore.repository;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.domain.Book;
import com.bookstore.domain.Category;
import com.bookstore.repository.config.RepositoryConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RepositoryConfiguration.class})
@Transactional
public class BookRepositoryUnitTest {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	public void bookRepositoryIsNotNull(){
		assertNotNull(bookRepository);
	}
	
	@Test 
	public void categoryRepositoryIsNotNull(){
		assertNotNull(categoryRepository);
	}
	
	@Test
	public void saveBook(){
		Book book = new Book();
		book.setTitle("Effective Java");
		book.setIsbn("9827262661");
		book.setDescription("Brings together seventy-eight indispensable programmer's rules of thumb.");
		book.setAuthor("Joshua Bloch");
		book.setYear(2008);
		book.setPrice(new BigDecimal("31.20"));
		
		Category category = new Category();
		category.setName("IT");
		categoryRepository.storeCategory(category);
		
		book.setCategory(category);
		
		bookRepository.storeBook(book);
		
		List<Book> findByCategory = bookRepository.findByCategory(category);
		book = findByCategory.get(0);
		
		assertNotNull(book);
	}
	
	
	@Test
	public void findBookById(){
		
		String author = "Joshua Bloch";
		
		Book book = new Book();
		book.setTitle("Effective Java");
		book.setIsbn("9827262661");
		book.setDescription("Brings together seventy-eight indispensable programmer's rules of thumb.");
		book.setAuthor(author);
		book.setYear(2008);
		book.setPrice(new BigDecimal("31.20"));
		
		Category category = new Category();
		category.setName("IT");
		categoryRepository.storeCategory(category);
		
		book.setCategory(category);
		
		bookRepository.storeBook(book);
		Book findById = bookRepository.findById(1l);
		assertEquals(author, findById.getAuthor());
	}

	
	@Test
	public void randomBooks(){
		
		Book book = new Book();
		book.setTitle("Effective Java");
		book.setIsbn("9827262661");
		book.setDescription("Brings together seventy-eight indispensable programmer's rules of thumb.");
		book.setAuthor("Joshua Bloch");
		book.setYear(2008);
		book.setPrice(new BigDecimal("31.20"));
		
		Category category = new Category();
		category.setName("IT");
		categoryRepository.storeCategory(category);
		
		book.setCategory(category);
		
		bookRepository.storeBook(book);		
		
		book = new Book();
		book.setTitle("Java 101");
		book.setIsbn("1234567");
		book.setDescription("Brings together seventy-eight indispensable programmer's rules of thumb.");
		book.setAuthor("Joshua Bloch");
		book.setYear(2008);
		book.setPrice(new BigDecimal("31.20"));
		
		categoryRepository.storeCategory(category);
		
		book.setCategory(category);
		
		bookRepository.storeBook(book);				
		
		
		List<Book> findRandom = bookRepository.findRandom(2);
		for (Book bk : findRandom) {
			System.out.println(bk.getTitle());
		}
		
		assertNotNull(findRandom);
	}
	
	
}
