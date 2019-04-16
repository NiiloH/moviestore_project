package com.example.palvelinprojekti.domain;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String author;
    private String isbn;
    private int year;
    private double price;
    String type;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "categoryId")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Item(){

    }

    // Creating the attributes

    public Item(String title,
                String author,
                String isbn,
                int year,
                double price,
                String type,
                Category category) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
        this.price = price;
        this.type = type;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    @Override
    public String toString() {
        if (this.category != null)
            return "Item [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", year=" + year + ", price=" + price + ", type=" + type +", category=" + this.getCategory() + "]";
        else
            return "Item [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", year=" + year + ", price=" + price + ", type=" + type +"]";
    }

}
