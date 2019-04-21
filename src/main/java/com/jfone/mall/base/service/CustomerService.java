package com.jfone.mall.base.service;

import com.jfone.mall.base.RequestEntity.CustomerRequestEntity;
import com.jfone.mall.base.entity.work.JfoneCoustomer;

public interface CustomerService {

     int registerCustomer(JfoneCoustomer customer);

     JfoneCoustomer searchByEmailOrUsername(String s);


     int update(CustomerRequestEntity customer);
}
