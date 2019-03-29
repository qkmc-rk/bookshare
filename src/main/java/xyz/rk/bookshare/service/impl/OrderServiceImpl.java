package xyz.rk.bookshare.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.rk.bookshare.bean.OrderBean;
import xyz.rk.bookshare.dao.CatalogMapper;
import xyz.rk.bookshare.dao.OrderMapper;
import xyz.rk.bookshare.model.Book;
import xyz.rk.bookshare.model.Catalog;
import xyz.rk.bookshare.model.Order;
import xyz.rk.bookshare.model.User;
import xyz.rk.bookshare.service.BookService;
import xyz.rk.bookshare.service.OrderService;
import xyz.rk.bookshare.service.UserService;
import xyz.rk.bookshare.util.UserUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    CatalogMapper catalogMapper;

    @Resource
    OrderMapper orderMapper;

    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    @Override
    public List<OrderBean> myBoughtOrder(int userId) {
        //新建一个order bean
        List<OrderBean> orderBeans = new ArrayList<>();

        OrderBean orderBean;
        User seller;
        Book book;
        Catalog catalog;

        List<Order> orders;

        //1.查询所有订单
        try {
            //用户此时作为买家，查询订单
            orders = orderMapper.selectByUserId(userId);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("sorry but cant find the user's buy orders");
            return null;
        }
        //遍历每一订单，并找到订单中的其它信息，放入list
        Integer bookId;
        Integer sellerId;
        Integer catalogId;
        for (Order order:orders) {
            //通过order找到user和book
            sellerId = order.getSellerid();
            bookId = order.getBookid();
            //System.out.println(userService.getById(sellerId) + "," + bookService);
            //查询卖家和书本
            seller = userService.getById(sellerId);
            book = bookService.getById(bookId);
            //找书本的分类
            catalogId = book.getCatalogid();
            catalog = catalogMapper.selectByPrimaryKey(catalogId);

            //对敏感字段进行去除
            seller = UserUtil.wipeSecInfo(seller);

            orderBean = new OrderBean();
            orderBean.setBook(book);
            orderBean.setOrder(order);
            orderBean.setSeller(seller);
            orderBean.setCatalog(catalog);

            orderBeans.add(orderBean);
        }
        //返回订单信息
        return orderBeans;
    }

    @Override
    public List<OrderBean> mySoldOrder(int userId) {
        //新建一个order bean
        List<OrderBean> orderBeans = new ArrayList<>();
        List<Order> orders;

        OrderBean orderBean;
        User buyer;
        Book book;
        Catalog catalog;

        //1.查询所有订单
        try {
            //用户此时作为卖家，查询订单
            orders = orderMapper.selectBySellerId(userId);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("sorry but cant find the user's sell orders");
            return null;
        }
        //遍历每一订单，并找到订单中的其它信息，放入list
        Integer bookId;
        Integer buyerId;
        Integer catalogId;
        for (Order order:orders) {
            //通过order找到user和book
            bookId = order.getBookid();
            buyerId = order.getUserid();

            //System.out.println(userService.getById(sellerId) + "," + bookService);
            //查询卖家和书本
            buyer = userService.getById(buyerId);
            book = bookService.getById(bookId);
            //找书本的分类
            catalogId = book.getCatalogid();
            catalog = catalogMapper.selectByPrimaryKey(catalogId);

            //去除敏感信息
            buyer = UserUtil.wipeSecInfo(buyer);

            orderBean = new OrderBean();
            orderBean.setBook(book);
            orderBean.setOrder(order);
            orderBean.setBuyer(buyer);
            orderBean.setCatalog(catalog);

            orderBeans.add(orderBean);
        }
        //返回订单信息
        return orderBeans;
    }

    @Override
    public boolean deleteOrder(int orderId) {
        int rs = 0;
        try {
            rs = orderMapper.deleteByPrimaryKey(orderId);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("sorry but failed to delete the order");
        }
        if (rs > 0)
            return true;
        return false;
    }

    @Override
    public boolean confirm(int orderId, int userId) {
        Order order;
        try {
            order = orderMapper.selectByPrimaryKey(orderId);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("cant find the order");
            return false;
        }
        Integer status = order.getStatus();
        Integer userid = order.getUserid();
        Integer newStautus = status;

        if(userId == userid){
            //买家
            switch (status){
                case 0:
                    newStautus = 10;
                    break;
                case 1:
                    newStautus = 11;
                    break;
                case 10:
                    newStautus = status;
                    break;
                case 11:
                    newStautus = status;
                    break;
            }
        }else{
            //卖家
            switch (status){
                case 0:
                    newStautus = 1;
                    break;
                case 1:
                    newStautus = status;
                    break;
                case 10:
                    newStautus = 11;
                    break;
                case 11:
                    newStautus = status;
                    break;
            }
        }
        //重新更新
        order.setStatus(newStautus);
        int rs = 0;
        try {
            rs = orderMapper.updateByPrimaryKey(order);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("hello update order failed");
        }
        if (rs > 0)
            return true;
        return false;
    }

    @Override
    public boolean generateOrder(Order order) {
        int rs = 0;
        try {
            rs = orderMapper.insert(order);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("sorry but generate order failed");
        }
        if (rs > 0)
            return true;
        return false;
    }


}
