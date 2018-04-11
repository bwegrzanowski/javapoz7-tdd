package com.sda.service.bookStore;

import java.util.ArrayList;
import java.util.List;

public class BookStore {
    private final List<Book> books;

    public BookStore() {
        this.books = new ArrayList<>();
    }

    public void add(Book book) {
        books.add(book);
    }

    public void updateTitle(Book book, String title) {
        Book bookInBookStore = books.get(books.indexOf(book));
        bookInBookStore.setTitle(title);
    }

    public List<Book> getBooks() {
        return books;
    }
}
