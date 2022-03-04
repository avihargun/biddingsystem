package com.project.bidding.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bidding.api.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
