package com.example.palvelinprojekti.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//ID FOR CATEGORY REPOSITORY



@Entity
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long categoryId;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Item> items;

    public Category() {}

    public Category(String name) {
        super();
        this.name = name;
    }

    //SETTERS & GETTERS FOR CATEGORY


    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


    //TO STRING FOR CATEGORY

    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", name=" + name + "]";
    }
}
