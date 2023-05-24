package com.mendix.recipemanagement.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name="tbl_categories")
@Entity
@Getter
@Setter
public class CategoryEntity {
    @Id
    @Column(name="category_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="category_name")
    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private RecipeEntity recipe;
}
