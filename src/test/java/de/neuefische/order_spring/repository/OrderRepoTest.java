package de.neuefische.order_spring.repository;


import de.neuefische.order_spring.model.Order;
import de.neuefische.order_spring.model.Product;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OrderRepoTest {

    @Test
    public void addOrderAddsAnotherOrderToTheOrderMap(){
        // GIVEN
        OrderRepo orderRepo= new OrderRepo();
        List<Product> productList= List.of(
                new Product("1", "Banana"),
                new Product("2", "Apple")
        );
        List<Order> expected = List.of(new Order(
                "1", List.of(
                        new Product("1", "Banana"),
                        new Product("2", "Apple"))
        ));

        // WHEN
        orderRepo.addOrder(productList);
        List<Order> actual = orderRepo.list();

        // THEN
        assertThat(actual, is(expected));
    }

}
