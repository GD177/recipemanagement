package com.mendix.recipemanagement.repository;

import com.mendix.recipemanagement.repository.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
    boolean existsByTitle(String title);

    @Query("SELECT r FROM RecipeEntity r WHERE LOWER(r.title) like LOWER(CONCAT('%', :title, '%'))")
    List<RecipeEntity> findRecipesByTitle(String title);

    @Query("SELECT r FROM RecipeEntity r JOIN r.categories c ON r.id = c.recipe.id WHERE LOWER(c.categoryName) = LOWER(:categoryName)")
    List<RecipeEntity> findRecipesByCategoryName(String categoryName);

    @Query("SELECT r FROM RecipeEntity r JOIN r.categories c ON r.id = c.recipe.id WHERE LOWER(r.title) like LOWER(CONCAT('%', :title, '%')) AND LOWER(c.categoryName) = LOWER(:categoryName)")
    List<RecipeEntity> findRecipesByTitleAndCategoryName(String title, String categoryName);
}