package xyz.rk.bookshare.bean;

import xyz.rk.bookshare.model.Book;
import xyz.rk.bookshare.model.Catalog;
import xyz.rk.bookshare.model.Order;
import xyz.rk.bookshare.model.User;

/**
 * 该类封装订单的详细信息
 * 订单id，订单号，卖家信息，图书信息等。
 */
public class OrderBean {

    //订单信息
    private Order order;
    //书的信息
    private Book book;
    //卖家
    private User seller;
    //买家
    private User buyer;

    private Catalog catalog;

    public Catalog getCatalog() {
        return catalog;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
