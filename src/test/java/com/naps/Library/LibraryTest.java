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
     * Adding Integration test
     */

    //Test 1:
    @Test
    void testBorrowBookMarksBookUnavailable() {
        // Arrange
        lib.members.add(new Member("M1", "Alice"));
        lib.books.add(new Book("101", "Clean Code", "Martin"));
        lib.books.add( new Book("102","Passion of life", "James"));

        // Act
        lib.borrow("M1", "102");

        // Assert
        assertFalse(lib.findBook("102").isAvailable());
    }


}
