package de.neuefische.order_spring.controller;

import de.neuefische.order_spring.model.Order;
import de.neuefische.order_spring.model.Product;
import de.neuefische.order_spring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
//        List<String> idList = new ArrayList<>(List.of(
//                "1", "2", "3"
//        ));
//        orderService.addOrder(idList);
    }

    @PostMapping
    public Order addOrder(@RequestBody List<String> productList){
        return orderService.addOrder(productList);
    }

    @GetMapping("orders")
    public List<Order> listAllOrders(){
        return orderService.listAllOrders();
    }

    @GetMapping("products")
    public List<Product> listAllProducts(){
        return orderService.listAllProducts();
    }

    //@GetMapping



}
