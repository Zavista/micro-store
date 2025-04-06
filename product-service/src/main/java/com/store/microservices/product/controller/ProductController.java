package com.store.microservices.product.controller;

import com.store.microservices.product.dto.ProductRequest;
import com.store.microservices.product.models.Product;
import com.store.microservices.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody ProductRequest productRequest){
        return productService.createProduct(productRequest);
    }
}
