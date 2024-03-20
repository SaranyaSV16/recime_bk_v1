package com.edex.recime.controller;

import java.io.File;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.edex.recime.model.Recipe;
import com.edex.recime.repo.RecipeRepo;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
	@Autowired
	private RecipeRepo recipeRepo;
	

@PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadedFile) {
        if (uploadedFile.isEmpty()) {
            return new ResponseEntity<>("Please select a file!", HttpStatus.OK);
        }
        try {

            byte[] bytes = uploadedFile.getBytes();

            UUID uuid = UUID.randomUUID();
//            String uploadsLocation = env.getProperty("resource.uploads");
            String uploadsLocation = "D:\\D Drive\\Recime\\recime\\src\\main\\resources\\Uploads\\";
            String fileLocation = uploadsLocation + uuid + uploadedFile.getOriginalFilename();
            Path path = Paths.get(fileLocation);
            Files.write(path, bytes);

            File file = new File(fileLocation);
            return ResponseEntity.status(HttpStatus.OK).body(file.getName());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CREATED).body(e.getMessage());

        }
    }
    
    
    
    @PostMapping("/addfile")
    public ResponseEntity<?> addFile(@RequestBody Recipe recipe){
        System.out.println("===Recipe Details=="+recipe.getName());
        Recipe savedEntity = recipeRepo.saveAndFlush(recipe);

        return ResponseEntity.status(HttpStatus.OK)
                .body(savedEntity);
        
    }
    
    @GetMapping("/getfile")
    public ResponseEntity<?> getFile(){
        List<Recipe> recipes = recipeRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(recipes);
                
    }
    
    @GetMapping("/cuisine/{cuisine}")
    public ResponseEntity<?> findBy(@PathVariable String cuisine){
    	List<Recipe> recipes = recipeRepo.findBy(cuisine);
    	return ResponseEntity
    			.status(HttpStatus.OK)
    			.body(recipes);
    }
    
    @GetMapping("/replace/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
    	Recipe recipes = recipeRepo.findById(id);
    	return ResponseEntity
    			.status(HttpStatus.OK)
    			.body(recipes);
    }
}
