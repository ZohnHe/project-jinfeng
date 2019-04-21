package com.jfone.mall.base.service.impl;


import com.jfone.mall.base.entity.work.ext.ExJfoneUser;
import com.jfone.mall.base.mapping.work.ext.ExJfoneUserMapper;
import com.jfone.mall.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ExJfoneUserMapper userMapper;


    @Override
    public ExJfoneUser searchUserByUsername(String username) {
        Example example = new Example(ExJfoneUser.class);
        example.createCriteria().andEqualTo("uUsername",username);
        List<ExJfoneUser> users = userMapper.selectByExample(example);
        if(users.size()>0&&users.get(0)!=null){
            return users.get(0);
        }else {
            return null;
        }
    }
}
