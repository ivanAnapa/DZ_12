package ru.netology.product;

public class Product {
    protected int id;
    protected String name;
    protected int cost;

    Product[] products = new Product[0];

    public Product(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }


    public int getId() {
        return id;
    }

    public Boolean matches(String query) {
        return name.contains(query);
    }


}
