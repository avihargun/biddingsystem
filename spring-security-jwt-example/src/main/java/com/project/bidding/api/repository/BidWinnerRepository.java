package com.project.bidding.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bidding.api.entity.BidWinner;

public interface BidWinnerRepository extends JpaRepository<BidWinner, Long>{

}
