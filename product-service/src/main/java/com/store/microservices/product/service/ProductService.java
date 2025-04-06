package com.store.microservices.product.service;

import com.store.microservices.product.dto.ProductRequest;
import com.store.microservices.product.models.Product;
import com.store.microservices.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(ProductRequest productRequest) {
        Product product = new Product(
                productRequest.id(),
                productRequest.name(),
                productRequest.description(),
                productRequest.price()
        );
        productRepository.save(product);
        log.info("Product created: {}", product);

        return product;
    }
}
