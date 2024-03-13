package com.edex.recime.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.edex.recime.model.Recipe;


@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Integer>{

}
