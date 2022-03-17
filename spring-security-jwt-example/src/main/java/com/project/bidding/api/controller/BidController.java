package com.project.bidding.api.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.project.bidding.api.entity.ReturnBid;
import com.project.bidding.api.entity.bid;

@Controller
public class BidController {

	@MessageMapping("/hello")
	  @SendTo("/bid/returnbid")      
	  public ReturnBid greeting(bid message) throws Exception {
	    Thread.sleep(1000); // simulated delay
	    return new ReturnBid(message.getAmount());
	  }  
	
	@RequestMapping(value="/auctionhouse/bid" , method=RequestMethod.GET)
	public String getbid()
	{
		return "Auctioneer_bid";
	}
}

