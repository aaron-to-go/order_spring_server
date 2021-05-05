package de.neuefische.order_spring.repository;

import de.neuefische.order_spring.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepo {

    private final Map<String, Product> products = new HashMap();

    public Product addProduct(Product product){
        products.put(product.getId(), product);
        return product;
    }

    public Optional<Product> getProduct(String id){
        if (products.get(id).equals(id)){
            return Optional.of(products.get(id));
        }
        return Optional.empty();
    }

    public List<Product> list(){
        return List.copyOf(products.values());
    }


}
