package xyz.rk.bookshare.service.impl;

import org.springframework.stereotype.Service;
import xyz.rk.bookshare.model.Notice;
import xyz.rk.bookshare.service.NoticeService;

import java.util.List;

@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService {
    @Override
    public List<Notice> getAll() {
        return null;
    }

    @Override
    public boolean addOne(Notice notice) {
        return false;
    }
}
