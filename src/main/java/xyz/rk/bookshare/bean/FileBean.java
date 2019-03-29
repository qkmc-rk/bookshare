package xyz.rk.bookshare.bean;

public class FileBean {

    private int errno;

    private String data;



    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FileBean{" +
                "errno=" + errno +
                ", data='" + data + '\'' +
                '}';
    }
}
