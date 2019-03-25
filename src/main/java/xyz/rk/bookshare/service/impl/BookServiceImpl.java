package xyz.rk.bookshare.service.impl;

import org.springframework.stereotype.Service;
import xyz.rk.bookshare.model.Book;
import xyz.rk.bookshare.service.BookService;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {
    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public List<Book> getByCatalogId(int catalogId) {
        return null;
    }

    @Override
    public boolean deleteOneBookById(int bookId) {
        return false;
    }

    @Override
    public Book getById(int bookId) {
        return null;
    }

    @Override
    public List<Book> getByUserId(int userId) {
        return null;
    }

    @Override
    public boolean soldBook(int bookId) {
        return false;
    }

    @Override
    public boolean publishOne(Book book) {
        return false;
    }
}
