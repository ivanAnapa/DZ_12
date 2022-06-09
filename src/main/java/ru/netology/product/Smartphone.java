package ru.netology.product;

import java.util.Arrays;
import java.util.Objects;

public class Smartphone extends Product {
    private String manufacturer;

    private Smartphone[] smartphones = new Smartphone[0];


    public Smartphone(int id, String name, int cost, String manufacturer) {
        super(id, name, cost);
        this.manufacturer = manufacturer;
    }


    @Override
    public int getId() {
        return super.id;
    }

    @Override
    public Boolean matches(String query) {
        return (name.contains(query) || manufacturer.contains(query));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(manufacturer, that.manufacturer) && Arrays.equals(smartphones, that.smartphones);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(manufacturer);
        result = 31 * result + Arrays.hashCode(smartphones);
        return result;
    }
}
