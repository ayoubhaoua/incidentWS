package com.CasaSIG.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CasaSIG.demo.repositories.CartoRepo;

@RestController
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	CartoRepo cartorepo;
	
	 @GetMapping("incident")
	    public List inc() {    	
	    	return (List) cartorepo.findAll();
	    }

}
