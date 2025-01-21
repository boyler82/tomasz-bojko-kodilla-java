package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
//        Given
        Library library = new Library("Sklodowska-Curie Library");
        library.getBooks().add(new Book("Title 1", "Author A.", LocalDate.of(2001,01,01)));
        library.getBooks().add(new Book("Title 2", "Author B.", LocalDate.of(2002,01,01)));
        library.getBooks().add(new Book("Title 3", "Author C.", LocalDate.of(2003,01,01)));

        Library shallowCloneLibrary = null;

        try {
            shallowCloneLibrary = library.shallowCopy();
            shallowCloneLibrary.setName("Shallow Clone Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClone = null;

        try {
            deepClone = library.deepCopy();
            deepClone.setName("Deep Clone Library");
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(library.toString());
        System.out.println(shallowCloneLibrary.toString());
        System.out.println(deepClone.toString());

//          When
//        library.getBooks().add(new Book("Title 4", "Author S.", LocalDate.of(2003,01,01)));
        System.out.println(library.books.size()+" "+shallowCloneLibrary.books.size()+" "+deepClone.books.size());
//          Then
//        assertTrue(library.books.size()==4);
        assertEquals(library.getBooks(),shallowCloneLibrary.getBooks());
//        assertTrue(deepClone.books.size()==3);


        System.out.println("---------");
        System.out.println(library.toString());
        System.out.println(shallowCloneLibrary.toString());
        System.out.println(deepClone.toString());

    }

}
