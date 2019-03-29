package xyz.rk.bookshare.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.rk.bookshare.dao.NoticeMapper;
import xyz.rk.bookshare.model.Notice;
import xyz.rk.bookshare.service.NoticeService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    NoticeMapper noticeMapper;

    @Override
    public List<Notice> getAll() {
        List<Notice> notices = null;
        try {
            notices = noticeMapper.selectAll();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("sorry but find all notices failed");

        }
        return notices;
    }

    @Override
    public boolean addOne(Notice notice) {
        notice.setCreatetime(new Date());
        int rs = 0;
        try {
            rs = noticeMapper.insert(notice);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("sorry but not insert a notice record");
        }
        if (rs > 0)
            return true;
        return false;
    }
}
