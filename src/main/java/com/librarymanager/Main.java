package com.librarymanager;

import com.librarymanager.Exceptions.DBException;
import com.librarymanager.dao.AuthorDAO;
import com.librarymanager.model.Author;
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
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Library-JPA");
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
                    System.out.println("Invalid option");
            }
        }
    }

    private void authorMenu(Scanner sc, EntityManager em){
        }
    }

    private void bookMenu(Scanner sc, EntityManager em){

    }


}
