package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.entity.Discount;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.DiscountRepository;
import com.cydeo.lab08rest.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;
    private final MapperUtil mapperUtil;


    public DiscountServiceImpl(DiscountRepository discountRepository, MapperUtil mapperUtil) {
        this.discountRepository = discountRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<DiscountDTO> getDiscountList() {
        return discountRepository.findAll().stream()
                .map(discount -> mapperUtil.convert(discount, new DiscountDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public DiscountDTO getDiscountListByName(String discountName) {

        Discount discount = discountRepository.findFirstByName(discountName);
        return mapperUtil.convert(discount, new DiscountDTO());


    }

    @Override
    public DiscountDTO createDiscount(DiscountDTO discount) {
        discountRepository.save(mapperUtil.convert(discount, new Discount()));
        return discount;
    }

    @Override
    public DiscountDTO updateDiscount(DiscountDTO discount) {

        discountRepository.save(mapperUtil.convert(discount,new Discount()));

        return discount;
    }
}
