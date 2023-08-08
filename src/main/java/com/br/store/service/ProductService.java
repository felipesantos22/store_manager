package com.br.store.service;

import com.br.store.entity.Product;
import com.br.store.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product createService(Product product) {
        return productRepository.save(product);
    }

}
