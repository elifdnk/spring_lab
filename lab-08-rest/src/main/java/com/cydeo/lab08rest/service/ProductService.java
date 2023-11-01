package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

   List <ProductDTO> getAllProducts();
   ProductDTO createProduct(ProductDTO product);
   ProductDTO updateProduct(ProductDTO product);
}
