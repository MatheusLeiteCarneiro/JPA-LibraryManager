package com.librarymanager;

import com.librarymanager.Exceptions.DBException;
import com.librarymanager.dao.AuthorDAO;
import com.librarymanager.dao.BookDAO;
import com.librarymanager.model.Author;
import com.librarymanager.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.h2.tools.Server;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main() {
        try {
            Server server = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082");
            server.start();
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("library-jpa");
            EntityManager em = emf.createEntityManager();


        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }

    }

    private void mainMenu(Scanner sc, EntityManager em) {
        int selector = -1;
        while (selector != 0) {
            System.out.println("(MAIN MENU)");
            System.out.println("DIGIT:");
            System.out.println("1-Authors Operations | 2-Books Operations | 0-Finish Operations");
            selector = sc.nextInt();
            sc.nextLine();
            System.out.println();
            switch (selector) {
                case 1:
                    authorMenu(sc, em);
                    break;
                case 2:
                    bookMenu(sc, em);
                    break;
                case 0:
                    System.out.println("Operations finished");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void authorMenu(Scanner sc, EntityManager em){
        AuthorDAO authorDAO = new AuthorDAO(em);
        Author author = null;
        System.out.println("(AUTHORS MENU)");
        System.out.println("DIGIT:");
        System.out.println("1- Create new Author | 2- Find Author Books | 3- List All Authors | 4- Update Author | 5- Delete Author");
        switch (sc.nextInt()) {
            case 1:
                System.out.print("Author Name:");
                String name = sc.nextLine();
                author = new Author(name);
                authorDAO.addAuthor(author);
                System.out.println("Author "+ author +" successfully added");
                break;
            case 2:
                System.out.print("Type Author ID: ");
                author = authorDAO.getAuthorByID(sc.nextLong());
                if(idFound(author)){
                System.out.println("Book list of the author: " + author.getName());
                author.getBookList().forEach(System.out::println);
                }
                break;
            case 3:
                System.out.println("Authors List");
                authorDAO.getAllAuthors().forEach(System.out::println);
                break;
            case 4:
                System.out.println("Type the ID of the author you want to update: ");
                author = authorDAO.getAuthorByID(sc.nextLong());
                sc.nextLine();
                if(idFound(author)){
                    System.out.println("Author: " + author);
                    System.out.println("New Name: ");
                    author.setName(sc.nextLine());
                    authorDAO.updateAuthor(author);
                    System.out.println("Successfully Updated");
                }
                break;
            case 5:
                System.out.println("Type the ID of the author you want to delete: ");
                author = authorDAO.getAuthorByID(sc.nextLong());
                if(idFound(author)){
                    authorDAO.removeAuthor(author);
                    System.out.println("Author " + author.getName() + "and their books successfully deleted");
                }
                break;
            default:
                System.out.println("Invalid option!");
        }
    }

    private void bookMenu(Scanner sc, EntityManager em){
        BookDAO bookDAO = new BookDAO(em);
        Book book = null;
        System.out.println("(BOOKS MENU)");
        System.out.println("DIGIT:");
        System.out.println("1- Create a new Book | 2- Find a Book By ID | 3- List All Books | 4- Update a Book | 5- Delete a Book");
        switch (sc.nextInt()) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid option!");
        }
    }

    private <T> boolean idFound(T type){
        if(type == null){
            System.err.println("ID not found!");
            return false;
        }
        return true;
    }


}
