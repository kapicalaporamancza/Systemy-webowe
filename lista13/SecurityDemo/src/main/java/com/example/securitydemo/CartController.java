package com.example.securitydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CookieService cookieService;

    @GetMapping("/user/addToCart")
    public String addToCart(@RequestParam("id") Long productId, 
                            @RequestParam("quantity") Integer quantity, 
                            HttpServletRequest request,
                            Model model) {
        // pobieranie ilości z ciastka
        Integer existingQuantity = cookieService.getQuantityFromCookie(productId, request);
        if (existingQuantity != null) {
            // jeśli ciastko już istnieje, to dodaj ilość do istniejącej ilości
            quantity += existingQuantity;
        }
        cartService.addToCart(productId, quantity);
        // przekierowanie na stronę koszyka
        return "redirect:/cart";
    }
}