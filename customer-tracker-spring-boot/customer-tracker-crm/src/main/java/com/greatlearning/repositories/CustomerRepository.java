package com.greatlearning.repositories;

import com.greatlearning.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer , Integer> {

}
