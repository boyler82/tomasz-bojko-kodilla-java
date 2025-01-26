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
            // Given
            Library library = new Library("Sklodowska-Curie Library");
            library.getBooks().add(new Book("Title 1", "Author A.", LocalDate.of(2001, 1, 1)));
            library.getBooks().add(new Book("Title 2", "Author B.", LocalDate.of(2002, 1, 1)));
            library.getBooks().add(new Book("Title 3", "Author C.", LocalDate.of(2003, 1, 1)));

            Library shallowCloneLibrary = null;
            Library deepCloneLibrary = null;

            try {
                shallowCloneLibrary = library.shallowCopy();
                shallowCloneLibrary.setName("Shallow Clone Library");
            } catch (CloneNotSupportedException e) {
                System.out.println(e);
            }

            try {
                deepCloneLibrary = library.deepCopy();
                deepCloneLibrary.setName("Deep Clone Library");
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Original Library: " + library);
            System.out.println("Shallow Clone Library: " + shallowCloneLibrary);
            System.out.println("Deep Clone Library: " + deepCloneLibrary);

            // When
            library.getBooks().add(new Book("Title 4", "Author S.", LocalDate.of(2004, 1, 1)));

            System.out.println("\nAfter Adding New Book to Original:");
            System.out.println("Original Library: " + library);
            System.out.println("Shallow Clone Library: " + shallowCloneLibrary);
            System.out.println("Deep Clone Library: " + deepCloneLibrary);

            // Then
            assertEquals(4, library.getBooks().size());
            assertEquals(4, shallowCloneLibrary.getBooks().size());
            assertEquals(3, deepCloneLibrary.getBooks().size());

    }
}