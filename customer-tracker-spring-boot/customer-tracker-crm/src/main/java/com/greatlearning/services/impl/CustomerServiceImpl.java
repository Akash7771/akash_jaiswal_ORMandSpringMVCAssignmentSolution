package com.greatlearning.services.impl;

import com.greatlearning.entities.Customer;
import com.greatlearning.repositories.CustomerRepository;
import com.greatlearning.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    private Customer getCustomerById(Integer customerId){
        Optional<Customer> theCustomer =  customerRepository.findById(customerId);

        return theCustomer.orElse(null);

    }

    @Override
    public List<Customer> getAllCustomersList() {
        List<Customer> theCustomerList = new ArrayList<>();
        Iterable<Customer> customerIterable =  customerRepository.findAll();
        customerIterable.forEach(theCustomerList::add);

        return theCustomerList;
    }

    @Override
    public void updateCustomer(Customer customer, Integer customerId) {

        if(customer == null || customerId ==null)
            return ;

        Customer customerAlreadyExist =  getCustomerById(customerId);

        if(customerAlreadyExist == null)
        return ;

        customerRepository.save(customer);

    }

    @Override
    @Transactional
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
        //todo : implement
        return theCustomerLists;

    }

    @Override
    @Transactional
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
