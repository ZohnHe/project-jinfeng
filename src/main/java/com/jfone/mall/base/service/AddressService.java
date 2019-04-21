package com.jfone.mall.base.service;

import com.jfone.mall.base.domain.UserAddress;
import com.jfone.mall.base.entity.work.JfoneShipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressService {
    List<JfoneShipping> queryAddressById(@Param("sUserId") int id);
    int addAddress(UserAddress userAddress);
    int deleteAddressById(@Param("id") int id);
    JfoneShipping selectAddressById(@Param("id") int id);
    int modifyAddress(UserAddress userAddress);
}
