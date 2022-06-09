package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductsTest {

    Product book1 = new Book(1, "Book1", 111, "Author1");
    Product book2 = new Book(2, "Book2", 222, "Author2");
    Product smartPhone1 = new Smartphone(3, "Smartphone1", 333, "Manufacturer1");
    Product smartPhone2 = new Smartphone(4, "Smartphone2", 444, "Manufacturer2");


    @Test
    public void shouldAddProduct() {
        ProductsManager manager = new ProductsManager();
        manager.add(book1);
        manager.add(book2);
        manager.add(smartPhone1);
        manager.add(smartPhone2);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, smartPhone1, smartPhone2};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldDeleteProduct() {

        ProductsManager manager = new ProductsManager();
        manager.add(book1);
        manager.add(book2);
        manager.add(smartPhone1);
        manager.add(smartPhone2);

        Product[] actual1 = manager.deleteByID(2);
        Product[] expected1 = {book1, smartPhone1, smartPhone2};
        Assertions.assertArrayEquals(expected1, actual1);

        Product[] actual2 = manager.deleteByID(4);
        Product[] expected2 = {book1, smartPhone1};
        Assertions.assertArrayEquals(expected2, actual2);

    }

    @Test
    public void shouldFindProduct() {

        ProductsManager manager = new ProductsManager();
        manager.add(book1);
        manager.add(book2);
        manager.add(smartPhone1);
        manager.add(smartPhone2);

        Product[] actual1 = manager.findByQuery("oo");
        Product[] expected1 = {book1, book2};
        Assertions.assertArrayEquals(expected1, actual1);

        Product[] actual2 = manager.findByQuery("r1");
        Product[] expected2 = {book1, smartPhone1};
        Assertions.assertArrayEquals(expected2, actual2);

        Product[] actual3 = manager.findByQuery("2");
        Product[] expected3 = {book2, smartPhone2};
        Assertions.assertArrayEquals(expected3, actual3);

    }

}
