package com.jfone.mall.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jfone.mall.base.domain.GoodsQueryEntity;
import com.jfone.mall.base.entity.work.ext.JfoneWayOrder;
import com.jfone.mall.base.entity.work.JfoneInOutStorageInfo;
import com.jfone.mall.base.entity.work.ext.JfoneInOutStorageInfoExt;
import com.jfone.mall.base.mapping.work.ext.JfoneWayOrderMapper;
import com.jfone.mall.base.mapping.work.JfoneInOutStorageInfoMapper;
import com.jfone.mall.base.mapping.work.ext.JfoneInOutStorageInfoMapperExt;
import com.jfone.mall.base.service.IStorageService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Author:Chen.Q
 * @DATE:Created in 16:092019/2/19
 * @Remarks
 */
@Service
public class StorageServiceImpl implements IStorageService {


    @Resource
    JfoneInOutStorageInfoMapper jfoneInOutStorageInfoMapper;

    @Resource
    JfoneInOutStorageInfoMapperExt jfoneInOutStorageInfoMapperExt;

    @Resource
    JfoneWayOrderMapper jfoneWayOrderMapper;

    @Override
    public PageInfo<JfoneInOutStorageInfo> selectAll(GoodsQueryEntity goodsQueryEntity) {

        //PageHelper.startPage(1,10);
        PageHelper.startPage(goodsQueryEntity.getPageNum(),goodsQueryEntity.getPageSize());
        //Example + List<TbGoodsInfo> data = tbGoodsInfoMapper.selectAll();
//        String orderStr = getOrderStr(goodsQueryEntity);
//
//        List<JfoneInOutStorageInfo> data = JfoneTransitInfoMapper.goodsSearchUn(goodsQueryEntity.getSearch(),orderStr);
        //通用查询模板
        Example example = new Example(JfoneInOutStorageInfo.class);
        if(goodsQueryEntity.getSearch()!=null){
            example.createCriteria().andEqualTo("flag","1").andEqualTo("cTransitInfoId",goodsQueryEntity.getSearch());
        }else{
            example.createCriteria().andEqualTo("flag","1");
        }

       /* JfoneCart jfoneCart = new JfoneCart();
        jfoneCart.setcQuantity(quantity);
        int updataQuantity = jfoneCartMapper.updateByExampleSelective(jfoneCart, example);*/
        /*List<JfoneInOutStorageInfo> jfoneInOutStorageInfos = jfoneInOutStorageInfoMapperper.selectAll();*/
        /*Example.Criteria criteria = example.createCriteria();
        criteria*/
        List<JfoneInOutStorageInfo> data = jfoneInOutStorageInfoMapper.selectByExample(example);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (JfoneInOutStorageInfo j :data ) {
            if(j.getTime()!=null){
                String dateString = formatter.format(j.getTime());
                j.setcInOutIndex(dateString);
                System.out.println(j.getcInOutIndex());
            }
        }
        return new PageInfo<JfoneInOutStorageInfo>(data);
    }

    @RequiresPermissions("item:manage")
    @Override
    public Integer addList(JfoneInOutStorageInfo jfoneInOutStorageInfo) {
        return jfoneInOutStorageInfoMapper.insert(jfoneInOutStorageInfo);
    }

    @RequiresPermissions("item:manage")
    @Override
    public Integer delList(JfoneInOutStorageInfoExt jfoneInOutStorageInfoExt) {
        Integer[] ids = jfoneInOutStorageInfoExt.getIds();
        //System.out.println(ids.length);
        return jfoneInOutStorageInfoMapperExt.delList(ids);
    }

    @Override
    public Integer modifyList(JfoneInOutStorageInfoExt jfoneInOutStorageInfoExt) {
        return jfoneInOutStorageInfoMapperExt.modifyList(jfoneInOutStorageInfoExt);
    }

    @Override
    public List<JfoneWayOrder> listByOrderId(JfoneWayOrder jfoneWayOrder) {
        return jfoneWayOrderMapper.listByOrderId(jfoneWayOrder);
    }

    @Override
    public Integer addId(JfoneInOutStorageInfoExt jfoneInOutStorageInfoExt) {
        return jfoneInOutStorageInfoMapperExt.addId(jfoneInOutStorageInfoExt);
    }


    @RequiresPermissions("item:manage")
    @Override
    public List<JfoneInOutStorageInfoExt> moveSel(JfoneInOutStorageInfoExt jfoneInOutStorageInfoExt) {
        return jfoneInOutStorageInfoMapperExt.moveSel(jfoneInOutStorageInfoExt);
    }

}
