package de.neuefische.order_spring.service;

import de.neuefische.order_spring.model.Order;
import de.neuefische.order_spring.model.Product;
import de.neuefische.order_spring.repository.OrderRepo;
import de.neuefische.order_spring.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {


    private ProductRepo productRepo;
    private OrderRepo orderRepo;


    public Order addOrder(List<Product> productList){
        return orderRepo.addOrder(productList);
    }

    public List<Product> listAllProducts(){
        return productRepo.list();
    }

    public List<Order> listAllOrders(){
        return orderRepo.list();
    }

}
