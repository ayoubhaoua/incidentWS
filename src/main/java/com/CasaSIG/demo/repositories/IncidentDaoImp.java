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
    public List c(String prov, String filter) {
        String sql="SELECT "+filter +" as name ,COUNT(*) as y FROM ( SELECT * from incident Join "+filter+" on incident."+filter+"_id="+filter+".id where province='"+prov+"')as aleas  GROUP BY "+filter;
        List a= (List) jdbcTemplate.queryForList(sql);
        return a;
    }
    
    @Override
    public List d(String filter) {
        String sql="SELECT "+filter +" as name ,COUNT(*) as y FROM incident Join "+filter+" on incident."+filter+"_id="+filter+".id GROUP BY "+filter;
        List a= (List) jdbcTemplate.queryForList(sql);
        return a;
    }
}
