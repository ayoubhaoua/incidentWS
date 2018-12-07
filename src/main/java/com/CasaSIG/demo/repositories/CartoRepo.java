package com.CasaSIG.demo.repositories;

import com.CasaSIG.demo.Models.Incident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
public interface CartoRepo extends CrudRepository<Incident,Long> {

    List findAllByPro(String str);
    @Query("SELECT DISTINCT i.province FROM Incident i")
    List findprov();
    @Query("SELECT DISTINCT i.etat FROM Incident i")
    List findetat();

}
