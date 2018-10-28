package com.codegym.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductList {
    private Map<Integer, Product> productList = new HashMap<>();

    public void add(Product product) {
        productList.put(product.getId(), product);
    }

    public void update(int id, Product product) {
        productList.replace(id, product);
    }

    public Product get(int id) {
        return productList.get(id);
    }

    public void delete(int id) {
        productList.remove(id);
    }
}
