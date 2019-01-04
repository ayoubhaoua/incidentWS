package com.CasaSIG.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.CasaSIG.demo.Models.Secteur;

public interface SecteurRepo extends CrudRepository<Secteur, Long>{
	Secteur findById(long id);
}
