package com.helixstack.projectDemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.helixstack.projectDemo.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
