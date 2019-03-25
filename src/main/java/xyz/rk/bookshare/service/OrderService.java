package xyz.rk.bookshare.service;

import xyz.rk.bookshare.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> myBoughtOrder(int solderId);

    List<Order> mySoldOrder(int userId);

    boolean confirmBuy(Order order);

    boolean confirmSell(Order order);

    boolean deleteOrder(int orderId);
}
