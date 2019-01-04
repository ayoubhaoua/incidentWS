package com.CasaSIG.demo.controllers;

import com.CasaSIG.demo.Models.Incident;
import com.CasaSIG.demo.Models.IncidentSer;
import com.CasaSIG.demo.dao.IncidentDao;
import com.CasaSIG.demo.repositories.CartoRepo;
import com.CasaSIG.demo.repositories.IncidentDaoImp;

import com.CasaSIG.demo.repositories.SecteurRepo;
import com.CasaSIG.demo.repositories.TypeRepo;


import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.xml.ws.Response;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
	private static final String dir = System.getProperty("user.dir")+"/img/";

    @Autowired
    CartoRepo cartoRepo;
    
    @Autowired
    SecteurRepo secteurRepo;
    
    @Autowired
    TypeRepo typeRepo;

    @Autowired
    IncidentDaoImp incidentDaoImp;
    

    @GetMapping("/all")
    public Iterable<Incident> all(){
        return cartoRepo.findAll();
    }
    @GetMapping("/stat/{filter}/{province}")
    public List allg(@PathVariable String province, @PathVariable String filter){
    	if(province.equals("All"))
    		return incidentDaoImp.d(filter);
    	else 
    		return incidentDaoImp.c(province,filter);
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
    public ResponseEntity add(@RequestBody Incident incident ) throws FileNotFoundException, IOException {
    	if(incident.getId()!=null && incident.getImage()==null)
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    	String img=incident.getImage();
    	incident.setImage("");
    	incident.setDate(new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime()));
    	incident.setEtat("en attente");
    	long a = cartoRepo.save(incident).getId();
            byte[] imageByte=Base64.decodeBase64(img);
            new FileOutputStream(dir+"/"+incident.getId()+".jpg").write(imageByte);
        incident.setImage("api/img/"+a+".jpg");
    	return ResponseEntity.ok(cartoRepo.save(incident));
    }
    
    
    @GetMapping("/secteurs")
    public List secteurs(){
    	return (List)secteurRepo.findAll();
    }
    
    @GetMapping("/types/{secteur}")
    public List types(@PathVariable long secteur){
    	return (List)typeRepo.findBySecteur(secteur);
    }

    @GetMapping("/incidents/{ime}")
    public List imes(@PathVariable String ime){
    	return cartoRepo.findByIME(ime);
    }


}
