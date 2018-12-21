package com.CasaSIG.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.CasaSIG.demo.Models.Professionnel;
import com.CasaSIG.demo.repositories.UserRepo;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Professionnel prof = userRepo.findByUsername(username);
		if(prof==null) {
			System.out.println("user not found");
		}
		return prof;
	}

}
