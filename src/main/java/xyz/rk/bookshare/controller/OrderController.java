package xyz.rk.bookshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.rk.bookshare.bean.OrderBean;
import xyz.rk.bookshare.model.Order;
import xyz.rk.bookshare.model.Token;
import xyz.rk.bookshare.model.User;
import xyz.rk.bookshare.service.BookService;
import xyz.rk.bookshare.service.OrderService;
import xyz.rk.bookshare.service.UserService;
import xyz.rk.bookshare.util.RestBean;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    //查询我买的订单
    @GetMapping("/{userId}")
    public RestBean boughtOrder(@PathVariable int userId){
        List<OrderBean> orders = orderService.myBoughtOrder(userId);
        if (null != orders)
            return RestBean.success(orders, "successfully find add buy orders");
        return RestBean.commonError("no buy orders find");
    }

    //查询我卖的订单
    @GetMapping("/sell/{userId}")
    public RestBean soldOrder(@PathVariable int userId){
        List<OrderBean> orders = orderService.mySoldOrder(userId);
        if (null != orders)
            return RestBean.success(orders, "successfully find add sold orders");
        return RestBean.commonError("no sold orders find");
    }
    //确认订单
    @PostMapping("/{orderId}")
    public RestBean confirmOrder(@PathVariable int orderId, HttpServletRequest request){
        String tokenStr = request.getHeader("token");
        Token token = userService.getByToken(tokenStr);
        Integer userId = token.getUserid();

        boolean rs =orderService.confirm(orderId,userId);
        if (rs)
            return RestBean.success(null, "successfully updated the order");
        return RestBean.commonError("failed to update the order");
    }
    //删除订单
    @DeleteMapping("/{orderId}")
    public RestBean deleteOrder(@PathVariable int orderId) {
        boolean rs = orderService.deleteOrder(orderId);
        if (rs)
            return RestBean.success(null, "delete order successfully");
        return RestBean.commonError("delete the order failed!!");
}
    //生成订单
    @PutMapping("")
    public RestBean generateOrder(Order order,HttpServletRequest request){
        //第一步，获取
        String tokenStr = request.getHeader("token");

        Token token = userService.getByToken(tokenStr);
        Integer userid = token.getUserid();
        order.setUserid(userid);
        order.setCreatetime(new Date());
        order.setStatus(0);
        boolean rs = orderService.generateOrder(order);
        if (rs)
            return  RestBean.success(null, "success");
        return RestBean.serverError(null, "sorry but failed to generate order");
    }
}
