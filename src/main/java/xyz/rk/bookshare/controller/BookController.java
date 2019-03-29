package xyz.rk.bookshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.rk.bookshare.model.Book;
import xyz.rk.bookshare.model.Token;
import xyz.rk.bookshare.service.BookService;
import xyz.rk.bookshare.service.UserService;
import xyz.rk.bookshare.util.RestBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    //获取所有书
    @GetMapping("")
    public RestBean getAll(@RequestParam(required = false) Integer catalogid){
        //若传入了catalogId，则只返回该类的书籍
        List<Book> books = bookService.getAll();
        if (null != books)
            return RestBean.success(books, "success find all books");
        return RestBean.serverError(null, "failed to find all books");
    }

    @DeleteMapping("/{id}")
    public RestBean deleteOne(@PathVariable int id){
        boolean rs = false;
        rs = bookService.deleteOneBookById(id);

        if (rs)
            return RestBean.success(null,  "successfully deleted one book");
        //通过判断rs是否删除成功
        return RestBean.serverError(null, "delete one book failed");
    }


    @GetMapping("/{id}")
    public RestBean detail(@PathVariable int id){
       Book book = bookService.getById(id);
        if (null != book)
            return RestBean.success(book, "find the book");
        return RestBean.serverError(null, "sorry cant find the book");
    }

    /**
     * request 可以取得header中的token
     * @param book
     * @param request
     * @return
     */
    @PutMapping("")
    public RestBean addOne(Book book, HttpServletRequest request){

        //使用token
        String tokenStr = request.getHeader("token");
        System.out.println("用户的token是：" + tokenStr);
        if(tokenStr == null) return RestBean.commonError("token not find in headers");

        //拿到userid
        Token token = userService.getByToken(tokenStr);
        int userId = token.getUserid();
        book.setUserid(userId);
        boolean rs = false;
        rs = bookService.publishOne(book);
        if(rs)
            return RestBean.success(null, "publish one book successfully!");
        return RestBean.serverError(null, "sorry but failed to publish book");
    }

    @PostMapping("/{id}")
    public RestBean alterBook(Book book, @PathVariable int id){
        book.setId(id);
        boolean rs = bookService.updateOneBook(book);
        if (rs)
            return RestBean.success(null, "successfully upodated the book");
        return RestBean.serverError(null, "failed to update the book");
    }
    @PostMapping("/{id}/sold")
    public RestBean sellBook(@PathVariable Integer id){
        boolean rs = bookService.soldBook(id);
        if (rs)
            return RestBean.success(null, "successfully sold the book");
        return RestBean.serverError(null, "failed to sell the book sorry");
    }

}
