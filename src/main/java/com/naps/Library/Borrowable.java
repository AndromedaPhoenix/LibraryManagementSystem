package com.naps.Library;

public interface Borrowable {
    boolean borrow(Book b);
    void giveBack(Book b);
}
