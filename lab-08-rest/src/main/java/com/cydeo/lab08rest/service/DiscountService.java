package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.DiscountDTO;

import java.util.List;

public interface DiscountService {

    List<DiscountDTO> getDiscountList();
    DiscountDTO getDiscountListByName(String discountName);
    DiscountDTO  createDiscount(DiscountDTO discount);
    DiscountDTO updateDiscount(DiscountDTO discount);
}
