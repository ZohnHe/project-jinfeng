package com.jfone.mall.base.service;


import com.jfone.mall.base.entity.work.ext.ExJfoneUser;

public interface UserService {

    ExJfoneUser searchUserByUsername(String username);
}
