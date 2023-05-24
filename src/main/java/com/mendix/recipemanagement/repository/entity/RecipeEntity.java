package com.mendix.recipemanagement.repository.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.*;

@Table(name="tbl_recipes", uniqueConstraints = @UniqueConstraint(columnNames = "title"))
@Entity
@Getter
@Setter
@EntityScan
public class RecipeEntity {
    @Id
    @Column(name="recipe_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", unique = true)
    private String title;
    private int yield;
    private String directions;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<CategoryEntity> categories;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<IngredientEntity> ingredients;

    /*@CreationTimestamp
    @Column(name="created_at", nullable=false, updatable=false)
    private Date createdAt;*/

    /*@UpdateTimestamp
    @Column(name="updated_at")
    private Date updatedAt;*/
}
