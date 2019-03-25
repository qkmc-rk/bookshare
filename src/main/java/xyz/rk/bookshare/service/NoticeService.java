package xyz.rk.bookshare.service;

import xyz.rk.bookshare.model.Notice;

import java.util.List;

public interface NoticeService {

    /**
     * 查询所有通知
     * @return List<Notice>
     */
    List<Notice> getAll();

    /**
     * 增加一条公告
     * @param notice 公告
     * @return 是否增加成功
     */
    boolean addOne(Notice notice);


}
