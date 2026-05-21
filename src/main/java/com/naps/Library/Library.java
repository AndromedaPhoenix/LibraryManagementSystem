package com.naps.Library;

import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();

    // to find the book by isbn from the list
    public Book findBook(String isbn) {
        return books.stream().filter(b -> b.isbn.equals(isbn)).findFirst().orElse(null);
    }

    // to find the member by id from the list
    public Member findMember(String id) {
        return members.stream().filter(m -> m.id.equals(id)).findFirst().orElse(null);
    }

    public void borrow(String memberId, String isbn) {
        Member m = findMember(memberId);
        Book b = findBook(isbn);

        // to check if member or book is not found
        if (m == null || b == null) {
            System.out.println("Member or book not found.");
            return;
        }

        // to check if the book is already borrowed
        if (b.borrowed) {
            System.out.println("Book already borrowed.");

            // to check if member is a premium member and show availability
            if (m instanceof PremiumMember pm) {
                System.out.println("Available on: " + pm.availability(b));
            }
            return;
        }

        // to borrow the book and print the result on screen
        if (m.borrow(b)) System.out.println("Borrowed successfully.");
        else System.out.println("Borrow failed (limit reached).");
    }

    public void returnBook(String memberId, String isbn) {
        Member m = findMember(memberId);
        Book b = findBook(isbn);

        // to check member and book exist then return the book
        if (m != null && b != null) {
            m.giveBack(b);
            System.out.println("Returned.");
        }
    }
    /**
     * Adding method to add external csv file from the resource folder.
     */
    public void loadBooksFromCSV(String filePath) {
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
//                if (data.length == 3) {
//                    books.add(new Book(data[0].trim(), data[1].trim(), data[2].trim()));
                /** Features of updated lines.
                 * - Removes any quotes " " automatically
                 * - Keeps ISBN as a string
                 * - Works with or without quotes
                 * - Works with leading zeros
                 * - Works with all your CSV files
                 */
                if (data.length == 3) {
                    String isbn = data[0].trim().replace("\"", "");
                    String title = data[1].trim().replace("\"", "");
                    String author = data[2].trim().replace("\"", "");

                    books.add(new Book(isbn, title, author));

                }
            }
            System.out.println("Books loaded from CSV.");
        } catch (Exception e) {
            System.out.println("Error loading CSV: " + e.getMessage());
        }
    }
}