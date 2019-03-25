package xyz.rk.bookshare.service.impl;

import org.springframework.stereotype.Service;
import xyz.rk.bookshare.model.Order;
import xyz.rk.bookshare.service.OrderService;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> myBoughtOrder(int solderId) {
        return null;
    }

    @Override
    public List<Order> mySoldOrder(int userId) {
        return null;
    }

    @Override
    public boolean confirmBuy(Order order) {
        return false;
    }

    @Override
    public boolean confirmSell(Order order) {
        return false;
    }

    @Override
    public boolean deleteOrder(int orderId) {
        return false;
    }
}
