package com.CasaSIG.demo.repositories;

import com.CasaSIG.demo.Models.Incident;
import com.CasaSIG.demo.Models.Professionnel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartoRepo extends CrudRepository<Incident,Long> {

    List findAllByPro(Professionnel pro);
    
    @Query("SELECT DISTINCT i.province FROM Incident i")
    List findprov();
    
    @Query("SELECT DISTINCT i.etat FROM Incident i")
    List findetat();
    
    @Query("SELECT i FROM Incident i WHERE i.etat!='refusé' AND i.pro.username=?1")
    List findeBypro(String pro);
    
    @Query("SELECT i.secteur.secteur as name ,COUNT(i) as y FROM Incident i  GROUP BY i.secteur.secteur")
    List findStat();
    
    @Query("SELECT i FROM Incident i WHERE i.IME=?1")
    List findByIME(String ime);
    
    
}
