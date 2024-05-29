package com.devskiller.orders;

import com.devskiller.orders.model.Customer;
import com.devskiller.orders.model.Order;
import com.devskiller.orders.model.OrderLine;
import com.devskiller.orders.model.Product;

import java.util.*;
import java.util.stream.Collectors;
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
        return orders.flatMap(o -> o.getOrderLines().stream())
                .sorted(Comparator.comparing(OrderLine::getQuantity))
                .map(OrderLine::getProduct)
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * Should return the most valuable customer, that is the customer that has the highest value of all placed orders.
     * If two customers have the same orders value, then any of them should be returned.
     *
     * @param orders orders stream
     * @return Optional of most valuable customer
     */
    public Optional<Customer> findMostValuableCustomer(Stream<Order> orders) {
        return orders.collect(Collectors.toMap(Order::getCustomer,
                order -> order.getOrderLines().stream().map(OrderLine::getProduct).mapToDouble(p -> p.getPrice().doubleValue()).sum(),
                Double::sum)).entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).map(Map.Entry::getKey).findFirst();
    }

}
