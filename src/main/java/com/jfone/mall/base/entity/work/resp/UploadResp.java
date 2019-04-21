package com.jfone.mall.base.entity.work.resp;

/**
 *  上传文件后，返回文件名网络路径
 *
 */
public class UploadResp {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UploadResp{" +
                "name='" + name + '\'' +
                '}';
    }
}
