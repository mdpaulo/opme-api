package com.opme.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.opme.api.entity.Bill;

@Repository("BillRepository")
public interface BillRepository extends CrudRepository<Bill, Integer>{

}
