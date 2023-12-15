package com.cydeo.converter;//package com.cydeo.lab08rest.converter;
//
//import com.cydeo.lab08rest.dto.CustomerDTO;
//import com.cydeo.lab08rest.service.CustomerService;
//import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//
//@Component
//@ConfigurationPropertiesBinding
//public class CustomerConverter implements Converter<Long, CustomerDTO> {
//
//    private CustomerService customerService;
//
//    public CustomerConverter(CustomerService customerService) {
//        this.customerService = customerService;
//    }
//
//    @Override
//    public CustomerDTO convert(Long customerId) {
//
//        return customerService.readById(customerId);
//
//    }
//
//}
