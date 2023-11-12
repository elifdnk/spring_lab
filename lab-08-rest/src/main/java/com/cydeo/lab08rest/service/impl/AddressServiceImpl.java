package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.exception.AddressNotFoundException;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.AddressRepository;
import com.cydeo.lab08rest.repository.CustomerRepository;
import com.cydeo.lab08rest.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;
    private final CustomerRepository customerRepository;

    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil, CustomerRepository customerRepository) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
        this.customerRepository = customerRepository;
    }


    @Override
    public List<AddressDTO> getAddressList() {
        return addressRepository.findAll().stream().map(address ->mapperUtil.convert(address,new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO) {

        Address  addressToSave = mapperUtil.convert(addressDTO,new Address());
         Address savedAddress = addressRepository.save(addressToSave);
         return mapperUtil.convert(savedAddress,new AddressDTO());
    }

    @Override
    public AddressDTO updateAddress(AddressDTO addressDTO) {
    Address foundAddress = addressRepository.findById(addressDTO.getId())
            .orElseThrow(()->new AddressNotFoundException("Address not found"));
    Address addressToUpdate = mapperUtil.convert(addressDTO,new Address());
    addressToUpdate.setId(foundAddress.getId());
    Address updatedAddress = addressRepository.save(addressToUpdate);
return mapperUtil.convert(updatedAddress,new AddressDTO());
    }

    @Override
    public List<AddressDTO> getAddressListByCustomerId(Long id) {
       return addressRepository.retrieveByCustomerId(id).stream().map(address -> mapperUtil.convert(address,new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> getAddressListByStartsWithAddress(String address) {
       return   addressRepository.findAllByStreetStartingWith(address).stream().map(address1 -> mapperUtil.convert(address,new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> getAddressListByCustomerAndName(Long id, String name) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        List<Address> addresses = addressRepository.findAllByCustomerAndName(customer,name);
        return addresses.stream()
                .map(address -> mapperUtil.convert(address,new AddressDTO()))
                .collect(Collectors.toList());





    }
}
