package com.librarymanager.dao;

import com.librarymanager.model.Author;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AuthorDAO {

    private EntityManager em;

    public AuthorDAO(EntityManager em) {
        this.em = em;
    }

    public void addAuthor(Author author) {
        try{
        em.getTransaction().begin();
        em.persist(author);
        em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            System.err.println("ERROR ON THE SAVING: " + e.getMessage());
        }

    }

    public void removeAuthor(Author author) {
        try{
        em.getTransaction().begin();
        em.remove(author);
        em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
            System.err.println("ERROR ON THE REMOVAL: " + e.getMessage());
        }
    }

    public Author getAuthorByID(long id) {
            return em.find(Author.class, id);
    }

    public List<Author> getAllAuthors() {
        return em.createQuery("SELECT a FROM Author a", Author.class).getResultList();
    }

   public void updateAuthor(Author author) {
        try{
        em.getTransaction().begin();
        em.merge(author);
        em.getTransaction().commit();
        }
         catch (Exception e){
            em.getTransaction().rollback();
            System.err.println("ERROR ON THE UPDATE: " + e.getMessage());
         }
   }

}
