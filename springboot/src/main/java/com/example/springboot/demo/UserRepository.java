package com.example.springboot.demo;

import org.springframework.data.repository.CrudRepository;

import com.example.springboot.controllers.User;

public interface UserRepository extends CrudRepository<User,Integer>{


}
