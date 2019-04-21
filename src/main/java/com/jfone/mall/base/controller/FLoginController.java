package com.jfone.mall.base.controller;


import com.jfone.mall.base.RequestEntity.LoginRequestEntity;
import com.jfone.mall.base.entity.work.JfoneCoustomer;
import com.jfone.mall.base.service.CustomerService;
import com.jfone.mall.base.utils.MD5SUtils;
import com.jfone.mall.base.utils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class FLoginController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Map login(@RequestBody LoginRequestEntity loginRequestEntity, HttpServletRequest request){
        Map<String,Object> map = null;
        String email = loginRequestEntity.getcEmail();
        JfoneCoustomer coustomer=null;
        if (email==null){
            coustomer= customerService.searchByEmailOrUsername(loginRequestEntity.getcUsername());
        }else {
            coustomer = customerService.searchByEmailOrUsername(loginRequestEntity.getcEmail());
        }
        if (coustomer!=null){
            String realPassword = coustomer.getcPassword();
            String activePassword=MD5SUtils.genMd5(coustomer.getcUsername(),loginRequestEntity.getcPassword());
            if (activePassword.equals(realPassword)){
                request.getSession().setAttribute("customer",coustomer);
                map= MapUtils.reposCode("200","登录成功，准备跳转");
            }else {
                map= MapUtils.reposCode("500","登录失败，密码错误");
            }
            return map;
        }else {
            map= MapUtils.reposCode("500","登录失败，账号错误");
            return map;
        }

    }
}
