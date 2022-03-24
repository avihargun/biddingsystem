package com.project.bidding.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bidding.api.entity.bid;


public interface BidRepository extends JpaRepository<bid, Long> {

}
