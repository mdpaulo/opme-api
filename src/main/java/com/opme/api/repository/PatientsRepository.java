package com.opme.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.opme.api.entity.Patients;

@Repository("PatientsRepository")
public interface PatientsRepository extends CrudRepository<Patients, Long> {

}
