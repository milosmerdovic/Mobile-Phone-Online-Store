package com.test.demo.service;

import java.util.List;

import com.test.demo.entity.Product;
import com.test.demo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void edit(Long id, Product product) {
        Product found = productRepository.getOne(id);
        found.setName(product.getName());
        found.setPrice(product.getPrice());
        save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllByOrderByIdAsc() {
        return productRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Long count() {
        return productRepository.count();
    }

    @Override
    public Product findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}