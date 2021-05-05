package de.neuefische.order_spring.controller;

import de.neuefische.order_spring.model.Product;
import de.neuefische.order_spring.service.OrderService;
import de.neuefische.order_spring.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

    ProductService productService = mock(ProductService.class);

    @Test
    public void findProductsReturnsProductsContainingMatchingStringInName(){
        // GIVEN
        when(productService.findProducts("A")).thenReturn(List.of(
                new Product("1", "Banana"),
                new Product("2", "Apple")));

        List<Product> expected = List.of(
                new Product("1", "Banana"),
                new Product("2", "Apple"));


        //WHEN
        List<Product> actual = productService.findProducts("A");

        // THEN
        assertThat(actual, is(expected));
        verify(productService).findProducts("A");
    }
}
