package de.neuefische.order_spring.repository;

import de.neuefische.order_spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepo {

    private final Map<String, Product> products = new HashMap<>();;


    @Autowired
    public ProductRepo(){
        products.put("1", new Product("1", "Banana"));
        products.put("2", new Product("2", "Apple"));
        products.put("3", new Product("3", "Kiwi"));
    }

    public Product addProduct(Product product){
        products.put(product.getId(), product);
        return product;
    }

    public Optional<Product> getProduct(String id){
        if (products.containsKey(id)){
            return Optional.of(products.get(id));
        }
        return Optional.empty();
    }

    public List<Product> list(){
        return List.copyOf(products.values());
    }


}
