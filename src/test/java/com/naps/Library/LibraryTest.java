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
    //Test3
    @Test
    void testReturnBookMakesBookAvailable() {
        // Arrange
        Member m = new Member("M1", "Namrata");
        Book b = new Book("101", "Hamro Nepali Book", "Janardan Dahal");
        lib.members.add(m);
        lib.books.add(b);
        lib.borrow("M1", "101");

        // Act
        lib.returnBook("M1", "101");

        // Assert
        assertTrue(b.isAvailable());
    }

   //Test 4
   @Test
   void testRegularMemberBorrowLimit() {
       // Arrange
       Member m = new Member("M1", "Alice");
       lib.members.add(m);
       lib.books.add(new Book("101", "B1", "A"));
       lib.books.add(new Book("102", "B2", "A"));
       lib.books.add(new Book("103", "B3", "A"));

       // Act
       lib.borrow("M1", "101");
       lib.borrow("M1", "102");
       lib.borrow("M1", "103");

       // Assert
       assertEquals(3, m.getBorrowed().size());
   }

    //Test 5
    @Test
    void testPremiumMemberBorrowLimit() {
        // Arrange
        PremiumMember pm = new PremiumMember("P1", "Shyam");
        lib.members.add(pm);

        lib.books.add(new Book("101", "B1", "A"));
        lib.books.add(new Book("102", "B2", "A"));
        lib.books.add(new Book("103", "B3", "A"));
        lib.books.add(new Book("104", "B4", "A"));
        lib.books.add(new Book("105", "B5", "A"));
        lib.books.add(new Book("106", "B6", "D"));

        // Act
        lib.borrow("P1", "101");
        lib.borrow("P1", "102");
        lib.borrow("P1", "103");
        lib.borrow("P1", "104");
        lib.borrow("P1", "105");
        lib.borrow("P1", "106");

        // Assert
        assertEquals(6, pm.getBorrowed().size());
    }



}
