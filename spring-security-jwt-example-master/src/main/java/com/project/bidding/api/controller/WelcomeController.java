package com.project.bidding.api.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.bidding.api.entity.AuthRequest;
import com.project.bidding.api.entity.Seller;
import com.project.bidding.api.service.SellerService;
import com.project.bidding.api.util.JwtUtil;


@Controller
@CrossOrigin(origins="*")
public class WelcomeController {

	@Autowired
	private SellerService sellerService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value="/login" , method=RequestMethod.GET)
    public String login() {
        return "login";
    }
    
    @RequestMapping(value="/signup" , method=RequestMethod.GET)
    public String signup() {
        return "signup";
    }
    
    @RequestMapping(value="/signup" , method=RequestMethod.POST)
    public String signuppost(@ModelAttribute Seller seller) {
    	
    	sellerService.saveSeller(seller);
        return "login";
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
        return "welcome";
      
    	
    }
}
