package com.example.productlistfragments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;


    public ProductService() {
    }

    private boolean isEmpty() {
        return productRepository.count() == 0;
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        while (productRepository.existsById(product.getId())||product.getId()==0) {
            product.setId(product.getId() + 1);
        }
        productRepository.save(product);
    }
    public Product getProductById(long id) {
        var value= productRepository.findById(id);
        return value.isEmpty()?null:value.get();
    }
    public Product getProduct(Product product){
        return getProductById(product.getId());
    }
    public void updateProduct(Product product) {
        productRepository.save(product);
    }
    public void deleteProduct(Product product) {
        productRepository.deleteById(product.getId());
    }
    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }

}
