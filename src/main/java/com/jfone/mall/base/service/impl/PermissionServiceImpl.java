package com.jfone.mall.base.service.impl;


import com.jfone.mall.base.entity.work.ext.ExJfonePermission;
import com.jfone.mall.base.mapping.work.ext.ExJfonePermissionMapper;
import com.jfone.mall.base.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    ExJfonePermissionMapper permissionMapper;


    @Override
    public List<ExJfonePermission> getPermissions(Integer roleId) {
        return permissionMapper.selectByRoleId(roleId);
    }
}
