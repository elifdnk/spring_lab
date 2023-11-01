package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.entity.Product;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.ProductRepository;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final MapperUtil mapperUtil;

    public ProductServiceImpl(ProductRepository productRepository, MapperUtil mapperUtil) {
        this.productRepository = productRepository;
        this.mapperUtil = mapperUtil;
    }


    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> mapperUtil.convert(product,new ProductDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO createProduct(ProductDTO product) {
         productRepository.save(mapperUtil.convert(product,new Product()));
        return product;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO product) {
       Product foundProduct = productRepository.findById(product.getId()).orElseThrow();
       Product convertProduct = mapperUtil.convert(product,new Product());
       convertProduct.setId(foundProduct.getId());
       productRepository.save(convertProduct);
       return product;
    }
}
