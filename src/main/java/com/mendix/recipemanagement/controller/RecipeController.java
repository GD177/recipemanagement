package com.mendix.recipemanagement.controller;

import com.mendix.recipemanagement.exceptions.DuplicateRecipeException;
import com.mendix.recipemanagement.models.ErrorResponse;
import com.mendix.recipemanagement.models.*;
import com.mendix.recipemanagement.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/getString")
    public String returnString()
    {
        return "Hello from recipe controller!!";
    }

    @GetMapping("/recipes")
    public ResponseEntity<?> getAllRecipes(@RequestParam(value = "title", required = false) String title,
                                                      @RequestParam(value = "category", required = false) String categoryName) {
        try {
            List<Recipe> recipes = recipeService.getAllRecipes(title, categoryName);

            if(recipes.size() == 0)
                return ResponseEntity.notFound().build();

            return ResponseEntity.ok(recipes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/recipes/{id}")
    public ResponseEntity<?> getRecipe(@PathVariable("id") Long recipeId) {
        try {
            Recipe recipe = recipeService.getRecipeById(recipeId);

            return ResponseEntity.ok(recipe);
        } catch (NoSuchElementException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage()));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/recipes")
    public ResponseEntity<?> addRecipe(@Valid @RequestBody Recipe recipe) {
        try{
            Recipe addedRecipe = recipeService.addRecipe(recipe);
            return ResponseEntity.ok(addedRecipe);
        }catch (DuplicateRecipeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(e.getMessage()));
        } catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
