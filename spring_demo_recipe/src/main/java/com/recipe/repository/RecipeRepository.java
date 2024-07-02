package com.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.entities.Recipe;
import com.recipe.entities.User;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {



}
