package com.project.bidding.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bidding.api.entity.Bidder;

public interface BidderRepository extends JpaRepository<Bidder, String>{

	Bidder save(Bidder bidder);
	
	Bidder findByBidderEmail(String bidderEmail);//this is used in login but right now we havent made login 17 feb

}
