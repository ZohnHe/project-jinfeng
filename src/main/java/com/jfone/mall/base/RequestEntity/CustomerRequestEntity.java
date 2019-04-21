package com.jfone.mall.base.RequestEntity;

import com.jfone.mall.base.entity.work.JfoneCoustomer;

public class CustomerRequestEntity  extends JfoneCoustomer {

    private String checkCode;

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
}
