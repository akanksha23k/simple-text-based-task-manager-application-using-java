package com.jap.task;

import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class CategoryOperations {
    private List<Category> categories;

    public CategoryOperations() {
        categories = new ArrayList<>();
    }

    public boolean addCategory(String name) {
        categories.add(new Category(name));
        return true;
    }

    public Category findCategory(String name) {
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        return null;
    }

    public List<Category> listAllCategories() {
        return categories;
    }
}