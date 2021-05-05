package de.neuefische.order_spring.service;

import de.neuefische.order_spring.model.Order;
import de.neuefische.order_spring.model.Product;
import de.neuefische.order_spring.repository.OrderRepo;
import de.neuefische.order_spring.repository.ProductRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

public class OrderServiceTest {

    @Mock
    OrderRepo orderRepo = mock(OrderRepo.class);
    ProductRepo productRepo = mock(ProductRepo.class);

    @Test
    public void addMethodShouldAddAnotherOrderToRepo(){
        // GIVEN
        when(orderRepo.addOrder(List.of(
                new Product("1", "Banana"),
                new Product("2", "Apple")
        ))).thenReturn(new Order("1", List.of(
                new Product("1", "Banana"),
                new Product("2", "Apple"))));

        // WHEN
        Order actual = orderRepo.addOrder(List.of(
                new Product("1", "Banana"),
                new Product("2", "Apple")));

        // THEN
        Order expected = new Order("1", List.of(
                new Product("1", "Banana"),
                new Product("2", "Apple")));

        assertThat(actual, is(expected));
        verify(orderRepo).addOrder(List.of(
                new Product("1", "Banana"),
                new Product("2", "Apple")));
    }

    @Test
    public void listMethodReturnsListOfOrders(){
        // GIVEN
        when(orderRepo.list()).thenReturn(List.of(
                new Order("1", List.of(
                        new Product("1", "Banana"),
                        new Product("2", "Apple")
                )))
        );

        List<Order> expected = List.of(new Order("1", List.of(
                new Product("1", "Banana"),
                new Product("2", "Apple"))));

        // WHEN
        List<Order> actual = orderRepo.list();

        // THEN
        assertThat(actual, is(expected));
        verify(orderRepo).list();
    }

    @Test
    public void findProductsReturnsProductsContainingMatchingStringInName(){
        // GIVEN
        when(productRepo.findKeyByValue("A")).thenReturn(List.of(
                new Product("1", "Banana"),
                new Product("2", "Apple")));

        List<Product> expected = List.of(
                new Product("1", "Banana"),
                new Product("2", "Apple"));


        //WHEN
        List<Product> actual = productRepo.findKeyByValue("A");

        // THEN
        assertThat(actual, is(expected));
        verify(productRepo).findKeyByValue("A");
    }
}
