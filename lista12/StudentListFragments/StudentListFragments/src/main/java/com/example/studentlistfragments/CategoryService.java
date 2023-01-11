package com.example.studentlistfragments;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    ArrayList<Category> categoryList =new ArrayList<>();


    public CategoryService() {
    }

    private boolean isEmpty() {
        return categoryList.size() == 0;
    }

    public List<Category> getAllCategory() {
        return categoryList;
    }

    public void addCategory(Category category) {
        categoryList.add(category);
    }
    public Category getCategoryById(long id) {
        for(Category category: categoryList){
            if(category.getId()==id)
                return category;
        }
        return null;
    }
    public Category getCategory(Category category){
        return getCategoryById(category.getId());
    }

    public void updateCategory(Category category) {
        deleteCategory(category);
        categoryList.add(category);
    }

    public void deleteCategory(Category category) {
        categoryList.remove(getCategoryById(category.getId()));
    }
    public void deleteCategoryById(long id) {
        categoryList.remove(getCategoryById(id));
    }

}
