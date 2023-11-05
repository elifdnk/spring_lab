package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
   List<CustomerDTO> getCustomerList();
    CustomerDTO getCustomerListByEmail(String email);
    CustomerDTO createCustomer(CustomerDTO customer);
    CustomerDTO updateCustomer(CustomerDTO customer);
}
