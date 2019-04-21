package com.jfone.mall.base.domain;

import com.jfone.mall.base.entity.work.JfoneShipping;

public class UserAddress extends JfoneShipping {
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
