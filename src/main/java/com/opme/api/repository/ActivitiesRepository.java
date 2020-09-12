package com.opme.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.opme.api.entity.Activities;

@Repository("ActivitiesRepository")
public interface ActivitiesRepository extends CrudRepository<Activities, Long>{

}
