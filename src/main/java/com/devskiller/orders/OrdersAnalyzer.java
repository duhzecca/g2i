package com.devskiller.orders;

import com.devskiller.orders.model.Customer;
import com.devskiller.orders.model.Order;
import com.devskiller.orders.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OrdersAnalyzer {

    /**
     * Should return at most three most popular products. Most popular product is the product that have the most occurrences
     * in given orders (ignoring product quantity).
     * If two products have the same popularity, then products should be ordered by name
     *
     * @param orders orders stream
     * @return list with up to three most popular products
     */
    public List<Product> findThreeMostPopularProducts(Stream<Order> orders) {
        // TODO: Implement this method
        return null;
    }

    /**
     * Should return the most valuable customer, that is the customer that has the highest value of all placed orders.
     * If two customers have the same orders value, then any of them should be returned.
     *
     * @param orders orders stream
     * @return Optional of most valuable customer
     */
    public Optional<Customer> findMostValuableCustomer(Stream<Order> orders) {
        // TODO: Implement this method
        return null;
    }

}
