package com.naps.Library;


import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Library lib = new Library();

    public static void main(String[] args) {
        seed();

        while (true) {
            System.out.println("\n1 Add Book\n2 Add Member\n3 Borrow\n4 Return\n5 List Books\n6 List Members\n0 Exit");
            System.out.print("Choice: ");
            switch (sc.nextInt()) {
                case 1 -> addBook();
                case 2 -> addMember();
                case 3 -> borrow();
                case 4 -> returnBook();
                case 5 -> lib.books.forEach(System.out::println);
                case 6 -> lib.members.forEach(System.out::println);
                case 0 -> { return; }
            }
        }
    }

    static void addBook() {
        System.out.print("ISBN: "); String isbn = sc.next();
        System.out.print("Title: "); String title = sc.next();
        System.out.print("Author: "); String author = sc.next();
        lib.books.add(new Book(isbn, title, author));
    }

    static void addMember() {
        System.out.print("ID: "); String id = sc.next();
        System.out.print("Name: "); String name = sc.next();
        System.out.print("Type (1=Regular, 2=Premium): ");
        int t = sc.nextInt();

        lib.members.add(t == 1 ? new Member(id, name) : new PremiumMember(id, name));
    }

    static void borrow() {
        System.out.print("Member ID: "); String id = sc.next();
        System.out.print("ISBN: "); String isbn = sc.next();
        lib.borrow(id, isbn);
    }

    static void returnBook() {
        System.out.print("Member ID: "); String id = sc.next();
        System.out.print("ISBN: "); String isbn = sc.next();
        lib.returnBook(id, isbn);
    }

    static void seed() {
        lib.books.add(new Book("111", "CleanCode", "Martin"));
        lib.books.add(new Book("222", "Java", "Bloch"));
        lib.members.add(new Member("M1", "Alice"));
        lib.members.add(new PremiumMember("M2", "Bob"));
    }
}
