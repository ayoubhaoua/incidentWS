package com.CasaSIG.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CasaSIG.demo.Models.Secteur;

import com.CasaSIG.demo.Models.Type;;

@Repository
public interface TypeRepo extends CrudRepository<Type, Long>{

	@Query("SElECT t FROM Type t WHERE t.secteur.id=?1")
	List findBySecteur(long secteur);
}
