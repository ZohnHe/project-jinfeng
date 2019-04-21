package com.jfone.mall.base.controller;

import com.github.pagehelper.PageInfo;
import com.jfone.mall.base.common.BaseResponse;
import com.jfone.mall.base.domain.GoodsListResp;
import com.jfone.mall.base.domain.GoodsQueryEntity;
import com.jfone.mall.base.entity.work.JfoneInOutStorageInfo;
import com.jfone.mall.base.entity.work.ext.JfoneInOutStorageInfoExt;
import com.jfone.mall.base.entity.work.ext.JfoneWayOrder;
import com.jfone.mall.base.service.IStorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Author:Chen.Q
 * @DATE:Created in 15:242019/2/19
 * @Remarks
 */
@Controller
@Api(tags="配送操作")  //swagger分类标题注解
@RequestMapping(value = "/storage")
public class storageController {
    @Resource
    IStorageService storageService;

    @ApiOperation(value = "获取商品列表数据", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<GoodsListResp<JfoneInOutStorageInfo>> getList(HttpServletRequest request, @Valid @RequestBody GoodsQueryEntity goodsQueryEntity, BindingResult errors){
        PageInfo<JfoneInOutStorageInfo> list = storageService.selectAll(goodsQueryEntity);
        /* 属性拷贝,可以使用Bean转换工具DozerBeanMapper */
        /*List<JfoneInOutStorageInfo> data = new ArrayList<JfoneInOutStorageInfo>();
        if(list.getList() != null){
            for(JfoneInOutStorageInfo poGoodsInfo:list.getList()){
                JfoneInOutStorageInfo bean = new JfoneInOutStorageInfo();
                try {
                    BeanUtils.copyProperties(poGoodsInfo, bean);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                data.add(bean);
            }
        }*/

        GoodsListResp<JfoneInOutStorageInfo> responseEntity = new GoodsListResp(list);

        responseEntity.setPageNum(goodsQueryEntity.getPageNum());
        responseEntity.setPageSize(goodsQueryEntity.getPageSize());
        responseEntity.setTotalRecord(list.getTotal());  //返回long int有长度限制 int的取值范围为: -2^31——2^31-1,即-2147483648——2147483647
        long totalPage = (responseEntity.getTotalRecord()+goodsQueryEntity.getPageSize()-1)/goodsQueryEntity.getPageSize(); //(总记录数+分页数-1)/分页数
        responseEntity.setTotalPage(totalPage);

        return new BaseResponse(responseEntity);
    }



    @ApiOperation(value = "获取商品列表数据", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/addList",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<JfoneInOutStorageInfo> addList(HttpServletRequest request,@RequestBody JfoneInOutStorageInfo jfoneInOutStorageInfo, BindingResult errors){
        BaseResponse baseResponse=new BaseResponse(JfoneInOutStorageInfo.class);
        baseResponse.setData(storageService.addList(jfoneInOutStorageInfo));

        baseResponse.setCode("200");
        baseResponse.setMsg("添加成功");
        return new BaseResponse(baseResponse);
    }


    @ApiOperation(value = "获取商品列表数据", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/delList",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<JfoneInOutStorageInfo> delList(HttpServletRequest request, @RequestBody JfoneInOutStorageInfoExt jfoneInOutStorageInfoExt, BindingResult errors){
        BaseResponse baseResponse=new BaseResponse(JfoneInOutStorageInfo.class);
        baseResponse.setData(storageService.delList(jfoneInOutStorageInfoExt));
        baseResponse.setCode("200");
        baseResponse.setMsg("添加成功");
        return new BaseResponse(baseResponse);
    }


    @ApiOperation(value = "获取商品列表数据", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/modifyList",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<JfoneInOutStorageInfo> modifyList(HttpServletRequest request, @RequestBody JfoneInOutStorageInfoExt jfoneInOutStorageInfoExt, BindingResult errors){
        BaseResponse baseResponse=new BaseResponse(JfoneInOutStorageInfo.class);
        /*System.out.println(jfoneInOutStorageInfoExt.getcTransitInfoId()+jfoneInOutStorageInfoExt.getcAddress()+"0000");*/
        baseResponse.setData(storageService.modifyList(jfoneInOutStorageInfoExt));
        baseResponse.setCode("200");
        baseResponse.setMsg("修改成功");
        return new BaseResponse(baseResponse);
    }

    @RequestMapping(value = "/orderId",method = RequestMethod.POST)
    public BaseResponse<String> orderId(HttpServletRequest request, HttpServletResponse response){
        Integer index=222;
        String o=request.getParameter("orderId");
        Long orderId=Long.parseLong(o);
       /* Integer orderId=Integer.parseInt(request.getParameter("orderId"));*/
        System.out.println(orderId+"  "+o);
        JfoneWayOrder jfoneWayOrder=new JfoneWayOrder();
        jfoneWayOrder.setOrderId(orderId);
        List<JfoneWayOrder> list=storageService.listByOrderId(jfoneWayOrder);
        if(list.size()>0) {
            for (JfoneWayOrder j : list) {
                index++;
                JfoneInOutStorageInfoExt jExt = new JfoneInOutStorageInfoExt();
                jExt.setcTransitInfoId(index);
                jExt.setcOperation("生成运单");
                jExt.setcAddress(j.getProvince()+j.getCity() + j.getDistrict() + j.getAddress());/*j.getProvince()+j.getCity() + j.getDistrict() + j.getAddress()*/
                jExt.setcDescription("1");
                /*jExt.setTime(new Date());*/
                storageService.addId(jExt);
                return new BaseResponse("success");
            }
        }
            return new BaseResponse("error");
    }



    @ApiOperation(value = "获取商品列表数据", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/moveSel",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<JfoneInOutStorageInfoExt> moveSel(HttpServletRequest request, @RequestBody JfoneInOutStorageInfoExt jfoneInOutStorageInfoExt, BindingResult errors){

        BaseResponse baseResponse=new BaseResponse(JfoneInOutStorageInfo.class);
        List<JfoneInOutStorageInfoExt> list= storageService.moveSel(jfoneInOutStorageInfoExt);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (JfoneInOutStorageInfo jfoneInOutStorageInfo :list ) {
            if(jfoneInOutStorageInfo.getTime()!=null){
                String dateStr = formatter.format(jfoneInOutStorageInfo.getTime());
                jfoneInOutStorageInfo.setcInOutIndex(dateStr);
            }
        }
        baseResponse.setData(list);
        baseResponse.setCode("200");
        baseResponse.setMsg("查询成功");
        return new BaseResponse(baseResponse);
    }
}
