package com.CasaSIG.demo.repositories;

import com.CasaSIG.demo.Models.Incident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
public interface CartoRepo extends CrudRepository<Incident,Long> {

    int countAllBySecteur(String secteur);
}
