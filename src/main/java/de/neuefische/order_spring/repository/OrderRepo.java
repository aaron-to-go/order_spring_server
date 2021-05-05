package de.neuefische.order_spring.repository;


import de.neuefische.order_spring.model.Order;
import de.neuefische.order_spring.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepo {

    private Map<String, Order> orderMap = new HashMap<>();
    private int id = 1;

    public Order addOrder(List<Product> productList){

        Order newOrder = new Order(String.valueOf(id), productList);
        id++;
        return newOrder;
    }

    public List<Order> list(){
        return List.copyOf(orderMap.values());
    }

}
