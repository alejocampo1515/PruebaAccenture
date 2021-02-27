package com.pruebasAccenture.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pruebasAccenture.app.model.ProductEntity;
import com.pruebasAccenture.app.service.ProductService;



@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = {""}, method = RequestMethod.GET)
	public ResponseEntity<List<ProductEntity>> getAllProducts() {
		return new ResponseEntity<List<ProductEntity>>(productService.getAllProducts(), HttpStatus.OK);
		
	}

}
