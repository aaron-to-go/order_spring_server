package de.neuefische.order_spring.controller;

import de.neuefische.order_spring.model.Product;
import de.neuefische.order_spring.service.OrderService;
import de.neuefische.order_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {

    private final OrderService orderService;
    private final ProductService productService;

    @Autowired
    public ProductController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }


    @GetMapping
    public List<Product> findProducts(@RequestParam Optional<String> search){
        if (search.isPresent() && !search.get().isBlank()) {
            return productService.findProducts(search.get());
        }
        return productService.listAllProducts();
    }

}
