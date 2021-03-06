/**
 * 
 */
package com.pruebasAccenture.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pruebasAccenture.app.exception.RecordNotFoundException;
import com.pruebasAccenture.app.model.CustomerEntity;
import com.pruebasAccenture.app.repository.CustomersRepository;

/**
 * @author alejocampo
 *
 */

@Service
public class CustomerService {

	@Autowired
	private CustomersRepository customersRepository;

	public List<CustomerEntity> getAllCustomers() {
		List<CustomerEntity> result;
		result = (List<CustomerEntity>) customersRepository.findAll();
		if (result.size() > 0) {
			return result;
		}
		return new ArrayList<CustomerEntity>();
	}

	public CustomerEntity getCustomerById(Long id) throws RecordNotFoundException {
		Optional<CustomerEntity> customer = customersRepository.findById(id);
		if (customer.isPresent()) {
			return customer.get();
		}
		return new CustomerEntity();
	}

	public CustomerEntity createOrUpdateCustomer(CustomerEntity customer) {
		Long id = customer.getId();
		if (id == null) {
			customer = customersRepository.save(customer);
			return customer;
		}

		Optional<CustomerEntity> currentCustomer = customersRepository.findById(id);
		if (currentCustomer.isPresent()) {
			CustomerEntity newCustomer = currentCustomer.get();
			newCustomer.setIdentification(customer.getAddress());
			newCustomer.setFirstName(customer.getFirstName());
			newCustomer.setLastName(customer.getLastName());
			newCustomer.setAddress(customer.getAddress());
			newCustomer = customersRepository.save(customer);
			return newCustomer;
		} else {
			customer = customersRepository.save(customer);
			return customer;

		}

	}

	public void deleteCustomerById(Long id) throws RecordNotFoundException {
		Optional<CustomerEntity> customer = customersRepository.findById(id);
		if (customer.isPresent()) {
			customersRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No existe cliente");
		}
	}

}
