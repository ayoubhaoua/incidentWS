package com.CasaSIG.demo.repositories;

import com.CasaSIG.demo.Models.Incident;
import com.CasaSIG.demo.dao.IncidentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class IncidentDaoImp extends JdbcDaoSupport implements IncidentDao {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public List allgeom() {
        String sql="SELECT ST_AsGeoJSON(geometry) as geometry from incident";
        List a=jdbcTemplate.queryForList(sql);
        return a;
    }

}
