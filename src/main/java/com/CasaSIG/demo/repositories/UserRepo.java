package com.CasaSIG.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.CasaSIG.demo.Models.Professionnel;

public interface UserRepo extends CrudRepository<Professionnel, Long>{
	
	Professionnel findByUsername(String Username);
}
