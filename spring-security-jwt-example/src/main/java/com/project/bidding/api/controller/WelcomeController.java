package com.project.bidding.api.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.project.bidding.api.entity.Auction;
import com.project.bidding.api.entity.AuthRequest;
import com.project.bidding.api.entity.Bidder;
import com.project.bidding.api.entity.Seller;
import com.project.bidding.api.repository.AuctionRepository;
import com.project.bidding.api.service.BidderService;
import com.project.bidding.api.service.SellerService;
import com.project.bidding.api.util.JwtUtil;


@Controller
@CrossOrigin(origins="*")
public class WelcomeController {

	@Autowired
	AuctionRepository auctionRepository;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private BidderService bidderService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value="/auctionhouse/login" , method=RequestMethod.GET)
    public String login() {
        return "auctioneer-login";
    }
    
    @RequestMapping(value="/auctionhouse/signup" , method=RequestMethod.GET)
    public String signup() {
        return "auctioneer-signup";
    }
    
    @RequestMapping(value="/auctionhouse/signup" , method=RequestMethod.POST)
    public String signuppost(@ModelAttribute Seller seller) {
    	
    	sellerService.saveSeller(seller);
        return "auctioneer-login";
    }
    
    @RequestMapping(value="/auctionhouse/addauction" , method=RequestMethod.GET)
    public String getauction() {
    	

        return "Auction";
    }
    
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(200000);
        return multipartResolver;
    }
    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/auctionimage";
    @RequestMapping(value="/auctionhouse/addauction" ,method = RequestMethod.POST)
	@ResponseBody
	public String saveStudent(@ModelAttribute Auction auction, @RequestParam("imgName") MultipartFile file ) {
		

		String filename=file.getOriginalFilename().substring(file.getOriginalFilename().length()-4);
		Path fileNameAndPath =Paths.get(uploadDirectory,filename);
		
		try {
			Files.write(fileNameAndPath, file.getBytes());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		auction.setimageName(filename);
		auctionRepository.save(auction);
		
		return "Save Data Successfully ! ";
	}
    
    @RequestMapping(value=  "/authenticate", method=RequestMethod.POST)
    public String generateToken(@ModelAttribute AuthRequest authRequest, HttpServletRequest request,HttpServletResponse response) throws Exception {
 
    	System.out.println(authRequest.getUserName());
    	try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
       
        System.out.println(jwtUtil.generateToken(authRequest.getUserName()));
        
        Cookie cookie = new Cookie("token",jwtUtil.generateToken(authRequest.getUserName()));
        response.addCookie(cookie);
       // HttpSession session = request.getSession();
       // session.setAttribute("token", jwtUtil.generateToken(authRequest.getUserName()));
        //response.sendRedirect("/welcome");
        return "auctioneer-welcome";
      
    	
    }
    
    
    /* ------------------------------ Below code is for bidder  ------------------------------ */
    
    
    @RequestMapping(value="/bidder/signup" , method=RequestMethod.GET)
    public String bidderSignUp() {
        return "bidder-signup";
    }
    
    @RequestMapping(value="/bidder/signup" , method=RequestMethod.POST)
    public String bidderSignInAfterSignUp(@ModelAttribute Bidder bidder) {
    	
    	bidderService.bidderSignUp(bidder);
        return "bidder-login";
    }
    
    @RequestMapping(value="/bidder/login" , method=RequestMethod.GET)
    public String bidderLogin() {
        return "bidder-login";
    }

}
