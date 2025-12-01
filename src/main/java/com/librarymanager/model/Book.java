package com.librarymanager.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(name = "Publication_Date")
    private LocalDate publicationDate;

    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {
    }

    public Book(String name, LocalDate publicationDate, Author author) {
        this.name = name;
        this.publicationDate = publicationDate;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
