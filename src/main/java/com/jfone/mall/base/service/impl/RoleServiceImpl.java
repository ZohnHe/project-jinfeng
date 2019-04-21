package com.jfone.mall.base.service.impl;


import com.jfone.mall.base.entity.work.ext.ExJfoneRole;
import com.jfone.mall.base.mapping.work.ext.ExJfoneRoleMapper;
import com.jfone.mall.base.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private ExJfoneRoleMapper exJfoneRoleMapper;

    @Override
    public ExJfoneRole getRole(int id) {
        ExJfoneRole role = exJfoneRoleMapper.selectByPrimaryKey(id);
        if(role!=null) return role;
        else return null;
    }
}
