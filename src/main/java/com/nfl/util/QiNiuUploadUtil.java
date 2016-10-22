package com.nfl.util;

import com.qiniu.util.Auth;

import java.io.IOException;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;

public class QiNiuUploadUtil {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    private String ACCESS_KEY = "9nHdP_-RehGtHG1nkzgCk7nqZHobTiruxxN7J5Em";
    private String SECRET_KEY = "IiXbcXqGHAv0axkcm2xYJmvrga14ww0-8poeVsEZ";
    //要上传的空间
    private String bucketname = "teamwork";

    //密钥配置
    private Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //创建上传对象
    private UploadManager uploadManager = new UploadManager();

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    private String getUpToken() {
        return auth.uploadToken(bucketname);
    }

    //上传文件的流data
    //上传到七牛后保存的文件名 saveFileName
    public static void upload(byte[] data,String saveFileName) throws IOException {
        QiNiuUploadUtil qiNiuUploadUtil = new QiNiuUploadUtil();
        try {
            //调用put方法上传
            Response res = qiNiuUploadUtil .uploadManager.put(data, saveFileName, qiNiuUploadUtil.getUpToken());
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }
}
