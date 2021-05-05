package de.neuefische.order_spring.controller;

import de.neuefische.order_spring.model.Order;
import de.neuefische.order_spring.model.Product;
import de.neuefische.order_spring.repository.OrderRepo;
import de.neuefische.order_spring.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

public class OrderControllerTest {

    @Mock
    OrderService orderService = mock(OrderService.class);

    @Test
    public void addMethodShouldAddAnotherOrderToService(){
        // GIVEN
        when(orderService.addOrder(List.of(
                "1", "2"
        ))).thenReturn(new Order("1", List.of(
                new Product("1", "Banana"),
                new Product("2", "Apple"))));

        // WHEN
        Order actual = orderService.addOrder(List.of(
                "1", "2"));

        // THEN
        Order expected = new Order("1", List.of(
                new Product("1", "Banana"),
                new Product("2", "Apple")));

        assertThat(actual, is(expected));
        verify(orderService).addOrder(List.of(
                "1", "2"));
    }

    @Test
    public void listMethodReturnsListOfOrders(){
        // GIVEN
        when(orderService.listAllOrders()).thenReturn(List.of(
                new Order("1", List.of(
                        new Product("1", "Banana"),
                        new Product("2", "Apple")
                )))
        );

        List<Order> expected = List.of(new Order("1", List.of(
                new Product("1", "Banana"),
                new Product("2", "Apple"))));

        // WHEN
        List<Order> actual = orderService.listAllOrders();

        // THEN
        assertThat(actual, is(expected));
        verify(orderService).listAllOrders();

    }




}
