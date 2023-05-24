package com.mendix.recipemanagement.services;

import com.mendix.recipemanagement.models.Category;
import com.mendix.recipemanagement.repository.CategoryRepository;
import com.mendix.recipemanagement.repository.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.mendix.recipemanagement.util.Helper.distinctByKey;
import static com.mendix.recipemanagement.util.Helper.mapList;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories()
    {
        var categoryEntities = categoryRepository.findAll();
        List<CategoryEntity> distinctCategories = categoryEntities.stream()
                .filter(distinctByKey(category -> category.getCategoryName().toLowerCase()))
                .collect(Collectors.toList());

        return mapList(distinctCategories, Category.class);
    }
}
