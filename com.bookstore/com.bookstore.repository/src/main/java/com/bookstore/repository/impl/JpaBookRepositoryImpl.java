package com.bookstore.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bookstore.domain.Book;
import com.bookstore.domain.Category;
import com.bookstore.repository.BookRepository;


/**
 * JPA implementation for the {@link BookRepository}.
 * 
 * @author Marten Deinum
 * @author Koen Serneels
 * 
 */
@Repository("bookRepository")
public class JpaBookRepositoryImpl implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Book findById(long id) {
        return this.entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> findByCategory(Category category) {
        String hql = "select b from Book b where b.category=:category";
        TypedQuery<Book> query = this.entityManager.createQuery(hql, Book.class);
        query.setParameter("category", category);
        return query.getResultList();
    }

    @Override
    public List<Book> findRandom(int count) {
        String hql = "select b from Book b order by rand()";
        TypedQuery<Book> query = this.entityManager.createQuery(hql, Book.class);
        query.setMaxResults(count);
        return query.getResultList();
    }


    @Override
    public void storeBook(Book book) {
        this.entityManager.merge(book);
    }
}
