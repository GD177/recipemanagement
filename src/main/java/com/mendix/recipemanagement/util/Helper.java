package com.mendix.recipemanagement.util;

import com.mendix.recipemanagement.models.Recipe;
import com.mendix.recipemanagement.repository.entity.CategoryEntity;
import com.mendix.recipemanagement.repository.entity.IngredientEntity;
import com.mendix.recipemanagement.repository.entity.RecipeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public final class Helper {
    //@Autowired
    private static ModelMapper modelMapper;

    //private Helper(){};
    @Autowired
    private Helper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    };
    public static Recipe convertEntityToModel(RecipeEntity recipeEntity) {
        return modelMapper.map(recipeEntity, Recipe.class);
    }

    public static RecipeEntity convertModelToEntity(Recipe recipe) {
        RecipeEntity recipeEntity = modelMapper.map(recipe, RecipeEntity.class);

        // Map the Category objects to CategoryEntity objects
        List<CategoryEntity> categoryEntities = recipe.getCategories().stream()
                .map(category -> {
                    CategoryEntity categoryEntity = modelMapper.map(category, CategoryEntity.class);
                    categoryEntity.setRecipe(recipeEntity);
                    return categoryEntity;
                })
                .collect(Collectors.toList());

        recipeEntity.setCategories(categoryEntities);

        // Map the Category objects to CategoryEntity objects
        List<IngredientEntity> ingredientEntities = recipe.getIngredients().stream()
                .map(category -> {
                    IngredientEntity ingredientEntity = modelMapper.map(category, IngredientEntity.class);
                    ingredientEntity.setRecipe(recipeEntity);
                    return ingredientEntity;
                })
                .collect(Collectors.toList());

        recipeEntity.setIngredients(ingredientEntities);

        return recipeEntity;
    }

    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
