package com.opme.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.opme.api.entity.Cards;

@Repository("CardsRepository")
public interface CardsRepository extends CrudRepository<Cards, Long>{

}
