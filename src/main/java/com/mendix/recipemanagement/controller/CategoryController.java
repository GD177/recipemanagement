package com.mendix.recipemanagement.controller;

import com.mendix.recipemanagement.models.Category;
import com.mendix.recipemanagement.services.CategoryService;
import com.mendix.recipemanagement.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getRecipeCategories() {
        try {
            List<Category> categories = categoryService.getAllCategories();
            if(categories.size() == 0)
                return ResponseEntity.notFound().build();

            return ResponseEntity.ok(categories);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}