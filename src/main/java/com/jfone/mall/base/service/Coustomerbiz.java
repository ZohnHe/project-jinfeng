package com.jfone.mall.base.service;

import com.github.pagehelper.PageInfo;

import com.jfone.mall.base.entity.work.JfoneCoustomer;
import com.jfone.mall.base.entity.work.dto.CoustomerAddEntity;
import com.jfone.mall.base.entity.work.dto.CoustomerModifyEntity;
import com.jfone.mall.base.entity.work.dto.CoustomerQueryEntity;

public interface Coustomerbiz {
    PageInfo<JfoneCoustomer> getCoustomerList(CoustomerQueryEntity coustomerQueryEntity);
    PageInfo<JfoneCoustomer> getCoustomerFList(CoustomerQueryEntity coustomerQueryEntity);
    int CoustomerDelete(String[] CoustomerIds);
    int CoustomerAdd(CoustomerAddEntity coustomerAddEntity);
    int CoustomerModify(CoustomerModifyEntity coustomerModifyEntity);
    int CoustomerFModify(CoustomerModifyEntity coustomerModifyEntity);
}
