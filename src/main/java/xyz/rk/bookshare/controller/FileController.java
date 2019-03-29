package xyz.rk.bookshare.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import xyz.rk.bookshare.bean.FileBean;
import xyz.rk.bookshare.util.QiNiuFileUtil;
import xyz.rk.bookshare.util.RestBean;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping("/img")
    public RestBean uploadImg(@RequestParam("img") MultipartFile img){
        System.out.println("开始上传图片");
        if(!img.isEmpty() || img.getSize() > 0) {
            System.out.println("找到文件");
            //将图片存到uploadfile中去
            String fileName = img.getOriginalFilename();
            InputStream inputStream  = null;
            try {
                inputStream = img.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
                return RestBean.clientError(null,"cannot get img stream");
            }
            String key = QiNiuFileUtil.uploadFile(inputStream,fileName);
            String dns = QiNiuFileUtil.getDns();
            FileBean fileBean = new FileBean();
            fileBean.setErrno(0);
            fileBean.setData(dns + "/" + key);
            System.out.println(fileBean);
            return RestBean.success(fileBean,"successfully uploaded the img");
        }else {
            return RestBean.clientError(null,"null img uploaded");
        }
    }
}
