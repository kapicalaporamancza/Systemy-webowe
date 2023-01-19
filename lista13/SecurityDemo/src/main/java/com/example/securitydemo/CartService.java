package com.example.securitydemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

    private Map<Long, Integer> cart;

    public CartService() {
        cart = new HashMap<>();
    }

    public void addToCart(Long productId, Integer quantity) {
        // sprawdzenie czy produkt już jest w koszyku
        if (cart.containsKey(productId)) {
            // jeśli tak, to dodaj ilość do istniejącej ilości
            cart.put(productId, cart.get(productId) + quantity);
        } else {
            // jeśli nie, to dodaj produkt do koszyka
            cart.put(productId, quantity);
        }
    }

    public Map<Long, Integer> getCart() {
        return cart;
    }

}
