package com.mendix.recipemanagement.models;

import com.mendix.recipemanagement.repository.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    private Long id;
    @NotNull
    @NotBlank
    private String title;
    @NotEmpty
    private List<Category> categories;
    private int yield;
    @NotEmpty
    private List<Ingredient> ingredients;
    @NotNull
    @NotBlank
    private String directions;
}
