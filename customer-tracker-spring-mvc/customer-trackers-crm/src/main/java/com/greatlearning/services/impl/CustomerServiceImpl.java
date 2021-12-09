package com.greatlearning.services.impl;

import com.greatlearning.entities.Customer;
import com.greatlearning.repositories.CustomerRepository;
import com.greatlearning.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    
	@Autowired
    private CustomerRepository customerRepository;

    private Customer getCustomerById(Integer customerId){
        return customerRepository.findById(customerId);
    }

    @Override
    public List<Customer> getAllCustomersList() {
        return customerRepository.findAll();        
    }

    @Override
    public void updateCustomer(Customer customer, Integer customerId) {

        if(customer == null || customerId ==null)
            return ;

        Customer customerAlreadyExist =  getCustomerById(customerId);

        if(customerAlreadyExist == null)
        return ;

        customerRepository.merge(customer);

    }

    @Override
    public void saveCustomer(Customer customer) {
        if(customer==null)
            return;

        if(checkIfCustomerDetailsIsNotNull(customer)) return;

        customerRepository.save(customer);

    }

    private Boolean checkIfCustomerDetailsIsNotNull(Customer customer) {
        return (customer.getFirstName().equals("") || customer.getLastName().equals("") || customer.getEmail().equals(""));

    }

    @Override
    public List<Customer> searchCustomers(String fistName, String lastName, String email) {
        List<Customer> theCustomerLists = new ArrayList<>();
        return theCustomerLists;

    }

    @Override
    public void deleteCustomer(Integer customerId) {
        Customer customerAlreadyExist =  getCustomerById(customerId);

        if(customerAlreadyExist == null)
            return ;

        customerRepository.delete(customerAlreadyExist);

    }

    @Override
    public Customer getCustomerByCustomerId(Integer customerId) {
        if(customerId == null)
            return null;
        return getCustomerById(customerId);

    }

}
