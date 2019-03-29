package xyz.rk.bookshare.util;

/**
 * 单列模式
 *
 * 该类为rest风格接口返回数据的封装类
 */
public class RestBean{


    //数据
    private Object data;
    private int code;
    private String msg;

    private RestBean(Object data,int code, String msg){
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public static RestBean success(Object obj, String msg){
        return new RestBean(obj,200 , msg);
    }
    public static RestBean clientError(Object obj, String msg){
        return new RestBean(obj,400, msg);
    }
    public static RestBean serverError(Object obj, String msg){
        return new RestBean(obj,500, msg);
    }
    public static RestBean commonError(String msg){
        return new RestBean(null,100, msg);
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
