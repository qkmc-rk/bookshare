package xyz.rk.bookshare.model;

import java.util.Date;

public class Notice {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.id
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.userid
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    private Integer userid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.createtime
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    private Date createtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.content
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.id
     *
     * @return the value of notice.id
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.id
     *
     * @param id the value for notice.id
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.userid
     *
     * @return the value of notice.userid
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.userid
     *
     * @param userid the value for notice.userid
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.createtime
     *
     * @return the value of notice.createtime
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.createtime
     *
     * @param createtime the value for notice.createtime
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.content
     *
     * @return the value of notice.content
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.content
     *
     * @param content the value for notice.content
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}