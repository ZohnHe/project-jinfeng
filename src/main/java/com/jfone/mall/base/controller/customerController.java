package com.jfone.mall.base.controller;


import com.jfone.mall.base.RequestEntity.CustomerRequestEntity;
import com.jfone.mall.base.entity.work.JfoneCoustomer;

import com.jfone.mall.base.service.CustomerService;
import com.jfone.mall.base.utils.MD5SUtils;
import com.jfone.mall.base.utils.MailUtils;
import com.jfone.mall.base.utils.MapUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping(value = "static")
public class customerController {

    @Autowired
    @Qualifier(value = "customerService")
    private CustomerService customerService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping(value="/customer_sendEmail",method = RequestMethod.POST)
    @ResponseBody
    public Map sendEmail(@RequestBody CustomerRequestEntity customer){
        JfoneCoustomer jfoneCoustomer = null;
        Map<String, Object> map =null;
       jfoneCoustomer = customerService.searchByEmailOrUsername(customer.getcEmail());
        if (jfoneCoustomer==null){
            System.out.println("需要注册");
            String activeCode = RandomStringUtils.randomNumeric(5);

            MailUtils.sendMail("注册会员","金丰一号商城提醒你:<br/>本次你注册的会员激活码为:"+activeCode+"," +
                    "有效时间为5分钟，请及时激活，谢谢。<br/>" +
                    "有任务问题请拨打4008008820。",customer.getcEmail());
            redisTemplate.opsForValue().set(customer.getcEmail(), activeCode, 5, TimeUnit.MINUTES);
            System.out.println(customer.getcEmail());
            String activecodeRedis = redisTemplate.opsForValue().get(customer.getcEmail());
            System.out.println(activecodeRedis);
            map= MapUtils.reposCode("200","发送注册成功");
            return map;
        }else {
        System.out.println("注册失败");
        map= MapUtils.reposCode("500","该邮箱地址已被注册,请输入新的邮箱");
        return map;
    }
   }

    @RequestMapping(value="customer_register",method = RequestMethod.POST)
    @ResponseBody
    public Map register(@RequestBody CustomerRequestEntity customer){
        Map<String, Object> map = null;
        String s = customer.getCheckCode();
        System.out.println(customer.getCheckCode()+""+customer.getcEmail()+""+customer.getcPassword()+""+customer.getcUsername());
        String activecodeRedis = redisTemplate.opsForValue().get(customer.getcEmail());
        System.out.println(activecodeRedis);
        if(!activecodeRedis.equals(customer.getCheckCode())){
            map= MapUtils.reposCode("500","验证码错误，请重新输入或重新获取");
            return map;
        }else {
            String password = MD5SUtils.genMd5(customer.getcUsername(), customer.getcPassword());
            customer.setcPassword(password);
            customer.setcCreateTime(new Date());
            customer.setcUpdateTime(new Date());
           try{
                customerService.registerCustomer(customer);
           }catch (Exception ex){
               map= MapUtils.reposCode("500","用户名已被注册。请使用用户名进行注册");
               return map;
            }
            map= MapUtils.reposCode("200","注册成功");
            return map;
        }


    }

    @RequestMapping(value = "getcustomer",method = RequestMethod.GET)
    @ResponseBody
    public Map getCustomer(HttpServletRequest request){
        Map<String,Object> map = null;
        JfoneCoustomer coustomer = (JfoneCoustomer) request.getSession().getAttribute("customer");
        if (coustomer==null){
            map = MapUtils.reposCode("500", "还未登录，请先登录");
        }else {
            map = MapUtils.reposCode("200", "欢迎登录");
            map.put("coustomer",coustomer);
        }
        return map;
    }
    @RequestMapping(value = "updateCustomer",method = RequestMethod.POST)
    @ResponseBody
    public Map updateCustomer(@RequestBody CustomerRequestEntity customer){
        Map<String,Object> map = null;
        int result = customerService.update(customer);
        if (result>0){
            map=MapUtils.reposCode("200","修改成功");
        }else {
            map=MapUtils.reposCode("500","修改失败");
        }
        return map;
    }

}
