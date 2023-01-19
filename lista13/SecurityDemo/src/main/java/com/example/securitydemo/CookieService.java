package com.example.securitydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class CookieService {

    public void addToCookie(Long productId, Integer quantity, HttpServletResponse response) {
        // tworzenie ciastka z id i ilością
        Cookie cookie = new Cookie(productId.toString(), quantity.toString());
        // ustawienie czasu życia ciastka
        cookie.setMaxAge(60 * 60 * 24); // 1 dzień
        // dodanie ciastka do odpowiedzi
        response.addCookie(cookie);
    }

    public Integer getQuantityFromCookie(Long productId, HttpServletRequest request) {
        // pobieranie tablicy z ciastkami z żądania
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            // przeszukanie tablicy ciastek w celu znalezienia ciastka o danym id
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(productId.toString())) {
                    // zwrócenie ilości z ciastka
                    return Integer.parseInt(cookie.getValue());
                }
            }
        }
        return null;
    }

}
