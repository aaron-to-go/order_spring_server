package de.neuefische.order_spring.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

    private String id;
    private List<Product> orderedProducts = new ArrayList<>();

    public Order(String id, List<Product> orderedProducts){
        this.id = id;
        this.orderedProducts = orderedProducts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<Product> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(orderedProducts, order.orderedProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderedProducts);
    }
}
