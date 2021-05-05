package de.neuefische.order_spring.repository;


import de.neuefische.order_spring.model.Order;
import de.neuefische.order_spring.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepo {

    private Map<String, Order> orderMap;
    private ProductRepo productRepo;
    private int id = 1;

    public OrderRepo(){
        this.orderMap = new HashMap<>();
    }

    public Order addOrder(List<String> productList){
        List<Product> products = new ArrayList<>();
        for (String id : productList){
            products.add(productRepo.getProduct(id).get());
        }

        Order newOrder = new Order(String.valueOf(id), products);
        id++;
        return newOrder;
    }



    public List<Order> list(){
        return List.copyOf(orderMap.values());
    }

}
