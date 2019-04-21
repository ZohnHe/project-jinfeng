package com.jfone.mall.base.service;


import com.jfone.mall.base.entity.work.ext.ExJfonePermission;

import java.util.List;

public interface PermissionService {

    List<ExJfonePermission> getPermissions(Integer roleId);
}
