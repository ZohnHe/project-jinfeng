package com.jfone.mall.base.mapping.work.ext;

import com.jfone.mall.base.entity.work.ext.ExJfonePermission;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ExJfonePermissionMapper extends Mapper<ExJfonePermission> {


    List<ExJfonePermission> selectByRoleId(Integer roleId);
}
