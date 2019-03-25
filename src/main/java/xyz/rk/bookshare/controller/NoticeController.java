package xyz.rk.bookshare.controller;

import org.springframework.web.bind.annotation.*;
import xyz.rk.bookshare.model.Notice;
import xyz.rk.bookshare.util.RestBean;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @GetMapping("")
    public RestBean getAll(){
        return null;
    }

    @PutMapping("/{id}")
    public RestBean addOne(@PathVariable int id, @RequestBody Notice notice){
        return null;
    }
}
