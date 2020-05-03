package com.webfluxpoc.callerservice.repository;

import com.webfluxpoc.callerservice.model.Category;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends ReactiveCrudRepository<Category, Integer> {
}