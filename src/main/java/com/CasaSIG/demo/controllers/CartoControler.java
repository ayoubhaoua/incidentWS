package com.CasaSIG.demo.controllers;

import com.CasaSIG.demo.Models.Incident;
import com.CasaSIG.demo.Models.IncidentSer;
import com.CasaSIG.demo.dao.IncidentDao;
import com.CasaSIG.demo.repositories.CartoRepo;
import com.CasaSIG.demo.repositories.IncidentDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.xml.ws.Response;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping("/api/carto")
public class CartoControler {

    @Autowired
    CartoRepo cartoRepo;

    @Autowired
    IncidentDaoImp incidentDaoImp;
    

    @GetMapping("/all")
    public Iterable<Incident> all(){
        return cartoRepo.findAll();
    }
    @GetMapping("/stat/{province}")
    public List allg(@PathVariable String province){
    	if(province.equals("All"))
    		return incidentDaoImp.d();
    	else 
    		return incidentDaoImp.c(province);
    }
    
    @GetMapping("/prov")
    public List prov(){
    	return cartoRepo.findprov();
    }
    @GetMapping("/etat")
    public List etat(){
    	return cartoRepo.findetat();
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Incident add(@RequestBody Incident incident ) {
    	incident.setDate(new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime()));
    	incident.setEtat("en attente");
    	return cartoRepo.save(incident);
    }
   

}
