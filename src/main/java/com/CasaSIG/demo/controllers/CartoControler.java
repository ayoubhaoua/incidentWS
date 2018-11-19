package com.CasaSIG.demo.controllers;

import com.CasaSIG.demo.Models.Incident;
import com.CasaSIG.demo.dao.IncidentDao;
import com.CasaSIG.demo.repositories.CartoRepo;
import com.CasaSIG.demo.repositories.IncidentDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping("carto")
public class CartoControler {

    @Autowired
    CartoRepo cartoRepo;

    @Autowired
    IncidentDaoImp incidentDaoImp;

    @GetMapping("/all")
    public Iterable<Incident> all(){
        return cartoRepo.findAll();
    }
    @GetMapping("/statAll")
    public  Map allgeom(){
        ArrayList<Map<String,Integer>> a = new ArrayList<>();
        Map<String,Integer> b=new HashMap<String,Integer>();
        b.put("eau",cartoRepo.countAllBySecteur("eau"));
        b.put("electricite", cartoRepo.countAllBySecteur("electricite"));
        b.put("infrastructure",cartoRepo.countAllBySecteur("infrastructure"));
        return b;
    }
}
