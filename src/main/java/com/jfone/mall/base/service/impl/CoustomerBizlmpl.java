package com.jfone.mall.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;

import com.jfone.mall.base.entity.work.JfoneCoustomer;
import com.jfone.mall.base.entity.work.JfoneProduct;
import com.jfone.mall.base.entity.work.dto.CoustomerAddEntity;
import com.jfone.mall.base.entity.work.dto.CoustomerModifyEntity;
import com.jfone.mall.base.entity.work.dto.CoustomerQueryEntity;
import com.jfone.mall.base.mapping.work.JfoneCoustomerMapper;
import com.jfone.mall.base.service.Coustomerbiz;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service("coustomerbiz")
public class CoustomerBizlmpl implements Coustomerbiz {
    @Resource
    JfoneCoustomerMapper jfoneCoustomerMapper;

    public PageInfo<JfoneCoustomer> getCoustomerList(CoustomerQueryEntity coustomerQueryEntity) {

        PageHelper.startPage(coustomerQueryEntity.getPageNum(),coustomerQueryEntity.getPageSize());

        //Example + List<TbGoodsInfo> data = tbGoodsInfoMapper.selectAll();
        String orderStr = getOrderStr(coustomerQueryEntity);

        List<JfoneCoustomer> data = jfoneCoustomerMapper.CoustomerSearch(coustomerQueryEntity.getSearch(),orderStr);
        System.out.println("data"+data);
        return new PageInfo<JfoneCoustomer>(data);
    }

    public PageInfo<JfoneCoustomer> getCoustomerFList(CoustomerQueryEntity coustomerQueryEntity) {

        PageHelper.startPage(coustomerQueryEntity.getPageNum(),coustomerQueryEntity.getPageSize());

        //Example + List<TbGoodsInfo> data = tbGoodsInfoMapper.selectAll();
        String orderStr = getOrderStr(coustomerQueryEntity);

        List<JfoneCoustomer> data = jfoneCoustomerMapper.CoustomerFSearchUn(coustomerQueryEntity.getSearch(),orderStr);
        System.out.println("data"+data);
        return new PageInfo<JfoneCoustomer>(data);
    }

    @RequiresPermissions("product:manage")
    public int CoustomerDelete(String[] coustomerIds) {
        return jfoneCoustomerMapper.coustomerDelete(coustomerIds);
    }

    @RequiresPermissions("product:manage")
    @Override
    @CacheEvict(value="coustomer",allEntries=true)
    public int CoustomerAdd(CoustomerAddEntity coustomerAddEntity) {
        JfoneCoustomer jfoneCoustomer = new JfoneCoustomer();
        //goodsAddEntity.setpMainImage("123");

        BeanUtils.copyProperties(coustomerAddEntity,jfoneCoustomer);
        jfoneCoustomer.setcStatus("1");
        /*jfoneProduct.setGoodsFatherid(8);
        jfoneProduct.setGoodsParentid(1);*/


        return  jfoneCoustomerMapper.insert(jfoneCoustomer);
    }

    @RequiresPermissions("product:manage")
    @Override
    @CacheEvict(value="coustomer",allEntries=true)
    public int CoustomerModify(CoustomerModifyEntity coustomerModifyEntity) {
        /* 查询条件的设置 */
        Example example = new Example(JfoneProduct.class);
        //example.createCriteria() 构建查询条件
        //createCriteria()查询器，where条件
        //andEqualTo每个查询条件项是什么，各个字段 id=goodsModifyEntity.getGoodsIdx()
        example.createCriteria().andEqualTo("id",coustomerModifyEntity.getCoustomerIds());

        List<JfoneCoustomer> list = jfoneCoustomerMapper.selectByExample(example);
        if( list != null && list.size() > 0){
            JfoneCoustomer jfoneCoustomer = list.get(0);
            BeanUtils.copyProperties(coustomerModifyEntity,jfoneCoustomer);
            return  jfoneCoustomerMapper.updateByExample(jfoneCoustomer,example);
        }
        return 0;
    }

    @RequiresPermissions("product:manage")
    @Override
    @CacheEvict(value="coustomer",allEntries=true)
    public int CoustomerFModify(CoustomerModifyEntity coustomerModifyEntity) {
        /* 查询条件的设置 */
        Example example = new Example(JfoneProduct.class);
        //example.createCriteria() 构建查询条件
        //createCriteria()查询器，where条件
        //andEqualTo每个查询条件项是什么，各个字段 id=goodsModifyEntity.getGoodsIdx()
        example.createCriteria().andEqualTo("id",coustomerModifyEntity.getCoustomerIds());

        List<JfoneCoustomer> list = jfoneCoustomerMapper.selectByExample(example);
        if( list != null && list.size() > 0){
            JfoneCoustomer jfoneCoustomer = list.get(0);
            BeanUtils.copyProperties(coustomerModifyEntity,jfoneCoustomer);
            return  jfoneCoustomerMapper.updateByExample(jfoneCoustomer,example);
        }
        return 0;
    }

    private String getOrderStr(CoustomerQueryEntity coustomerQueryEntity){
        StringBuffer stringBuffer = new StringBuffer();
        if(!StringUtil.isEmpty(coustomerQueryEntity.getOrder())) {
            String strs[] = {"id","c_username","c_nickname","c_email","c_status"};
            stringBuffer.append(" order by "+strs[Integer.parseInt(coustomerQueryEntity.getOrder())]+" " + coustomerQueryEntity.getDir());
        }
        return stringBuffer.toString();
    }
}
