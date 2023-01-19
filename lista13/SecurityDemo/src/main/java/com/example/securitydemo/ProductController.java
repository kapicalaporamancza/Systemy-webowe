package com.example.securitydemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/admin/product/")
    public String home(Locale locale, Model model) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);
        String serverTime = dateFormat.format(date);
        model.addAttribute("serverTime", serverTime.toString());
        List<Product> productList = productService.getAllProduct();
        model.addAttribute("productList", productList);
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("categoryList", categoryList);
        return "admin/product/index";
    }

    @GetMapping("/user/product/")
    public String list(Locale locale, Model model) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);
        String serverTime = dateFormat.format(date);
        model.addAttribute("serverTime", serverTime.toString());
        List<Product> productList = productService.getAllProduct();
        model.addAttribute("productList", productList);
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("categoryList", categoryList);
        return "user/index";
    }

    @GetMapping("/admin/product/add")
    public String add(Model model) {
        // pass category list to the view
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("categories", categoryList);
        model.addAttribute("product", new Product());
        return "admin/product/add";
    }

    @PostMapping("/admin/product/add")
    public String add(@ModelAttribute Product product) {

        productService.addProduct(product);
        return "redirect:/admin/product/";
    }

    // how to put a parameter in a query string
    // e.a. /student/details?id=3
    @GetMapping("/admin/product/details")
    public String add(@RequestParam("id") long inputId, Model model) {
        model.addAttribute("product", productService.getProductById(inputId));
        Category category = categoryService.getCategoryById(productService.getProductById(inputId).getCategory());
        model.addAttribute("category", category);
        return "/admin/product/details";
    }

    // how to put parameter in an URL
    // e.a. /student/3/edit
    @GetMapping(value = { "/admin/product/{studId}/edit" })
    public String edit(Model model, @PathVariable Integer studId) {
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("categories", categoryList);
        model.addAttribute("product", productService.getProductById(studId));
        return "/admin/product/edit";
    }

    @PostMapping(value = { "/admin/product/edit" })
    public String edit(@ModelAttribute Product product) {
        productService.updateProduct(product);
        return "redirect:/admin/product/";
    }

    // how to put a parameter in a query string
    // e.a. /student/remove?id=3
    @GetMapping("/admin/product/remove")
    public String remove(@RequestParam("id") long id) {
        productService.deleteProductById(id);
        return "redirect:/admin/product/";
    }

}
