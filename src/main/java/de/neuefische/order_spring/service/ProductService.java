package de.neuefische.order_spring.service;

import de.neuefische.order_spring.model.Product;
import de.neuefische.order_spring.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> listAllProducts(){
        return productRepo.list();
    }

    public List<Product> findProducts(String search){

        return productRepo.findKeyByValue(search.toLowerCase());

    }
}
