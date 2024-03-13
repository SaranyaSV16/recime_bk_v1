package com.edex.recime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edex.recime.model.Register;
import com.edex.recime.repo.RegisterRepo;

@RestController
@RequestMapping("/register")

public class RegisterController {
@Autowired
private RegisterRepo registerRepo;

@PostMapping("/add")
public ResponseEntity<?> addRegister(@RequestBody Register register){
	
	register.setRole("user");
	
    Register savedEntity = registerRepo.saveAndFlush(register);
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(savedEntity);
    
}

@GetMapping("/check")
public ResponseEntity<?> findby(@RequestParam String email, String password){
    System.out.println("==Email==="+email);
    System.out.println("==Password==="+password);

    Register regist = registerRepo.findBy(email,password);
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(regist);
        
}
}
