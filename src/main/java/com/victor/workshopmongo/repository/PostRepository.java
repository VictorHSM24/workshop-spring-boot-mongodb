package com.victor.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.victor.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
}