package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAddressList(){
        return ResponseEntity.ok(
                new ResponseWrapper("address list successfully retrieved",addressService.getAddressList(), HttpStatus.ACCEPTED));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createAddress(@RequestBody AddressDTO address){
        return ResponseEntity.ok(
                new ResponseWrapper("address successfully created",addressService.createAddress(address),HttpStatus.ACCEPTED)
        );
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateAddress(@RequestBody AddressDTO address){
        return  ResponseEntity.ok(
                new ResponseWrapper("address updated",addressService.updateAddress(address),HttpStatus.ACCEPTED)
        );
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<ResponseWrapper> getAddressListByCustomerId(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                new ResponseWrapper("address list successfully retrieved",addressService.getAddressListByCustomerId(id), HttpStatus.ACCEPTED));
    }

    @GetMapping("/startsWith/{address}")
    public ResponseEntity<ResponseWrapper> getAddressListByStartsWithAddress(@PathVariable("address") String address) {
        return ResponseEntity.ok(
                new ResponseWrapper("address list successfully retrieved",addressService.getAddressListByStartsWithAddress(address), HttpStatus.ACCEPTED));
    }

    @GetMapping("/customer/{customerId}/name/{name}")
    public ResponseEntity<ResponseWrapper> getAddressListByCustomerAndName(@PathVariable("customerId") Long id,@PathVariable("name") String name){
        return ResponseEntity.ok(
                new ResponseWrapper("address list successfully retrieved",addressService.getAddressListByCustomerAndName(id,name), HttpStatus.ACCEPTED));
    }








}
