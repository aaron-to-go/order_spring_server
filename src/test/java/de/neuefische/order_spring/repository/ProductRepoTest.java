package de.neuefische.order_spring.repository;

import de.neuefische.order_spring.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductRepoTest {


    @Test
    public void getProductTest(){
        //GIVEN
        ProductRepo productRepo = new ProductRepo();
        String id = "2";

        //WHEN
        Product actual = productRepo.getProduct(id).get();

        //THEN
        Product expected = new Product("2", "Apple");

        assertEquals(actual, expected);
    }

    @Test
    public void findKeyByValueTest(){
        //GIVEN
        ProductRepo productRepo = new ProductRepo();
        String search = "A";

        //WHEN
        List<Product> actual = productRepo.findKeyByValue(search.toLowerCase());

        //THEN
        List<Product> expected = List.of(
                new Product("1", "Banana"),
                new Product("2", "Apple"));

        assertEquals(expected, actual);
    }
}
