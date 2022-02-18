package com.project.bidding.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bidding.api.entity.Bidder;
import com.project.bidding.api.repository.BidderRepository;

@Service
public class BidderService {
	@Autowired
	private BidderRepository bidderRepository;
	
	public void bidderSignUp(Bidder bidder)
	{
		bidderRepository.save(bidder);
	}
	
	
	public void bidderLogin(Bidder bidder)
	{//left to implement
	}
	
}
