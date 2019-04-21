package com.jfone.mall.base.service.impl;

import com.jfone.mall.base.RequestEntity.CustomerRequestEntity;
import com.jfone.mall.base.entity.work.JfoneCoustomer;
import com.jfone.mall.base.mapping.work.JfoneCoustomerMapper;
import com.jfone.mall.base.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private JfoneCoustomerMapper jfoneCoustomerMapper;


    @Override
    @Transactional
    public int registerCustomer(JfoneCoustomer customer) {
        int result = jfoneCoustomerMapper.insert(customer);
        return result;
    }

    @Override
/*
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
*/
    public JfoneCoustomer searchByEmailOrUsername(String s) {
        Example example = new Example(JfoneCoustomer.class);
        example.createCriteria().andEqualTo("cEmail",s).orEqualTo("cUsername",s);
        List<JfoneCoustomer> jfoneCoustomers = jfoneCoustomerMapper.selectByExample(example);
        if (jfoneCoustomers.size()>0&&jfoneCoustomers.get(0)!=null){
            return jfoneCoustomers.get(0);
        }else {
            return null;
        }

    }

    @Override
    public int update(CustomerRequestEntity customer) {
        Example example = new Example(JfoneCoustomer.class);
        int i = jfoneCoustomerMapper.updateByExampleSelective(customer, example);
        return i;
    }


}
