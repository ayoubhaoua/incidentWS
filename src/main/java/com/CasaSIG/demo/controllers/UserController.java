package com.CasaSIG.demo.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.CasaSIG.demo.Models.Incident;
import com.CasaSIG.demo.Models.Professionnel;
import com.CasaSIG.demo.repositories.CartoRepo;
import com.CasaSIG.demo.repositories.UserRepo;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	CartoRepo cartorepo;
	
	@Autowired
	UserRepo userRepo;
	
    @RequestMapping("user")
    public Principal user(Principal user) {
    	
    	return user;
    }
    
    @GetMapping("incident/{username}")
    public List inc(@PathVariable String username) { 
    	return cartorepo.findeBypro(username);
    }
    
    @RequestMapping(value = "/modifier", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody Incident incident ) {
    		return ResponseEntity.ok(cartorepo.save(incident));
    }
}
