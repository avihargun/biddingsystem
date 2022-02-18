package com.project.bidding.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bidding.api.entity.Seller;
import com.project.bidding.api.repository.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	public void saveSeller(Seller seller)
	{
		sellerRepository.save(seller);
	
	}
}
