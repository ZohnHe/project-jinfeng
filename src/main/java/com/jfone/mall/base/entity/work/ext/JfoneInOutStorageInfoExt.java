package com.jfone.mall.base.entity.work.ext;

import com.jfone.mall.base.entity.work.JfoneInOutStorageInfo;

import javax.persistence.Transient;


public class JfoneInOutStorageInfoExt extends JfoneInOutStorageInfo {
    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    @Transient
    private Integer[] ids;


}