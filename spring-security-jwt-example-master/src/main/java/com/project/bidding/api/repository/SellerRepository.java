package com.project.bidding.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bidding.api.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, String>{

	Seller save(Seller seller);
	
	Seller findByEmail(String sellerid);

}
