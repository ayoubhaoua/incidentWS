package com.CasaSIG.demo.dao;

import com.CasaSIG.demo.Models.Incident;

import java.util.List;
import java.util.Map;

public interface IncidentDao {

	List c(String prov, String filter);

	List d(String filter);
}
