package com.greatlearning.services;

import com.greatlearning.entities.Customer;
import java.util.List;

public interface CustomerService {
    public List<Customer> getAllCustomersList();
    public void updateCustomer(Customer customer , Integer customerId);
    public void saveCustomer(Customer customer);
    public List<Customer> searchCustomers(String fistName , String lastName , String email);
    public void deleteCustomer(Integer customerId);
    public Customer getCustomerByCustomerId(Integer customerId);
}
