package com.jfone.mall.base.controller;

import com.jfone.mall.base.domain.AccountEntity;
import com.jfone.mall.base.domain.UserAddress;
import com.jfone.mall.base.entity.work.JfoneShipping;
import com.jfone.mall.base.service.AddressService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AddressController {

    @Resource
    AddressService addressService;
    @ApiOperation(value = "用户测试")
    @RequestMapping(value = "/tij_dingd",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public List<JfoneShipping> queryAddressById(HttpServletRequest request, @Valid @RequestBody AccountEntity account ){
        List<JfoneShipping> jfoneShippings = addressService.queryAddressById(account.getId());

        return jfoneShippings;
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public int addAddress(HttpServletRequest request,@Valid @RequestBody UserAddress userAddress ){
        String city = userAddress.getCity();
        String[] split = city.split("/");
        userAddress.setsReceiverProvince(split[0]);
        userAddress.setsReceiverCity(split[1]);
        userAddress.setsReceiverDistrict(split[2]);
        int address = addressService.addAddress(userAddress);

        return 0;
    }

    @RequestMapping(value = "/deleteAdderss",method = RequestMethod.POST)
    @ResponseBody
    public int deleteAdderss(HttpServletRequest request,@Valid @RequestBody UserAddress userAddress ){
        int id = addressService.deleteAddressById(userAddress.getId());
        return id;
    }

    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    @ResponseBody
    public JfoneShipping selectAdderssById(HttpServletRequest request, @Valid @RequestBody AccountEntity accountEntity ){
        System.out.println(accountEntity.getId());
        JfoneShipping jfoneShipping = addressService.selectAddressById(accountEntity.getId());
        return jfoneShipping;
    }
 @RequestMapping(value = "/modifyAddress",method = RequestMethod.POST)
    @ResponseBody
    public int modifAdderss(HttpServletRequest request,@Valid @RequestBody UserAddress userAddress ){
     String city = userAddress.getCity();
     String[] split = city.split("/");
     userAddress.setsReceiverProvince(split[0]);
     userAddress.setsReceiverCity(split[1]);
     userAddress.setsReceiverDistrict(split[2]);
     userAddress.setsUserId(21);
     int modifyAddress = addressService.modifyAddress(userAddress);
        return modifyAddress;
    }

}
