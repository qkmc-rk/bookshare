package xyz.rk.bookshare.controller;

import org.springframework.web.bind.annotation.*;
import xyz.rk.bookshare.model.Book;
import xyz.rk.bookshare.util.RestBean;

@RestController
@RequestMapping("/book")
public class BookController {

    //获取所有书
    @GetMapping("")
    public RestBean getAll(@RequestParam(required = false) int catalogId){
        //若传入了catalogId，则只返回该类的书籍
        return null;
    }

    @DeleteMapping("/{id}")
    public RestBean deleteOne(@PathVariable int id){
        return null;
    }


    @GetMapping("/{id}")
    public RestBean detail(@PathVariable int id){
        return null;
    }

    @PutMapping("")
    public RestBean addOne(@RequestBody Book book){
        return null;
    }

    @PostMapping("/{id}")
    public RestBean alterBook(@PathVariable int id,@RequestBody Book book){
        return null;
    }

}
