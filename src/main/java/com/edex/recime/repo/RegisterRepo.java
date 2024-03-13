package com.edex.recime.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edex.recime.model.Register;

@Repository
public interface RegisterRepo extends JpaRepository<Register, Integer>{

	 @Query(value = "Select * from register Where email = :email AND password = :password", nativeQuery = true)
	    Register findBy(String email, String password);
}
