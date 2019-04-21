package com.jfone.mall.base.controller;


import com.jfone.mall.base.entity.work.ext.ExJfoneUser;

import com.jfone.mall.base.utils.MapUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class BLoginController {

    @RequestMapping(value = "/bcklogin",method = RequestMethod.POST)
    @ResponseBody
    public Map login(@RequestBody ExJfoneUser user, HttpServletRequest request){
        Map<String, Object> map =null;
        String s = user.getuUsername();
        String s1 = user.getuPassword();
        System.out.println(s+s1);
        UsernamePasswordToken  token = new UsernamePasswordToken(user.getuUsername(), user.getuPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            /*JfoneCoustomer jfoneCoustomer = (JfoneCoustomer) subject.getPreviousPrincipals();*/
            //登录成功
            //将用户信息保存Session
            map=MapUtils.reposCode("200","登录成功，欢迎进入金丰商城后台管理");
        }  catch (UnknownSessionException use) {
            subject = new Subject.Builder().buildSubject();
            subject.login(token);
            map=MapUtils.reposCode("500","会话异常");
            return map;
        }
        catch(UnknownAccountException ex){
            map=  MapUtils.reposCode("500","账号错误");
            return map;
        }
        catch (IncorrectCredentialsException ice) {
            map= MapUtils.reposCode("500","密码错误");
            return map;
        }
        catch (LockedAccountException lae) {
            map=  MapUtils.reposCode("500","账号已被锁定");
            return map;
        }
        catch (DisabledAccountException dae) {
            map= MapUtils.reposCode("500","账户异常");
            return map;
        }
        catch (AuthenticationException ae) {
            map=  MapUtils.reposCode("500","未有权限异常");
            return map;
        }
        catch(Exception e){
            map=   MapUtils.reposCode("500","最大的异常");
            return map;
        }
        return map;
    }

    @RequestMapping(value = "getbguser",method = RequestMethod.POST)
    @ResponseBody
    public Map getUser(){
        Map map = null;
        ExJfoneUser user = (ExJfoneUser)SecurityUtils.getSubject().getPrincipal();
        map =MapUtils.reposCode("200","");
        map.put("user",user);
        return map;
    }
    @RequestMapping(value = "delbguser",method = RequestMethod.GET)
    @ResponseBody
    public Map delUser(){
        Map map = null;
        SecurityUtils.getSubject().logout();
        map =MapUtils.reposCode("200","退出成功，请重新登录");
        return map;

    }
}
