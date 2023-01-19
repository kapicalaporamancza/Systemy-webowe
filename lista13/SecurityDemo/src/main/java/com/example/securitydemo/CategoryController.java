package com.example.securitydemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class CategoryController {
    private final CategoryService categoryService;
    private final ProductService productService;

    public CategoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/admin/category")
    public String home(Locale locale, Model model) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);
        String serverTime = dateFormat.format(date);
        model.addAttribute("serverTime", serverTime.toString());
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("categoryList", categoryList);
        return "admin/product/index";
    }

    @GetMapping("/admin/product/addCategory")
    public String add(Model model) {
        model.addAttribute("category", new Category());
        return "admin/product/addCategory";
    }

    @PostMapping("/admin/product/addCategory")
    public String add(@ModelAttribute Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/product/";
    }

    // how to put parameter in an URL
    // e.a. /student/3/edit
    @GetMapping(value = { "/admin/product/{studId}/editCategory" })
    public String edit(Model model, @PathVariable Integer studId) {
        model.addAttribute("category", categoryService.getCategoryById(studId));
        return "/admin/product/editCategory";
    }

    @PostMapping(value = { "/product/editCategory" })
    public String edit(@ModelAttribute Category category) {
        categoryService.updateCategory(category);
        return "redirect:/admin/product/";
    }

    // how to put a parameter in a query string
    // e.a. /student/remove?id=3
    @GetMapping("/admin/category/remove")
    public String remove(@RequestParam("id") long id) {
        List<Product> productList = productService.getAllProduct();
        for (Product product : productList) {
            if (product.getCategory() == id)
                productService.deleteProductById(product.getId());
        }
        categoryService.deleteCategoryById(id);
        return "redirect:/admin/product/";
    }

}
