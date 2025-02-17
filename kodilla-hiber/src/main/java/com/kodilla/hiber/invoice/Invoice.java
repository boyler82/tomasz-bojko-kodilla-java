package com.kodilla.hiber.invoice;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "INVOICE")
public class Invoice {

    private int id;
    private String name;

    private List<Item> items = new ArrayList<>();


    public Invoice() {
    }

    public Invoice(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID_INVOICE", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "invoice",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}, // Dodaj PERSIST
            fetch = FetchType.EAGER
    )
    public List<Item> getItems() {
        return items;
    }



    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Column(name = "INVOICE_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
