package com.mendix.recipemanagement.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name="tbl_ingredients")
@Entity
@Getter
@Setter
public class IngredientEntity {
    @Id
    @Column(name="ingredient_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String quantity;   //part of amount
    private String unit;       //part of amount
    private String item;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private RecipeEntity recipe;
}