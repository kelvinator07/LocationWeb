package com.geekykel.location.repos;

import com.geekykel.location.entities.Location;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by GeekyKel on 5/21/2019
 */
public interface LocationRespository extends JpaRepository<Location, Integer> {
	
	//@Query(value = "SELECT type, count(type) FROM location GROUP BY type")
	//List<Object[]> findTypeAndTypeCount();

}