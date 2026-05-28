package com.naps.Library;


import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Library lib = new Library();

    public static void main(String[] args) {
        seed();

        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. List Books");
            System.out.println("6. List Members");
            System.out.println("7. Search Book");
            System.out.println("8. Search Member");

            System.out.println("0. Exit");
            System.out.print("Choice: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> addMember();
                case 3 -> borrow();
                case 4 -> returnBook();
                case 5 -> lib.books.forEach(System.out::println);
                case 6 -> lib.members.forEach(System.out::println);
                case 7 -> searchBook();
                case 8 -> searchMember();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    // ---------- Input Helper ----------
    static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }

    // ---------- Menu Actions ----------
    static void addBook() {
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Author: ");
        String author = sc.nextLine();

        lib.books.add(new Book(isbn, title, author));
        System.out.println("Book added.");
    }

    static void addMember() {
        System.out.print("Member ID: ");
        String id = sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Type (1 = Regular, 2 = Premium): ");
        int type = readInt();

        if (type == 1)
            lib.members.add(new Member(id, name));
        else
            lib.members.add(new PremiumMember(id, name));

        System.out.println("Member added.");
    }

    static void borrow() {
        System.out.print("Member ID: ");
        String id = sc.nextLine();

        System.out.print("Book ISBN: ");
        String isbn = sc.nextLine();

        lib.borrow(id, isbn);
    }

    static void returnBook() {
        System.out.print("Member ID: ");
        String id = sc.nextLine();

        System.out.print("Book ISBN: ");
        String isbn = sc.nextLine();

        lib.returnBook(id, isbn);
    }

    static void searchBook() {
        System.out.println("\n--- Search Book ---");
        System.out.println("1. By ISBN");
        System.out.println("2. By Title");
        System.out.println("3. By Author");
        System.out.print("Choice: ");

        int choice = readInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter ISBN: ");
                Book b = lib.findBook(sc.nextLine());
                System.out.println(b != null ? b : "Book not found.");
            }
            case 2 -> {
                System.out.print("Enter Title: ");
                lib.findBooksByTitle(sc.nextLine()).forEach(System.out::println);
            }
            case 3 -> {
                System.out.print("Enter Author: ");
                lib.findBooksByAuthor(sc.nextLine()).forEach(System.out::println);
            }
        }
    }
    static void searchMember() {
        System.out.println("\n--- Search Member ---");
        System.out.println("1. By Member ID");
        System.out.println("2. By Name");
        System.out.print("Choice: ");

        int choice = readInt();
        sc.nextLine(); // clear buffer

        switch (choice) {
            case 1 -> {
                System.out.print("Enter Member ID: ");
                String id = sc.nextLine();
                Member m = lib.findMember(id);
                System.out.println(m != null ? m : "Member not found.");
            }
            case 2 -> {
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                lib.findMembersByName(name)
                        .forEach(System.out::println);
            }
            default -> System.out.println("Invalid option.");
        }
    }
    // ---------- Sample Data ----------
    static void seed() {
        /**lib.books.add(new Book("111", "CleanCode", "Martin"));
        lib.books.add(new Book("222", "Java", "Bloch"));
         */
        //lib.loadBooksFromCSV("src/main/resources/Book.csv"); ( test)
        // lib.loadBooksFromCSV("Book.csv"); ( test)
        lib.loadBooksFromCSV("src/main/resources/Book.csv");
        lib.members.add(new Member("M1", "Pranita"));
        lib.members.add(new PremiumMember("M2", "Sugal"));
    }
}
