package com.librarymanager.dao;

import com.librarymanager.model.Book;
import jakarta.persistence.EntityManager;

import java.util.List;

public class BookDAO {
    private EntityManager em;

    public BookDAO(EntityManager em) {
        this.em = em;
    }

    public void addBook(Book book) {
        try{
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            System.err.println("ERROR ON THE SAVING: " + e.getMessage());
        }

    }

    public void removeBook(Book book) {
        try{
            em.getTransaction().begin();
            em.remove(book);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
            System.err.println("ERROR ON THE REMOVAL: " + e.getMessage());
        }
    }

    public Book getBook(long id) {
        return em.find(Book.class, id);
    }

    public List<Book> getAllBooks() {
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    public void updateBook(Book book) {
        try{
            em.getTransaction().begin();
            em.merge(book);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
            System.err.println("ERROR ON THE UPDATE: " + e.getMessage());
        }
    }
}
