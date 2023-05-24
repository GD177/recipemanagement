package com.mendix.recipemanagement.services;

import com.mendix.recipemanagement.exceptions.DuplicateRecipeException;
import com.mendix.recipemanagement.models.Recipe;
import com.mendix.recipemanagement.repository.RecipeRepository;
import com.mendix.recipemanagement.repository.entity.RecipeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.mendix.recipemanagement.util.Helper.*;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public List<Recipe> getAllRecipes(String title, String categoryName) {
        List<RecipeEntity> recipeEntityList;

        if(title != null && categoryName != null)
            recipeEntityList = recipeRepository.findRecipesByTitleAndCategoryName(title, categoryName);
        else if(title != null && categoryName == null)
            recipeEntityList = recipeRepository.findRecipesByTitle(title);
        else if (title == null && categoryName != null) {
            recipeEntityList = recipeRepository.findRecipesByCategoryName(categoryName);
        }
        else
            recipeEntityList = recipeRepository.findAll();

        return mapList(recipeEntityList, Recipe.class);
    }

    @Override
    public Recipe getRecipeById(Long recipeId) {
       Optional<RecipeEntity> recipeEntity = recipeRepository.findById(recipeId);

        if (recipeEntity.isPresent()) {
            return convertEntityToModel(recipeEntity.get());
        } else {
            // Handle the case when the Optional is empty
            throw new NoSuchElementException("Recipe not found");
        }
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        // Check if a recipe with the same title already exists
        if (recipeRepository.existsByTitle(recipe.getTitle())) {
            throw new DuplicateRecipeException("Recipe with the same title already exists");
        }

        // Conversion and saving logic
        RecipeEntity recipeEntity = convertModelToEntity(recipe);
        RecipeEntity savedRecipeEntity = recipeRepository.save(recipeEntity);

        return convertEntityToModel(savedRecipeEntity);
    }
}