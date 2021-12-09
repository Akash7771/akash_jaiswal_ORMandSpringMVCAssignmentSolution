package com.greatlearning.controller;

import com.greatlearning.entities.Customer;
import com.greatlearning.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CustomerService customerService;


    @RequestMapping({"/customers-list" , "index"})
    public ModelAndView getAllCustomersList(){
        ModelAndView model = new ModelAndView();
        List<Customer> theCustomersList = customerService.getAllCustomersList();
        model.addObject("theCustomersList" , theCustomersList);
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/saveCustomerForm" , method = RequestMethod.POST)
    public String addNewCustomer(@ModelAttribute Customer customer){       
        customerService.saveCustomer(customer);
        return "redirect:/customers-list";
    }

    @RequestMapping(value = "/updateCustomerForm" , method = RequestMethod.POST)
    public String updateNewCustomer(@ModelAttribute Customer customer , @Param(value = "customerId") Integer customerId){
        customerService.updateCustomer( customer , customerId);
        return "redirect:/customers-list";
    }

    @RequestMapping(value = "/addCustomer")
    public ModelAndView addCustomerPage(){
        return new ModelAndView("add-customer");
    }

    @RequestMapping(value = "/updateCustomer")
    public ModelAndView updateCustomer(@Param(value="customerId") Integer customerId){
        System.out.println("update customer API called");
        ModelAndView model = new ModelAndView();
        model.addObject("customerId" , customerId);
        Customer theCustomer = customerService.getCustomerByCustomerId(customerId);
        model.addObject("theCustomer" , theCustomer);
        model.setViewName("edit-customer");
        return model;
    }
    @RequestMapping(value = "/deleteCustomer")
    public String deleteCustomer(@Param(value = "customerId") Integer customerId){
        customerService.deleteCustomer(customerId);
        return "redirect:customers-list";
    }
}


