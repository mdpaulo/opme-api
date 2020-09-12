package com.opme.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.opme.api.entity.HealthInsurance;

@Repository("HealthInsuranceRepository")
public interface HealthInsuranceRepository  extends CrudRepository<HealthInsurance, Integer>{

}
