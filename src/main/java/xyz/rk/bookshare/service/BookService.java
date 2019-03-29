package xyz.rk.bookshare.service;

import xyz.rk.bookshare.model.Book;

import java.util.List;

/**
 * 书的服务类
 *
 */
public interface BookService {

    /***
     * 获取所有书籍
     * @return 所有书籍列表
     */
    List<Book> getAll();

    /**
     * 通过catalogid获取某个种类的书
     * @param catalogId 书本的分类id
     * @return 某个种类的书籍
     */
    List<Book> getByCatalogId(int catalogId);


    /**
     * 删除一本书 通过id
     * @param bookId
     * @return 是否删除成功
     */
    boolean deleteOneBookById(int bookId);


    /**
     * 通过一本书的id查询这本书的所有信息
     * @param bookId
     * @return
     */
    Book getById(int bookId);


    List<Book> getByUserId(int userId);

    /**
     * 出售一本书，将该书的sold字段变为1
     * @param bookId
     * @return 买卖书成功
     */
    boolean soldBook(int bookId);

    boolean publishOne(Book book);

    boolean updateOneBook(Book book);
}
