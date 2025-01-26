package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public class Library extends Prototype<Library> {

    private String name;
    private Set<Book> books;

    public Library(final String name) {
        this.name = name;
        this.books = new HashSet<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", name='" + name + '\'' +
                '}';
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library deepCopyLibrary = super.clone();
        deepCopyLibrary.books = new HashSet<>();
        for (Book book : books) {
            Book copiedBook = new Book(book.getTitle(), book.getAuthor(), book.getPublicationDate());
            deepCopyLibrary.books.add(copiedBook);
        }
        return deepCopyLibrary;
    }
}