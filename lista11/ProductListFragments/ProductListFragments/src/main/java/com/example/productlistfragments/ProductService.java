package com.example.productlistfragments;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    ArrayList<Product> productList = new ArrayList<>();

    public ProductService() {
    }

    public void seed() {
        productList.add(new Product(1, "Chleb", 0.8, 12, "pieczywo"));
        productList.add(new Product(2, "Mleko", 1.5, 5, "nabiał"));
        productList.add(new Product(3, "Ser", 0.5, 10, "nabiał"));
        productList.add(new Product(4, "Jajka", 0.3, 6, "nabiał"));
        productList.add(new Product(5, "Czekolada", 2, 3, "słodycze"));
    }

    private boolean isEmpty() {
        return productList.size() == 0;
    }

    public List<Product> getAllProduct() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Product getProductById(long id) {
        for (Product product : productList) {
            if (product.getId() == id)
                return product;
        }
        return null;
    }

    public Product getProduct(Product product) {
        return getProductById(product.getId());
    }

    public void updateProduct(Product product) {
        deleteProduct(product);
        productList.add(product);
    }

    public void deleteProduct(Product product) {
        productList.remove(getProductById(product.getId()));
    }

    public void deleteProductById(long id) {
        productList.remove(getProductById(id));
    }

}
