package com.kodilla.testing.library;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Nested
    @DisplayName("Sorting library database tests.")
    class LibrarySortingTestSuite {
        @Test
        void testListBooksWithConditionsReturnList() {
//      Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOfBooks = new ArrayList<>();
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);                   // [5]
            Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);    // [6]
            Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);    // [7]
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);                 // [8]
            resultListOfBooks.add(book1);                                                    // [9]
            resultListOfBooks.add(book2);                                                    // [10]
            resultListOfBooks.add(book3);                                                    // [11]
            resultListOfBooks.add(book4);
            when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);
//When
            List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");
//        Then
            assertEquals(4, theListOfBooks.size());
        }

        @Test
        void testListBooksWithConditionMoreThan20() {
//        Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf0Books = new ArrayList<>();                           // [2]
            List<Book> resultListOf15Books = generateListOfNBooks(15);                       // [3]
            List<Book> resultListOf40Books = generateListOfNBooks(40);                       // [4]
            when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);                                             // [6]
            when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);                                              // [8]
            when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);
//      When
            List<Book> the0ListBooks = bookLibrary.listBooksWithCondition("ZeroBooks");
            List<Book> the15ListBooks = bookLibrary.listBooksWithCondition("any");
            List<Book> the40ListBooks = bookLibrary.listBooksWithCondition("FortyBooks");

//      Then
            assertEquals(0, the0ListBooks.size());
            assertEquals(15, the15ListBooks.size());
            assertEquals(0, the40ListBooks.size());



        }

        @Test
        void testListBooksWithConditionFragmentShorterThan3() {                          // [1]
            // Given
            LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);            // [2]
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);               // [3]

            // When
            List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");       // [4]

            // Then
            assertEquals(0, theListOfBooks10.size());                                     // [5]
            verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());    // [6]
        }
    }

    @Nested
    @DisplayName("User books list tests")
    class UserBooksTestSuite {
        @Test
        void testUserHaveNoBooks() {
//          Given
            BookLibrary userBookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultUserListOf0Books = new ArrayList<>();
            List<Book> resultUserListOf1Book = generateListOfNBooks(1);
            List<Book> resultUserListOf5Books = generateListOfNBooks(5);
            LibraryUser testUser = new LibraryUser("John", "Wick", "1981111122222");
            when(libraryDatabaseMock.listBooksInHandsOf(testUser))
                    .thenReturn(resultUserListOf0Books)
                    .thenReturn(resultUserListOf1Book)
                    .thenReturn(resultUserListOf5Books);

// When
            List<Book> theUserListOf0Books = userBookLibrary.listBooksInHandsOf(testUser);
            List<Book> theUserListOf1Book = userBookLibrary.listBooksInHandsOf(testUser);
            List<Book> theUserListOf5Books = userBookLibrary.listBooksInHandsOf(testUser);

// Then
            assertEquals(0, theUserListOf0Books.size());
            assertEquals(1, theUserListOf1Book.size());
            assertEquals(5, theUserListOf5Books.size());

        }
    }
}