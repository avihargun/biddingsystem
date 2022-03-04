package com.project.bidding.api.service;

import java.util.List;

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
	

	public boolean checkIfSellerEmailIdAlreadyExistInTheDatabase(Seller seller) {
		if(sellerRepository.findByEmail(seller.getEmail())!=null) return true;
		return false;
	}

}
