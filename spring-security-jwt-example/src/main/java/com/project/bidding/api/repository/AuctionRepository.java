package com.project.bidding.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bidding.api.entity.Auction;

public interface AuctionRepository extends JpaRepository<Auction, Long>{

}
