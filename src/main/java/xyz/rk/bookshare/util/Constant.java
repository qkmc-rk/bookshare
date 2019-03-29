package xyz.rk.bookshare.util;

public class Constant {

    /**
     * 是否出售
     */
    public static final Byte NOT_SOLD = 0;

    public static final Byte SOLD = 1;
    /**
     * token的有效时间 sec  默认<b>259200</b>s,一天
     */
    public static final Integer TOKEN_FRAME = 2592000;

    public static final Integer SUCCESS = 1;

    /**
     * 用户权利定义
     */
    public static final Byte USUAL_CUSTOM = 0;
    public static final Byte ADMIN_USER = 1;

    /**
     * 是否锁定用户
     */
    public static final Integer LOCKED = 1;
    public static final Integer UNLOCKED = 0;
}
