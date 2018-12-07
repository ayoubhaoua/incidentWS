package com.CasaSIG.demo.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CasaSIG.demo.repositories.CartoRepo;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	CartoRepo cartorepo;
	
    @RequestMapping("user")
    public Principal user(Principal user) {
        return user;
    }
    
    @GetMapping("incident")
    public List inc(String pro) {    	
    	return cartorepo.findAllByPro(pro);
    }
}
