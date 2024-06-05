package com.projetopoobackend.sistemadeestoque.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projetopoobackend.sistemadeestoque.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	 void save(List<User> list);

	 Optional<User> findById(String id);
	    
}
