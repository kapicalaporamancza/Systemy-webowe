package com.example.studentlistfragments;

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

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public String home(Locale locale, Model model) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);
        String serverTime = dateFormat.format(date);
        model.addAttribute("serverTime", serverTime.toString() );
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("categoryList", categoryList );
        return "product/index";
    }



    @GetMapping("/product/addCategory")
    public String add(Model model) {
        model.addAttribute("category", new Category() );
        return "product/addCategory";
    }

    @PostMapping("/product/addCategory")
    public String add(@ModelAttribute Category category) {
        categoryService.addCategory(category);
        return "redirect:/product/";
    }



    // how to put parameter in an URL
    // e.a. /student/3/edit
    @GetMapping(value = {"/product/{studId}/editCategory"})
    public String edit(Model model, @PathVariable Integer studId) {
        model.addAttribute("category", categoryService.getCategoryById(studId) );
        return "/product/editCategory";
    }

    @PostMapping(value = {"/product/editCategory"})
    public String edit(@ModelAttribute Category category) {
        categoryService.updateCategory(category);
        return "redirect:/product/";
    }

    // how to put a parameter in a query string
    // e.a. /student/remove?id=3
    @GetMapping("/category/remove")
    public String remove(@RequestParam("id") long id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/product/";
    }

}


