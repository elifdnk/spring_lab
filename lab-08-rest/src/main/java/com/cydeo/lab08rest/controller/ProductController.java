package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                .status(HttpStatus.ACCEPTED)
                .body(new ResponseWrapper("string",productService.getAllProducts(),HttpStatus.ACCEPTED));
    }

//    @PostMapping
//    public ResponseEntity<ResponseWrapper> createProduct(@RequestBody ProductDTO product){
//
//
//    }


}
