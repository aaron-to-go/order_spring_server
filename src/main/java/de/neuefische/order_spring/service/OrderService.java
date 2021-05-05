package de.neuefische.order_spring.service;

import de.neuefische.order_spring.model.Order;
import de.neuefische.order_spring.model.Product;
import de.neuefische.order_spring.repository.OrderRepo;
import de.neuefische.order_spring.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
            if(productRepo.getProduct(id).isPresent()) {
                products.add(productRepo.getProduct(id).get());
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No product with this id, idiot");
            }
        }

        return orderRepo.addOrder(products);
    }

    public List<Order> listAllOrders(){
        return orderRepo.list();
    }


}
