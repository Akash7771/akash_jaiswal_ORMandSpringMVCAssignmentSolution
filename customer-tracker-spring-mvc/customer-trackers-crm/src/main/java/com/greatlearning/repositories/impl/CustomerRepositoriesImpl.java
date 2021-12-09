package com.greatlearning.repositories.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.config.EntityManagementUtil;
import com.greatlearning.entities.Customer;
import com.greatlearning.repositories.CustomerRepository;

@Repository
public class CustomerRepositoriesImpl implements CustomerRepository{
	
	@Autowired
	EntityManagementUtil entityManager; 
	
	@Override
	public Customer findById(Integer customerId) {
		return (Customer) entityManager.getSession().createQuery("from Customer where customerId =:customerId").setParameter("customerId",customerId).uniqueResult();		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAll() {		
		return entityManager.getSession().createQuery("from Customer").list();
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		Transaction transaction = entityManager.getSession().beginTransaction();
		entityManager.getSession().saveOrUpdate(customer);		
		transaction.commit();		
	}

	@Override
	@Transactional
	public void merge(Customer customer) {
		Transaction transaction = entityManager.getSession().beginTransaction();				
		entityManager.getSession().merge(customer);
		entityManager.getSession().flush();
		transaction.commit();		
	}

	@Override
	@Transactional
	public void delete(Customer customer) {
		Transaction transaction = entityManager.getSession().beginTransaction();
		entityManager.getSession().delete(customer);
		transaction.commit();
		
	}

}
