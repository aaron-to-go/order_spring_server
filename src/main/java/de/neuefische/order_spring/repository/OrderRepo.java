package de.neuefische.order_spring.repository;


import de.neuefische.order_spring.model.Order;
import de.neuefische.order_spring.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepo {

    private final Map<String, Order> orderMap;
    private final ProductRepo productRepo = new ProductRepo();
    private int id = 1;

    public OrderRepo(){
        this.orderMap = new HashMap<>();

    }

    public Order addOrder(List<Product> productList){

        Order newOrder = new Order(String.valueOf(id), productList);

        return newOrder;
    }



    public List<Order> list(){
        return List.copyOf(orderMap.values());
    }

}
