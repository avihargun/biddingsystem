package com.project.bidding.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.bidding.api.entity.Auction;
import com.project.bidding.api.entity.ReturnBid;
import com.project.bidding.api.entity.bid;
import com.project.bidding.api.repository.AuctionRepository;

@Controller
public class BidController {
    
	@Autowired
	AuctionRepository auctionRepository;
	@MessageMapping("/hello")
	  @SendTo("/bid/returnbid")      
	  public ReturnBid greeting(bid message) throws Exception {
//	    Thread.sleep(1000); // simulated delay
	    return new ReturnBid(message.getBidValue());
	  }  
	
	@RequestMapping(value="/auctionhouse/bid" , method=RequestMethod.GET)
	public String getbid()
	{
		return "Auctioneer_bid";
	}
	
	@RequestMapping(value="/auctionhouse/bidtest" , method=RequestMethod.GET)
	public String bidtest()
	{
		return "bidding-test";
	}
	
	 //------------------live auction ------------
    @RequestMapping(value="/bidder/live-auction/{eventNo}" , method=RequestMethod.GET)
    public String liveAuctionPost(@PathVariable("eventNo") long eventNo, Model model) {

    	
    	
    	model.addAttribute("items", auctionRepository.findByeventNo(eventNo));//items will have the list of items so will hagve to implement foreeach lopp in jsp page
    	Auction a = (Auction) auctionRepository.findByeventNo(eventNo);
    	model.addAttribute("catalog", a.getItems());
    	
    	
    	return "bidder-live-auction";
    }

    @RequestMapping(value="/bidder/live-auction" , method=RequestMethod.POST)
    public String liveAuctionGet(Model model) {
    	return "bidder-live-auction";
    }
	                 
}

