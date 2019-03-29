package xyz.rk.bookshare.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.rk.bookshare.dao.BookMapper;
import xyz.rk.bookshare.model.Book;
import xyz.rk.bookshare.service.BookService;
import xyz.rk.bookshare.util.Constant;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    BookMapper bookMapper;

    @Override
    public List<Book> getAll() {
        List<Book> books = null;
        try {
            books = bookMapper.selectAll();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("sorry cant find all books");
        }
        return books;
    }

    @Override
    public List<Book> getByCatalogId(int catalogId) {
        return null;
    }

    @Override
    public boolean deleteOneBookById(int bookId) {
        int rs = 0;
        try {
            rs = bookMapper.deleteByPrimaryKey(bookId);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("sorry but failed to delete one book");
        }
        if(rs > 0)
            return true;
        return false;
    }

    @Override
    public Book getById(int bookId) {
        Book book = null;
        try {
            book = bookMapper.selectByPrimaryKey(bookId);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("sorry i cant find the book");
        }
        return book;
    }

    @Override
    public List<Book> getByUserId(int userId) {
        return null;
    }

    @Override
    public boolean soldBook(int bookId) {
        int rs = 0;
        try {
            rs = bookMapper.updateSoldByPrimaryKey(Constant.SOLD,bookId);
        }catch (Exception e){
            e.printStackTrace();
            logger.info(" sorry but sold failed");
        }
        if (rs > 0)
            return true;
        return false;
    }

    @Override
    public boolean publishOne(Book book) {
        book.setCreatetime(new Date());
        book.setSold(Constant.NOT_SOLD);
        int rs = 0;
        try {
            rs = bookMapper.insert(book);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("insert a book failed");
        }
        if(rs > 0)
            return true;
        return false;
    }

    @Override
    public boolean updateOneBook(Book book) {
        int rs = 0;
        try {
            rs = bookMapper.updateByPrimaryKey(book);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("sorry but cant update！！ book");
        }
        if (rs > 0)
            return true;
        return false;
    }
}
