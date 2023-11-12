package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.dto.ProductRequest;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public ResponseEntity<ResponseWrapper> getProductList(){

        return ResponseEntity
                .ok(
               new ResponseWrapper("products are successfully retrieved",productService.getAllProducts(),HttpStatus.ACCEPTED));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateProduct(@RequestBody ProductDTO product){

        return ResponseEntity
                .ok(new ResponseWrapper("Product is updated",productService.updateProduct(product),HttpStatus.CREATED));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createProduct(@RequestBody ProductDTO product){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseWrapper("Product created!",productService.createProduct(product),HttpStatus.OK));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> getProductListByName(@PathVariable("name") String name){
        return ResponseEntity
                .ok(new ResponseWrapper("Project is successfully retrieved",productService.findByProductName(name),HttpStatus.OK));
    }

    @GetMapping("/top3")
    public ResponseEntity<ResponseWrapper> getTop3ProductList(){
        return ResponseEntity
                .ok(new ResponseWrapper("Products are successfully retrieved",productService.findTop3(),HttpStatus.ACCEPTED));
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<ResponseWrapper> getProductListByPrice(@PathVariable("price")BigDecimal price){
        return ResponseEntity
                .ok(new ResponseWrapper("Products are successfully retrieved",productService.countProductByPriceGreaterThan(price),HttpStatus.ACCEPTED));
    }


    @PostMapping("/categoryandprice")
    public ResponseEntity<ResponseWrapper> getAllByCategoriesAndPrice(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(ResponseWrapper.builder()
                .code(200)
                .success(true)
                .message("Products are retrieved successfully.")
                .data(productService.readAllByCategoriesAndPrice(productRequest))
                .build());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<ResponseWrapper> getProductListByCategory(@PathVariable("id") Long id){
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved",
                productService.getProductsByCategory(id),HttpStatus.OK));
    }



}
