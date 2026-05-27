package com.naps.Library;
/**
 *  @BeforeEach for setup methods, @Test for test cases, or reset the test and run initial setup before running
 *  next test.
 * and static assertions for validating expected results.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LibraryTest {

    private Library lib;

    @BeforeEach
    void setUp() {
        lib = new Library();
    }

    /**
     * Adding Unit test
     */

    //Test 1:
    @Test
    void testFindBookReturnsCorrectBook() {
        // Arrange
        Book b = new Book("101", "Clean Code", "Martin");
        lib.books.add(b);

        // Act
        Book result = lib.findBook("101");

        // Assert
        assertEquals(b, result);
    }

    //Test 2:
    @Test
    void testFindBookReturnsNullWhenNotFound() {
        // Arrange
        lib.books.add(new Book("101", "Clean Code", "Martin"));

        // Act
        Book result = lib.findBook("999");

        // Assert
        assertNull(result);
    }

    //Test 3:
    @Test
    void testFindMemberReturnsCorrectMember() {
        // Arrange
        Member m = new Member("M1", "Alice");
        lib.members.add(m);

        // Act
        Member result = lib.findMember("M1");

        // Assert
        assertEquals(m, result);
    }

    //Test 4:
    @Test
    void testFindMemberReturnsNullWhenNotFound() {
        // Arrange
        lib.members.add(new Member("M1", "Alice"));

        // Act
        Member result = lib.findMember("M2");

        // Assert
        assertNull(result);
    }


    /**
     * Adding Integration test
     */

    //Test 1:
    @Test
    void testBorrowBookMarksBookUnavailable() {
        // Arrange
        lib.members.add(new Member("M1", "Ranbeer"));
        lib.books.add(new Book("101", "Heartbeat on shell", "Hari"));
        lib.books.add( new Book("102","Passion of life", "Sita"));

        // Act
        lib.borrow("M1", "102");

        // Assert
        assertFalse(lib.findBook("102").isAvailable());
    }
    //Test 2:
    @Test
    void testBorrowBookAddsToMemberBorrowList() {
        // Arrange
        Member m = new Member("M1", "Angila");
        lib.members.add(m);
        lib.books.add(new Book("101", "Dog Hound ", "Axel"));

        // Act
        lib.borrow("M1", "101");

        // Assert
        assertEquals(1,m.getBorrowed().size());
    }




}
