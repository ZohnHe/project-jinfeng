package com.jfone.mall.base.service.impl;

import com.jfone.mall.base.domain.UserAddress;
import com.jfone.mall.base.entity.work.JfoneShipping;
import com.jfone.mall.base.mapping.work.JfoneShippingMapper;
import com.jfone.mall.base.service.AddressService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    JfoneShippingMapper jfoneShippingMapper;
    @Override
    public List<JfoneShipping> queryAddressById(int id) {
        Example example = new Example(JfoneShipping.class);
        example.createCriteria().andEqualTo("sUserId",id);
        List<JfoneShipping> jfoneShipping = jfoneShippingMapper.selectByExample(example);
        if (jfoneShipping != null){
           return jfoneShipping;

        }
        return null;
    }

    @Override
    public int addAddress(UserAddress userAddress) {

        int insert = jfoneShippingMapper.insert(userAddress);
        return insert;
    }

    @Override
    public int deleteAddressById(int id) {
        Example example = new Example(JfoneShipping.class);
        example.createCriteria().andEqualTo("id",id);
        int delete = jfoneShippingMapper.deleteByExample(example);
        return delete;
    }

//    @Override
//    public JfoneShipping modifAddressById(int id) {
//        System.out.println("111111111111");
//        return null;
//    }

    @Override
    public JfoneShipping selectAddressById(int id) {
        Example example = new Example(JfoneShipping.class);
        example.createCriteria().andEqualTo("id",id);
        List<JfoneShipping> jfoneShippings = jfoneShippingMapper.selectByExample(example);

        return jfoneShippings.get(0);
    }

    @Override
    public int modifyAddress(UserAddress userAddress) {
        int primaryKey = jfoneShippingMapper.updateByPrimaryKey(userAddress);
        return primaryKey;
    }
}
