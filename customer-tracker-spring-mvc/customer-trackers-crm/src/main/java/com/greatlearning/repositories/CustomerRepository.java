package com.greatlearning.repositories;

import org.springframework.stereotype.Service;
import com.greatlearning.entities.Customer;
import java.util.List;


@Service
public interface CustomerRepository {
	public Customer findById(Integer customerId);
	public List<Customer> findAll();
	public void save(Customer customer);
	public void merge(Customer customer);
	public void delete(Customer customer);
	
}
