/**
 * 
 */
package com.pruebasAccenture.app.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pruebasAccenture.app.model.ProductEntity;
import com.pruebasAccenture.app.repository.ProductsRepository;

/**
 * @author alejocampo
 *
 */

@Service
public class ProductService {

	@Autowired
	private ProductsRepository productsRepository;

	public List<ProductEntity> getAllProducts() {
		List<ProductEntity> result;
		result = (List<ProductEntity>) productsRepository.findAll();
		if (result.size() > 0) {
			return result;
		}
		return new ArrayList<ProductEntity>();
	}
}
