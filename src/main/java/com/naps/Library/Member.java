package com.naps.Library;
/**
 *
 */

import java.time.LocalDate;
import java.util.ArrayList;

public class Member implements Borrowable {
    String id, name;
    int limit = 3;
    ArrayList<Book> borrowed = new ArrayList<>();

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean borrow(Book b) {
        if (borrowed.size() >= limit || b.borrowed) return false;

        b.borrowed = true;
        b.dueDate = LocalDate.now().plusDays(14);
        borrowed.add(b);
        return true;
    }

    @Override
    public void giveBack(Book b) {
        borrowed.remove(b);
        b.borrowed = false;
        b.dueDate = null;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (" + borrowed.size() + "/" + limit + ")";
    }
    }