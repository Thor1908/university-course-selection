package com.universitycourseapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.universitycourseapp.entities.User;

@Repository
public interface UserLoginRepository extends CrudRepository<User, Integer> {
	User findByUsername(String username);

}