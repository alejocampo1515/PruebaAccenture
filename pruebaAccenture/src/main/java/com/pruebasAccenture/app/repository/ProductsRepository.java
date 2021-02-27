package com.pruebasAccenture.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pruebasAccenture.app.model.ProductEntity;


@Repository
public interface ProductsRepository extends 
				CrudRepository<ProductEntity, Long>{

}