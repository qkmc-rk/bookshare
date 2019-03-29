package xyz.rk.bookshare.model;

import java.util.Date;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.phone
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.account
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    private String account;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.nickname
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    private String nickname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.qq
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    private String qq;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.createtime
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    private Date createtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.ugrant
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    private Byte ugrant;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.ulock
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    private Integer ulock;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.phone
     *
     * @return the value of user.phone
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.phone
     *
     * @param phone the value for user.phone
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.account
     *
     * @return the value of user.account
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public String getAccount() {
        return account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.account
     *
     * @param account the value for user.account
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.nickname
     *
     * @return the value of user.nickname
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.nickname
     *
     * @param nickname the value for user.nickname
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.qq
     *
     * @return the value of user.qq
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public String getQq() {
        return qq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.qq
     *
     * @param qq the value for user.qq
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.createtime
     *
     * @return the value of user.createtime
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.createtime
     *
     * @param createtime the value for user.createtime
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.ugrant
     *
     * @return the value of user.ugrant
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public Byte getUgrant() {
        return ugrant;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.ugrant
     *
     * @param ugrant the value for user.ugrant
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public void setUgrant(Byte ugrant) {
        this.ugrant = ugrant;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.ulock
     *
     * @return the value of user.ulock
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public Integer getUlock() {
        return ulock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.ulock
     *
     * @param ulock the value for user.ulock
     *
     * @mbg.generated Mon Mar 25 13:14:37 CST 2019
     */
    public void setUlock(Integer ulock) {
        this.ulock = ulock;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", qq='" + qq + '\'' +
                ", createtime=" + createtime +
                ", ugrant=" + ugrant +
                ", ulock=" + ulock +
                '}';
    }
}