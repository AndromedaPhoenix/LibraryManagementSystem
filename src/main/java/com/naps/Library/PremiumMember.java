package com.naps.Library;

import java.time.LocalDate;

public class PremiumMember extends Member {

    public PremiumMember(String id, String name) {
        super(id, name);
        this.limit = 6; // Premium limit
    }

    public LocalDate availability(Book b) {
        return b.borrowed ? b.dueDate : null;
    }
}
