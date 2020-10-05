package edu.mum.cs.cs544.exercises;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private int id;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Reservation() {
    }

    public Reservation(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Reservation [id=" + id + ", date=" + date + ", book=" + book + "]";
    }


}
