package com.jfone.mall.base.controller;


import com.github.pagehelper.PageInfo;
import com.jfone.mall.base.common.BaseResponse;

import com.jfone.mall.base.entity.work.TbGoodsInfo;
import com.jfone.mall.base.entity.work.dto.GoodsAddEntity;
import com.jfone.mall.base.entity.work.dto.GoodsDeleteEntity;
import com.jfone.mall.base.entity.work.dto.GoodsModifyEntity;
import com.jfone.mall.base.entity.work.dto.GoodsQueryEntity;
import com.jfone.mall.base.entity.work.ext.PcGoodsInfo;
import com.jfone.mall.base.entity.work.resp.*;
import com.jfone.mall.base.service.Goodsbiz;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller("goodsController")
@Api(tags="后台商品模块")  //swagger分类标题注解
@RequestMapping(value = "/goods",method = RequestMethod.POST)
public class GoodsController  {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

/*    @Autowired
    private GlobalBiz globalBiz;*/

    @Autowired
    private Goodsbiz goodsbiz;


    @ApiOperation(value = "获取商品上架列表数据", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<GoodsListResp<VoGoodsInfo>> getGoodsList(@Valid @RequestBody GoodsQueryEntity goodsQueryEntity, BindingResult errors){
        //请求参数异常处理，加错误提示
        RequestAssets.assetsError(errors);

        //PbGoodsInfo poGoodsInfo = new PbGoodsInfo();
        //利用插件获取用户信息
        PageInfo<PcGoodsInfo> list = goodsbiz.getGoodsList(goodsQueryEntity);
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

        responseEntity.setPageNum(goodsQueryEntity.getPageNum());
        responseEntity.setPageSize(goodsQueryEntity.getPageSize());
        responseEntity.setTotalRecord(list.getTotal());  //返回long int有长度限制 int的取值范围为: -2^31——2^31-1,即-2147483648——2147483647
        long totalPage = (responseEntity.getTotalRecord()+goodsQueryEntity.getPageSize()-1)/goodsQueryEntity.getPageSize(); //(总记录数+分页数-1)/分页数
        responseEntity.setTotalPage(totalPage);

        return new BaseResponse(responseEntity);
    }

    @ApiOperation(value = "获取商品下架列表数据", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/listF",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<GoodsListResp<VoGoodsInfo>> getGoodsFList(@Valid @RequestBody GoodsQueryEntity
                                                                              goodsQueryEntity, BindingResult errors){
        //请求参数异常处理，加错误提示
        RequestAssets.assetsError(errors);

        //PbGoodsInfo poGoodsInfo = new PbGoodsInfo();
        //利用插件获取用户信息
        PageInfo<PcGoodsInfo> list = goodsbiz.getGoodsFList(goodsQueryEntity);
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

        responseEntity.setPageNum(goodsQueryEntity.getPageNum());
        responseEntity.setPageSize(goodsQueryEntity.getPageSize());
        responseEntity.setTotalRecord(list.getTotal());  //返回long int有长度限制 int的取值范围为: -2^31——2^31-1,即-2147483648——2147483647
        long totalPage = (responseEntity.getTotalRecord()+goodsQueryEntity.getPageSize()-1)/goodsQueryEntity.getPageSize(); //(总记录数+分页数-1)/分页数
        responseEntity.setTotalPage(totalPage);

        return new BaseResponse(responseEntity);
    }

    @ApiOperation(value = "删除指定商品", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<GoodsDeleteResp> goodsDelete(HttpServletRequest request, @Valid @RequestBody GoodsDeleteEntity goodsDeleteEntity, BindingResult errors){
        //请求参数异常处理，加错误提示
        RequestAssets.assetsError(errors);
        GoodsDeleteResp goodsDeleteResp = new GoodsDeleteResp();
        goodsDeleteResp.setResult(goodsbiz.goodsDelete(goodsDeleteEntity.getGoodsIds()));

        return new BaseResponse(goodsDeleteResp);
    }
    @ApiOperation(value = "添加商品", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<GoodsAddResp> goodsAdd(HttpServletRequest request, @Valid @RequestBody GoodsAddEntity goodsAddEntity, BindingResult errors){
        //请求参数异常处理，加错误提示
        RequestAssets.assetsError(errors);

        GoodsAddResp goodsAddResp = new GoodsAddResp();
        goodsAddResp.setResult(goodsbiz.goodsAdd(goodsAddEntity));
        System.out.println("添加成功");
        return new BaseResponse(goodsAddResp);
    }
    @ApiOperation(value = "修改商品信息", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<GoodsModifyResp> goodsModify(HttpServletRequest request, @Valid @RequestBody GoodsModifyEntity goodsModifyEntity, BindingResult errors){
        //请求参数异常处理，加错误提示
        RequestAssets.assetsError(errors);

        GoodsModifyResp goodsModifyResp = new GoodsModifyResp();
        goodsModifyResp.setResult(goodsbiz.goodsModify(goodsModifyEntity));

        return new BaseResponse(goodsModifyResp);
    }


/*    @ApiOperation(value = "修改商品上架信息", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/modifyF",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<GoodsModifyResp> goodsFModify(HttpServletRequest request, @Valid @RequestBody
            GoodsModifyEntity goodsModifyEntity, BindingResult errors){
        //请求参数异常处理，加错误提示
        RequestAssets.assetsError(errors);

        GoodsModifyResp goodsModifyResp = new GoodsModifyResp();
        goodsModifyResp.setResult(goodsbiz.goodsModify(goodsModifyEntity));

        return new BaseResponse(goodsModifyResp);
    }*/

}
