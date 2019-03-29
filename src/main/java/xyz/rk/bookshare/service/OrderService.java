package xyz.rk.bookshare.service;

import xyz.rk.bookshare.bean.OrderBean;
import xyz.rk.bookshare.model.Order;

import java.util.List;

public interface OrderService {

    List<OrderBean> myBoughtOrder(int userId);

    List<OrderBean> mySoldOrder(int userId);

    boolean deleteOrder(int orderId);

    boolean confirm(int orderId, int userId);

    boolean generateOrder(Order order);
}
