package com.edex.recime.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edex.recime.model.Recipe;


@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Integer>{

	@Query(value="Select * from Recipes Where cuisine = :cuisine", nativeQuery = true )
	List<Recipe> findBy(String cuisine);
	
	@Query(value = "Select * from Recipes Where id = :id", nativeQuery = true)
	Recipe findById(int id);
}
