package com.victor.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.victor.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
}