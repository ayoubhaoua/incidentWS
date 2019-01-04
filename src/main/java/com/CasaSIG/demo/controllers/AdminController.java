package com.CasaSIG.demo.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.CasaSIG.demo.Models.Incident;
import com.CasaSIG.demo.Models.Secteur;
import com.CasaSIG.demo.repositories.CartoRepo;
import com.CasaSIG.demo.repositories.SecteurRepo;
import com.CasaSIG.demo.repositories.UserRepo;

@RestController
@RequestMapping("admin")
public class AdminController {
	
	private static final String dir = System.getProperty("user.dir")+"/img/";
	
	@Autowired
	CartoRepo cartoRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	SecteurRepo secteurRepo;
	
	
    @RequestMapping(value = "/modifier", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody Incident incident ) {
    		return ResponseEntity.ok(cartoRepo.save(incident));
    }
    
    @GetMapping("profs/{id}")
    public List profs(@PathVariable long id) {
    	
    	Secteur secteur =secteurRepo.findById(id);
    	return userRepo.findBySecteur(secteur);
    }
    @GetMapping("del/{id}")
    public boolean del(@PathVariable long id) {
    	try {
    	cartoRepo.deleteById(id);
    	}
    	catch (Exception e) {
			return false;
		}
    	return true;
    }

}
