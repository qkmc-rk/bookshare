package xyz.rk.bookshare.controller;

import org.springframework.web.bind.annotation.*;
import xyz.rk.bookshare.model.Order;
import xyz.rk.bookshare.util.RestBean;

@RestController
@RequestMapping("/order")
public class OrderController {

    //查询我买的订单
    @GetMapping("/{userId}")
    public RestBean boughtOrder(@PathVariable int userId){
        return null;
    }

    //查询我卖的订单
    @GetMapping("/sell/{userId}")
    public RestBean soldOrder(@PathVariable int userId){
        return null;
    }
    //确认订单
    @PostMapping("/{orderId}")
    public RestBean confirmOrder(@PathVariable int orderId){
        return null;
    }
    //删除订单
    @DeleteMapping("/{orderId}")
    public RestBean deleteOrder(@PathVariable int orderId){
        return null;
    }
    //生成订单
    @PutMapping("")
    public RestBean generateOrder(@RequestBody Order order){
        return null;
    }
}
