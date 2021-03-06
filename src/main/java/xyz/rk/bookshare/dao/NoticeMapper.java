package xyz.rk.bookshare.dao;

import java.util.List;
import xyz.rk.bookshare.model.Notice;

public interface NoticeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    int insert(Notice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    Notice selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    List<Notice> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    int updateByPrimaryKey(Notice record);
}