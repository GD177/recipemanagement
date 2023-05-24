package com.mendix.recipemanagement.service;

import com.mendix.recipemanagement.models.Recipe;
import com.mendix.recipemanagement.repository.RecipeRepository;
import com.mendix.recipemanagement.repository.entity.CategoryEntity;
import com.mendix.recipemanagement.repository.entity.IngredientEntity;
import com.mendix.recipemanagement.repository.entity.RecipeEntity;
import com.mendix.recipemanagement.services.RecipeService;
import com.mendix.recipemanagement.services.RecipeServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@Disabled
@SpringBootTest
@AutoConfigureTestDatabase
public class RecipeServiceImplTest {
    private static final Long RECIPE_ID = 1L;

    @Mock
    private RecipeRepository recipeRepository;

    @InjectMocks
    private RecipeServiceImpl recipeService;

    @Mock
    private ModelMapper modelMapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        modelMapper = new ModelMapper(); // Initialize the modelMapper instance
        //recipeService.setModelMapper(modelMapper); // Set the modelMapper instance to the recipeService
    }

    /*@Disabled
    @Test
    public void testGetAllRecipes() {
        // Mock the repository's behavior
        List<RecipeEntity> mockRecipeEntities = new ArrayList<>();
        RecipeEntity recipeEntity1 = new RecipeEntity();
        recipeEntity1.setId(1L);
        recipeEntity1.setTitle("Recipe 1");
        mockRecipeEntities.add(recipeEntity1);

        RecipeEntity recipeEntity2 = new RecipeEntity();
        recipeEntity2.setId(2L);
        recipeEntity2.setTitle("Recipe 2");
        mockRecipeEntities.add(recipeEntity2);

        when(recipeRepository.findAll()).thenReturn(mockRecipeEntities);

        // Call the service method
        List<Recipe> result = recipeService.getAllRecipes();

        // Verify the result
        assertEquals(2, result.size());
        assertEquals("Recipe 1", result.get(0).getTitle());
        assertEquals("Recipe 2", result.get(1).getTitle());

        // Verify that the repository method was called
        verify(recipeRepository, times(1)).findAll();
    }

    @Disabled
    @Test
    public void testGetRecipeById()
    {
        // Mock the repository's behavior
        RecipeEntity mockRecipeEntity = new RecipeEntity();
        mockRecipeEntity.setId(1L);
        mockRecipeEntity.setTitle("Recipe 1");

        Collection<CategoryEntity> categoryEntities = new ArrayList<>();
        CategoryEntity categoryEntity1 = new CategoryEntity();
        categoryEntity1.setId(1L);
        categoryEntity1.setCategoryName("Cake");

        Collection<IngredientEntity> ingredientEntities = new ArrayList<>();
        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setId(1L);
        ingredientEntity.setItem("test");
        ingredientEntity.setUnit("cup");
        ingredientEntity.setQuantity("2");
        ingredientEntity.setRecipe(mockRecipeEntity);

        mockRecipeEntity.setCategories(categoryEntities);
        mockRecipeEntity.setIngredients(ingredientEntities);
        mockRecipeEntity.setDirections("test testing");
        mockRecipeEntity.setYield(2);

        when(recipeRepository.findById(1L)).thenReturn(Optional.of(mockRecipeEntity));

        Recipe mockRecipe = new Recipe();
        mockRecipe.setId(1L);
        mockRecipe.setTitle("Recipe 1");
        when(modelMapper.map(any(Recipe.class), eq(RecipeEntity.class)))
                .thenAnswer(invocation -> {
                    Recipe recipeArg = invocation.getArgument(0);
                    // Perform any required mapping logic here
                    // Return the mockRecipe object or any other desired value
                    return mockRecipe;
                });

                        //Optional.of(invocation.getArgument(0, Recipe.class)));

        // Call the service method
        Recipe result = recipeService.getRecipeById(1L);

        // Verify the result
        assertNotNull(result);
        assertEquals(1L, result.getId().longValue());
        assertEquals("Recipe 1", result.getTitle());

        // Verify that the repository method was called
        verify(recipeRepository, times(1)).findById(1L);
    }*/

    @Test
    void contextLoads() {
    }
}
