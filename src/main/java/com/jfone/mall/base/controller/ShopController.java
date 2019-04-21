package com.jfone.mall.base.controller;

import com.github.pagehelper.PageInfo;
import com.jfone.mall.base.common.BaseResponse;

import com.jfone.mall.base.entity.work.TbGoodsInfo;
import com.jfone.mall.base.entity.work.dto.GoodsQueryEntity;
import com.jfone.mall.base.entity.work.ext.PcGoodsInfo;
import com.jfone.mall.base.entity.work.resp.GoodsListResp;
import com.jfone.mall.base.entity.work.resp.VoGoodsInfo;
import com.jfone.mall.base.service.Shopbiz;
import com.jfone.mall.base.utils.RequestAssets;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller("shopController")
@Api(tags="前台商品模块")  //swagger分类标题注解
@RequestMapping(value = "/shop",method = RequestMethod.POST)
public class ShopController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

/*    @Autowired
    private GlobalBiz globalBiz;*/

    @Autowired
    private Shopbiz shopbiz;

    @ApiOperation(value = "前台获取商品列表数据", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<GoodsListResp<VoGoodsInfo>> getGoodsList(@Valid @RequestBody GoodsQueryEntity goodsQueryEntity, BindingResult errors){
        //请求参数异常处理，加错误提示
        RequestAssets.assetsError(errors);

        //PbGoodsInfo poGoodsInfo = new PbGoodsInfo();
        //利用插件获取用户信息
        PageInfo<PcGoodsInfo> list = shopbiz.getGoodsList(goodsQueryEntity);
        /* 属性拷贝,可以使用Bean转换工具DozerBeanMapper */
        List<VoGoodsInfo> data = new ArrayList<VoGoodsInfo>();
        if(list.getList() != null){
            for(PcGoodsInfo pcGoodsInfo:list.getList()){
                VoGoodsInfo bean = new VoGoodsInfo();
                try {
                    BeanUtils.copyProperties(pcGoodsInfo,bean);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                data.add(bean);
            }
        }

        //将list<VoGoodsInfo>数据存入GoodsListResp的data中
        GoodsListResp<TbGoodsInfo> responseEntity = new GoodsListResp(data);

        return new BaseResponse(responseEntity);
    }

}
