package com.pruebasAccenture.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pruebasAccenture.app.model.CustomerEntity;

@Repository
public interface CustomersRepository extends 
				CrudRepository<CustomerEntity, Long>{

}