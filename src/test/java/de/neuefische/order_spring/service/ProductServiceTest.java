package de.neuefische.order_spring.service;

import de.neuefische.order_spring.model.Product;
import de.neuefische.order_spring.repository.ProductRepo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    ProductRepo productRepo = mock(ProductRepo.class);

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
