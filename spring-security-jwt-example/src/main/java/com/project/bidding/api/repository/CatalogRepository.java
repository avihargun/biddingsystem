package com.project.bidding.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bidding.api.entity.Catalog;

public interface CatalogRepository extends JpaRepository<Catalog,Long> {
	
		Catalog save(Catalog catalog);	
}
