package com.CasaSIG.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CasaSIG.demo.Models.Secteur;

@Repository
public interface SecteurRepo extends CrudRepository<Secteur, Long> {
	
	Secteur findById(long id);

}
