package ru.netology.product;

import java.util.Arrays;
import java.util.Objects;

public class Book extends Product {
    private String author;

    private Book[] books = new Book[0];

    public Book(int id, String name, int cost, String author) {
        super(id, name, cost);
        this.author = author;
    }

    @Override
    public int getId() {
        return super.id;
    }

    @Override
    public Boolean matches(String query) {
        return (name.contains(query) || author.contains(query));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) && Arrays.equals(books, book.books);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(author);
        result = 31 * result + Arrays.hashCode(books);
        return result;
    }
}
