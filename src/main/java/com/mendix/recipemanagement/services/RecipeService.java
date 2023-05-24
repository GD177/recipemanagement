package com.mendix.recipemanagement.services;

import com.mendix.recipemanagement.models.Category;
import com.mendix.recipemanagement.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipes(String title, String categoryName);
    Recipe getRecipeById(Long id);
    Recipe addRecipe(Recipe recipe);
}