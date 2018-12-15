package com.CasaSIG.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.CasaSIG.demo.Models.Incident;
import com.CasaSIG.demo.repositories.CartoRepo;

@RestController
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	CartoRepo cartoRepo;
	
	
    @RequestMapping(value = "/modifier", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody Incident incident ) {
    	if(incident.getEtat().equals("refusé")||incident.getEtat().equals("accepté"))
    		return ResponseEntity.ok(cartoRepo.save(incident));
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
