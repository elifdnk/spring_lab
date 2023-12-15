package com.cydeo.service;

import com.cydeo.dto.DiscountDTO;

import java.util.List;

public interface DiscountService {

    List<DiscountDTO> readAll();
    DiscountDTO update(DiscountDTO discountDTO);
    DiscountDTO create(DiscountDTO discountDTO);
    DiscountDTO readByName(String name);

}
