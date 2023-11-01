package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


public interface ProductService {

   List <ProductDTO> getAllProducts();
   ProductDTO createProduct(ProductDTO product);
   ProductDTO updateProduct(ProductDTO product);

   ProductDTO findByProductName(String name);

   List<ProductDTO> findTop3();
   Integer countProductByPriceGreaterThan(BigDecimal price);

   List<ProductDTO> listProductByPriceAndQuantity(BigDecimal price,Integer quantity);

   List<ProductDTO> getProductsByCategory(Long id);

}
