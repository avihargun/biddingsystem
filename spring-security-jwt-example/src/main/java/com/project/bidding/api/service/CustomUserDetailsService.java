package com.project.bidding.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.project.bidding.api.entity.Seller;
import com.project.bidding.api.repository.SellerRepository;


import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private SellerRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Seller seller = repository.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(seller.getEmail(), seller.getPassword(), new ArrayList<>());
    }
}
