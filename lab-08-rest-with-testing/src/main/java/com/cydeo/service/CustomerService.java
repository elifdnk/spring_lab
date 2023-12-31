package com.cydeo.service;

import com.cydeo.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO findById(Long customerId);
    boolean existById(Long customerId);
    List<CustomerDTO> readAll();
    CustomerDTO update(CustomerDTO customerDTO);
    CustomerDTO create(CustomerDTO customerDTO);
    CustomerDTO readByEmail(String email);

}
