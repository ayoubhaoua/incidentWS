package com.CasaSIG.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.CasaSIG.demo.Models.Professionnel;
import com.CasaSIG.demo.Models.Secteur;

public interface UserRepo extends CrudRepository<Professionnel, Long>{
	
	Professionnel findById(long id);
	Professionnel findByUsername(String Username);
	List findBySecteur(Secteur secteur);
}
