package com.example.securitydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public CategoryService() {
    }

    private boolean isEmpty() {
        return categoryRepository.count() == 0;
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        while (categoryRepository.existsById(category.getId())||category.getId()==0) {
            category.setId(category.getId() + 1);
        }
        categoryRepository.save(category);
    }
    public Category getCategoryById(long id) {
        var value= categoryRepository.findById(id);
        return value.isEmpty()?null:value.get();
    }
    public Category getCategory(Category category){
        return getCategoryById(category.getId());
    }
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }
    public void deleteCategory(Category category) {
        categoryRepository.deleteById(category.getId());
    }
    public void deleteCategoryById(long id) {
        categoryRepository.deleteById(id);
    }

}
