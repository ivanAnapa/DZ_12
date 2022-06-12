package ru.netology.product;

public class ProductsManager {

    private Product[] products = new Product[0];

    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];
        System.arraycopy(products, 0, tmp, 0, products.length);
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }


    public Product[] findByQuery(String query) {
        Product[] result = new Product[0];

        for (Product product : products) {

            if (product.matches(query)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;

            }
        }
        return result;
    }

    public Product[] deleteByID(int id) {

        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        Product[] result = new Product[products.length - 1];
        int count = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                result[count] = product;
                count++;
            }
            products = result;
        }
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
