package edu.mum.cs.cs544.exercises;

import javax.persistence.Entity;

@Entity
public class Book extends Product {
    private String author;

    public Book() {
    }

    public Book(String name, String description, String author) {
        super(name, description);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return super.toString() + " author=" + author + " ";
    }
}
