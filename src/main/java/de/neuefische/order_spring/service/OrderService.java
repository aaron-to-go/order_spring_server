package de.neuefische.order_spring.service;

import de.neuefische.order_spring.model.Order;
import de.neuefische.order_spring.model.Product;
import de.neuefische.order_spring.repository.OrderRepo;
import de.neuefische.order_spring.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class OrderService {


    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    @Autowired
    public OrderService(ProductRepo productRepo, OrderRepo orderRepo){
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }


    public Order addOrder(List<String> productList){

        List<Product> products = new ArrayList<>();
        for (String id : productList){
            products.add(productRepo.getProduct(id).get());
        }

        return orderRepo.addOrder(products);
    }

    public List<Product> listAllProducts(){
        return productRepo.list();
    }

    public List<Order> listAllOrders(){
        return orderRepo.list();
    }

    public List<Product> findProducts(String search){

        return productRepo.findKeyByValue(search.toLowerCase());

    }

}
